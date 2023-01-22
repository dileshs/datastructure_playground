package main.java;

import java.util.Arrays;
/*Write a function to find the longest common prefix string amongst an array of strings.

        If there is no common prefix, return an empty string "".



        Example 1:

        Input: strs = ["flower","flow","flight"]
        Output: "fl"
        Example 2:

        Input: strs = ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.*/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[] {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int index=1; index < strs.length; index++) {
            //while(!strs[index].startsWith(prefix))
            while(strs[index].indexOf(prefix) != 0) { // check if current string has prefix value
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

    /*public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length() && first.charAt(c) == last.charAt(c))
        {
            c++;
        }
        return c == 0 ? "" : first.substring(0, c);
    }*/
}
