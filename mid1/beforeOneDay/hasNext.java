import java.util.Scanner;
class ScannerExample {
    public static void main(String[] args) {
        // Example input string
        String input = "Hello world! How are you?";
        
        // Create a Scanner object to scan through the input string
        Scanner scanner = new Scanner(input);
        
        // Check if there are more tokens available
        while (scanner.hasNext()) {
            // Read the next token
            String token = scanner.next();
            System.out.println("Token: " + token);
        }
        
        // Close the scanner to release resources
        scanner.close();
    }
}
