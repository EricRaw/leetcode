package simple100;

/**
 * @author EricRaww
 * @create 2022-04-04
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 用 f(x)f(x) 表示爬到第 xx 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：
 *
 */
public class N70ClimbStairs {
    public static void main(String[] args) {
        int i = climbStairs(5);
        System.out.println(i);
    }

    /**
     * 方法一：递归
     * @param n
     * @return
     */
    private static int climbStairs( int n){
        if(n== 1)
            return 1;
        if (n ==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
}
