package tests.calendar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.calendar.Calendar.dayOfWeek;
import static tests.calendar.Calendar.main;

/**
 * @author Ihor Soldatenko
 * @project Tests
 * @date 10.08.2022
 */
class CalendarTest {

    static int count = 0;

    void calendarTest(int nYDay, int month, int day, int result) {
        assertEquals(dayOfWeek(nYDay, month, day), result);
        System.out.print(++count + "; ");
        mainTest(nYDay, month, day);
    }
    void mainTest(int nYDay, int month, int day) {
        InputStream argsStream = new ByteArrayInputStream(
                (nYDay + "\n" + month + "\n" + day)
                        .getBytes(StandardCharsets.UTF_8));
        System.setIn(argsStream);
        main(null);
    }

    @Test
    void dayOfWeekTest() {

        //region Граничные значения области определения
        calendarTest(1, 1, 1, 1);
        calendarTest(2, 1, 1, 2);
        calendarTest(0, 1, 1, -1);
        calendarTest(1, 2, 1, 4);
        calendarTest(1, 0, 1, -1);
        calendarTest(1, 1, 2, 2);
        calendarTest(1, 1, 0, -1);

        calendarTest(7, 1, 1, 7);
        calendarTest(6, 1, 1, 6);
        calendarTest(8, 1, 1, -1);
        calendarTest(7, 2, 1, 3);
        calendarTest(7, 0, 1, -1);
        calendarTest(7, 1, 2, 1);
        calendarTest(7, 1, 0, -1);

        calendarTest(1, 1, 31, 3);
        calendarTest(2, 1, 31, 4);
        calendarTest(0, 1, 31, -1);
        calendarTest(1, 2, 31, -1);
        calendarTest(1, 0, 31, -1);
        calendarTest(1, 1, 32, -1);
        calendarTest(1, 1, 30, 2);

        calendarTest(7, 1, 31, 2);
        calendarTest(6, 1, 31, 1);
        calendarTest(8, 1, 31, -1);
        calendarTest(7, 2, 31, -1);
        calendarTest(7, 0, 31, -1);
        calendarTest(7, 1, 30, 1);
        calendarTest(7, 1, 32, -1);

        calendarTest(1, 12, 1, 6);
        calendarTest(2, 12, 1, 7);
        calendarTest(0, 12, 1, -1);
        calendarTest(1, 11, 1, 4);
        calendarTest(1, 13, 1, -1);
        calendarTest(1, 12, 2, 7);
        calendarTest(1, 12, 0, -1);

        calendarTest(7, 12, 1, 5);
        calendarTest(6, 12, 1, 4);
        calendarTest(8, 12, 1, -1);
        calendarTest(7, 13, 1, -1);
        calendarTest(7, 11, 1, 3);
        calendarTest(7, 12, 0, -1);
        calendarTest(7, 12, 2, 6);

        calendarTest(1, 12, 31, 1);
        calendarTest(0, 12, 31, -1);
        calendarTest(2, 12, 31, 2);
        calendarTest(1, 11, 31, -1);
        calendarTest(1, 13, 31, -1);
        calendarTest(1, 12, 30, 7);
        calendarTest(1, 12, 32, -1);

        calendarTest(7, 12, 31, 7);
        calendarTest(6, 12, 31, 6);
        calendarTest(8, 12, 31, -1);
        calendarTest(7, 11, 31, -1);
        calendarTest(7, 13, 31, -1);
        calendarTest(7, 12, 30, 6);
        calendarTest(7, 12, 32, -1);

        calendarTest(1, 2, 28, 3);
        calendarTest(0, 2, 28, -1);
        calendarTest(2, 2, 28, 4);
        calendarTest(1, 1, 28, 7);
        calendarTest(1, 3, 28, 3);
        calendarTest(1, 2, 29, -1);
        calendarTest(1, 2, 27, 2);

        calendarTest(7, 2, 28, 2);
        calendarTest(6, 2, 28, 1);
        calendarTest(8, 2, 28, -1);
        calendarTest(7, 1, 28, 6);
        calendarTest(7, 3, 28, 2);
        calendarTest(7, 2, 29, -1);
        calendarTest(7, 2, 27, 1);

        calendarTest(1, 3, 31, 6);
        calendarTest(0, 3, 31, -1);
        calendarTest(2, 3, 31, 7);
        calendarTest(1, 2, 31, -1);
        calendarTest(1, 4, 31, -1);
        calendarTest(1, 3, 30, 5);
        calendarTest(1, 3, 32, -1);

        calendarTest(7, 3, 31, 5);
        calendarTest(6, 3, 31, 4);
        calendarTest(8, 3, 31, -1);
        calendarTest(7, 2, 31, -1);
        calendarTest(7, 4, 31, -1);
        calendarTest(7, 3, 30, 4);
        calendarTest(7, 3, 32, -1);

        calendarTest(1, 4, 30, 1);
        calendarTest(0, 4, 30, -1);
        calendarTest(2, 4, 30, 2);
        calendarTest(1, 3, 30, 5);
        calendarTest(1, 5, 30, 3);
        calendarTest(1, 4, 29, 7);
        calendarTest(1, 4, 31, -1);

        calendarTest(7, 4, 30, 7);
        calendarTest(6, 4, 30, 6);
        calendarTest(8, 4, 30, -1);
        calendarTest(7, 3, 30, 4);
        calendarTest(7, 5, 30, 2);
        calendarTest(7, 4, 31, -1);
        calendarTest(7, 4, 29, 6);

        calendarTest(1, 5, 31, 4);
        calendarTest(0, 5, 31, -1);
        calendarTest(2, 5, 31, 5);
        calendarTest(1, 6, 31, -1);
        calendarTest(1, 4, 31, -1);
        calendarTest(1, 5, 30, 3);
        calendarTest(1, 5, 32, -1);

        calendarTest(1, 6, 30, 6);
        calendarTest(0, 6, 30, -1);
        calendarTest(2, 6, 30, 7);
        calendarTest(1, 5, 30, 3);
        calendarTest(1, 7, 30, 1);
        calendarTest(1, 6, 29, 5);
        calendarTest(1, 6, 31, -1);

        calendarTest(7, 6, 30, 5);
        calendarTest(6, 6, 30, 4);
        calendarTest(8, 6, 30, -1);
        calendarTest(7, 5, 30, 2);
        calendarTest(7, 7, 30, 7);
        calendarTest(7, 6, 31, -1);
        calendarTest(7, 6, 29, 4);

        calendarTest(1, 7, 31, 2);
        calendarTest(0, 7, 31, -1);
        calendarTest(2, 7, 31, 3);
        calendarTest(1, 8, 31, 5);
        calendarTest(1, 6, 31, -1);
        calendarTest(1, 7, 30, 1);
        calendarTest(1, 7, 32, -1);

        calendarTest(7, 7, 31, 1);
        calendarTest(6, 7, 31, 7);
        calendarTest(8, 7, 31, -1);
        calendarTest(7, 8, 31, 4);
        calendarTest(7, 6, 31, -1);
        calendarTest(7, 7, 30, 7);
        calendarTest(7, 7, 32, -1);

        calendarTest(1, 8, 31, 5);
        calendarTest(0, 8, 31, -1);
        calendarTest(2, 8, 31, 6);
        calendarTest(1, 7, 31, 2);
        calendarTest(1, 9, 31, -1);
        calendarTest(1, 8, 31, 5);
        calendarTest(1, 8, 30, 4);
        calendarTest(1, 8, 32, -1);

        calendarTest(7, 8, 31, 4);
        calendarTest(8, 8, 31, -1);
        calendarTest(6, 8, 31, 3);
        calendarTest(7, 9, 31, -1);
        calendarTest(7, 7, 31, 1);
        calendarTest(7, 8, 30, 3);
        calendarTest(7, 8, 32, -1);

        calendarTest(1, 9, 30, 7);
        calendarTest(0, 9, 30, -1);
        calendarTest(2, 9, 30, 1);
        calendarTest(1, 10, 30, 2);
        calendarTest(1, 8, 30, 4);
        calendarTest(1, 9, 31, -1);
        calendarTest(1, 9, 29, 6);

        calendarTest(7, 9, 30, 6);
        calendarTest(6, 9, 30, 5);
        calendarTest(8, 9, 30, -1);
        calendarTest(7, 8, 30, 3);
        calendarTest(7, 10, 30, 1);
        calendarTest(7, 9, 31, -1);
        calendarTest(7, 9, 29, 5);

        calendarTest(1, 10, 31, 3);
        calendarTest(2, 10, 31, 4);
        calendarTest(0, 10, 31, -1);
        calendarTest(1, 11, 31, -1);
        calendarTest(1, 9, 31, -1);
        calendarTest(1, 10, 30, 2);
        calendarTest(1, 10, 32, -1);

        calendarTest(7, 10, 31, 2);
        calendarTest(8, 10, 31, -1);
        calendarTest(6, 10, 31, 1);
        calendarTest(7, 11, 31, -1);
        calendarTest(7, 9, 31, -1);
        calendarTest(7, 10, 30, 1);
        calendarTest(7, 10, 32, -1);

        calendarTest(1, 11, 30, 5);
        calendarTest(2, 11, 30, 6);
        calendarTest(0, 11, 30, -1);
        calendarTest(1, 10, 30, 2);
        calendarTest(1, 12, 30, 7);
        calendarTest(1, 11, 31, -1);
        calendarTest(1, 11, 29, 4);

        calendarTest(7, 11, 30, 4);
        calendarTest(6, 11, 30, 3);
        calendarTest(8, 11, 30, -1);
        calendarTest(7, 10, 30, 1);
        calendarTest(7, 12, 30, 6);
        calendarTest(7, 11, 31, -1);
        calendarTest(7, 11, 29, 3);

        //endregion

        //region Классы "эквивалентности"

        //region Результата - понедельник
        calendarTest(5, 1, 11, 1);
        calendarTest(4, 1, 11, 7);
        calendarTest(6, 1, 11, 2);
        calendarTest(5, 2, 11, 4);
        calendarTest(5, 0, 11, -1);
        calendarTest(5, 1, 12, 2);
        calendarTest(5, 1, 10, 7);

        calendarTest(4, 1, 12, 1);
        calendarTest(5, 1, 18, 1);
        calendarTest(3, 2, 17, 1);
        calendarTest(2, 2, 18, 1);
        calendarTest(1, 2, 19, 1);
        calendarTest(2, 3, 4, 1);
        calendarTest(1, 3, 5, 1);
        calendarTest(6, 3, 7, 1);
        calendarTest(3, 4, 14, 1);
        calendarTest(2, 4, 15, 1);
        calendarTest(1, 4, 16, 1);
        calendarTest(5, 5, 17, 1);
        calendarTest(4, 5, 18, 1);
        calendarTest(6, 5, 23, 1);
        calendarTest(2, 6, 10, 1);
        calendarTest(1, 6, 11, 1);
        calendarTest(6, 6, 13, 1);
        calendarTest(2, 7, 15, 1);
        calendarTest(1, 7, 16, 1);
        calendarTest(6, 7, 18, 1);
        calendarTest(1, 8, 13, 1);
        calendarTest(5, 8, 16, 1);
        calendarTest(4, 8, 17, 1);
        calendarTest(3, 8, 18, 1);
        calendarTest(3, 9, 15, 1);
        calendarTest(2, 9, 16, 1);
        calendarTest(1, 9, 17, 1);
        calendarTest(6, 10, 10, 1);
        calendarTest(5, 10, 11, 1);
        calendarTest(4, 10, 12, 1);
        calendarTest(3, 10, 13, 1);
        calendarTest(5, 11, 15, 1);
        calendarTest(4, 11, 16, 1);
        calendarTest(3, 11, 17, 1);
        calendarTest(6, 12, 26, 1);
        calendarTest(5, 12, 27, 1);
        calendarTest(4, 12, 28, 1);

        calendarTest(3, 12, 29, 1);
        calendarTest(4, 12, 29, 2);
        calendarTest(2, 12, 29, 7);
        calendarTest(3, 11, 29, 6);
        calendarTest(3, 13, 29, -1);
        calendarTest(3, 12, 28, 7);
        calendarTest(3, 12, 30, 2);
        //endregion

        //region Результат - вторник
        calendarTest(6, 1, 4, 2);
        calendarTest(5, 1, 4, 1);
        calendarTest(7, 1, 4, 3);
        calendarTest(6, 0, 4, -1);
        calendarTest(6, 2, 4, 5);
        calendarTest(6, 1, 5, 3);
        calendarTest(6, 1, 3, 1);

        calendarTest(5, 1, 5, 2);
        calendarTest(4, 1, 6, 2);
        calendarTest(5, 2, 9, 2);
        calendarTest(4, 2, 10, 2);
        calendarTest(3, 2, 11, 2);
        calendarTest(6, 3, 15, 2);
        calendarTest(5, 3, 16, 2);
        calendarTest(4, 3, 17, 2);
        calendarTest(3, 3, 18, 2);
        calendarTest(2, 3, 19, 2);
        calendarTest(1, 3, 20, 2);
        calendarTest(5, 4, 6, 2);
        calendarTest(4, 4, 7, 2);
        calendarTest(3, 4, 8, 2);
        calendarTest(2, 4, 9, 2);
        calendarTest(1, 4, 10, 2);
        calendarTest(6, 5, 3, 2);
        calendarTest(5, 5, 4, 2);
        calendarTest(4, 5, 5, 2);
        calendarTest(1, 6, 12, 2);
        calendarTest(6, 6, 14, 2);
        calendarTest(5, 6, 15, 2);
        calendarTest(3, 7, 1, 2);
        calendarTest(2, 7, 2, 2);
        calendarTest(1, 7, 3, 2);
        calendarTest(4, 8, 18, 2);
        calendarTest(3, 8, 19, 2);
        calendarTest(2, 8, 20, 2);
        calendarTest(4, 9, 8, 2);
        calendarTest(3, 9, 9, 2);
        calendarTest(2, 9, 10, 2);
        calendarTest(6, 10, 4, 2);
        calendarTest(5, 10, 5, 2);
        calendarTest(4, 10, 6, 2);
        calendarTest(3, 11, 25, 2);
        calendarTest(2, 11, 26, 2);
        calendarTest(1, 11, 27, 2);
        calendarTest(4, 12, 22, 2);
        calendarTest(3, 12, 23, 2);

        calendarTest(2, 12, 24, 2);
        calendarTest(3, 12, 24, 3);
        calendarTest(1, 12, 24, 1);
        calendarTest(2, 11, 24, 7);
        calendarTest(2, 13, 24, -1);
        calendarTest(2, 12, 25, 3);
        calendarTest(2, 12, 23, 1);
        //endregion

        //region Результат - среда
        calendarTest(3, 1, 1, 3);
        calendarTest(2, 1, 1, 2);
        calendarTest(4, 1, 1, 4);
        calendarTest(3, 2, 1, 6);
        calendarTest(3, 0, 1, -1);
        calendarTest(3, 1, 2, 4);
        calendarTest(3, 1, 0, -1);

        calendarTest(2, 1, 2, 3);
        calendarTest(1, 1, 3, 3);
        calendarTest(2, 2, 6, 3);
        calendarTest(1, 2, 7, 3);
        calendarTest(6, 2, 9, 3);
        calendarTest(5, 3, 10, 3);
        calendarTest(4, 3, 11, 3);
        calendarTest(3, 3, 12, 3);
        calendarTest(6, 4, 13, 3);
        calendarTest(5, 4, 14, 3);
        calendarTest(4, 4, 15, 3);
        calendarTest(1, 5, 16, 3);
        calendarTest(6, 5, 18, 3);
        calendarTest(5, 5, 19, 3);
        calendarTest(6, 6, 22, 3);
        calendarTest(5, 6, 23, 3);
        calendarTest(4, 6, 24, 3);
        calendarTest(1, 7, 25, 3);
        calendarTest(6, 7, 27, 3);
        calendarTest(5, 7, 28, 3);
        calendarTest(4, 8, 26, 3);
        calendarTest(3, 8, 27, 3);
        calendarTest(2, 8, 28, 3);
        calendarTest(3, 9, 17, 3);
        calendarTest(2, 9, 18, 3);
        calendarTest(1, 9, 19, 3);
        calendarTest(6, 10, 5, 3);
        calendarTest(5, 10, 6, 3);
        calendarTest(4, 10, 7, 3);
        calendarTest(6, 11, 9, 3);
        calendarTest(5, 11, 10, 3);
        calendarTest(4, 11, 11, 3);
        calendarTest(5, 12, 8, 3);
        calendarTest(4, 12, 9, 3);

        calendarTest(3, 12, 10, 3);
        calendarTest(2, 12, 10, 2);
        calendarTest(4, 12, 10, 4);
        calendarTest(3, 11, 10, 1);
        calendarTest(3, 13, 10, -1);
        calendarTest(3, 12, 11, 4);
        calendarTest(3, 12, 9, 2);
        //endregion

        //region Результат - четверг
        calendarTest(4, 1, 1, 4);
        calendarTest(3, 1, 1, 3);
        calendarTest(5, 1, 1, 5);
        calendarTest(4, 2, 1, 7);
        calendarTest(4, 0, 1, -1);
        calendarTest(4, 1, 2, 5);
        calendarTest(4, 1, 0, -1);

        calendarTest(3, 1, 2, 4);
        calendarTest(2, 1, 3, 4);
        calendarTest(3, 2, 20, 4);
        calendarTest(2, 2, 21, 4);
        calendarTest(1, 2, 22, 4);
        calendarTest(2, 3, 7, 4);
        calendarTest(1, 3, 8, 4);
        calendarTest(6, 3, 10, 4);
        calendarTest(1, 4, 5, 4);
        calendarTest(6, 4, 7, 4);
        calendarTest(5, 4, 8, 4);
        calendarTest(3, 5, 15, 4);
        calendarTest(2, 5, 16, 4);
        calendarTest(1, 5, 17, 4);
        calendarTest(5, 6, 17, 4);
        calendarTest(4, 6, 18, 4);
        calendarTest(3, 6, 19, 4);
        calendarTest(6, 7, 21, 4);
        calendarTest(5, 7, 22, 4);
        calendarTest(4, 7, 23, 4);
        calendarTest(3, 7, 24, 4);
        calendarTest(2, 7, 25, 4);
        calendarTest(1, 7, 26, 4);
        calendarTest(5, 8, 26, 4);
        calendarTest(4, 8, 27, 4);
        calendarTest(3, 8, 28, 4);
        calendarTest(4, 9, 17, 4);
        calendarTest(3, 9, 18, 4);
        calendarTest(2, 9, 19, 4);
        calendarTest(2, 10, 10, 4);
        calendarTest(1, 10, 11, 4);
        calendarTest(6, 10, 13, 4);
        calendarTest(6, 11, 3, 4);
        calendarTest(5, 11, 4, 4);
        calendarTest(4, 11, 5, 4);
        calendarTest(6, 12, 29, 4);
        calendarTest(5, 12, 30, 4);

        calendarTest(4, 12, 31, 4);
        calendarTest(5, 12, 31, 5);
        calendarTest(3, 12, 31, 3);
        calendarTest(4, 11, 31, -1);
        calendarTest(4, 13, 31, -1);
        calendarTest(4, 12, 30, 3);
        calendarTest(4, 12, 32, -1);
        //endregion

        //region Результат - пятница
        calendarTest(5, 1, 1, 5);
        calendarTest(4, 1, 1, 4);
        calendarTest(6, 1, 1, 6);
        calendarTest(5, 2, 1, 1);
        calendarTest(5, 0, 1, -1);
        calendarTest(5, 1, 2, 6);
        calendarTest(5, 1, 0, -1);

        calendarTest(4, 1, 2, 5);
        calendarTest(3, 1, 3, 5);
        calendarTest(1, 2, 2, 5);
        calendarTest(6, 2, 4, 5);
        calendarTest(5, 2, 5, 5);
        calendarTest(5, 3, 19, 5);
        calendarTest(4, 3, 20, 5);
        calendarTest(3, 3, 21, 5);
        calendarTest(4, 4, 10, 5);
        calendarTest(3, 4, 11, 5);
        calendarTest(2, 4, 12, 5);
        calendarTest(6, 5, 13, 5);
        calendarTest(5, 5, 14, 5);
        calendarTest(4, 5, 15, 5);
        calendarTest(4, 6, 12, 5);
        calendarTest(3, 6, 13, 5);
        calendarTest(2, 6, 14, 5);
        calendarTest(6, 7, 15, 5);
        calendarTest(5, 7, 16, 5);
        calendarTest(4, 7, 17, 5);
        calendarTest(5, 8, 6, 5);
        calendarTest(4, 8, 7, 5);
        calendarTest(3, 8, 8, 5);
        calendarTest(6, 9, 2, 5);
        calendarTest(5, 9, 3, 5);
        calendarTest(4, 9, 4, 5);
        calendarTest(3, 10, 10, 5);
        calendarTest(2, 10, 11, 5);
        calendarTest(1, 10, 12, 5);
        calendarTest(6, 11, 25, 5);
        calendarTest(5, 11, 26, 5);
        calendarTest(4, 11, 27, 5);
        calendarTest(1, 12, 28, 5);
        calendarTest(6, 12, 30, 5);

        calendarTest(5, 12, 31, 5);
        calendarTest(6, 12, 31, 6);
        calendarTest(4, 12, 31, 4);
        calendarTest(5, 11, 31, -1);
        calendarTest(5, 13, 31, -1);
        calendarTest(5, 12, 30, 4);
        calendarTest(5, 12, 32, -1);
        //endregion

        //region Результат - суббота

        calendarTest(6, 1, 1, 6);
        calendarTest(7, 1, 1, 7);
        calendarTest(5, 1, 1, 5);
        calendarTest(6, 2, 1, 2);
        calendarTest(6, 0, 1, -1);
        calendarTest(6, 1, 2, 7);
        calendarTest(6, 1, 0, -1);

        calendarTest(5, 1, 2, 6);
        calendarTest(4, 1, 3, 6);
        calendarTest(6, 2, 5, 6);
        calendarTest(5, 2, 6, 6);
        calendarTest(4, 2, 7, 6);
        calendarTest(4, 3, 7, 6);
        calendarTest(3, 3, 8, 6);
        calendarTest(2, 3, 9, 6);
        calendarTest(5, 4, 17, 6);
        calendarTest(4, 4, 18, 6);
        calendarTest(3, 4, 19, 6);
        calendarTest(6, 5, 14, 6);
        calendarTest(5, 5, 15, 6);
        calendarTest(4, 5, 16, 6);
        calendarTest(5, 6, 19, 6);
        calendarTest(4, 6, 20, 6);
        calendarTest(3, 6, 21, 6);
        calendarTest(5, 7, 3, 6);
        calendarTest(4, 7, 4, 6);
        calendarTest(3, 7, 5, 6);
        calendarTest(4, 8, 22, 6);
        calendarTest(3, 8, 23, 6);
        calendarTest(2, 8, 24, 6);
        calendarTest(2, 9, 7, 6);
        calendarTest(1, 9, 8, 6);
        calendarTest(6, 9, 10, 6);
        calendarTest(1, 10, 13, 6);
        calendarTest(6, 10, 15, 6);
        calendarTest(5, 10, 16, 6);
        calendarTest(4, 11, 21, 6);
        calendarTest(3, 11, 22, 6);
        calendarTest(2, 11, 23, 6);
        calendarTest(2, 12, 28, 6);
        calendarTest(1, 12, 29, 6);

        calendarTest(6, 12, 31, 6);
        calendarTest(7, 12, 31, 7);
        calendarTest(5, 12, 31, 5);
        calendarTest(6, 11, 31, -1);
        calendarTest(6, 13, 31, -1);
        calendarTest(6, 12, 30, 5);
        calendarTest(6, 12, 32, -1);
        //endregion

        //region Результат - воскресение
        calendarTest(6, 1, 2, 7);
        calendarTest(7, 1, 2, 1);
        calendarTest(5, 1, 2, 6);
        calendarTest(6, 2, 2, 3);
        calendarTest(6, 0, 2, -1);
        calendarTest(6, 1, 1, 6);
        calendarTest(6, 1, 3, 1);

        calendarTest(5, 1, 3, 7);
        calendarTest(4, 1, 4, 7);
        calendarTest(3, 2, 9, 7);
        calendarTest(2, 2, 10, 7);
        calendarTest(1, 2, 11, 7);
        calendarTest(2, 3, 3, 7);
        calendarTest(1, 3, 4, 7);
        calendarTest(6, 3, 6, 7);
        calendarTest(1, 4, 15, 7);
        calendarTest(6, 4, 17, 7);
        calendarTest(5, 4, 18, 7);
        calendarTest(5, 5, 2, 7);
        calendarTest(4, 5, 3, 7);
        calendarTest(3, 5, 4, 7);
        calendarTest(2, 6, 9, 7);
        calendarTest(1, 6, 10, 7);
        calendarTest(6, 6, 12, 7);
        calendarTest(6, 7, 10, 7);
        calendarTest(5, 7, 11, 7);
        calendarTest(4, 7, 12, 7);
        calendarTest(6, 8, 28, 7);
        calendarTest(5, 8, 29, 7);
        calendarTest(4, 8, 30, 7);
        calendarTest(5, 9, 12, 7);
        calendarTest(4, 9, 13, 7);
        calendarTest(3, 9, 14, 7);
        calendarTest(4, 10, 4, 7);
        calendarTest(3, 10, 5, 7);
        calendarTest(2, 10, 6, 7);
        calendarTest(4, 11, 1, 7);
        calendarTest(3, 11, 2, 7);
        calendarTest(2, 11, 3, 7);
        calendarTest(3, 12, 28, 7);
        calendarTest(2, 12, 29, 7);

        calendarTest(1, 12, 30, 7);
        calendarTest(2, 12, 30, 1);
        calendarTest(0, 12, 30, -1);
        calendarTest(1, 11, 30, 5);
        calendarTest(1, 13, 30, -1);
        calendarTest(1, 12, 31, 1);
        calendarTest(1, 12, 29, 6);
        //endregion

        //endregion

        //region Предметная область -календарь
        calendarTest(1, 4, 29, 7);
        calendarTest(5, 12, 25, 6);
        calendarTest(1, 12, 31, 1);
        calendarTest(6, 10, 22, 6);
        calendarTest(3, 7, 25, 5);
        calendarTest(2, 1, 1, 2);
        calendarTest(7, 4, 27, 4);
        //endregion

        //region Реализация +10
        calendarTest(1, -1, 2, -1);
        calendarTest(1, 14, 2, -1);
        calendarTest(1, 1, -1, -1);
        calendarTest(-2, 1, 7, -1);
        calendarTest(15, 1, 7, -1);
//12
        calendarTest(2147483647,1,1,-1);
        calendarTest(1,2147483647,1,-1);
        calendarTest(1,1,2147483647,-1);
        calendarTest(2147483647,2147483647,1,-1);
        calendarTest(2147483647,2147483647,2147483647,-1);
        calendarTest(-2147483648,2147483647,2147483647,-1);
        calendarTest(-2147483648,-2147483648,2147483647,-1);
        calendarTest(-2147483648,-2147483648,-2147483648,-1);
        calendarTest(-2147483648,-2147483648,1,-1);
        calendarTest(-2147483648,1,1,-1);
        calendarTest(1,-2147483648,1,-1);
        calendarTest(1,1,-2147483648,-1);


        //endregion

        //region Случайные значения
        calendarTest(1, 5, 13, 7);
        calendarTest(6, 4, 17, 7);
        calendarTest(3, 9, 23, 2);
        calendarTest(3, 7, 21, 1);
        calendarTest(7, 9, 1, 5);
        calendarTest(3, 12, 21, 7);
        calendarTest(2, 3, 27, 3);
        calendarTest(5, 10, 22, 5);
        calendarTest(4, 4, 29, 3);
        calendarTest(1, 10, 7, 7);
        calendarTest(6, 10, 31, 1);
        calendarTest(7, 6, 26, 1);
        calendarTest(6, 12, 18, 7);
        calendarTest(3, 5, 10, 6);
        calendarTest(3, 1, 25, 6);
        //endregion

        //region Другие особые значения
        calendarTest(1, 4, 29, 7);
        calendarTest(2, 4, 27, 6);
        calendarTest(3, 4, 17, 4);
        calendarTest(4, 12, 19, 6);
        calendarTest(5, 12, 15, 3);
        calendarTest(6, 10, 10, 1);
        calendarTest(7, 4, 26, 3);
        calendarTest(1, 3, 8, 4);
        calendarTest(6, 8, 17, 3);

        //endregion

    }
}