import org.example.Account;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @ParameterizedTest
    // Automatically reads the CSV file from src/test/resources
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {

        // 1. Arrange
        Account acc = new Account(username, password, email);

        // 2. Act
        boolean actual = acc.registerAccount();

        // 3. Assert (JUnit handles the comparison and error reporting)
        assertEquals(expected, actual, "Failed for user: " + username);
    }
}