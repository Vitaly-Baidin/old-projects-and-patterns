import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        int diffYear = today.getYear() - birthday.getYear();

        String date = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE").localizedBy(new Locale("us"));

        for (int i = 0; i <= diffYear; i++) {
            if (birthday.isAfter(today)) {
                break;
            }
            date = date + i + " - " + formatter.format(birthday) + System.lineSeparator();
            birthday = birthday.plusYears(1);
        }

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        
        return date;
    }
}
