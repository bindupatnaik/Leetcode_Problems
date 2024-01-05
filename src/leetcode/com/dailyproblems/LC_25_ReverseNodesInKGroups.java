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

//Time: O(n)
//Space : O(1)
class LC_25_ReverseNodesInKGroups {
    /*
        k = 3
        counter = 1
        1 < k
        2 < k
        3 < 3
        1->2>3->4->5->6->7->8
        3->2->1->6->5->4->7->8
        front_node = curr = head
        reverseNodes(frontNode, currNode);
        currNode = currNode.next reset the counter to 1 and repeat it
    */

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public ListNode reverseKGroup(ListNode head, int k) {

        //edge cases
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr_node = head;
        ListNode front_node = head;
        ListNode prev_node = null;
        int counter = 1;
        ListNode rear_node = null;


        while(counter < k){
            curr_node = curr_node.next;
            counter++;
        }

        ListNode new_head = curr_node;
        curr_node = head;

        while(curr_node!=null){
            front_node = curr_node;
            counter = 1;
            while(counter < k && curr_node!=null ){
                curr_node = curr_node.next;
                counter++;
            }
            if (counter == k && curr_node!=null){
                rear_node = curr_node;
                reverseLL(front_node, rear_node);
                if (prev_node!=null){
                    prev_node.next = rear_node;
                }
                prev_node = front_node;
                curr_node = front_node.next;
            }

        }
        return new_head;
    }

    // 1->2>3->4->5->6->7->8
    // null<-1<-2 3
    //  2->1->3

    // 3->2->1->6->5->4->7->8

    private void reverseLL(ListNode front_node, ListNode rear_node){
        ListNode curr = front_node;
        ListNode prev = null;
        ListNode rear_next = rear_node.next;
        while(curr!=null && curr!=rear_next){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        front_node.next = curr;
    }
}


