import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/SkillBox";
            String user = "username";
            String pass = "12345678";
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT course_name, COUNT(*) / (MAX(month(subscription_date)) - MIN(month(subscription_date))) AS avg_buy_per_month, MAX(month(subscription_date)) - MIN(month(subscription_date)) AS count_month FROM PurchaseList WHERE YEAR (subscription_date) = '2018' GROUP BY course_name;");

            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String avgBuy = resultSet.getString("avg_buy_per_month");
                String countMonth = resultSet.getString("count_month");
                System.out.println(courseName + " " + avgBuy + " " + countMonth);
            }

            connection.close();
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
