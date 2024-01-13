package leetcode.com.dailyproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Time: O(n)
//Space : O(n) in worst case if the tree is sparse, otherwise in average case O(logN) if tree is balanced
class LC_94_BinaryTreeInorderTraversal_Easy {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        inorderTraversalRecursion(root, output);
        return output;
    }

    private void inorderTraversalRecursion(TreeNode curr, List<Integer> output) {
        if (curr == null) {
            return;
        }
        inorderTraversalRecursion(curr.left, output);
        output.add(curr.val);
        inorderTraversalRecursion(curr.right, output);
    }
    //Time: O(n)
    //Space : O(n) if tree is sparse the stack contains n elements to left and then O(logN) in case of balance tree
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null){
            return output;
        }
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while(curr!=null || !stack.isEmpty()){

            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;

        }

        return output;
    }


}