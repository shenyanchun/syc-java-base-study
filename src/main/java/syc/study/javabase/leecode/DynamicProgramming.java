package syc.study.javabase.leecode;
/**
 * @author syc
 */
public class DynamicProgramming {
    public static int climbStairs(int n) {
       int q = 0,p = 0,r = 1;
        for (int i=1;i<=n;i++) {
            q = p;
            p = r;
            r = q+p;
        }

        return r;
    }


    public static void main(String[] args) {
        int i = climbStairs(10);
        System.out.println(i);
    }
}
