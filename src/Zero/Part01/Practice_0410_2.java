package Zero.Part01;

public class Practice_0410_2 {

    public static int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            int x = (right - left);
            int y = height[left] < height[right] ? height[left] : height[right];
            int curArea = x * y;
            maxArea = maxArea > curArea ? maxArea : curArea;

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution(height));
    }
}
