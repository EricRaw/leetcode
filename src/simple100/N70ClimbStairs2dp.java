package simple100;

/**
 * @author EricRaww
 * @create 2022-04-04
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 用 f(x)f(x) 表示爬到第 xx 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：
 * f(x)=f(x−1)+f(x−2)
 */
public class N70ClimbStairs2dp {
    public static void main(String[] args) {
        int i = climbStairs(45);
        System.out.println(i);
    }

    /**
     * 方法三：动态规划
     * @param n
     * @return
     */
    private static int climbStairs( int n){
        if (n==1){
            return 1;
        }
        int [] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
