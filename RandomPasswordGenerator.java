package Java_Internship;

import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()_-+=<>?";

        String password = "";

        for (int i = 0; i < length; i++) {
            String charSet = "";

            if (includeNumbers) {
                charSet += numbers;
            }
            if (includeLowercase) {
                charSet += lowercaseLetters;
            }
            if (includeUppercase) {
                charSet += uppercaseLetters;
            }
            if (includeSpecialChars) {
                charSet += specialChars;
            }

            int randomIndex = random.nextInt(charSet.length());
            char randomChar = charSet.charAt(randomIndex);
            password += randomChar;
        }

        System.out.println("Generated password: " + password);

        scanner.close();
    }
}