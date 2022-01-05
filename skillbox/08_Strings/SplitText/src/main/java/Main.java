public class Main {

  public static void main(String[] args) {

  }

  public static String splitTextIntoWords(String text) {
    //TODO реализуйте метод
    String regex = "[\\s\\,\\.[0-9];-]+";
    String[] words = text.split(regex);
    String answer = "";
    if (!text.equals("")) {
      for (int i = 0; i < words.length; i++) {
        if (words.length - 1 == i) {
          answer += words[i];
        } else {
          answer += words[i] + System.lineSeparator();
        }
      }
    }
    return answer;
  }

}