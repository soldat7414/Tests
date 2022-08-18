package tests.calendar;

import java.util.Scanner;

/**
 * @author Ihor Soldatenko
 * @project Tests
 * @date 01.08.2022
 */
public class Calendar {

    static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        int day = -1;
        int month = -1;
        int newYearDay = -1;

        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()) newYearDay = scanner.nextInt();
        if(scanner.hasNextInt()) month = scanner.nextInt();
        if(scanner.hasNextInt()) day = scanner.nextInt();


        System.out.println(dayOfWeek(newYearDay, month, day));
    }

    static int dayOfWeek(int nYday, int month, int day) {
        if(day < 1 | month < 1 | month > 12 | nYday < 1 | nYday > 7) return -1; //Проверено в границах области определения
        if(day > DAYS_IN_MONTH[month-1]) return -1;
        int days = 0;
        for (int i = 0; i < month - 1; i++) {
            days += DAYS_IN_MONTH[i];
        }
        days += day-1;
        int dayOfWeek = (days % 7 + nYday) ;
        if (dayOfWeek > 7) dayOfWeek -= 7;

        return dayOfWeek;
    }
}
