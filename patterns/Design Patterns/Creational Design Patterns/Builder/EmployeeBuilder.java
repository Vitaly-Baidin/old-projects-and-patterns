import java.time.LocalDate;

public class EmployeeBuilder {
    private String firsName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String hobby;

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Employee getEmployee() {
        return new Employee(firsName, lastName, birthday, email, hobby);
    }
}
