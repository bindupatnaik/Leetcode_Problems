package leetcode.com.dailyproblems;

/**
 * the same question can be asked to print all unique numbers in a given list or array which is not sorted.
 * Note: duplicates are present.
 *
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 *
 * then use Set to save unique numbers and return set
 *
 * but if they ask not to use extra space then sort the array first in-place and then
 *
 * start =0;
 * System.out.println(nums[start]);
 * for (int end=1;end<n;end++){
 *             if (nums[start]!=nums[end]){
 *                System.out.println(nums[end]);
 * 							 start = end;
 *             }
 *        }
 */

class LC_26_RemoveDuplicatesFromSortedArray {
    /*
     nums = [1,1,2,2,2,3,4,5,5,6,6]
     nums = [0,0,1,1,1,2,2,3,3,4]
     Time: O(n)
     Space: O(1)
    */
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int start = 0;
        int n = nums.length;
        for (int end=1;end<n;end++){
            if (nums[start]!=nums[end]){
                nums[++start] = nums[end];
            }
        }
        return start + 1;
    }
}
