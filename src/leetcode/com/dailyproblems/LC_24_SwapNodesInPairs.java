package leetcode.com.dailyproblems;


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
class LC_24_SwapNodesInPairs {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    //Approach - using Prehead approach
    //Desc: here you use prev = prehead and keep moving prev and current pointers
    //Time: O(n)
    //Space : O(1)
    public ListNode swapPairsUsingPrevNode(ListNode head) {

        if (head == null){
            return head;
        }

        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode curr = head;
        ListNode prev = prehead;

        while(curr!=null && curr.next!=null){
            prev.next = curr.next;
            ListNode afterNode = curr.next.next ;
            curr.next.next = curr;
            curr.next = afterNode;

            prev = curr;
            curr = curr.next;
        }
        return prehead.next;
    }
    // 1->2->3->4->5->6
    // 2->1->3->4->5->6
    //

    //Approach2 - naming each node seperately that helps for easy coding
    //Time = O(n)
    //Space = O(1)
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode current_node = head;
        ListNode swap_node = null;
        ListNode after_node = null;
        ListNode previous_node = null;

        ListNode new_head = current_node.next;
        while(current_node!=null && current_node.next!=null){
            swap_node = current_node.next; // 2, 4
            after_node = swap_node.next; // 3, 5

            current_node.next = after_node;//3, 5
            swap_node.next = current_node;//1, 3

            if (previous_node!=null){
                previous_node.next = swap_node;
            }
            previous_node = current_node; // 1 3
            current_node = current_node.next;//3 5
        }

        return new_head;

    }

}
