import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;
import java.util.Locale;

public class Main {

  public static void main(String[] args) {
    System.out.println(getPeriodFromBirthday(LocalDate.of(1970, 10, 17)));
  }

  private static String getPeriodFromBirthday(LocalDate birthday) {
    LocalDate now = LocalDate.now();
    Period period = Period.between(birthday, now);
    String text = period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days";

    return text;
  }

}
