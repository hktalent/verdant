package Math.P258_AddDigits;

/**
 * @Data Structures:
 * @Algorithms used:
 * @Time Complexity:   O(n)
 * @Space Complexity:  O(1)
 */
public class Solution258 {
    public int addDigits(int num) {
        int dig = 0;
        if (num / 10 == 0)
            return num;
        while (num / 10 > 0) {
            dig += num % 10;
            num = num / 10;
        }
        dig += num;
        return addDigits(dig);
    }

    public static void main(String[] args) {
        Solution258 sol = new Solution258();
        System.out.println(sol.addDigits(12));
    }
}
