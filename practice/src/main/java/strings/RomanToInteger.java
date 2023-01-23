package main.java.strings;

import java.util.Map;
/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given a roman numeral, convert it to an integer.



        Example 1:

        Input: s = "III"
        Output: 3
        Explanation: III = 3.*/
public class RomanToInteger {
    static Map<Character, Integer> romanToIntMap = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000);
    public static void main(String[] args) {
        System.out.println(romanToInteger("III"));
        System.out.println(romanToInteger("LVIII"));
        System.out.println(romanToInteger("MCMXCIV"));
    }

    private static int romanToInteger(String roman) {
        char[] chars = roman.toCharArray();
        int finalNum=0;
        for (int i=0; i < chars.length; i++) {
            if (i == chars.length-1) {
                finalNum = finalNum + romanToIntMap.get(chars[i]);
            } else if (romanToIntMap.get(chars[i]) < romanToIntMap.get(chars[i+1])) {
                finalNum = finalNum + (romanToIntMap.get(chars[i+1]) - romanToIntMap.get(chars[i]));
                i++;
            } else {
                finalNum = finalNum + romanToIntMap.get(chars[i]);
            }
        }
        return finalNum;
    }

    /* faster
    public static int romanToInteger(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) {
                ans -= num;
            } else {
                ans += num;
            }
        }
        return ans;
    }*/
}
