import org.antlr.v4.runtime.tree.Tree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    private TreeMap<String, String> phoneBook = new TreeMap<>();

    Pattern pattern;
    Matcher matcher;

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (currentPhone(phone) && currentName(name)) {
            if (phoneBook.containsKey(phone)) {
                phoneBook.remove(phone);
                phoneBook.put(phone, name);
            } else {
                phoneBook.put(phone, name);
            }
        }
    }

    private boolean currentName(String name) {
        pattern = Pattern.compile("((([a-zA-Zа-яА-Я]+)\\s+)?([a-zA-Zа-яА-Я]+))+");
        matcher = pattern.matcher(name);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    private boolean currentPhone(String phone) {
        pattern = Pattern.compile("(^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$)");
        matcher = pattern.matcher(phone);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        return phoneBook.containsKey(phone) ? phoneBook.get(phone) + " - " + phone : "";
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String> searchPhone = new TreeSet<>();
        StringJoiner phones = new StringJoiner(", ");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()){
            if (entry.getValue().equals(name)) {
                phones.add(entry.getKey());
            }
        }
        searchPhone.add(name + " - " + phones);
        if (searchPhone.isEmpty()) {
            return new TreeSet<>();
        }
        return searchPhone;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        HashSet<String> allContacts = new HashSet<>();
        HashSet<String> nameSet = new HashSet<>();
        String name;
        StringJoiner phones;

       for (int i = 0; i < phoneBook.size(); i++) {
           name = "";
           phones = new StringJoiner(", ");
           for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
               if (name.isEmpty() && !nameSet.contains(entry.getValue())) {
                   name = entry.getValue();
                   nameSet.add(name);
               }
               if (entry.getValue().equals(name)) {
                   phones.add(entry.getKey());
               }
           }
           if (name.isEmpty()) continue;
           allContacts.add(name + " - " + phones);
       }
       if (allContacts.isEmpty()) {
            return new TreeSet<>();
        }
        return allContacts;
    }

    public TreeMap<String, String> getPhoneBook() {
        return phoneBook;
    }
    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}