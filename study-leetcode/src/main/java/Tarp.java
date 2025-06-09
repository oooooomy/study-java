import java.util.Arrays;

public class Tarp {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Tarp().trap(height));
    }

    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] >= max) {
                max = height[i];
            }
            prefix[i] = max;
        }

        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (height[i] >= max) {
                max = height[i];
            }
            suffix[i] = max;
        }

        for (int i = 0; i < n; i++) {
            res += (Math.min(prefix[i], suffix[i]) - height[i]);
        }

        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(suffix));
        return res;
    }

}
