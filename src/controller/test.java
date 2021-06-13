package controller;

import java.time.LocalDate;

public class test {
    public static void main(String[] args) {
        LocalDate a = LocalDate.of(2019,2,11);
        a.getMonth();
        System.out.println(a.getMonthValue());
    }
}
