public class Printer {
    private String queue;
    private int pendingPagesCount;
    private int printPagesCount;

    public void append(String text) {
        append(text, "No");
    }

    public void append(String text, String name) {
        append(text, name, 1);
    }

    public void append(String text, String name, int count) {
        queue = "Имя документа: " + name + "\nКоличество страниц: " + count + " \n Текст документа \n ================= \n" + text;
        pendingPagesCount += count;
    }

    public void clear() {
        queue = "";
        pendingPagesCount = 0;
    }

    public void print() {
        System.out.println(queue);
        printPagesCount += pendingPagesCount;
        clear();
    }

    public int getPendingPagesCount() {
        return pendingPagesCount;
    }

    public int getPrintPagesCount() {
        return printPagesCount;
    }
}
