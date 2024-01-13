package leetcode.com.dailyproblems;

class LC_28_FindTheIndexOfTheFirstOccurrenceInAString {
    /**
     len(needle) > len(haystack)
     return -1;
     0 1 2 3 4 5 6 7 8
     s a d b u t s a d
     a d b u t s a d
     s a d
     0 1 2 3 4 5 6 7
     l e e t c o d e
     0 1 2
     e e t
     */

    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        for(int windowStart=0;windowStart<=n-m;windowStart++){
            for (int i=0;i<m;i++){
                if (needle.charAt(i)!=haystack.charAt(windowStart+i)){
                    break;
                }
                if (i == m - 1){
                    return windowStart;
                }
            }
        }
        return -1;
    }


    //Time - O(n * m)
    //Space - O(1)
    public int strStrBestApproach(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        // if (haystack.length() < needle.length()){
        //     return -1;
        // }

        for(int end=0;end<h-n+1;end++){
            if (haystack.charAt(end) == needle.charAt(0)){
                if (haystack.substring(end, end+n).equals(needle)){
                    return end;
                }
            }
        }
        return -1;
    }

    private boolean isNeedleInHayStack(String haystack, String needle, int index1){
        int index2 = 0;
        //here we dont need to check index1 < haystack.length() since it wont exceed as we are checking h-n in above for loop. if index1 reaches end of string even index2 reaches at the end of needle. But keeping as general good to have condition.
        while(index1 < haystack.length() && index2 < needle.length()){
            if (haystack.charAt(index1) == needle.charAt(index2)){
                index1++;
                index2++;
            }else{
                return false;
            }
        }
        if (index2 < needle.length()){
            return false;
        }
        return true;
    }


    public int strStrIntuition(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        if (haystack.length() < needle.length()){
            return -1;
        }

        for(int end=0;end<h-n+1;end++){
            if (haystack.charAt(end) == needle.charAt(0)){
                if (isNeedleInHayStack(haystack, needle, end)== true){
                    return end;
                }
            }
        }
        return -1;
    }


}