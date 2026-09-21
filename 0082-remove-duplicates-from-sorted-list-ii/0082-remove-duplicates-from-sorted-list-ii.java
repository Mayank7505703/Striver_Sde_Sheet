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
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer>list = new ArrayList<>();
        ListNode temp= head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        LinkedHashMap<Integer,Integer>map =new LinkedHashMap<>();
        for(int c: list){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr= dummy;
        for(int i:map.keySet()){
            if(map.get(i)==1){
                curr.next =new ListNode(i);
                curr=curr.next;
            }
        }
        return dummy.next;
    }
}