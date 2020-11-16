package simple100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EricRaww
 * @create 2020-11-05
 */
public class N3LengthOfLongestSubString {
    public static void main(String[] args) {
        //aab
        //abcabcbb
        //bbbbb
        //pwwkew
        //dvdf
        String s = "dvdf";
        System.out.println(lengthOfLongestSubString(s));
        System.out.println(lengthOfLongestSubStringFromleetcode(s));
    }
   //自己的想法不过关
    public static int lengthOfLongestSubString(String s) {
        int result = 0;
        int Maxresult=0;
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashSet.contains(s.charAt(i))) {
                hashSet.clear();
                if(Maxresult<=result){
                    Maxresult=result;
                }
                hashSet.add(s.charAt(i));
                result=1;
            }else{
                hashSet.add(s.charAt(i));
                result=result+1;
            }
        }
        if(result>=Maxresult){
            return result;
        }else {
            return Maxresult;
        }
    }

    /**
     *
     * @param s
     * @return
     * 滑动窗口
     */
    public static int lengthOfLongestSubStringFromleetcode(String s) {

        Set<Character> hashSet=new HashSet<>();
        int n=s.length();
        //右指针，初始值为-1
        int rk=-1,ans=0;
        for (int i = 0; i <n ; i++) {
            if(i != 0){
                hashSet.remove(s.charAt(i-1));
            }
            while (rk+1<n && !hashSet.contains(s.charAt(rk+1))){
               hashSet.add(s.charAt(rk+1));
               ++rk;
            }
            ans=Math.max(ans,rk-i+1);
        }
        return ans;
    }

}
