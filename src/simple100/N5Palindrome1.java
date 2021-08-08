package simple100;

/**
 * @author EricRaww
 * @create 2021-08-08
 * @description
 */
public class N5Palindrome1 {
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
        /**
         * 枚举所有长度大于1的子串
         */
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (j-i+1>maxLength && validPalindromic(charArray,i,j)){
                    maxLength=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLength);

    }
    private static boolean validPalindromic(char[] charArray, int left, int right){
        while (left<right){
            if (charArray[left] !=charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
