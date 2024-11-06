import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("What day were you born in?");
        int dayInput = myScanner.nextInt();
        System.out.println("What month were you born in?");
        int monthInput = myScanner.nextInt() - 1;
        System.out.println("What year were you born in?");
        int yearInput = myScanner.nextInt();

        Calendar currentDate = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        birthDate.set(Calendar.YEAR, yearInput);
        birthDate.set(Calendar.MONTH, monthInput);
        birthDate.set(Calendar.DATE, dayInput);

        // code calculates the age in months, checks if the current day of the month has passed the birth day of the month to know whether to count it or not.
        // This way we can just append the age in days to the end
        int months = (currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)) * 12 + currentDate.get(Calendar.MONTH) - birthDate.get(Calendar.MONTH);
        if (currentDate.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH)) {
            months-=1;
        }
        // convert months to years and calculate months from the total month count
        int ageinYears = months / 12;
        int ageinMonths = months % 12;

        // we have to update the date instance so we can extract the milliseconds from it
        birthDate.add(Calendar.YEAR, ageinYears);
        birthDate.add(Calendar.MONTH, ageinMonths);

        //  remaining days after full years and months are accounted for
        long diffInMillis = currentDate.getTimeInMillis() - birthDate.getTimeInMillis();
        long ageinDays = TimeUnit.MILLISECONDS.toDays(diffInMillis);


        System.out.println("You are " + ageinYears + " years, " + ageinMonths + " month(s), and " + ageinDays + " day(s) old");
    }
}