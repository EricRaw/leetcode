package simple100;

/**
 * @author EricRaww
 * @create 2021-08-08
 * @description 动态规划
 * 时间复杂度：O(n的二次方)，n为字符串的长度
 * 空间复杂度：O(n的二次方),即存储动态规划状态需要的空间
 */
public class N5Palindrome3 {
    public static void main(String[] args) {
        String s = longestPalindrome("cbbcaaad");
        System.out.println(s);

    }

    private static String longestPalindrome(String s){
        int len=s.length();
        if (len<2){
            return s;
        }
        int maxLen=1;
        int begin=0;
        //dp[i][j]表示s[i...j]是否是回文串
        boolean [][] dp=new boolean[len][len];
        //初始化：所有长度为i的子串都是回文串
        for (int i = 0; i <len ; i++) {
            dp[i][i]=true;
        }
        char[] charArray=s.toCharArray();
        //递推开始
        //先枚举子串长度
        for (int L = 2; L < len; L++) {
            //枚举左边界
            for (int i = 0; i < len; i++) {
                //由L和i可以确定右边界，即j-i+1=L得
                int j=L+i-1;
                //如果右边界越界，就可以退出当前循环
                if(j>=len){
                    break;
                }
                if (charArray[i] != charArray[j]){
                    dp[i][j] =false;
                }else {
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                //只要dp[i][L]==true成立，就表示s[i..L]是回文，此时记录长度和起始位置
                if (dp[i][j] && j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;

                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }





















}
