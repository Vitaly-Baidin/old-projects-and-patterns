import java.time.LocalDate;

public class Employee {
    private final String firsName;
    private final String lastName;
    private final LocalDate birthday;
    private final String email;
    private final String hobby;

    public Employee(String firsName, String lastName, LocalDate birthday, String email, String hobby) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.hobby = hobby;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "Работник: " + firsName + " " + lastName + System.lineSeparator() +
                "Дата рождения: " + birthday + System.lineSeparator() +
                (email != null && !email.isEmpty() ? "email: " + email + System.lineSeparator() : "email не указан" + System.lineSeparator()) +
                (hobby != null && !hobby.isEmpty() ? "хобби: " + hobby + System.lineSeparator() : "хобби не указаны" + System.lineSeparator());
    }
}
