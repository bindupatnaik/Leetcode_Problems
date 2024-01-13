package leetcode.com.dailyproblems;

class LC_1768_MergeStringAlterately {

    //Time : O(max(n1,n2))
    //Space : O(n1+n2) for storing the output
    public String mergeAlternatelyIntuition(String word1, String word2) {
        /**
         word 1 = pqrs ab.   abcd
         word 2 = ab.  pqrs  pqrs
         start with word1
         */
        //edge cases
        if (word1==null || word1.length()==0){
            return word2;
        }

        if (word2==null || word2.length()==0){
            return word1;
        }

        StringBuilder buffer = new StringBuilder();
        int i = 0;
        int n1 = word1.length();
        int n2 = word2.length();
        for (i=0;i<n1;i++){
            char c1 = word1.charAt(i);
            buffer.append(c1);

            if (i < n2){
                char c2 = word2.charAt(i);
                buffer.append(c2);
            }
        }

        if (i<n2){
            buffer.append(word2.substring(i,n2));
        }

        return buffer.toString();
    }
    /**
     Constraints:

     1 <= word1.length, word2.length <= 100
     word1 and word2 consist of lowercase English letters.

     Time : O(max(n1,n2))
     Space: O(n1+n2)
     */
    public String mergeAlternately(String word1, String word2) {

        if (word1==null || word1.length()==0){
            return word2;
        }

        if (word2==null || word2.length()==0){
            return word1;
        }

        int n1 = word1.length();
        int n2 = word2.length();
        int p1 = 0;
        int p2 = 0;
        StringBuilder result = new StringBuilder();
        while(p1 < n1 || p2 < n2){

            if (p1 < n1){
                result.append(word1.charAt(p1));
                p1++;
            }

            if (p2 < n2){
                result.append(word2.charAt(p2));
                p2++;
            }
        }
        return result.toString();
    }
}
