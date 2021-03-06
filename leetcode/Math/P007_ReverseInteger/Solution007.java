package Math.P007_ReverseInteger;

/**
 * @Data Structures:
 * @Algorithms used:
 * @Time Complexity:   O(n)
 * @Space Complexity:  O(1)
 */
public class Solution007 {
    public int reverse(int x) {
        long ret = 0;
        while (x != 0) {
            ret = ret * 10 + (x % 10);
            if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) ret;
    }

    public static void main(String[] args) {
        Solution007 sol = new Solution007();
        System.out.println(sol.reverse(153423649));
    }
}
