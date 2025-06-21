class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int area = (right - left) * min(height[left], height[right]);
            if (area > maxWater)
                maxWater = area;

            if (height[left] <= height[right])
                left++;
            else
                right--;        
        }

        return maxWater;
        
    }

    private int min(int a, int b) {
        if (a<=b)
            return a;
        return b;    
    }
}