package leetcode.com.dailyproblems;

class LC_08_StringToIntegerAtoI {
    /**
     * " -45"
     * " +45"
     * " 45"
     * " -+45"
     * Question to ask?
     * " abcd +42"
     *
     * total = 0;
     * sign = 1;
     *
     * write code to ignore the white Space
     * if c == '-':
     * sign = -1;
     * index++;
     * else if (c == '+')
     * sign = 1;
     *
     * isDigit()
     *
     Time: O(n)
     Space : O(1)
     *
     */
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int index = 0;
        int sign = 1;
        long total = 0;

        for (index = 0; index < s.length(); index++) {
            if (s.charAt(index) != ' ') {
                break;
            }
        }
        if (index < s.length() && s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (index < s.length() && s.charAt(index) == '+') {
            sign = 1;
            index++;
        }
        // " -45"
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            char c = s.charAt(index);
            total = total * 10 + c - '0';

            if (total * sign > Integer.MAX_VALUE) {
                total = Integer.MAX_VALUE;
                break;
            }
            if (total * sign < Integer.MIN_VALUE) {
                total = Integer.MIN_VALUE;
                System.out.println(total);
                break;
            }
            index++;
        }
        return (int) total * sign;
    }
}