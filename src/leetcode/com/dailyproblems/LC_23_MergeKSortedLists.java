package leetcode.com.dailyproblems;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Pair{
    int value;
    int list_index;
    int col_index;

    public Pair(int value, int list_index, int col_index){
        this.value = value;
        this.list_index = list_index;
        this.col_index = col_index;
    }
}
class LC_23_MergeKSortedLists {

     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    /*

     Problem : if they ask question like given array of arrays like
     [[1,2,3],[4,4,5,6],[2,2,3]]
     return Sorted Linked List.


     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        //Iterate over the lists build main_array by adding each arr to main_array.
        List<List<Integer>> main_array = new ArrayList<>();
        for (ListNode node : lists){
            List<Integer> arr = new ArrayList<>();
            while(node!=null){
                arr.add(node.val);
                node = node.next;
            }
            main_array.add(arr);
        }

        //set the capacity of PQ to lists.length
        PriorityQueue<Pair> queue = new PriorityQueue<>(lists.length, (obj1, obj2)-> obj1.value - obj2.value);

        //Build a priority Queue
        int index = 0;
        for(List<Integer> list : main_array){
            if (list.size()!=0){
                queue.add(new Pair(list.get(0), index, 0));
            }
            index++;

        }
        ListNode prehead = new ListNode(-1);
        ListNode tail = prehead;
        //poll each node
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            ListNode node = new ListNode(pair.value);
            tail.next = node;
            tail = tail.next;
            List<Integer> list = main_array.get(pair.list_index);
            int value = 0;
            if ( pair.col_index + 1 < list.size() ){
                value  = list.get(pair.col_index+1);
                queue.add(new Pair(value, pair.list_index, pair.col_index+1));
            }
        }

        return prehead.next;


    }
    //Approach3 - PriorityQueue
    //Time: O(nk log k)
    //Space: O(k) for storing nodes in PQ + O(n) for new linkedList
    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (l1,l2)-> l1.val - l2.val);
        //Build a priority Queue
        for(ListNode node : lists){
            if (node!=null){
                queue.add(node);
            }
        }
        ListNode prehead = new ListNode(-1);
        ListNode tail = prehead;
        //poll each node
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next!=null){
                queue.add(tail.next);
            }
        }
        return prehead.next;
    }
    //Approach 1 - BruteForce
    //Desc - take each list and merge to next list
    //Time : K lists N elements in each list 2n+ 3n+ ...+kn = (k(k+1)/2)n comparistions
    //Space : O(1)  - though there are KN elements I am just reusing them.
    public ListNode mergeKListsBruteForce(ListNode[] lists) {

        if (lists==null || lists.length == 0){
            return null;
        }
        ListNode output = null;
        for (ListNode list : lists){
            if (output == null ){
                output = list;
                continue;
            }
            output = merge(output, list);

        }
        return output;

    }

    //Approach 2 - divide and conquer
    //Desc - Divide until the array size is 2 and then merge two lists
    //Time - no of iterations = logk and each iteration cost is nk => total = nklogk
    //Space - O(nk)

    public ListNode mergeKListsUsingDivideAndConquer(ListNode[] lists) {
        if (lists==null || lists.length==0){
            return null;
        }

        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int start, int end){

        if (start == end){
            return lists[start];
        }

        if (start+1 == end){
            return merge(lists[start], lists[end]);
        }


        int mid = start + (end - start) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid+1, end);

        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2){

        if (l1==null){
            return l2;
        }

        if (l2==null){
            return l1;
        }

        ListNode prehead = new ListNode(-1);
        ListNode tail = prehead;

        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }else{
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }

        if (l1!=null){
            tail.next = l1;
        }
        if (l2!=null){
            tail.next = l2;
        }

        return prehead.next;

    }
}
