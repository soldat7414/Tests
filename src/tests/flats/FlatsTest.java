package tests.flats;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static tests.flats.Flats.*;

/**
 * @author Ihor Soldatenko
 * @project Tests
 * @date 15.08.2022
 */
class FlatsTest {
static int count = 0;
    void testEntrance(int flatNumber, int floors, int flatsOnFloor, int result){
        assertEquals(Flats.count(flatNumber, floors, flatsOnFloor)[0], result);
        System.out.print(++count + "; ");
    }

    void testFloor(int flatNumber, int floors, int flatsOnFloor, int result){
        assertEquals(Flats.count(flatNumber, floors, flatsOnFloor)[1], result);
        System.out.print(++count + "; ");
    }

    void countTest(int flatNumber, int floors, int flatsOnFloor, int entrance, int floor){
        testEntrance(flatNumber, floors, flatsOnFloor, entrance);
        testFloor(flatNumber, floors, flatsOnFloor, floor);
        mainTest(flatNumber, floors, flatsOnFloor);
    }

    void mainTest(int flatNumber, int floors, int flatsOnFloor) {
        InputStream argsStream = new ByteArrayInputStream(
                (flatNumber + "\n" + floors + "\n" + flatsOnFloor)
                        .getBytes(StandardCharsets.UTF_8));
        System.setIn(argsStream);
        main(null);
    }
    @Test
    void count() {

        //region Граничные значения области определения 14 точек
        countTest(1,1,1, 1,1);
        countTest(0,1,1, -1,-1);
        countTest(2,1,1, 2,1);
        countTest(1,0,1, -1,-1);
        countTest(1,2,1, 1,1);
        countTest(1,1,2, 1,1);
        countTest(1,1,0, -1,-1);

        countTest(2147483647,1,1, 2147483647,1);
        countTest(2147483647,2,1, 1073741824,1);
        countTest(2147483647,0,1, -1,-1);
        countTest(2147483647,1,2, 1073741824,1);
        countTest(2147483647,1,0, -1,-1);
        countTest(2147483646,1,1, 2147483646,1);
        countTest(-2147483648,1,1, -1,-1);

        countTest(1,2147483647,1, 1,1);
        countTest(0,2147483647,1, -1,-1);
        countTest(2,2147483647,1, 1,2);
        countTest(1,2147483647,0, -1,-1);
        countTest(1,2147483647,2, -1,-1);
        countTest(1,2147483646,1, 1,1);
        countTest(1,-2147483648,1, -1,-1);

        countTest(2147483647,2147483647,1, 1,2147483647);
        countTest(2147483647,2147483647,2, -1,-1);
        countTest(2147483647,2147483647,0, -1,-1);
        countTest(2147483647,2147483646,1, 2,1);
        countTest(2147483647,-2147483648,1, -1,-1);
        countTest(2147483646,2147483647,1, 1,2147483646);
        countTest(-2147483648,2147483647,1, -1,-1);

        countTest(1,1,2147483647, 1,1);
        countTest(0,1,2147483647, -1,-1);
        countTest(2,1,2147483647, 1,1);
        countTest(1,0,2147483647, -1,-1);
        countTest(1,2,2147483647, -1,-1);
        countTest(1,1,2147483646, 1,1);
        countTest(1,1,-2147483648, -1,-1);

        countTest(2147483647,1,2147483647, 1,1);
        countTest(2147483646,1,2147483647, 1,1);
        countTest(-2147483648,1,2147483647, -1,-1);
        countTest(2147483647,0,2147483647, -1,-1);
        countTest(2147483647,2,2147483647, -1,-1);
        countTest(2147483647,1,2147483646, 2,1);
        countTest(2147483647,1,-2147483648, -1,-1);

        countTest(1,46341,46340, 1,1);
        countTest(2,46341,46340, 1,1);
        countTest(0,46341,46340, -1,-1);
        countTest(1,46342,46340, -1,-1);
        countTest(1,46340,46340, 1,1);
        countTest(1,46341,46341, -1,-1);
        countTest(1,46341,46339, 1,1);

        countTest(2147483647,46341,46340, 2,1);
        countTest(2147483646,46341,46340, 2,1);
        countTest(-2147483648,46341,46340, -1,-1);
        countTest(2147483647,46342,46340, -1,-1);
        countTest(2147483647,46340,46340, 2,2);
        countTest(2147483647,46341,46341, -1,-1);
        countTest(2147483647,46341,46339, 2,2);

        countTest(2147483647,92683,23170, 2,1);
        countTest(2147483646,92683,23170, 2,1);
        countTest(-2147483648,92683,23170, -1,-1);
        countTest(2147483647,92682,23170, 2,2);
        countTest(2147483647,92684,23170, -1,-1);
        countTest(2147483647,92683,23169, 2,5);
        countTest(2147483647,92683,23171, -1,-1);

        countTest(1073741823,92683,23170, 1,46342);
        countTest(1073741822,92683,23170, 1,46342);
        countTest(1073741824,92683,23170, 1,46342);
        countTest(1073741823,92682,23170, 1,46342);
        countTest(1073741823,92684,23170, -1,-1);
        countTest(1073741823,92683,23169, 1,46344);
        countTest(1073741823,92683,23171, -1,-1);

        countTest(1,92683,23170, 1,1);
        countTest(0,92683,23170, -1,-1);
        countTest(2,92683,23170, 1,1);
        countTest(1,92682,23170, 1,1);
        countTest(1,92684,23170, -1,-1);
        countTest(1,92683,23169, 1,1);
        countTest(1,92683,23171, -1,-1);

        countTest(2147483647,23170,92683, 2,1);
        countTest(2147483646,23170,92683, 2,1);
        countTest(-2147483648,23170,92683, -1,-1);
        countTest(2147483647,23170,92682, 2,1);
        countTest(2147483647,23170,92684, -1,-1);
        countTest(2147483647,23169,92683, 2,2);
        countTest(2147483647,23171,92683, -1,-1);

        countTest(1073741823,23170,92683, 1,11586);
        countTest(1073741822,23170,92683, 1,11586);
        countTest(1073741823,23170,92683, 1,11586);
        countTest(1073741823,23170,92682, 1,11586);
        countTest(1073741823,23170,92684, -1,-1);
        countTest(1073741823,23169,92683, 1,11586);
        countTest(1073741823,23171,92683, -1,-1);

        countTest(1,23170,92683, 1,1);
        countTest(0,23170,92683, -1,-1);
        countTest(2,23170,92683, 1,1);
        countTest(1,23170,92682, 1,1);
        countTest(1,23170,92684, -1,-1);
        countTest(1,23169,92683, 1,1);
        countTest(1,23171,92683, -1,-1);

        //endregion

        //region Классы "эквивалентности" - 22 классов /

        //Граничные дома
        //region 1 этажей, 1 квартиры
        countTest(0,1,1, -1,-1);
        countTest(1,1,1, 1,1);
        countTest(2,1,1, 2,1);

        countTest(1073741822,1,1, 1073741822,1);
        countTest(1073741823,1,1, 1073741823,1);
        countTest(1073741824,1,1, 1073741824,1);

        countTest(2147483646,1,1, 2147483646,1);
        countTest(2147483647,1,1, 2147483647,1);
        countTest(-2147483648,1,1, -1,-1);
        //endregion

        //region 1 этажей, 2147483647 квартиры
        countTest(0,1,2147483647, -1,-1);
        countTest(1,1,2147483647, 1,1);
        countTest(2,1,2147483647, 1,1);
        countTest(21474836,1,2147483647, 1,1);
        countTest(42949672,1,2147483647, 1,1);
        countTest(715827882,1,2147483647, 1,1);
        countTest(1073741823,1,2147483647, 1,1);
        countTest(2147483646,1,2147483647, 1,1);
        countTest(2147483647,1,2147483647, 1,1);
        countTest(-2147483648,1,2147483647, -1,-1);
        //endregion

        //region 2147483647 этажей, 1 квартиры
        countTest(0,2147483647,1, -1,-1);
        countTest(1,2147483647,1, 1,1);
        countTest(2,2147483647,1, 1,2);

        countTest(1073741823,2147483647,1, 1,1073741823);
        countTest(1073741824,2147483647,1, 1,1073741824);
        countTest(1073741825,2147483647,1, 1,1073741825);

        countTest(2147483646,2147483647,1, 1,2147483646);
        countTest(2147483647,2147483647,1, 1,2147483647);
        countTest(-2147483648,2147483647,1, -1,-1);
        //endregion

        //region 46341 этажей, 46340 квартиры
        countTest(0,46341,46340, -1,-1);
        countTest(1,46341,46340, 1,1);
        countTest(2,46341,46340, 1,1);
        countTest(6620,46341,46340, 1,1);
        countTest(15446,46341,46340, 1,1);
        countTest(30892,46341,46340, 1,1);
        countTest(46339,46341,46340, 1,1);
        countTest(46340,46341,46340, 1,1);
        countTest(46341,46341,46340, 1,2);

        countTest(23262680,46341,46340, 1,502);
        countTest(23262681,46341,46340, 1,503);
        countTest(23262682,46341,46340, 1,503);
        countTest(23269300,46341,46340, 1,503);
        countTest(23274265,46341,46340, 1,503);
        countTest(23297435,46341,46340, 1,503);
        countTest(23309019,46341,46340, 1,503);
        countTest(23309020,46341,46340, 1,503);
        countTest(23309021,46341,46340, 1,504);

        countTest(2147441940,46341,46340, 1,46341);
        countTest(2147441941,46341,46340, 2,1);
        countTest(2147441942,46341,46340, 2,1);
        countTest(2147477689,46341,46340, 2,1);
        countTest(2147462794,46341,46340, 2,1);
        countTest(2147455843,46341,46340, 2,1);
        countTest(2147483646,46341,46340, 2,1);
        countTest(2147483647,46341,46340, 2,1);
        countTest(-2147483648,46341,46340, -1,-1);
        //endregion

        //Предметная область
        //region 5 этажей, 4 квартиры
        countTest(0,5,4, -1,-1);
        countTest(1,5,4, 1,1);
        countTest(2,5,4, 1,1);
        countTest(4,5,4, 1,1);
        countTest(3,5,4, 1,1);
        countTest(5,5,4, 1,2);

        countTest(424,5,4, 22,1);
        countTest(425,5,4, 22,2);
        countTest(426,5,4, 22,2);
        countTest(428,5,4, 22,2);
        countTest(429,5,4, 22,3);

        countTest(1073741824,5,4, 53687092,1);
        countTest(1073741825,5,4, 53687092,2);
        countTest(1073741826,5,4, 53687092,2);
        countTest(1073741827,5,4, 53687092,2);
        countTest(1073741828,5,4, 53687092,2);
        countTest(1073741829,5,4, 53687092,3);

        countTest(2147483636,5,4, 107374182,4);
        countTest(2147483637,5,4, 107374182,5);
        countTest(2147483638,5,4, 107374182,5);
        countTest(2147483639,5,4, 107374182,5);
        countTest(2147483640,5,4, 107374182,5);
        countTest(2147483641,5,4, 107374183,1);
        //endregion

        //region 9 этажей, 8 квартиры
        countTest(0,9,8, -1,-1);
        countTest(1,9,8, 1,1);
        countTest(2,9,8, 1,1);
        countTest(4,9,8, 1,1);
        countTest(6,9,8, 1,1);
        countTest(8,9,8, 1,1);
        countTest(9,9,8, 1,2);
        countTest(10,9,8, 1,2);

        countTest(424,9,8, 6,8);
        countTest(425,9,8, 6,9);
        countTest(426,9,8, 6,9);
        countTest(427,9,8, 6,9);
        countTest(429,9,8, 6,9);
        countTest(431,9,8, 6,9);
        countTest(432,9,8, 6,9);
        countTest(433,9,8, 7,1);

        countTest(2147483640,9,8, 29826162,6);
        countTest(2147483644,9,8, 29826162,7);
        countTest(2147483645,9,8, 29826162,7);
        countTest(2147483646,9,8, 29826162,7);
        countTest(2147483647,9,8, 29826162,7);
        countTest(-2147483648,9,8, -1,-1);
        //endregion

        //Случайные значения
        //region 172143 этажей, 1274 квартиры
        countTest(0,172143,1274, -1,-1);
        countTest(1,172143,1274, 1,1);
        countTest(2,172143,1274, 1,1);
        countTest(572,172143,1274, 1,1);
        countTest(858,172143,1274, 1,1);
        countTest(1273,172143,1274, 1,1);
        countTest(1274,172143,1274, 1,1);
        countTest(1275,172143,1274, 1,2);

        countTest(219308908,172143,1274, 1,172142);
        countTest(219308909,172143,1274, 1,172143);
        countTest(219308910,172143,1274, 1,172143);
        countTest(219310181,172143,1274, 1,172143);
        countTest(219310182,172143,1274, 1,172143);
        countTest(219310183,172143,1274, 2,1);

        countTest(2147482428,172143,1274, 10,136335);
        countTest(2147482429,172143,1274, 10,136336);
        countTest(2147482430,172143,1274, 10,136336);
        countTest(2147482653,172143,1274, 10,136336);
        countTest(2147483178,172143,1274, 10,136336);
        countTest(2147483646,172143,1274, 10,136336);
        countTest(2147483647,172143,1274, 10,136336);
        countTest(-2147483648,172143,1274, -1,-1);
        //endregion

        //Особые значения

        //region 163 этажей, 70 квартиры
        countTest(0,163,70, -1,-1);
        countTest(1,163,70, 1,1);
        countTest(2,163,70, 1,1);
        countTest(35,163,70, 1,1);
        countTest(69,163,70, 1,1);
        countTest(70,163,70, 1,1);
        countTest(71,163,70, 1,2);

        countTest(11340,163,70, 1,162);
        countTest(11341,163,70, 1,163);
        countTest(11342,163,70, 1,163);
        countTest(11392,163,70, 1,163);
        countTest(11409,163,70, 1,163);
        countTest(11410,163,70, 1,163);
        countTest(11411,163,70, 2,1);
        //endregion
        //endregion

        //region Предметная область - строительство
        countTest(14,10,4, 1,4);
        countTest(36,5,4, 2,4);
        countTest(83,24,6, 1,14);
        countTest(217,8,3, 10,1);
        countTest(837,4,100, 3,1);
        countTest(16183,162,100, 1,162);
        countTest(815,162,100, 1,9);
        countTest(333,25,6, 3,6);
        countTest(218,40,5, 2,4);
        countTest(3000,9,4, 84,3);
        countTest(6000,9,4, 167,6);
        //endregion

        //region Реализация
        countTest(-1,1,1, -1,-1);
        countTest(1,1,-1, -1,-1);
        countTest(1,-1,1, -1,-1);

        countTest(46841,46341,46341, -1,-1);
        countTest(500,2147483647,46341, -1,-1);
        countTest(500,46340,2147483647, -1,-1);
        countTest(500,2147483647,2147483647, -1,-1);
        countTest(500,-2147483648,2147483647, -1,-1);
        countTest(500,2147483647,-2147483648, -1,-1);
        countTest(500,-2147483648,-2147483648, -1,-1);

        //endregion

        //region Случайные знначения
        countTest(162940204,1,1196921048, 1,1);
        countTest(1291516141,51531568,9, 3,40438658);
        countTest(1388532795,46240,22333, 2,15935);
        countTest(638732632,553295566,1, 2,85437066);
        countTest(2013577678,10971474,140, 2,3411224);
        countTest(56600169,52064861,38, 1,1489479);
        countTest(1246080787,228,5941107, 1,210);
        countTest(1920209609,145,759516, 18,64);
        countTest(1538084308,6,293766702, 1,6);
        countTest(1481165222,6,278910010, 1,6);
        countTest(1297625362,620305,1136, 2,521971);
        //endregion

        //region Другие особые значения +5
        countTest(777,666,555, 1,2);
        countTest(555,666,777, 1,1);
        countTest(710,45,1, 16,35);
        countTest(393,35,8, 2,15);
        countTest(370,1,17, 22,1);

        countTest(46841,46341,46340, 1,2);
        countTest(46841,46340,46341, 1,2);

        countTest(500,2147483647,1, 1,500);
        countTest(500,1073741824,1, 1,500);
        countTest(500,1073741824,2, -1,-1);
        countTest(500,1073741823,2, 1,250);
        countTest(500,715827883,2, 1,250);
        countTest(500,715827883,3, -1,-1);
        countTest(500,715827882,3, 1,167);
        countTest(500,536870912,3, 1,167);
        countTest(500,536870912,4, -1,-1);
        countTest(500,2,1073741823, 1,1);
        countTest(500,2,715827883, 1,1);
        countTest(500,3,715827883, -1,-1);
        countTest(500,3,715827882, 1,1);
        countTest(500,3,536870912, 1,1);
        countTest(500,4,536870912, -1,-1);
        //endregion


    }
}