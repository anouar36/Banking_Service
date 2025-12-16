import com.logitrack.Account;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class BankAccountTest {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    private static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }

    public static void main(String[] args) {
        System.out.println("--- Running Acceptance Test Scenario ---");

        Account account = new Account();


        LocalDate date1 = parseDate("10-01-2012");

        System.out.println("Applying: Deposit 1000 on 10-01-2012");

        account.deposit(1000);

        LocalDate date2 = parseDate("13-01-2012");
        System.out.println("Applying: Deposit 2000 on 13-01-2012");
        account.deposit(2000);

        LocalDate date3 = parseDate("14-01-2012");
        System.out.println("Applying: Withdrawal 500 on 14-01-2012");
        account.withdraw(500);

        System.out.println("\n--- Printing Bank Statement ---\n");
        account.printStatement();

        System.out.println("\n--- Expected Output (Based on Acceptance Test) ---\n");
        System.out.println("DATE | AMOUNT | TYPE | BALANCE");
        System.out.println("2012-01-10 | 1000 | Deposit | 1000");
        System.out.println("2012-01-13 | 2000 | Deposit | 3000");
        System.out.println("2012-01-14 | 500 | Withdrawal | 2500");

        System.out.println("\n--- Test of Exception Handling (Example) ---");
        try {
            account.withdraw(5000);
        } catch (IllegalStateException e) {
            System.out.println("SUCCESS: Caught expected exception: " + e.getMessage());
        }
        try {
            account.deposit(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("SUCCESS: Caught expected exception: " + e.getMessage());
        }
    }
}