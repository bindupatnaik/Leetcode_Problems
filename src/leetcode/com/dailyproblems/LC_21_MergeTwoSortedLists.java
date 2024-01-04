package leetcode.com.dailyproblems;

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
public class LC_21_MergeTwoSortedLists {
     class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * Recursion approach
     * Time : O(n + m)
     * Space: O(n+m) due to recursion stack
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        mergeTwoListsRecursion(list1, list2, prehead);
        return prehead.next;


    }

    private void mergeTwoListsRecursion(ListNode l1, ListNode l2, ListNode tail){
        //base condition
        if (l1 == null){
            tail.next = l2;
            return;
        }
        if (l2 == null){
            tail.next = l1;
            return;
        }

        //calling recursion based on condition
        if (l1.val <= l2.val){
            tail.next = l1;
            tail = tail.next;
            l1 = l1.next;
            mergeTwoListsRecursion(l1, l2, tail);
        }else{
            tail.next = l2;
            tail = tail.next;
            l2 = l2.next;
            mergeTwoListsRecursion(l1, l2, tail);
        }

    }

    //Time: O(n+m)
    //Space: O(1)
    //Iterative approach Optimized way

    public ListNode mergeTwoListsOptimized(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        ListNode prehead = new ListNode(-1);
        ListNode tail = prehead;

        while(list1!=null && list2!=null){
            if (list1.val <= list2.val){
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            }else{
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        if (list1!=null){
            tail.next = list1;
        }
        if (list2!=null){
            tail.next = list2;
        }

        return prehead.next;
    }

    /**
     * Iterative Intuition approach
     * Time: O(n+m)
     * Space : O(1)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListsIntution(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode head = null;
        ListNode tail = head;
        while(list1!=null && list2!=null){
            if (list1.val <= list2.val){
                if (head == null){ // 1
                    head = list1;
                    tail = head;
                }else{
                    tail.next = list1;
                    tail = tail.next;
                }
                list1 = list1.next;
            }else{
                if (head == null){
                    head = list2;
                    tail = head;
                }else{
                    tail.next = list2;
                    tail = tail.next;
                }
                list2 = list2.next;
            }
        }

        if (list1!=null){
            tail.next = list1;
        }
        if (list2!=null){
            tail.next = list2;
        }

        return head;

    }
}
