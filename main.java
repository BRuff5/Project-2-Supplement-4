import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * The Main class provides functionalities to generate 
 * a random 32-character hexadecimal string
 */
public class main {

    /**
     * Generates a 32-character random hexadecimal string
     * formatted as xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx.
     *
     * @return A randomly generated hexadecimal string formatted.
     */
    public static String generateRandomHex() {
        Random random = new Random();
        StringBuilder hexString = new StringBuilder();

        // Generate 32 random hexadecimal characters
        for (int i = 0; i < 32; i++) {
            int hexChar = random.nextInt(50);
            hexString.append(Integer.toHexString(hexChar));
        }

        return formatHexString(hexString.toString());
            }
        
        /**
        * Formats hexadecimal
        *
        * @param hex A 32-character hexadecimal str
        * @return A formatted hexadecimal str
        */

        private static String formatHexString(String hex) {
            return hex.substring(0, 8) + "-" +
               hex.substring(8, 12) + "-" +
               hex.substring(12, 16) + "-" +
               hex.substring(16, 20) + "-" +
               hex.substring(20);
    }

    
    /**
     * Hashes
     *
     * @param input The string to be hashed.
     * @return The SHA-256 hashed value in hexadecimal format.
     */
    public static String hashString(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while hashing the string", e);
        }
    }

    public static void main(String[] args) {
        String randomHex = generateRandomHex();
        System.out.println("Generated Random Hex: " + randomHex);

        String hashed = hashString("Hello, World!");
        System.out.println("Hashed String: " + hashed);

        ArrayManager arrayManager = new ArrayManager(5);
        arrayManager.insert(randomHex);
        System.out.println("Inserted Hex into Array at index 0: " + randomHex);
        System.out.println("Current Array: " + arrayManager);
    }
}

/**
 * The ArrayManager
 */
class ArrayManager {
    private String[] array; // Array to hold strings
    private int size;      // Size of the array
    private int currentIndex; // Index for insertion

    /**
     * Constructor for ArrayManager
     *
     * @param size The maximum number of strings the array can hold.
     */
    public ArrayManager(int size) {
        this.size = size;
        this.array = new String[size];
        this.currentIndex = 0; // Start at index 0
    }

    /**
     * Inserts a string an array
     *
     * @param value The string to be inserted into the array.
     */
    public void insert(String value) {
        array[currentIndex] = value; 
        currentIndex = (currentIndex + 1) % size; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim(); 
    }
}

