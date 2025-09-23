public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String newString = s.toLowerCase();
        String reversed = new StringBuilder(newString).reverse().toString();
        return reversed.equals(newString);
    }
}