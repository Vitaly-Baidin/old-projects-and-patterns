import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Authentication {

    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
    private final String LOGIN_FORM_URL = "https://2domains.ru/login";
    private final String LOGIN_ACTION_URL = "https://2domains.ru/login";
    private final String USERNAME;
    private final String PASSWORD;

    public Authentication(String username, String password) {
        USERNAME = username;
        PASSWORD = password;
    }

    public String getJSONDomains() throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put("accept-encoding", "gzip, deflate");

        Connection.Response loginForm = Jsoup.connect(LOGIN_ACTION_URL).userAgent(USER_AGENT).headers(headers).execute();
        Map<String, String> cookies = loginForm.cookies();
        Document html = loginForm.parse();


        String authToken = html.select("#login-form > input[type=\"hidden\"]")
                .first()
                .attr("value");
        System.out.println("Found authToken:" + authToken);

        Map<String, String> formData = new HashMap<>();
        formData.put("LoginForm[username]", USERNAME);
        formData.put("LoginForm[password]", PASSWORD);
        formData.put("_csrf_ident", authToken);
        headers.put("Content-Type", "application/x-www-form-urlencoded");

        Connection.Response afterLoginPage = Jsoup.connect(LOGIN_ACTION_URL)
                .cookies(cookies)
                .headers(headers)
                .userAgent(USER_AGENT)
                .data(formData)
                .method(Connection.Method.POST)
                .referrer(LOGIN_FORM_URL).execute();

        // update cookies
        cookies = afterLoginPage.cookies();

        Connection.Response homePage = Jsoup.connect("https://2domains.ru/manager/api/user-service-list/list?page=1&per-page=2000&sort=expiration_date,-id&view=compact&type=domain")
                .cookies(cookies)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Content-Type", "application/json;charset=UTF-8")
                .ignoreContentType(true)
                .execute();

        return homePage.body();
    }
}
