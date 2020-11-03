package simple100;



/**
 * @author EricRaww
 * @create 2020-11-03
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: -123
 * 输出: -321
 * 输入: 120
 * 输出: 21
 * 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 */
public class reverseInt {

    public static void main(String[] args) {
        int i=-120;
        System.out.println(reverse(i));
        System.out.println(reverseFromleetcode(i));
    }
    public static int reverse(int x){
        String s = String.valueOf(x);
        if(s.contains("-")){
            s=s.substring(1);
            StringBuilder result=new StringBuilder(s);
            result.reverse();
            if(Long.parseLong(result.toString())>Integer.MAX_VALUE || Long.parseLong(result.toString())<Integer.MIN_VALUE )
                return 0;
            return -Integer.parseInt(result.toString());
        }else {
            StringBuilder result=new StringBuilder(s);
            result.reverse();
            if(Long.parseLong(result.toString())>Integer.MAX_VALUE || Long.parseLong(result.toString())<Integer.MIN_VALUE )
                return 0;
            return Integer.parseInt(result.toString());
        }
    }
    /**
     * 方法：弹出和推入数字 & 溢出前进行检查
     * 思路
     *
     * 我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
     */
    public static int reverseFromleetcode(int x){
        int rev=0;
        while (x !=0){
            int pop=x % 10;
            x /= 10;
            if(rev >Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE /10 && pop>7)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE /10 && pop< -8 )) return 0;
            rev=rev*10 +pop;
        }
        return rev;
    }

}
