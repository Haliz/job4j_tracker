package ru.job4j.inheritance.lesson4;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report1 = new TextReport();
        String text = report1.generate("Report's name", "Report's body");
        System.out.println(text);

        System.out.println();

        HtmlReport report2 = new HtmlReport();
        text = report2.generate("Report's name", "Report's body");
        System.out.println(text);

        System.out.println();

        JSONReport report3 = new JSONReport();
        text = report3.generate("Report's name", "Report's body");
        System.out.println(text);
            }
}
