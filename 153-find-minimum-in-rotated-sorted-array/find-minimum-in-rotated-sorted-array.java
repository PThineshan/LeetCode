class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
       
        if (nums[0] < nums[len - 1])
            return nums[0];

        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[len - 1]) {
                result = nums[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;    
    }
}