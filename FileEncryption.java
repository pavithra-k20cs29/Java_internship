package Java_Internship;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter '1' for encryption or '2' for decryption: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter the file name or path: ");
        String filePath = scanner.nextLine();

        File inputFile = new File(filePath);
        File outputFile = new File("encrypted.txt");

        try {
            if (option == 1) { //encryption 
                encryptFile(inputFile, outputFile);
                String fileName = filePath;
				Object encryptedContent = outputFile;
				System.out.println("encrypted_  " + fileName + encryptedContent);
                System.out.println("File encrypted successfully!");
            }
            
            else if (option == 2) { //Decryption
                decryptFile(inputFile, outputFile);
                String fileName = filePath;
				Object decryptedContent = outputFile;
				System.out.println("decrypted_  " + fileName + decryptedContent);
                System.out.println("File decrypted successfully!");
            } else {
                System.out.println("Invalid option entered!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
        }
    }

    private static void writeToFile(String string, Object encryptedContent) {
		
	}

	private static void encryptFile(File inputFile, File outputFile) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(inputFile.getAbsolutePath())));

        // Simple encryption algorithm: shift each character by 1 position
        StringBuilder encryptedData = new StringBuilder();
        for (char c : data.toCharArray()) {
            encryptedData.append((char) (c + 1));
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(encryptedData.toString());
        }
    }

    private static void decryptFile(File inputFile, File outputFile) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(inputFile.getAbsolutePath())));

        // Simple decryption algorithm: shift each character back by 1 position
        StringBuilder decryptedData = new StringBuilder();
        for (char c : data.toCharArray()) {
            decryptedData.append((char) (c - 1));
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(decryptedData.toString());
        }
    }
}














//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class FileEncryptionDecryption {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
//        char choice = scanner.next().charAt(0);
//
//        System.out.print("Enter the file name or path: ");
//        String fileName = scanner.next();
//
//        String inputContent = readFileContent(fileName);
//
//        if (choice == 'E') {
//            String encryptedContent = encrypt(inputContent);
//            writeToFile("encrypted_" + fileName, encryptedContent);
//            System.out.println("File encrypted successfully.");
//        } else if (choice == 'D') {
//            String decryptedContent = decrypt(inputContent);
//            writeToFile("decrypted_" + fileName, decryptedContent);
//            System.out.println("File decrypted successfully.");
//        }
//
//        scanner.close();
//    }
//
//    private static String readFileContent(String fileName) {
//        StringBuilder content = new StringBuilder();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(fileName));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                content.append(line);
//                content.append(System.lineSeparator());
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return content.toString();
//    }
//
//    private static void writeToFile(String fileName, String content) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
//            writer.write(content);
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String encrypt(String content) {
//        // Implement encryption algorithm
//        // Return the encrypted content
//        return null;
//    }
//
//    private static String decrypt(String content) {
//        // Implement decryption algorithm
//        // Return the decrypted content
//        return null;
//    }
//}