public class Jianz025 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //1.迭代
    /*public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode tmp = new ListNode(-1);
        ListNode yummy = tmp;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tmp.next = list1;
                list1 = list1.next;
            }else{
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if(list1 != null) tmp.next = list1;

        if(list2 != null) tmp.next = list2;

        return yummy.next;
    }*/
    //2.递归
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null || list2 == null){
            return list1 != null ? list1 : list2;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }else{
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }
}
