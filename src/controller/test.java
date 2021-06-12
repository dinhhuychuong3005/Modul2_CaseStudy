package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String s = localDate.format(dateTimeFormatter);
        System.out.println(s);
    }
}
