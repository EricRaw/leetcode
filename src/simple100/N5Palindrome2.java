package simple100;

/**
 * @author EricRaww
 * @create 2021-08-08
 * @description 中心扩散法
 * 时间复杂度：O(n的二次方)，n为字符串的长度
 * 空间复杂度：O(1),只用到常数个的临时变量
 */
public class N5Palindrome2 {
    public static void main(String[] args) {
        String s = longestPalindrome("cbbd");
        System.out.println(s);

    }

    public static String longestPalindrome(String s){
        int len=s.length();
        if (len<2){
            return s;
        }
        int maxLength=1;
        int begin=0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len-1; i++){
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i + 1);
            int curMaxLen = Math.max(oddLen, evenLen);
            if(curMaxLen >maxLength){
                maxLength=curMaxLen;
                begin=i-(maxLength-1)/2;
            }
        }
        return s.substring(begin,begin+maxLength);

    }

    /***
     *
     * @param charArray
     * @param left
     * @param right
     * @return 当left=right的时候，回文中心是一个字符串，回文串的长度是奇数
     * 当left+1=right的时候，此时回文中心两个字符串，回文串的长度是偶数
     */
    private static int expandAroundCenter(char[] charArray, int left, int right) {
        int len = charArray.length;
        int i=left;
        int j=right;
        while (i>=0 && j<len){
            if(charArray[i] == charArray[j]){
                i--;
                j++;
            }else {
                break;
            }
        }
        return j-i-1;
    }


}
