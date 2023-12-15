package Java_Internship;
public class PalindromeChecker {
    public static boolean isPalindrome(String word) {
        String strippedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int left = 0;
        int right = strippedWord.length() - 1;

        while (left < right) {
            if (strippedWord.charAt(left) != strippedWord.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String word = "A man, a plan, a canal, Panama!";
        System.out.println(isPalindrome(word));
        if(isPalindrome(word)==true) {
        	System.out.println("                        Perfect Match !!!");
        }
        else {
        	System.out.println("                        OOPs No Match ! ");
        }
    }
}