package leetcode.com.dailyproblems;

import java.util.ArrayList;
import java.util.List;

class LC_46_Permutations {
    /**
     1 2 3
     1 3 2
     2 1 3
     2 3 1
     3 2 1
     3 1 2
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        permuteRec(nums, 0 , output);
        return output;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //Time: O(n.n!)
//    There are nnn options for the first number, n−1n - 1n−1 for the second, and so on.
//    For each of the n!n!n! permutations, we need O(n)O(n)O(n) work to copy curr into the answer. This gives us O(n⋅n!)O(n \cdot n!)O(n⋅n!) work.
    //Space : O(n.n!) there are n! leaf nodes and cost to copy n items to a list is n and there are n! items like that. But if
    //you don't consider the space to save ans we just consider the number of recursion calls. which os O(n) alone recursion calls.

    private void permuteRec(int[] nums, int i, List<List<Integer>> output){

        //base condition
        if (i == nums.length){
            List<Integer> list = new ArrayList<>();
            for (int j=0;j<nums.length;j++){
                list.add(nums[j]);
            }
            output.add(list);
            return;
        }

        //algorithm
        for(int j=i;j<nums.length;j++){
            swap(nums, i, j);
            permuteRec(nums, i+1, output);
            swap(nums, i,j);
        }
    }
}
