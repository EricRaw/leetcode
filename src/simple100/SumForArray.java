package simple100;

/**
 * @author EricRaww
 * @create 2020-11-01
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 */
public class SumForArray {
    public static void main(String[] args) {
        int [] arr={2,7,11,15};
        int sum=13;
        for (int i = 0; i <arr.length ; i++) {
            //i==0,j==1
            //i==1,j==2
            //i==2,j==3
            for (int j = i+1; j <arr.length; j++) {
                int sum1=arr[i]+arr[j];
                System.out.println(sum1);
                if(sum1==sum){
                    System.out.println("result is "+i+ " and "+ j);
                }
            }
        }
    }
}
