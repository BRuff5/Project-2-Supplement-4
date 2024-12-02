public class mainTest {

    
    public void testGenerateRandomHex() {
        String randomHex = main.generateRandomHex();

        assertNotNull(randomHex, "Random hex should not be null");
        assertEquals(36, randomHex.length(), "Formatted hex should have 36 characters");
        assertTrue(randomHex.matches("^[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}$"),
                "Random hex does not match expected format");
    }

    
    public void testHashString() {
        String input = "Hello, World!";
        String hashed = main.hashString(input);

        assertNotNull(hashed, "Hashed string should not be null");
        assertEquals(64, hashed.length(), "SHA-256 hash should have 64 characters");

        String expectedHash = "a.591a6d40bf420404a011733cfb7b190d62c65bf0bcda32b91a3f1c4d178b6c8";
        assertEquals(expectedHash, hashed, "Hashed string does not match expected hash");
    }

    
    public void testArrayManagerInsert() {
        ArrayManager manager = new ArrayManager(3);
        manager.insert("A");
        manager.insert("B");
        manager.insert("C");

        assertEquals("A B C", manager.toString(), "Array contents after insertions should match");

        // Test circular insertion
        manager.insert("D");
        assertEquals("D B C", manager.toString(), "Circular insertion should overwrite old values");
    }

    private void assertNotNull(String randomHex, String random_hex_should_not_be_null) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
