import org.antlr.v4.runtime.tree.Tree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {

    private ArrayList<String> emailList;
    private TreeSet<String> emailListSorted = new TreeSet<>();

    private static final String REGEX_EMAIL = "(\\w+\\.)*\\w+@(\\w+\\.)[A-Za-z]+";
    private Pattern pattern;
    private Matcher matcher;

    public void add(String email) {
        // TODO: валидный формат email добавляется
        pattern = Pattern.compile(REGEX_EMAIL);
        matcher = pattern.matcher(email);

        if (matcher.matches()) {
            email = email.toLowerCase();
            emailListSorted.add(email);
        }
    }

    public ArrayList<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        emailList = new ArrayList<>(emailListSorted);
        return emailList;
    }

}
