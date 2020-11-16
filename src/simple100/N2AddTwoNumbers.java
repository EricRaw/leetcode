package simple100;

/**
 * @author EricRaww
 * @create 2020-11-16
 */
public class N2AddTwoNumbers {

    public static void main(String[] args) {

    }

    /**
     * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
     *
     * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。具体而言，如果当前两个链表处相应位置的数字为 n1,n2n1,n2，进位值为 \textit{carry}carry，则它们的和为 n1+n2+\textit{carry}n1+n2+carry；其中，答案链表处相应位置的数字为 (n1+n2+\textit{carry}) \% 10(n1+n2+carry)%10，而新的进位值为 \lfloor\frac{n1+n2+\textit{carry}}{10}\rfloor⌊
     * 10
     * n1+n2+carry
     * ​
     *  ⌋。
     *
     * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 00 。
     *
     * 此外，如果链表遍历结束后，有 \textit{carry} > 0carry>0，还需要在答案链表的后面附加一个节点，节点的值为 \textit{carry}carry
     *
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public static N2ListNode addtwo(N2ListNode l1,N2ListNode l2){
        N2ListNode head=null,tail=null;
        int carry=0;
        while (l1 !=null || l2 !=null){
            int n1= l1 !=null ? l1.val : 0;
            int n2= l2 !=null ? l2.val : 0;
            int sum=n1+n2+carry;
            if(head == null){
                head = tail =new N2ListNode(sum % 10);
            }else {
                tail.next=new N2ListNode(sum % 10);
                tail=tail.next;
            }
            carry=sum/10;
            if(l1 !=null){
                l1 = l1.next;
            }
            if(l2 !=null)
                l2=l2.next;
        }
        if(carry > 0){
            tail.next=new N2ListNode(carry);
        }
        return head;
    }
}
