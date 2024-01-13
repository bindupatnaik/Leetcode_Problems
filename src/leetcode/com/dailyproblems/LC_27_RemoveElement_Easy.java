package leetcode.com.dailyproblems;

class LC_27_RemoveElement_Easy {
    /**
     [-1,-20,8, 21, 21, 36,-20 , 41] val = -20
     start = -1;
     end = 0 to n-1;
     while(){
     if nums[end]!= val{
     swapping is not needed
     //instead replace the value of start with end.
     }else{
     continue;
     }
     }

     return ++start;
     */

    //Time: O(n)
    //Space : O(1)
    public int removeElement(int[] nums, int val) {
        int start = -1;
        for (int end=0;end<nums.length;end++){
            if (nums[end] != val){
                //No need to swap the values. just need to replace.
                // int temp = nums[++start];
                // nums[start] = nums[end];
                // nums[end] = temp;
                nums[++start] = nums[end];
            }else{
                continue;
            }
        }
        return start+1;
    }
}
