import com.logitrack.Account;


import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


public class BankAccountAcceptanceTest {
    public static void main(String[] args) {
        Clock clock = Clock.fixed(
                Instant.parse("2012-01-10T00:00:00Z"),
                ZoneId.systemDefault()
        );


        Account account = new Account(clock);


        account.deposit(1000);


        clock = Clock.fixed(
                Instant.parse("2012-01-13T00:00:00Z"),
                ZoneId.systemDefault()
        );
        account = new Account(clock);
        account.deposit(2000);


        clock = Clock.fixed(
                Instant.parse("2012-01-14T00:00:00Z"),
                ZoneId.systemDefault()
        );
        account.withdraw(500);


        account.printStatement();
    }
}