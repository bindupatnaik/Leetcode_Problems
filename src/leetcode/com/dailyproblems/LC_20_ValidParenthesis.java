package leetcode.com.dailyproblems;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class LC_20_ValidParenthesis {
    /*
    valid - ()[]{}
    invalid - ][
    invalid - ({[
    */

    //Time : O(n)
    //Space : O(n)
    public boolean isValidIntuition(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == ')'){
                if (stack.isEmpty()){
                    return false;
                }else if(stack.peek()!='('){
                    return false;
                }else{
                    stack.pop();
                }
            }else if(c==']'){
                if (stack.isEmpty()){
                    return false;
                }else if(stack.peek()!='['){
                    return false;
                }else{
                    stack.pop();
                }
            }else if(c == '}'){
                if (stack.isEmpty()){
                    return false;
                }else if(stack.peek()!='{'){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();

    }

    //Time : O(n)
    //Space : O(n)
    //If interviewer asks to reduce repeated code of intuition approach
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (map.get(c)!=null){
                if (!stack.isEmpty() && stack.peek()!=map.get(c)){
                    return false;
                }else if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }

            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();


    }
}