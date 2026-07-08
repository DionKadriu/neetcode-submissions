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
    public ListNode mergeKLists(ListNode[] lists) {

          
        List<Integer> list = new ArrayList();

        for (ListNode nodes : lists){ 
           
            while (nodes != null){
                list.add(nodes.val);
                nodes = nodes.next;
            }
        }
        list.sort(Comparator.comparing(Integer::intValue));

        ListNode dummy = new ListNode();
        ListNode res = dummy;
        

        for (int val : list){
            dummy.next = new ListNode(val);
            dummy = dummy.next;
        }
        

        return res.next;
    }
}
