import static org.junit.Assert.assertNotNull;

/**
 * Test class for the main class and ArrayManager.
 */
public class mainTest {

    /**
     * Test the generateRandomHex method.
     */
    
    public void testGenerateRandomHex() {
        String randomHex = main.generateRandomHex();

        // Verify that the generated string is not null
        assertNotNull(randomHex, "Generated hex string should not be null.");

        // Verify the length of the generated string
        assertEquals(36, randomHex.length(), "Formatted hex string should have 36 characters including dashes.");

        // Verify the format of the generated string
        String expectedPattern = "^[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}$";
        assertTrue(randomHex.matches(expectedPattern), "Generated hex string does not match the expected format.");
    }

    /**
     * Test the hashString method.
     */
    
    public void testHashString() {
        String input = "Hello, World!";
        String hashed = main.hashString(input);

        // Verify that the hashed value is not null
        assertNotNull(hashed, "Hashed value should not be null.");

        // Verify the length of the hashed value
        assertEquals(64, hashed.length(), "SHA-256 hash should be 64 characters long.");

        // Verify the hashed value matches the expected output
        String expectedHash = "a591a6d40bf420404a011733cfb7b190d62c65bf0bcda32b91a3f1c4d178b6c8";
        assertEquals(expectedHash, hashed, "Hash value does not match the expected hash for the input.");
    }

    /**
     * Test the ArrayManager class for insertion functionality.
     */
    
    public void testArrayManagerInsert() {
        ArrayManager arrayManager = new ArrayManager(3);
        String value1 = "value1";
        String value2 = "value2";

        // Insert values into the array
        arrayManager.insert(value1);
        arrayManager.insert(value2);

        // Verify the values were inserted correctly
        assertEquals(value1, arrayManager.get(0), "Value at index 0 should match the inserted value.");
        assertEquals(value2, arrayManager.get(1), "Value at index 1 should match the inserted value.");
    }

    /**
     * Test the ArrayManager class for edge cases.
     */
    
    public void testArrayManagerEdgeCases() {
        ArrayManager arrayManager = new ArrayManager(2);

        // Insert values up to the limit
        arrayManager.insert("value1");
        arrayManager.insert("value2");

        // Attempt to insert beyond the array size
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            arrayManager.insert("value3");
        });

        assertEquals("Array is full.", exception.getMessage(), "Expected exception message for array overflow.");
    }
}
