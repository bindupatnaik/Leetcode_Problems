package leetcode.com.dailyproblems;



class LC_11_ContainerWithMostWater {
    /**
     *
     * [1,8,6,2,5,4,8,3,7]
     bruteforce
     for (i=0 to n){
        for (j = i+1 to n){
            width = min(height[i],height[j])
            length = j - i
            currArrea = width * length
            maxArea = max(currArea, maxArea)
        }
     }
     two pointer approach
     start = 0;
     end = len(height) - 1
     while(start < end)
        min(height[start], height[end]) * (end - start)

     */
    //two pointer approach
    //[1,8,6,2,5,4,8,3,7]
    // Time: O(n)
    // Space : O(1)
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while(start < end){
            int length = Math.min(height[start], height[end]) ;
            int breadth = end - start;
            int currArea = length * breadth;
            maxArea = Math.max(currArea, maxArea);
            if (height[start] <= height[end]){
                start++;
            }else if (height [start] > height[end]){
                end--;
            }
        }
        return maxArea;
    }
    //BruteForce - TimeLimitExceeded
    //Time : O(n^2)
    //Space : O(1)
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for(int start=0;start<height.length;start++){
            for(int end=start+1;end<height.length;end++){
                int length = Math.min(height[start], height[end]);
                int breadth = end - start;
                int currArea = length * breadth;
                maxArea = Math.max(currArea, maxArea);
            }
        }
        return maxArea;
    }
}
