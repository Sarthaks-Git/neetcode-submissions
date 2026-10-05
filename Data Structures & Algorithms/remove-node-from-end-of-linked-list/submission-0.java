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

class Solution {
    int count=0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=new ListNode(0);

        temp.next=head;

        remove(temp,n);

        return temp.next;
    }

    private void remove(ListNode node,int n){
        if(node == null) return;

        remove(node.next,n);
        count++;

        if(count == n+1) 
            node.next=node.next.next;
    }
}
