public class Jianz022 {
    public class ListNode {
     int val;
     ListNode next = null;
     public ListNode(int val) {
       this.val = val;
     }
   }
   //1.双指针
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode node1 = pHead;
        ListNode node2 = pHead;
        while(node1 != null){
            node1 = node1.next;
            if(k != 0){
                k--;
            }else{
                node2 = node2.next;
            }
        }
        return k == 0 ? node2 : null;
    }
}
