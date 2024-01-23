package Java_Internship;

import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int passwordStrength = checkPasswordStrength(password);
        String strengthFeedback = getStrengthFeedback(passwordStrength);

        System.out.println(strengthFeedback);
    }

    public static int checkPasswordStrength(String password) {
        int strength = 0;
        
        if (password.length() >= 8) {
            strength++;
        }
        
        if (password.matches(".*[A-Z].*")) {
            strength++;
        }
        
        if (password.matches(".*[a-z].*")) {
            strength++;
        }
        
        if (password.matches(".*\\d.*")) {
            strength++;
        }
        
        if (password.matches(".*[@#$%^&+=].*")) {
            strength++;
        }
        
        return strength;
    }

    public static String getStrengthFeedback(int strength) {
        switch (strength) {
            case 0:
                return "Weak password. Please choose a longer password.";
            case 1:
                return "Fair password. Consider adding more complexity.";
            case 2:
                return "Moderate password. You're on the right track!";
            case 3:
                return "Strong password. Well done!";
            case 4:
                return "Very strong password. Keep up the good work!";
            default:
                return "Invalid password.";
        }
    }
}












//
//import java.util.Scanner;
//
//public class PasswordStrengthChecker {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a password: ");
//        String password = scanner.nextLine();
//        
//        int score = 0;
//        if (password.length() >= 8) {
//            score++;
//        }
//        if (password.matches(".*[A-Z].*")) {
//            score++;
//        }
//        if (password.matches(".*[a-z].*")) {
//            score++;
//        }
//        if (password.matches(".*\\d.*")) {
//            score++;
//        }
//        if (password.matches(".*[^a-zA-Z0-9].*")) {
//            score++;
//        }
//        
//        if (score >= 4) {
//            System.out.println("Strong password");
//        } else if (score >= 3) {
//            System.out.println("Medium password");
//        } else {
//            System.out.println("Weak password");
//        }
//    }
//}