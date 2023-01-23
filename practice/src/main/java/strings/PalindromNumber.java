package main.java.strings;

/*
Given an integer x, return true if x is a
        palindrome
        , and false otherwise.



        Example 1:

        Input: x = 121
        Output: true
        Explanation: 121 reads as 121 from left to right and from right to left.
        Example 2:

        Input: x = -121
        Output: false
        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.*/
public class PalindromNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    private static boolean isPalindrome(int num) {
        if (num<0) return false;
        int temp = num; //copy num
        int reverse = 0;
        while (num != 0) {
            reverse = reverse*10 + num%10; //shift all digits in reverse to left by *10 and then add the last digit using %10
            num = num/10; //chop last digit
        }
        return reverse==temp;
    }
}
