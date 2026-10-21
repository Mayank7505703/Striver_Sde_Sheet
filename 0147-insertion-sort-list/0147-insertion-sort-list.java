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
    public ListNode insertionSortList(ListNode head) {
        ArrayList<Integer>list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int c[]= new int[list.size()];
        int k =0;
        for(int i : list){
            c[k++]=i;
        }
        for(int i =0;i<c.length;i++){
            int j=i;
            while(j>0 && c[j-1]>c[j]){
                int tem = c[j];
                c[j]=c[j-1];
                c[j-1]=tem;
                j--;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int i=0;i<list.size();i++){
            curr.next = new ListNode(c[i]);
            curr= curr.next; 
        }
        return dummy.next;
    }
}