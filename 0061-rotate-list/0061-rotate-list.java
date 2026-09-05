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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode temp =head;
        int count =0;
        while(temp!= null){
            count++;
            temp =temp.next;

        }
        k = k % count;
        if(k==0){
            return head;
        }
        temp =head;
        int count2=0;
        while(temp !=null){
            if(count-k<=count2){
                curr.next=temp;
                curr=curr.next;
            }
            count2++;
            temp =temp.next;
        }
       temp =head;
       for(int i =1;i<count-k;i++){
        temp =temp.next;
       }
        ListNode newHead = temp.next;
        temp.next = null;

        curr.next = head; 

        return newHead;
    }
}