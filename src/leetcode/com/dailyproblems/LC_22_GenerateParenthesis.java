package leetcode.com.dailyproblems;


import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm: BackTracking
 * Time: 
 * Space: O(2*n) for recursion stack
 */
public class LC_22_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        backtrack(n, 0, 0, output, buffer);
        return output;
    }
    private void backtrack(int n, int open, int close, List<String> output, StringBuilder buffer){
        if (buffer.length() == 2 * n){
            output.add(buffer.toString());
            return;
        }
        if (open < n){
            buffer.append('(');
            backtrack(n, open+1, close, output, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
        }

        if (close < open){
            buffer.append(')');
            backtrack(n, open, close+1, output, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
        }

    }
}
