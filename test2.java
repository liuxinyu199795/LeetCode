package GaoPinSuanFa;

public class test2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode p=l1, q=l2, cur=l3;
        int add = 0;
        while(p!=null||q!=null){
            int x=(p!=null)?p.val:0;
            int y=(q!=null)?q.val:0;
            int sum =x+y+add;
            add=sum/10;
            cur.next=new ListNode(sum % 10);
            cur=cur.next;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        if(add>0){
            cur.next = new ListNode(add);
        }
        return l3.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1= new ListNode(3);
        ListNode l2= new ListNode(9);
        ListNode l3=addTwoNumbers(l1,l2);
    }
}

