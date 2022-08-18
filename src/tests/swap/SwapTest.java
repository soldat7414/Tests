package tests.swap;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.*;
import static tests.swap.Swap.main;
import static tests.swap.Swap.rebase;

/**
 * @author Ihor Soldatenko
 * @project Tests
 * @date 05.08.2022
 */
public class SwapTest {

    static int kount = 0;

    void rebaseTest(int x, int y) {
        assertTrue(y == rebase(x, y)[0]
                && x == rebase(x, y)[1]);
        kount++;
        System.out.print(kount + ": ");

        mainTest(x, y);

    }

    void inEqualClassOne(int x, int y) {
        assertTrue(0 <= rebase(x, y)[0]
                && 0 <= rebase(x, y)[1]);
        rebaseTest(x, y);
    }

    void outOfEqualClassOne(int x, int y) {
        assertFalse(0 <= rebase(x, y)[0]
                && 0 <= rebase(x, y)[1]);
        rebaseTest(x, y);
    }

    void inEqualClassTwo(int x, int y) {
        assertTrue(0 < rebase(x, y)[0]
                && 0 > rebase(x, y)[1]);
        rebaseTest(x, y);
    }

    void outOfEqualClassTwo(int x, int y) {
        assertFalse(0 < rebase(x, y)[0]
                && 0 > rebase(x, y)[1]);
        rebaseTest(x, y);
    }

    void inEqualClassThree(int x, int y) {
        assertTrue(0 >= rebase(x, y)[0]
                && 0 >= rebase(x, y)[1]);
        rebaseTest(x, y);
    }

    void outOfEqualClassThree(int x, int y) {
        assertFalse(0 >= rebase(x, y)[0]
                && 0 >= rebase(x, y)[1]);
        rebaseTest(x, y);
    }

    void inEqualClassFour(int x, int y) {
        assertTrue(0 < rebase(x, y)[0]
                && 0 > rebase(x, y)[1]);
        rebaseTest(x, y);
    }

    void outOfEqualClassFour(int x, int y) {
        assertFalse(0 > rebase(x, y)[0]
                && 0 <= rebase(x, y)[1]);
        rebaseTest(x, y);
    }

    void inEqualClassFive(int x, int y) {
        assertEquals(Math.abs(rebase(x, y)[0]), Math.abs(rebase(x, y)[1]));
        rebaseTest(x, y);
    }

    void outOfEqualClassFive(int x, int y) {
        assertNotEquals(Math.abs(rebase(x, y)[0]), Math.abs(rebase(x, y)[1]));
        rebaseTest(x, y);
    }


    void mainTest(int x, int y) {
        InputStream argsStream = new ByteArrayInputStream((x + "\n" + y).getBytes(StandardCharsets.UTF_8));
        System.setIn(argsStream);
        main(null);
    }

    @Test
    void oneTest() {
        //region граница области определения
        rebaseTest(2095607377, -317632911);

        rebaseTest(MAX_VALUE, MAX_VALUE);
        rebaseTest(MAX_VALUE, MIN_VALUE);
        rebaseTest(MIN_VALUE, MIN_VALUE);
        rebaseTest(MIN_VALUE, MAX_VALUE);
        rebaseTest(MIN_VALUE, 0);
        rebaseTest(0, MIN_VALUE);
        rebaseTest(MAX_VALUE, 0);
        rebaseTest(0, MAX_VALUE);
        //Особые значения границы области определения
        rebaseTest(MAX_VALUE, 429496729);
        rebaseTest(MAX_VALUE, 858993458);
        rebaseTest(MAX_VALUE, 1288490187);
        rebaseTest(MAX_VALUE, 1717986916);
        rebaseTest(MAX_VALUE, 2147483645);
        rebaseTest(MAX_VALUE, -429496729);
        rebaseTest(MAX_VALUE, -858993458);
        rebaseTest(MAX_VALUE, -1288490187);
        rebaseTest(MAX_VALUE, -1717986916);
        rebaseTest(MAX_VALUE, -2147483645);
        rebaseTest(MIN_VALUE, 429496729);
        rebaseTest(MIN_VALUE, 858993458);
        rebaseTest(MIN_VALUE, 1288490187);
        rebaseTest(MIN_VALUE, 1717986916);
        rebaseTest(MIN_VALUE, 2147483645);
        rebaseTest(MIN_VALUE, -429496729);
        rebaseTest(MIN_VALUE, -858993458);
        rebaseTest(MIN_VALUE, -1288490187);
        rebaseTest(MIN_VALUE, -1717986916);
        rebaseTest(MIN_VALUE, -2147483645);
        rebaseTest(429496729, MAX_VALUE);
        rebaseTest(858993458, MAX_VALUE);
        rebaseTest(1288490187, MAX_VALUE);
        rebaseTest(1717986916, MAX_VALUE);
        rebaseTest(2147483645, MAX_VALUE);
        rebaseTest(-429496729, MAX_VALUE);
        rebaseTest(-858993458, MAX_VALUE);
        rebaseTest(-1288490187, MAX_VALUE);
        rebaseTest(-1717986916, MAX_VALUE);
        rebaseTest(-2147483645, MAX_VALUE);
        rebaseTest(429496729, MIN_VALUE);
        rebaseTest(858993458, MIN_VALUE);
        rebaseTest(1288490187, MIN_VALUE);
        rebaseTest(1717986916, MIN_VALUE);
        rebaseTest(2147483645, MIN_VALUE);
        rebaseTest(-429496729, MIN_VALUE);
        rebaseTest(-858993458, MIN_VALUE);
        rebaseTest(-1288490187, MIN_VALUE);
        rebaseTest(-1717986916, MIN_VALUE);
        rebaseTest(-2147483645, MIN_VALUE);
        //случайные значения границы области определения
        rebaseTest(1725134879, MAX_VALUE);
        rebaseTest(1703693963, MAX_VALUE);
        rebaseTest(1679161165, MAX_VALUE);
        rebaseTest(311057718, MAX_VALUE);
        rebaseTest(1425276169, MAX_VALUE);
        rebaseTest(496192457, MAX_VALUE);
        rebaseTest(149190237, MAX_VALUE);
        rebaseTest(1387643996, MAX_VALUE);
        rebaseTest(1185178704, MAX_VALUE);
        rebaseTest(1448720733, MAX_VALUE);
        rebaseTest(554845643, MAX_VALUE);
        rebaseTest(907407718, MAX_VALUE);
        rebaseTest(888670748, MAX_VALUE);
        rebaseTest(549550718, MAX_VALUE);
        rebaseTest(23990168, MAX_VALUE);
        rebaseTest(230970577, MAX_VALUE);
        rebaseTest(1164431589, MAX_VALUE);
        rebaseTest(1867369144, MAX_VALUE);
        rebaseTest(2049114926, MAX_VALUE);
        rebaseTest(567018494, MAX_VALUE);
        rebaseTest(-1216822950, MAX_VALUE);
        rebaseTest(-957531674, MAX_VALUE);
        rebaseTest(-569838631, MAX_VALUE);
        rebaseTest(-871918869, MAX_VALUE);
        rebaseTest(-13150946, MAX_VALUE);
        rebaseTest(-323201662, MAX_VALUE);
        rebaseTest(-1354315995, MAX_VALUE);
        rebaseTest(-1286377418, MAX_VALUE);
        rebaseTest(-1903980155, MAX_VALUE);
        rebaseTest(-1994643695, MAX_VALUE);
        rebaseTest(-1763293704, MAX_VALUE);
        rebaseTest(-898870949, MAX_VALUE);
        rebaseTest(-647007419, MAX_VALUE);
        rebaseTest(-1720268604, MAX_VALUE);
        rebaseTest(-1112595411, MAX_VALUE);
        rebaseTest(-1089521975, MAX_VALUE);
        rebaseTest(-782432582, MAX_VALUE);
        rebaseTest(-52015352, MAX_VALUE);
        rebaseTest(-1433010821, MAX_VALUE);
        rebaseTest(-273914561, MAX_VALUE);
        rebaseTest(-1034877638, MIN_VALUE);
        rebaseTest(-215862456, MIN_VALUE);
        rebaseTest(-1750861021, MIN_VALUE);
        rebaseTest(-1940680459, MIN_VALUE);
        rebaseTest(-1725539683, MIN_VALUE);
        rebaseTest(-255311835, MIN_VALUE);
        rebaseTest(-1617379287, MIN_VALUE);
        rebaseTest(-1327208875, MIN_VALUE);
        rebaseTest(-459927873, MIN_VALUE);
        rebaseTest(-968813872, MIN_VALUE);
        rebaseTest(-1381241879, MIN_VALUE);
        rebaseTest(-790800463, MIN_VALUE);
        rebaseTest(-39258554, MIN_VALUE);
        rebaseTest(-309949590, MIN_VALUE);
        rebaseTest(-650620994, MIN_VALUE);
        rebaseTest(-1336703887, MIN_VALUE);
        rebaseTest(-386007982, MIN_VALUE);
        rebaseTest(-180520034, MIN_VALUE);
        rebaseTest(-1436453800, MIN_VALUE);
        rebaseTest(-1205984674, MIN_VALUE);
        rebaseTest(1093024810, MIN_VALUE);
        rebaseTest(1943185693, MIN_VALUE);
        rebaseTest(1400720878, MIN_VALUE);
        rebaseTest(722540141, MIN_VALUE);
        rebaseTest(1134706208, MIN_VALUE);
        rebaseTest(477500774, MIN_VALUE);
        rebaseTest(1862799099, MIN_VALUE);
        rebaseTest(428767886, MIN_VALUE);
        rebaseTest(2126059793, MIN_VALUE);
        rebaseTest(1315527149, MIN_VALUE);
        rebaseTest(1049935890, MIN_VALUE);
        rebaseTest(1739603276, MIN_VALUE);
        rebaseTest(303630075, MIN_VALUE);
        rebaseTest(1507821397, MIN_VALUE);
        rebaseTest(757196290, MIN_VALUE);
        rebaseTest(1843442983, MIN_VALUE);
        rebaseTest(1082418650, MIN_VALUE);
        rebaseTest(1953583720, MIN_VALUE);
        rebaseTest(2072616793, MIN_VALUE);
        rebaseTest(1415352221, MIN_VALUE);
        rebaseTest(MIN_VALUE, 1312499196);
        rebaseTest(MIN_VALUE, 1937284701);
        rebaseTest(MIN_VALUE, 624393577);
        rebaseTest(MIN_VALUE, 1628628405);
        rebaseTest(MIN_VALUE, 234807033);
        rebaseTest(MIN_VALUE, 1245047202);
        rebaseTest(MIN_VALUE, 955645718);
        rebaseTest(MIN_VALUE, 876963992);
        rebaseTest(MIN_VALUE, 562713547);
        rebaseTest(MIN_VALUE, 1385782757);
        rebaseTest(MIN_VALUE, 426462704);
        rebaseTest(MIN_VALUE, 233692954);
        rebaseTest(MIN_VALUE, 851385148);
        rebaseTest(MIN_VALUE, 543415527);
        rebaseTest(MIN_VALUE, 1858958849);
        rebaseTest(MIN_VALUE, 1852186708);
        rebaseTest(MIN_VALUE, 1015095856);
        rebaseTest(MIN_VALUE, 1298722982);
        rebaseTest(MIN_VALUE, 1011407341);
        rebaseTest(MIN_VALUE, 87029799);
        rebaseTest(MIN_VALUE, -1537035241);
        rebaseTest(MIN_VALUE, -1424550865);
        rebaseTest(MIN_VALUE, -789396890);
        rebaseTest(MIN_VALUE, -2085919867);
        rebaseTest(MIN_VALUE, -992570152);
        rebaseTest(MIN_VALUE, -201292173);
        rebaseTest(MIN_VALUE, -887071729);
        rebaseTest(MIN_VALUE, -1918585588);
        rebaseTest(MIN_VALUE, -1976126917);
        rebaseTest(MIN_VALUE, -1080684620);
        rebaseTest(MIN_VALUE, -1085366949);
        rebaseTest(MIN_VALUE, -2035904298);
        rebaseTest(MIN_VALUE, -132482197);
        rebaseTest(MIN_VALUE, -1497977874);
        rebaseTest(MIN_VALUE, -1555654924);
        rebaseTest(MIN_VALUE, -86473230);
        rebaseTest(MIN_VALUE, -1335230285);
        rebaseTest(MIN_VALUE, -622946141);
        rebaseTest(MIN_VALUE, -14799270);
        rebaseTest(MIN_VALUE, -277386443);
        rebaseTest(MAX_VALUE, -323033074);
        rebaseTest(MAX_VALUE, -689170201);
        rebaseTest(MAX_VALUE, -1277487365);
        rebaseTest(MAX_VALUE, -480652000);
        rebaseTest(MAX_VALUE, -990612312);
        rebaseTest(MAX_VALUE, -290169386);
        rebaseTest(MAX_VALUE, -964342954);
        rebaseTest(MAX_VALUE, -125681104);
        rebaseTest(MAX_VALUE, -1151129627);
        rebaseTest(MAX_VALUE, -1228048210);
        rebaseTest(MAX_VALUE, -1075496030);
        rebaseTest(MAX_VALUE, -35181627);
        rebaseTest(MAX_VALUE, -462198760);
        rebaseTest(MAX_VALUE, -1026505363);
        rebaseTest(MAX_VALUE, -28256970);
        rebaseTest(MAX_VALUE, -1552725960);
        rebaseTest(MAX_VALUE, -1123757968);
        rebaseTest(MAX_VALUE, -1232018895);
        rebaseTest(MAX_VALUE, -2056089612);
        rebaseTest(MAX_VALUE, -110261903);
        rebaseTest(MAX_VALUE, 1443597708);
        rebaseTest(MAX_VALUE, 908358674);
        rebaseTest(MAX_VALUE, 117573473);
        rebaseTest(MAX_VALUE, 1595671651);
        rebaseTest(MAX_VALUE, 353598895);
        rebaseTest(MAX_VALUE, 1311495803);
        rebaseTest(MAX_VALUE, 1879067506);
        rebaseTest(MAX_VALUE, 256632642);
        rebaseTest(MAX_VALUE, 1857065612);
        rebaseTest(MAX_VALUE, 2060563561);
        rebaseTest(MAX_VALUE, 2140695970);
        rebaseTest(MAX_VALUE, 557634349);
        rebaseTest(MAX_VALUE, 340131767);
        rebaseTest(MAX_VALUE, 1776083433);
        rebaseTest(MAX_VALUE, 296035474);
        rebaseTest(MAX_VALUE, 1144481756);
        rebaseTest(MAX_VALUE, 1547608937);
        rebaseTest(MAX_VALUE, 1923830319);
        rebaseTest(MAX_VALUE, 1391781261);
        rebaseTest(MAX_VALUE, 431547611);

        //endregion

        //region граница области определения | Валидный сосед
        //углы и оси
        rebaseTest(MAX_VALUE - 1, MAX_VALUE);
        rebaseTest(MAX_VALUE - 1, MIN_VALUE);
        rebaseTest(MIN_VALUE + 1, MIN_VALUE);
        rebaseTest(MIN_VALUE + 1, MAX_VALUE);
        rebaseTest(MAX_VALUE, MAX_VALUE - 1);
        rebaseTest(MAX_VALUE, MIN_VALUE + 1);
        rebaseTest(MIN_VALUE, MIN_VALUE + 1);
        rebaseTest(MIN_VALUE, MAX_VALUE - 1);
        rebaseTest(MAX_VALUE - 1, MAX_VALUE - 1);
        rebaseTest(MAX_VALUE - 1, MIN_VALUE + 1);
        rebaseTest(MIN_VALUE + 1, MIN_VALUE + 1);
        rebaseTest(MIN_VALUE + 1, MAX_VALUE - 1);
        rebaseTest(MIN_VALUE + 1, 0);
        rebaseTest(0, MIN_VALUE + 1);
        rebaseTest(MAX_VALUE - 1, 0);
        rebaseTest(0, MAX_VALUE - 1);
        //границы
        rebaseTest(MAX_VALUE - 1, 429496729);
        rebaseTest(MAX_VALUE - 1, 858993458);
        rebaseTest(MAX_VALUE - 1, 1288490187);
        rebaseTest(MAX_VALUE - 1, 1717986916);
        rebaseTest(MAX_VALUE - 1, 2147483645);
        rebaseTest(MAX_VALUE - 1, -429496729);
        rebaseTest(MAX_VALUE - 1, -858993458);
        rebaseTest(MAX_VALUE - 1, -1288490187);
        rebaseTest(MAX_VALUE - 1, -1717986916);
        rebaseTest(MAX_VALUE - 1, -2147483645);
        rebaseTest(MIN_VALUE + 1, 429496729);
        rebaseTest(MIN_VALUE + 1, 858993458);
        rebaseTest(MIN_VALUE + 1, 1288490187);
        rebaseTest(MIN_VALUE + 1, 1717986916);
        rebaseTest(MIN_VALUE + 1, 2147483645);
        rebaseTest(MIN_VALUE + 1, -429496729);
        rebaseTest(MIN_VALUE + 1, -858993458);
        rebaseTest(MIN_VALUE + 1, -1288490187);
        rebaseTest(MIN_VALUE + 1, -1717986916);
        rebaseTest(MIN_VALUE + 1, -2147483645);
        rebaseTest(429496729, MAX_VALUE - 1);
        rebaseTest(858993458, MAX_VALUE - 1);
        rebaseTest(1288490187, MAX_VALUE - 1);
        rebaseTest(1717986916, MAX_VALUE - 1);
        rebaseTest(2147483645, MAX_VALUE - 1);
        rebaseTest(-429496729, MAX_VALUE - 1);
        rebaseTest(-858993458, MAX_VALUE - 1);
        rebaseTest(-1288490187, MAX_VALUE - 1);
        rebaseTest(-1717986916, MAX_VALUE - 1);
        rebaseTest(-2147483645, MAX_VALUE - 1);
        rebaseTest(429496729, MIN_VALUE + 1);
        rebaseTest(858993458, MIN_VALUE + 1);
        rebaseTest(1288490187, MIN_VALUE + 1);
        rebaseTest(1717986916, MIN_VALUE + 1);
        rebaseTest(2147483645, MIN_VALUE + 1);
        rebaseTest(-429496729, MIN_VALUE + 1);
        rebaseTest(-858993458, MIN_VALUE + 1);
        rebaseTest(-1288490187, MIN_VALUE + 1);
        rebaseTest(-1717986916, MIN_VALUE + 1);
        rebaseTest(-2147483645, MIN_VALUE + 1);
        //Валидные соседи случайных значений
        rebaseTest(1725134879, MAX_VALUE - 1);
        rebaseTest(1703693963, MAX_VALUE - 1);
        rebaseTest(1679161165, MAX_VALUE - 1);
        rebaseTest(311057718, MAX_VALUE - 1);
        rebaseTest(1425276169, MAX_VALUE - 1);
        rebaseTest(496192457, MAX_VALUE - 1);
        rebaseTest(149190237, MAX_VALUE - 1);
        rebaseTest(1387643996, MAX_VALUE - 1);
        rebaseTest(1185178704, MAX_VALUE - 1);
        rebaseTest(1448720733, MAX_VALUE - 1);
        rebaseTest(554845643, MAX_VALUE - 1);
        rebaseTest(907407718, MAX_VALUE - 1);
        rebaseTest(888670748, MAX_VALUE - 1);
        rebaseTest(549550718, MAX_VALUE - 1);
        rebaseTest(23990168, MAX_VALUE - 1);
        rebaseTest(230970577, MAX_VALUE - 1);
        rebaseTest(1164431589, MAX_VALUE - 1);
        rebaseTest(1867369144, MAX_VALUE - 1);
        rebaseTest(2049114926, MAX_VALUE - 1);
        rebaseTest(567018494, MAX_VALUE - 1);
        rebaseTest(-1216822950, MAX_VALUE - 1);
        rebaseTest(-957531674, MAX_VALUE - 1);
        rebaseTest(-569838631, MAX_VALUE - 1);
        rebaseTest(-871918869, MAX_VALUE - 1);
        rebaseTest(-13150946, MAX_VALUE - 1);
        rebaseTest(-323201662, MAX_VALUE - 1);
        rebaseTest(-1354315995, MAX_VALUE - 1);
        rebaseTest(-1286377418, MAX_VALUE - 1);
        rebaseTest(-1903980155, MAX_VALUE - 1);
        rebaseTest(-1994643695, MAX_VALUE - 1);
        rebaseTest(-1763293704, MAX_VALUE - 1);
        rebaseTest(-898870949, MAX_VALUE - 1);
        rebaseTest(-647007419, MAX_VALUE - 1);
        rebaseTest(-1720268604, MAX_VALUE - 1);
        rebaseTest(-1112595411, MAX_VALUE - 1);
        rebaseTest(-1089521975, MAX_VALUE - 1);
        rebaseTest(-782432582, MAX_VALUE - 1);
        rebaseTest(-52015352, MAX_VALUE - 1);
        rebaseTest(-1433010821, MAX_VALUE - 1);
        rebaseTest(-273914561, MAX_VALUE - 1);
        rebaseTest(-1034877638, MIN_VALUE + 1);
        rebaseTest(-215862456, MIN_VALUE + 1);
        rebaseTest(-1750861021, MIN_VALUE + 1);
        rebaseTest(-1940680459, MIN_VALUE + 1);
        rebaseTest(-1725539683, MIN_VALUE + 1);
        rebaseTest(-255311835, MIN_VALUE + 1);
        rebaseTest(-1617379287, MIN_VALUE + 1);
        rebaseTest(-1327208875, MIN_VALUE + 1);
        rebaseTest(-459927873, MIN_VALUE + 1);
        rebaseTest(-968813872, MIN_VALUE + 1);
        rebaseTest(-1381241879, MIN_VALUE + 1);
        rebaseTest(-790800463, MIN_VALUE + 1);
        rebaseTest(-39258554, MIN_VALUE + 1);
        rebaseTest(-309949590, MIN_VALUE + 1);
        rebaseTest(-650620994, MIN_VALUE + 1);
        rebaseTest(-1336703887, MIN_VALUE + 1);
        rebaseTest(-386007982, MIN_VALUE + 1);
        rebaseTest(-180520034, MIN_VALUE + 1);
        rebaseTest(-1436453800, MIN_VALUE + 1);
        rebaseTest(-1205984674, MIN_VALUE + 1);
        rebaseTest(1093024810, MIN_VALUE + 1);
        rebaseTest(1943185693, MIN_VALUE + 1);
        rebaseTest(1400720878, MIN_VALUE + 1);
        rebaseTest(722540141, MIN_VALUE + 1);
        rebaseTest(1134706208, MIN_VALUE + 1);
        rebaseTest(477500774, MIN_VALUE + 1);
        rebaseTest(1862799099, MIN_VALUE + 1);
        rebaseTest(428767886, MIN_VALUE + 1);
        rebaseTest(2126059793, MIN_VALUE + 1);
        rebaseTest(1315527149, MIN_VALUE + 1);
        rebaseTest(1049935890, MIN_VALUE + 1);
        rebaseTest(1739603276, MIN_VALUE + 1);
        rebaseTest(303630075, MIN_VALUE + 1);
        rebaseTest(1507821397, MIN_VALUE + 1);
        rebaseTest(757196290, MIN_VALUE + 1);
        rebaseTest(1843442983, MIN_VALUE + 1);
        rebaseTest(1082418650, MIN_VALUE + 1);
        rebaseTest(1953583720, MIN_VALUE + 1);
        rebaseTest(2072616793, MIN_VALUE + 1);
        rebaseTest(1415352221, MIN_VALUE + 1);
        rebaseTest(MIN_VALUE + 1, 1312499196);
        rebaseTest(MIN_VALUE + 1, 1937284701);
        rebaseTest(MIN_VALUE + 1, 624393577);
        rebaseTest(MIN_VALUE + 1, 1628628405);
        rebaseTest(MIN_VALUE + 1, 234807033);
        rebaseTest(MIN_VALUE + 1, 1245047202);
        rebaseTest(MIN_VALUE + 1, 955645718);
        rebaseTest(MIN_VALUE + 1, 876963992);
        rebaseTest(MIN_VALUE + 1, 562713547);
        rebaseTest(MIN_VALUE + 1, 1385782757);
        rebaseTest(MIN_VALUE + 1, 426462704);
        rebaseTest(MIN_VALUE + 1, 233692954);
        rebaseTest(MIN_VALUE + 1, 851385148);
        rebaseTest(MIN_VALUE + 1, 543415527);
        rebaseTest(MIN_VALUE + 1, 1858958849);
        rebaseTest(MIN_VALUE + 1, 1852186708);
        rebaseTest(MIN_VALUE + 1, 1015095856);
        rebaseTest(MIN_VALUE + 1, 1298722982);
        rebaseTest(MIN_VALUE + 1, 1011407341);
        rebaseTest(MIN_VALUE + 1, 87029799);
        rebaseTest(MIN_VALUE + 1, -1537035241);
        rebaseTest(MIN_VALUE + 1, -1424550865);
        rebaseTest(MIN_VALUE + 1, -789396890);
        rebaseTest(MIN_VALUE + 1, -2085919867);
        rebaseTest(MIN_VALUE + 1, -992570152);
        rebaseTest(MIN_VALUE + 1, -201292173);
        rebaseTest(MIN_VALUE + 1, -887071729);
        rebaseTest(MIN_VALUE + 1, -1918585588);
        rebaseTest(MIN_VALUE + 1, -1976126917);
        rebaseTest(MIN_VALUE + 1, -1080684620);
        rebaseTest(MIN_VALUE + 1, -1085366949);
        rebaseTest(MIN_VALUE + 1, -2035904298);
        rebaseTest(MIN_VALUE + 1, -132482197);
        rebaseTest(MIN_VALUE + 1, -1497977874);
        rebaseTest(MIN_VALUE + 1, -1555654924);
        rebaseTest(MIN_VALUE + 1, -86473230);
        rebaseTest(MIN_VALUE + 1, -1335230285);
        rebaseTest(MIN_VALUE + 1, -622946141);
        rebaseTest(MIN_VALUE + 1, -14799270);
        rebaseTest(MIN_VALUE + 1, -277386443);
        rebaseTest(MAX_VALUE - 1, -323033074);
        rebaseTest(MAX_VALUE - 1, -689170201);
        rebaseTest(MAX_VALUE - 1, -1277487365);
        rebaseTest(MAX_VALUE - 1, -480652000);
        rebaseTest(MAX_VALUE - 1, -990612312);
        rebaseTest(MAX_VALUE - 1, -290169386);
        rebaseTest(MAX_VALUE - 1, -964342954);
        rebaseTest(MAX_VALUE - 1, -125681104);
        rebaseTest(MAX_VALUE - 1, -1151129627);
        rebaseTest(MAX_VALUE - 1, -1228048210);
        rebaseTest(MAX_VALUE - 1, -1075496030);
        rebaseTest(MAX_VALUE - 1, -35181627);
        rebaseTest(MAX_VALUE - 1, -462198760);
        rebaseTest(MAX_VALUE - 1, -1026505363);
        rebaseTest(MAX_VALUE - 1, -28256970);
        rebaseTest(MAX_VALUE - 1, -1552725960);
        rebaseTest(MAX_VALUE - 1, -1123757968);
        rebaseTest(MAX_VALUE - 1, -1232018895);
        rebaseTest(MAX_VALUE - 1, -2056089612);
        rebaseTest(MAX_VALUE - 1, -110261903);
        rebaseTest(MAX_VALUE - 1, 1443597708);
        rebaseTest(MAX_VALUE - 1, 908358674);
        rebaseTest(MAX_VALUE - 1, 117573473);
        rebaseTest(MAX_VALUE - 1, 1595671651);
        rebaseTest(MAX_VALUE - 1, 353598895);
        rebaseTest(MAX_VALUE - 1, 1311495803);
        rebaseTest(MAX_VALUE - 1, 1879067506);
        rebaseTest(MAX_VALUE - 1, 256632642);
        rebaseTest(MAX_VALUE - 1, 1857065612);
        rebaseTest(MAX_VALUE - 1, 2060563561);
        rebaseTest(MAX_VALUE - 1, 2140695970);
        rebaseTest(MAX_VALUE - 1, 557634349);
        rebaseTest(MAX_VALUE - 1, 340131767);
        rebaseTest(MAX_VALUE - 1, 1776083433);
        rebaseTest(MAX_VALUE - 1, 296035474);
        rebaseTest(MAX_VALUE - 1, 1144481756);
        rebaseTest(MAX_VALUE - 1, 1547608937);
        rebaseTest(MAX_VALUE - 1, 1923830319);
        rebaseTest(MAX_VALUE - 1, 1391781261);
        rebaseTest(MAX_VALUE - 1, 431547611);
        //endregion

        //region Предметная область - калькулятор. Границы предметной области совпадают с областью определения
        //Особые значения предметной области совпадают с областью определения
        //Случайные значения предметной области (по 20 значений в каждом классе эквивалентности)
        rebaseTest(1220374705, 1157494200);
        rebaseTest(203691803, 1935293531);
        rebaseTest(1540180078, 1794360055);
        rebaseTest(1447922543, 1033652972);
        rebaseTest(273469497, 1791353424);
        rebaseTest(245377649, 1108880058);
        rebaseTest(83988534, 587108347);
        rebaseTest(1548598910, 465134264);
        rebaseTest(777029097, 1541990478);
        rebaseTest(774496758, 1973981559);
        rebaseTest(391797598, 1849796922);
        rebaseTest(413882773, 2136994140);
        rebaseTest(1670390833, 279427356);
        rebaseTest(375813649, 2125735191);
        rebaseTest(608806145, 687699898);
        rebaseTest(1310293816, 1595034619);
        rebaseTest(503718177, 336320130);
        rebaseTest(1803822460, 1683250592);
        rebaseTest(86028500, 1859664172);
        rebaseTest(644021307, 850186019);
        rebaseTest(-165748569, 171842745);
        rebaseTest(-1158151307, 743079488);
        rebaseTest(-1072845300, 1383958730);
        rebaseTest(-1042878259, 947250818);
        rebaseTest(-90649931, 428820475);
        rebaseTest(-396205710, 1594399969);
        rebaseTest(-160904229, 1546643188);
        rebaseTest(-1038364964, 1044387017);
        rebaseTest(-1950037397, 1186102774);
        rebaseTest(-1382616073, 1074572048);
        rebaseTest(-1901339439, 1875656847);
        rebaseTest(-1420221675, 387840957);
        rebaseTest(-243529508, 1957287356);
        rebaseTest(-341470317, 1930263813);
        rebaseTest(-1654805211, 1522497601);
        rebaseTest(-153245673, 103310436);
        rebaseTest(-1752538309, 1491394394);
        rebaseTest(-2114180261, 1719259712);
        rebaseTest(-1234806579, 1785589198);
        rebaseTest(-1970108732, 114706136);
        rebaseTest(247258530, -1410411443);
        rebaseTest(1148260395, -2076794294);
        rebaseTest(1182596145, -193791390);
        rebaseTest(571306563, -2070336065);
        rebaseTest(877415669, -1075631422);
        rebaseTest(1233217634, -102747338);
        rebaseTest(2095607377, -317632911);
        rebaseTest(1421907587, -1776121128);
        rebaseTest(235643329, -1676347191);
        rebaseTest(507735304, -1472319641);
        rebaseTest(723624393, -1883175044);
        rebaseTest(1200301022, -269477075);
        rebaseTest(417923037, -1564116519);
        rebaseTest(1943190437, -920397077);
        rebaseTest(1443498772, -724795072);
        rebaseTest(1552288184, -927344123);
        rebaseTest(650919543, -1899902931);
        rebaseTest(523749425, -840735133);
        rebaseTest(1983067857, -732761457);
        rebaseTest(49263105, -1340904498);
        rebaseTest(-787231040, -1416080083);
        rebaseTest(-1959371897, -1839011859);
        rebaseTest(-848630180, -1833638568);
        rebaseTest(-570345755, -2111302224);
        rebaseTest(-2114318413, -434347779);
        rebaseTest(-1603389569, -547401287);
        rebaseTest(-1432760495, -1592873501);
        rebaseTest(-2113340610, -1570458240);
        rebaseTest(-49684296, -457739673);
        rebaseTest(-959568594, -480416913);
        rebaseTest(-1201019055, -1321147420);
        rebaseTest(-738192796, -1802519977);
        rebaseTest(-338966138, -1224159348);
        rebaseTest(-113997726, -1446459048);
        rebaseTest(-2137622224, -1660495472);
        rebaseTest(-1228776886, -338748479);
        rebaseTest(-716163550, -1940720378);
        rebaseTest(-1600780544, -138361678);
        rebaseTest(-1857599579, -1080355840);
        rebaseTest(-1235988908, -417574215);
        //endregion

        //region Предметная область - шахматы. Границы предметной области - квадрат 8х8. Так как предметная область мала, можно проверить каждое значений
        rebaseTest(1, 1);
        rebaseTest(2, 1);
        rebaseTest(3, 1);
        rebaseTest(4, 1);
        rebaseTest(5, 1);
        rebaseTest(6, 1);
        rebaseTest(7, 1);
        rebaseTest(8, 1);
        rebaseTest(1, 2);
        rebaseTest(2, 2);
        rebaseTest(3, 2);
        rebaseTest(4, 2);
        rebaseTest(5, 2);
        rebaseTest(6, 2);
        rebaseTest(7, 2);
        rebaseTest(8, 2);
        rebaseTest(1, 3);
        rebaseTest(2, 3);
        rebaseTest(3, 3);
        rebaseTest(4, 3);
        rebaseTest(5, 3);
        rebaseTest(6, 3);
        rebaseTest(7, 3);
        rebaseTest(8, 3);
        rebaseTest(1, 4);
        rebaseTest(2, 4);
        rebaseTest(3, 4);
        rebaseTest(4, 4);
        rebaseTest(5, 4);
        rebaseTest(6, 4);
        rebaseTest(7, 4);
        rebaseTest(8, 4);
        rebaseTest(1, 5);
        rebaseTest(2, 5);
        rebaseTest(3, 5);
        rebaseTest(4, 5);
        rebaseTest(5, 5);
        rebaseTest(6, 5);
        rebaseTest(7, 5);
        rebaseTest(8, 5);
        rebaseTest(1, 6);
        rebaseTest(2, 6);
        rebaseTest(3, 6);
        rebaseTest(4, 6);
        rebaseTest(5, 6);
        rebaseTest(6, 6);
        rebaseTest(7, 6);
        rebaseTest(8, 6);
        rebaseTest(1, 7);
        rebaseTest(2, 7);
        rebaseTest(3, 7);
        rebaseTest(4, 7);
        rebaseTest(5, 7);
        rebaseTest(6, 7);
        rebaseTest(7, 7);
        rebaseTest(8, 7);
        rebaseTest(1, 8);
        rebaseTest(2, 8);
        rebaseTest(3, 8);
        rebaseTest(4, 8);
        rebaseTest(5, 8);
        rebaseTest(6, 8);
        rebaseTest(7, 8);
        rebaseTest(8, 8);
        //endregion

        //region Класс эквивалентности 1 (x>=0 & y>=0)
        //region Граница класса эквивалентности
        inEqualClassOne(429496729, 0);
        inEqualClassOne(858993458, 0);
        inEqualClassOne(1288490187, 0);
        inEqualClassOne(1717986916, 0);
        inEqualClassOne(2147483645, 0);
        inEqualClassOne(0, 429496729);
        inEqualClassOne(0, 858993458);
        inEqualClassOne(0, 1288490187);
        inEqualClassOne(0, 1717986916);
        inEqualClassOne(0, 2147483645);
        //endregion

        //region валидный сосед границы класса
        inEqualClassOne(429496729, 1);
        inEqualClassOne(858993458, 1);
        inEqualClassOne(1288490187, 1);
        inEqualClassOne(1717986916, 1);
        inEqualClassOne(2147483645, 1);
        inEqualClassOne(1, 429496729);
        inEqualClassOne(1, 858993458);
        inEqualClassOne(1, 1288490187);
        inEqualClassOne(1, 1717986916);
        inEqualClassOne(1, 2147483645);
        //endregion

        //region Не валидный сосед
        outOfEqualClassOne(429496729, -1);
        outOfEqualClassOne(858993458, -1);
        outOfEqualClassOne(1288490187, -1);
        outOfEqualClassOne(1717986916, -1);
        outOfEqualClassOne(2147483645, -1);
        outOfEqualClassOne(-1, 429496729);
        outOfEqualClassOne(-1, 858993458);
        outOfEqualClassOne(-1, 1288490187);
        outOfEqualClassOne(-1, 1717986916);
        outOfEqualClassOne(-1, 2147483645);
        //endregion

        //region Особые значения класса
        inEqualClassOne(357913941, 429496729);
        inEqualClassOne(715827882, 429496729);
        inEqualClassOne(1073741823, 429496729);
        inEqualClassOne(1431655764, 429496729);
        inEqualClassOne(1789569705, 429496729);
        inEqualClassOne(2147483646, 429496729);
        inEqualClassOne(357913941, 858993458);
        inEqualClassOne(715827882, 858993458);
        inEqualClassOne(1073741823, 858993458);
        inEqualClassOne(1431655764, 858993458);
        inEqualClassOne(1789569705, 858993458);
        inEqualClassOne(2147483646, 858993458);
        inEqualClassOne(357913941, 1288490187);
        inEqualClassOne(715827882, 1288490187);
        inEqualClassOne(1073741823, 1288490187);
        inEqualClassOne(1431655764, 1288490187);
        inEqualClassOne(1789569705, 1288490187);
        inEqualClassOne(2147483646, 1288490187);
        inEqualClassOne(357913941, 1717986916);
        inEqualClassOne(715827882, 1717986916);
        inEqualClassOne(1073741823, 1717986916);
        inEqualClassOne(1431655764, 1717986916);
        inEqualClassOne(1789569705, 1717986916);
        inEqualClassOne(2147483646, 1717986916);
        inEqualClassOne(357913941, 2147483645);
        inEqualClassOne(715827882, 2147483645);
        inEqualClassOne(1073741823, 2147483645);
        inEqualClassOne(1431655764, 2147483645);
        inEqualClassOne(1789569705, 2147483645);
        inEqualClassOne(2147483646, 2147483645);
        //endregion

        //region Случайные значения
        inEqualClassOne(691366051, 1149663426);
        inEqualClassOne(297563939, 981631349);
        inEqualClassOne(638837333, 1117783301);
        inEqualClassOne(1724238774, 1125884084);
        inEqualClassOne(1954875341, 1902886240);
        inEqualClassOne(1092353884, 633918864);
        inEqualClassOne(1069876379, 461347445);
        inEqualClassOne(52117368, 1723199147);
        inEqualClassOne(1868787891, 1017693153);
        inEqualClassOne(1700655226, 1417154861);
        inEqualClassOne(944203664, 2104963448);
        inEqualClassOne(792979472, 1472929127);
        inEqualClassOne(1330128242, 1107628770);
        inEqualClassOne(684633823, 427776753);
        inEqualClassOne(1482894932, 1017839759);
        inEqualClassOne(1751895038, 693660746);
        inEqualClassOne(632880100, 2054288095);
        inEqualClassOne(2036733231, 129928278);
        inEqualClassOne(899232753, 1748239254);
        inEqualClassOne(1440156481, 1866666347);
        //endregion
        //endregion

        //region Класс эквивалентности 2 (x>0 & y<0)
        //region Границы класса эквивалентности
        //особые значения
        inEqualClassTwo(-429496729, 1);
        inEqualClassTwo(-858993458, 1);
        inEqualClassTwo(-1288490187, 1);
        inEqualClassTwo(-1717986916, 1);
        inEqualClassTwo(-2147483645, 1);
        inEqualClassTwo(-1, 429496729);
        inEqualClassTwo(-1, 858993458);
        inEqualClassTwo(-1, 1288490187);
        inEqualClassTwo(-1, 1717986916);
        inEqualClassTwo(-1, 2147483645);
        //Случайные значения
        inEqualClassTwo(-1800804039, 1);
        inEqualClassTwo(-1486731418, 1);
        inEqualClassTwo(-1372198669, 1);
        inEqualClassTwo(-1743160130, 1);
        inEqualClassTwo(-1599958851, 1);
        inEqualClassTwo(-270686326, 1);
        inEqualClassTwo(-37309682, 1);
        inEqualClassTwo(-325499956, 1);
        inEqualClassTwo(-1735769519, 1);
        inEqualClassTwo(-714329041, 1);
        inEqualClassTwo(-1, 2116570849);
        inEqualClassTwo(-1, 1833620997);
        inEqualClassTwo(-1, 1078082813);
        inEqualClassTwo(-1, 61362655);
        inEqualClassTwo(-1, 1244861410);
        inEqualClassTwo(-1, 520479502);
        inEqualClassTwo(-1, 292603485);
        inEqualClassTwo(-1, 560087285);
        inEqualClassTwo(-1, 601118562);
        inEqualClassTwo(-1, 2111303588);
        //endregion

        //region валидный сосед класса эквивалентности
        //особые значения
        inEqualClassTwo(-429496729, 2);
        inEqualClassTwo(-858993458, 2);
        inEqualClassTwo(-1288490187, 2);
        inEqualClassTwo(-1717986916, 2);
        inEqualClassTwo(-2147483645, 2);
        inEqualClassTwo(-2, 429496729);
        inEqualClassTwo(-2, 858993458);
        inEqualClassTwo(-2, 1288490187);
        inEqualClassTwo(-2, 1717986916);
        inEqualClassTwo(-2, 2147483645);
        //Случайные значения
        inEqualClassTwo(-1800804039, 2);
        inEqualClassTwo(-1486731418, 2);
        inEqualClassTwo(-1372198669, 2);
        inEqualClassTwo(-1743160130, 2);
        inEqualClassTwo(-1599958851, 2);
        inEqualClassTwo(-270686326, 2);
        inEqualClassTwo(-37309682, 2);
        inEqualClassTwo(-325499956, 2);
        inEqualClassTwo(-1735769519, 2);
        inEqualClassTwo(-714329041, 2);
        inEqualClassTwo(-2, 2116570849);
        inEqualClassTwo(-2, 1833620997);
        inEqualClassTwo(-2, 1078082813);
        inEqualClassTwo(-2, 61362655);
        inEqualClassTwo(-2, 1244861410);
        inEqualClassTwo(-2, 520479502);
        inEqualClassTwo(-2, 292603485);
        inEqualClassTwo(-2, 560087285);
        inEqualClassTwo(-2, 601118562);
        inEqualClassTwo(-2, 2111303588);
        //endregion

        //region Не валидный сосед класса эквивалентности
        //особые значения
        outOfEqualClassTwo(-429496729, 0);
        outOfEqualClassTwo(-858993458, 0);
        outOfEqualClassTwo(-1288490187, 0);
        outOfEqualClassTwo(-1717986916, 0);
        outOfEqualClassTwo(-2147483645, 0);
        outOfEqualClassTwo(0, 429496729);
        outOfEqualClassTwo(0, 858993458);
        outOfEqualClassTwo(0, 1288490187);
        outOfEqualClassTwo(0, 1717986916);
        outOfEqualClassTwo(0, 2147483645);
        //Случайные значения
        outOfEqualClassTwo(-1800804039, 0);
        outOfEqualClassTwo(-1486731418, 0);
        outOfEqualClassTwo(-1372198669, 0);
        outOfEqualClassTwo(-1743160130, 0);
        outOfEqualClassTwo(-1599958851, 0);
        outOfEqualClassTwo(-270686326, 0);
        outOfEqualClassTwo(-37309682, 0);
        outOfEqualClassTwo(-325499956, 0);
        outOfEqualClassTwo(-1735769519, 0);
        outOfEqualClassTwo(-714329041, 0);
        outOfEqualClassTwo(0, 2116570849);
        outOfEqualClassTwo(0, 1833620997);
        outOfEqualClassTwo(0, 1078082813);
        outOfEqualClassTwo(0, 61362655);
        outOfEqualClassTwo(0, 1244861410);
        outOfEqualClassTwo(0, 520479502);
        outOfEqualClassTwo(0, 292603485);
        outOfEqualClassTwo(0, 560087285);
        outOfEqualClassTwo(0, 601118562);
        outOfEqualClassTwo(0, 2111303588);
        //endregion

        //region Особые значения класса эквивалентности
        inEqualClassTwo(-429496729, 429496729);
        inEqualClassTwo(-429496729, 858993458);
        inEqualClassTwo(-429496729, 1288490187);
        inEqualClassTwo(-429496729, 1717986916);
        inEqualClassTwo(-429496729, 2147483645);
        inEqualClassTwo(-858993458, 429496729);
        inEqualClassTwo(-858993458, 858993458);
        inEqualClassTwo(-858993458, 1288490187);
        inEqualClassTwo(-858993458, 1717986916);
        inEqualClassTwo(-858993458, 2147483645);
        inEqualClassTwo(-1288490187, 429496729);
        inEqualClassTwo(-1288490187, 858993458);
        inEqualClassTwo(-1288490187, 1288490187);
        inEqualClassTwo(-1288490187, 1717986916);
        inEqualClassTwo(-1288490187, 2147483645);
        inEqualClassTwo(-1717986916, 429496729);
        inEqualClassTwo(-1717986916, 858993458);
        inEqualClassTwo(-1717986916, 1288490187);
        inEqualClassTwo(-1717986916, 1717986916);
        inEqualClassTwo(-1717986916, 2147483645);
        inEqualClassTwo(-2147483645, 429496729);
        inEqualClassTwo(-2147483645, 858993458);
        inEqualClassTwo(-2147483645, 1288490187);
        inEqualClassTwo(-2147483645, 1717986916);
        inEqualClassTwo(-2147483645, 2147483645);
        //endregion

        //region Случайные значения класса эквивалентности
        inEqualClassTwo(-30503743, 279898538);
        inEqualClassTwo(-139960427, 178934068);
        inEqualClassTwo(-803832507, 1496760951);
        inEqualClassTwo(-755825822, 792116071);
        inEqualClassTwo(-400450600, 1976456979);
        inEqualClassTwo(-460359264, 1068048030);
        inEqualClassTwo(-710804150, 1458454536);
        inEqualClassTwo(-1624596759, 164650085);
        inEqualClassTwo(-1415406641, 906444276);
        inEqualClassTwo(-1084569850, 1087695363);
        inEqualClassTwo(-1460422544, 77373750);
        inEqualClassTwo(-1715963281, 1437170635);
        inEqualClassTwo(-214322145, 1990949552);
        inEqualClassTwo(-1230427186, 2110585095);
        inEqualClassTwo(-1512742257, 707761143);
        inEqualClassTwo(-752687669, 373209385);
        inEqualClassTwo(-1721969812, 1991716644);
        inEqualClassTwo(-544214708, 195430290);
        inEqualClassTwo(-2009361456, 2098630590);
        inEqualClassTwo(-203853212, 802025363);
        //endregion
        //endregion

        //region Класс эквивалентности 3 (x<=0 & y<=0)
        //region Границы класса эквивалентности
        //Особые значания границ класса эквивалентности
        inEqualClassThree(-429496729, 0);
        inEqualClassThree(-858993458, 0);
        inEqualClassThree(-1288490187, 0);
        inEqualClassThree(-1717986916, 0);
        inEqualClassThree(-2147483645, 0);
        inEqualClassThree(0, -429496729);
        inEqualClassThree(0, -858993458);
        inEqualClassThree(0, -1288490187);
        inEqualClassThree(0, -1717986916);
        inEqualClassThree(0, -2147483645);
        //Случайные значения границ класса эквивалентности
        inEqualClassThree(-301822259, 0);
        inEqualClassThree(-1319283128, 0);
        inEqualClassThree(-1389191944, 0);
        inEqualClassThree(-1160272033, 0);
        inEqualClassThree(-1077965119, 0);
        inEqualClassThree(-982024217, 0);
        inEqualClassThree(-1897718705, 0);
        inEqualClassThree(-2089247404, 0);
        inEqualClassThree(-1682617398, 0);
        inEqualClassThree(-78689284, 0);
        inEqualClassThree(0, -30518371);
        inEqualClassThree(0, -311354930);
        inEqualClassThree(0, -927899400);
        inEqualClassThree(0, -1017944921);
        inEqualClassThree(0, -516233330);
        inEqualClassThree(0, -709455946);
        inEqualClassThree(0, -73862531);
        inEqualClassThree(0, -1741451017);
        inEqualClassThree(0, -952248235);
        inEqualClassThree(0, -1427217580);

        //endregion

        //region Валидные соседи границы класса эквивалентности
        //Особые значания границ класса эквивалентности
        inEqualClassThree(-429496729, -1);
        inEqualClassThree(-858993458, -1);
        inEqualClassThree(-1288490187, -1);
        inEqualClassThree(-1717986916, -1);
        inEqualClassThree(-2147483645, -1);
        inEqualClassThree(-1, -429496729);
        inEqualClassThree(-1, -858993458);
        inEqualClassThree(-1, -1288490187);
        inEqualClassThree(-1, -1717986916);
        inEqualClassThree(-1, -2147483645);
        //Случайные значения границ класса эквивалентности
        inEqualClassThree(-301822259, -1);
        inEqualClassThree(-1319283128, -1);
        inEqualClassThree(-1389191944, -1);
        inEqualClassThree(-1160272033, -1);
        inEqualClassThree(-1077965119, -1);
        inEqualClassThree(-982024217, -1);
        inEqualClassThree(-1897718705, -1);
        inEqualClassThree(-2089247404, -1);
        inEqualClassThree(-1682617398, -1);
        inEqualClassThree(-78689284, -1);
        inEqualClassThree(-1, -30518371);
        inEqualClassThree(-1, -311354930);
        inEqualClassThree(-1, -927899400);
        inEqualClassThree(-1, -1017944921);
        inEqualClassThree(-1, -516233330);
        inEqualClassThree(-1, -709455946);
        inEqualClassThree(-1, -73862531);
        inEqualClassThree(-1, -1741451017);
        inEqualClassThree(-1, -952248235);
        inEqualClassThree(-1, -1427217580);

        //endregion

        //region Не валидные соседи границы класса эквивалентности
        //Особые значания границ класса эквивалентности
        outOfEqualClassThree(-429496729, 1);
        outOfEqualClassThree(-858993458, 1);
        outOfEqualClassThree(-1288490187, 1);
        outOfEqualClassThree(-1717986916, 1);
        outOfEqualClassThree(-2147483645, 1);
        outOfEqualClassThree(1, -429496729);
        outOfEqualClassThree(1, -858993458);
        outOfEqualClassThree(1, -1288490187);
        outOfEqualClassThree(1, -1717986916);
        outOfEqualClassThree(1, -2147483645);
        //Случайные значения границ класса эквивалентности
        outOfEqualClassThree(301822259, 1);
        outOfEqualClassThree(1319283128, 1);
        outOfEqualClassThree(1389191944, 1);
        outOfEqualClassThree(1160272033, 1);
        outOfEqualClassThree(1077965119, 1);
        outOfEqualClassThree(982024217, 1);
        outOfEqualClassThree(1897718705, 1);
        outOfEqualClassThree(2089247404, 1);
        outOfEqualClassThree(1682617398, 1);
        outOfEqualClassThree(78689284, 1);
        outOfEqualClassThree(1, -30518371);
        outOfEqualClassThree(1, -311354930);
        outOfEqualClassThree(1, -927899400);
        outOfEqualClassThree(1, -1017944921);
        outOfEqualClassThree(1, -516233330);
        outOfEqualClassThree(1, -709455946);
        outOfEqualClassThree(1, -73862531);
        outOfEqualClassThree(1, -1741451017);
        outOfEqualClassThree(1, -952248235);
        outOfEqualClassThree(1, -1427217580);
        //endregion

        //region Случайные значения класса эквивалентности
        inEqualClassThree(-1081564317, -1189997006);
        inEqualClassThree(-1942820208, -151508326);
        inEqualClassThree(-1133758481, -440967672);
        inEqualClassThree(-1589235963, -1618320999);
        inEqualClassThree(-387265016, -1750749177);
        inEqualClassThree(-546369303, -566176167);
        inEqualClassThree(-122719907, -1337874095);
        inEqualClassThree(-957603859, -758285838);
        inEqualClassThree(-493177468, -394841137);
        inEqualClassThree(-390006226, -1820183563);
        inEqualClassThree(-1173864367, -845117616);
        inEqualClassThree(-1888308878, -426762817);
        inEqualClassThree(-1978414274, -1964679211);
        inEqualClassThree(-146593456, -871729597);
        inEqualClassThree(-162226966, -790532422);
        inEqualClassThree(-1177391984, -1737732459);
        inEqualClassThree(-1134134269, -129957597);
        inEqualClassThree(-2031289526, -130028347);
        inEqualClassThree(-1518921831, -1025318668);
        inEqualClassThree(-1775366095, -1972967451);
        //endregion

        //region Особые значения класса эквивалентности
        inEqualClassThree(-429496729, -429496729);
        inEqualClassThree(-429496729, -858993458);
        inEqualClassThree(-429496729, -1288490187);
        inEqualClassThree(-429496729, -1717986916);
        inEqualClassThree(-429496729, -2147483645);
        inEqualClassThree(-858993458, -429496729);
        inEqualClassThree(-858993458, -858993458);
        inEqualClassThree(-858993458, -1288490187);
        inEqualClassThree(-858993458, -1717986916);
        inEqualClassThree(-858993458, -2147483645);
        inEqualClassThree(-1288490187, -429496729);
        inEqualClassThree(-1288490187, -858993458);
        inEqualClassThree(-1288490187, -1288490187);
        inEqualClassThree(-1288490187, -1717986916);
        inEqualClassThree(-1288490187, -2147483645);
        inEqualClassThree(-1717986916, -429496729);
        inEqualClassThree(-1717986916, -858993458);
        inEqualClassThree(-1717986916, -1288490187);
        inEqualClassThree(-1717986916, -1717986916);
        inEqualClassThree(-1717986916, -2147483645);
        inEqualClassThree(-2147483645, -429496729);
        inEqualClassThree(-2147483645, -858993458);
        inEqualClassThree(-2147483645, -1288490187);
        inEqualClassThree(-2147483645, -1717986916);
        inEqualClassThree(-2147483645, -2147483645);
        //endregion
        //endregion

        //region Класс эквивалентности 4 (x<0 & y>0)
        //region Границы класса эквивалентности
        //Особые значания границ класса эквивалентности
        inEqualClassFour(-429496729, 1);
        inEqualClassFour(-858993458, 1);
        inEqualClassFour(-1288490187, 1);
        inEqualClassFour(-1717986916, 1);
        inEqualClassFour(-2147483645, 1);
        inEqualClassFour(-1, 429496729);
        inEqualClassFour(-1, 858993458);
        inEqualClassFour(-1, 1288490187);
        inEqualClassFour(-1, 1717986916);
        inEqualClassFour(-1, 2147483645);
        //Случайные значения границ класса эквивалентности
        inEqualClassFour(-1820375479, 1);
        inEqualClassFour(-1514398548, 1);
        inEqualClassFour(-246488542, 1);
        inEqualClassFour(-629737001, 1);
        inEqualClassFour(-2122774898, 1);
        inEqualClassFour(-1090440122, 1);
        inEqualClassFour(-148568417, 1);
        inEqualClassFour(-1873871798, 1);
        inEqualClassFour(-784147211, 1);
        inEqualClassFour(-1524584109, 1);
        inEqualClassFour(-1, 26407717);
        inEqualClassFour(-1, 474953484);
        inEqualClassFour(-1, 377294184);
        inEqualClassFour(-1, 748267297);
        inEqualClassFour(-1, 964255137);
        inEqualClassFour(-1, 507014776);
        inEqualClassFour(-1, 1206037948);
        inEqualClassFour(-1, 812754837);
        inEqualClassFour(-1, 733794447);
        inEqualClassFour(-1, 537522765);
        //endregion

        //region Валидные соседи границы класса эквивалентности
        //Особые значания границ класса эквивалентности
        inEqualClassFour(-429496729, 2);
        inEqualClassFour(-858993458, 2);
        inEqualClassFour(-1288490187, 2);
        inEqualClassFour(-1717986916, 2);
        inEqualClassFour(-2147483645, 2);
        inEqualClassFour(-1, 429496729);
        inEqualClassFour(-1, 858993458);
        inEqualClassFour(-1, 1288490187);
        inEqualClassFour(-1, 1717986916);
        inEqualClassFour(-1, 2147483645);
        //Случайные значения границ класса эквивалентности
        inEqualClassFour(-1820375479, 2);
        inEqualClassFour(-1514398548, 2);
        inEqualClassFour(-246488542, 2);
        inEqualClassFour(-629737001, 2);
        inEqualClassFour(-2122774898, 2);
        inEqualClassFour(-1090440122, 2);
        inEqualClassFour(-148568417, 2);
        inEqualClassFour(-1873871798, 2);
        inEqualClassFour(-784147211, 2);
        inEqualClassFour(-1524584109, 2);
        inEqualClassFour(-1, 26407717);
        inEqualClassFour(-1, 474953484);
        inEqualClassFour(-1, 377294184);
        inEqualClassFour(-1, 748267297);
        inEqualClassFour(-1, 964255137);
        inEqualClassFour(-1, 507014776);
        inEqualClassFour(-1, 1206037948);
        inEqualClassFour(-1, 812754837);
        inEqualClassFour(-1, 733794447);
        inEqualClassFour(-1, 537522765);

        //endregion

        //region Не валидные соседи границы класса эквивалентности
        //Особые значания границ класса эквивалентности
        //Особые значания границ класса эквивалентности
        outOfEqualClassFour(-429496729, 0);
        outOfEqualClassFour(-858993458, 0);
        outOfEqualClassFour(-1288490187, 0);
        outOfEqualClassFour(-1717986916, 0);
        outOfEqualClassFour(-2147483645, 0);
        outOfEqualClassFour(0, 429496729);
        outOfEqualClassFour(0, 858993458);
        outOfEqualClassFour(0, 1288490187);
        outOfEqualClassFour(0, 1717986916);
        outOfEqualClassFour(0, 2147483645);
        //Случайные значения границ класса эквивалентности
        outOfEqualClassFour(-1820375479, 0);
        outOfEqualClassFour(-1514398548, 0);
        outOfEqualClassFour(-246488542, 0);
        outOfEqualClassFour(-629737001, 0);
        outOfEqualClassFour(-2122774898, 0);
        outOfEqualClassFour(-1090440122, 0);
        outOfEqualClassFour(-148568417, 0);
        outOfEqualClassFour(-1873871798, 0);
        outOfEqualClassFour(-784147211, 0);
        outOfEqualClassFour(-1524584109, 0);
        outOfEqualClassFour(0, 26407717);
        outOfEqualClassFour(0, 474953484);
        outOfEqualClassFour(0, 377294184);
        outOfEqualClassFour(0, 748267297);
        outOfEqualClassFour(0, 964255137);
        outOfEqualClassFour(0, 507014776);
        outOfEqualClassFour(0, 1206037948);
        outOfEqualClassFour(0, 812754837);
        outOfEqualClassFour(0, 733794447);
        outOfEqualClassFour(0, 537522765);
        //endregion

        //region Случайные значения класса эквивалентности
        inEqualClassFour(-400828079, 1101557577);
        inEqualClassFour(-120117720, 599492821);
        inEqualClassFour(-1293533900, 2019330170);
        inEqualClassFour(-1030758277, 863372953);
        inEqualClassFour(-1397461090, 1028855221);
        inEqualClassFour(-2123402975, 197660244);
        inEqualClassFour(-1750317583, 468163133);
        inEqualClassFour(-928454531, 1924330613);
        inEqualClassFour(-764317012, 1978756663);
        inEqualClassFour(-1651701234, 1942645227);
        inEqualClassFour(-1874808902, 1224614013);
        inEqualClassFour(-1294577119, 1842127029);
        inEqualClassFour(-1138860251, 98540856);
        inEqualClassFour(-641207406, 1325578196);
        inEqualClassFour(-653285838, 910106440);
        inEqualClassFour(-1014575718, 640315352);
        inEqualClassFour(-650838627, 285599819);
        inEqualClassFour(-218932815, 1154098957);
        inEqualClassFour(-1451410268, 126664765);
        inEqualClassFour(-517238516, 183508411);
        //endregion

        //region Особые значения класса эквивалентности
        inEqualClassFour(-429496729, 429496729);
        inEqualClassFour(-429496729, 858993458);
        inEqualClassFour(-429496729, 1288490187);
        inEqualClassFour(-429496729, 1717986916);
        inEqualClassFour(-429496729, 2147483645);
        inEqualClassFour(-858993458, 429496729);
        inEqualClassFour(-858993458, 858993458);
        inEqualClassFour(-858993458, 1288490187);
        inEqualClassFour(-858993458, 1717986916);
        inEqualClassFour(-858993458, 2147483645);
        inEqualClassFour(-1288490187, 429496729);
        inEqualClassFour(-1288490187, 858993458);
        inEqualClassFour(-1288490187, 1288490187);
        inEqualClassFour(-1288490187, 1717986916);
        inEqualClassFour(-1288490187, 2147483645);
        inEqualClassFour(-1717986916, 429496729);
        inEqualClassFour(-1717986916, 858993458);
        inEqualClassFour(-1717986916, 1288490187);
        inEqualClassFour(-1717986916, 1717986916);
        inEqualClassFour(-1717986916, 2147483645);
        inEqualClassFour(-2147483645, 429496729);
        inEqualClassFour(-2147483645, 858993458);
        inEqualClassFour(-2147483645, 1288490187);
        inEqualClassFour(-2147483645, 1717986916);
        inEqualClassFour(-2147483645, 2147483645);
        //endregion
        //endregion

        //region Класс эквивалентности 5 (|x|==|y|)
        //region Особые значения класса эквивалентности
        inEqualClassFive(0, 0);
        inEqualClassFive(429496729, 429496729);
        inEqualClassFive(-429496729, 429496729);
        inEqualClassFive(429496729, -429496729);
        inEqualClassFive(-429496729, -429496729);
        inEqualClassFive(858993458, 858993458);
        inEqualClassFive(-858993458, 858993458);
        inEqualClassFive(858993458, -858993458);
        inEqualClassFive(-858993458, -858993458);
        inEqualClassFive(1288490187, 1288490187);
        inEqualClassFive(-1288490187, 1288490187);
        inEqualClassFive(1288490187, -1288490187);
        inEqualClassFive(-1288490187, -1288490187);
        inEqualClassFive(1717986916, 1717986916);
        inEqualClassFive(-1717986916, 1717986916);
        inEqualClassFive(1717986916, -1717986916);
        inEqualClassFive(-1717986916, -1717986916);
        inEqualClassFive(2147483645, 2147483645);
        inEqualClassFive(-2147483645, 2147483645);
        inEqualClassFive(2147483645, -2147483645);
        inEqualClassFive(-2147483645, -2147483645);
        inEqualClassFive(-429496729, -429496729);
        inEqualClassFive(429496729, -429496729);
        inEqualClassFive(-429496729, 429496729);
        inEqualClassFive(429496729, 429496729);
        inEqualClassFive(-858993458, -858993458);
        inEqualClassFive(858993458, -858993458);
        inEqualClassFive(-858993458, 858993458);
        inEqualClassFive(858993458, 858993458);
        inEqualClassFive(-1288490187, -1288490187);
        inEqualClassFive(1288490187, -1288490187);
        inEqualClassFive(-1288490187, 1288490187);
        inEqualClassFive(1288490187, 1288490187);
        inEqualClassFive(-1717986916, -1717986916);
        inEqualClassFive(1717986916, -1717986916);
        inEqualClassFive(-1717986916, 1717986916);
        inEqualClassFive(1717986916, 1717986916);
        inEqualClassFive(-2147483645, -2147483645);
        inEqualClassFive(2147483645, -2147483645);
        inEqualClassFive(-2147483645, 2147483645);
        inEqualClassFive(2147483645, 2147483645);
        //endregion

        //region Случайные значения класса эквивалентности
        inEqualClassFive(181314052, 181314052);
        inEqualClassFive(-181314052, 181314052);
        inEqualClassFive(181314052, -181314052);
        inEqualClassFive(-181314052, -181314052);
        inEqualClassFive(1556552363, 1556552363);
        inEqualClassFive(-1556552363, 1556552363);
        inEqualClassFive(1556552363, -1556552363);
        inEqualClassFive(-1556552363, -1556552363);
        inEqualClassFive(1724713355, 1724713355);
        inEqualClassFive(-1724713355, 1724713355);
        inEqualClassFive(1724713355, -1724713355);
        inEqualClassFive(-1724713355, -1724713355);
        inEqualClassFive(708539683, 708539683);
        inEqualClassFive(-708539683, 708539683);
        inEqualClassFive(708539683, -708539683);
        inEqualClassFive(-708539683, -708539683);
        inEqualClassFive(604284892, 604284892);
        inEqualClassFive(-604284892, 604284892);
        inEqualClassFive(604284892, -604284892);
        inEqualClassFive(-604284892, -604284892);
        inEqualClassFive(-930426268, -930426268);
        inEqualClassFive(930426268, -930426268);
        inEqualClassFive(-930426268, 930426268);
        inEqualClassFive(930426268, 930426268);
        inEqualClassFive(-1378537315, -1378537315);
        inEqualClassFive(1378537315, -1378537315);
        inEqualClassFive(-1378537315, 1378537315);
        inEqualClassFive(1378537315, 1378537315);
        inEqualClassFive(-2145828448, -2145828448);
        inEqualClassFive(2145828448, -2145828448);
        inEqualClassFive(-2145828448, 2145828448);
        inEqualClassFive(2145828448, 2145828448);
        inEqualClassFive(-1885673594, -1885673594);
        inEqualClassFive(1885673594, -1885673594);
        inEqualClassFive(-1885673594, 1885673594);
        inEqualClassFive(1885673594, 1885673594);
        inEqualClassFive(-1401846850, -1401846850);
        inEqualClassFive(1401846850, -1401846850);
        inEqualClassFive(-1401846850, 1401846850);
        inEqualClassFive(1401846850, 1401846850);
        //endregion

        //region Особые значения класса эквивалентности | не валидные соседи
        outOfEqualClassFive(1, 0);
        outOfEqualClassFive(429496729 + 1, 429496729);
        outOfEqualClassFive(-429496729 + 1, 429496729);
        outOfEqualClassFive(429496729 + 1, -429496729);
        outOfEqualClassFive(-429496729 + 1, -429496729);
        outOfEqualClassFive(858993458 + 1, 858993458);
        outOfEqualClassFive(-858993458 + 1, 858993458);
        outOfEqualClassFive(858993458 + 1, -858993458);
        outOfEqualClassFive(-858993458 + 1, -858993458);
        outOfEqualClassFive(1288490187 + 1, 1288490187);
        outOfEqualClassFive(-1288490187 + 1, 1288490187);
        outOfEqualClassFive(1288490187 + 1, -1288490187);
        outOfEqualClassFive(-1288490187 + 1, -1288490187);
        outOfEqualClassFive(1717986916 + 1, 1717986916);
        outOfEqualClassFive(-1717986916 + 1, 1717986916);
        outOfEqualClassFive(1717986916 + 1, -1717986916);
        outOfEqualClassFive(-1717986916 + 1, -1717986916);
        outOfEqualClassFive(2147483645 + 1, 2147483645);
        outOfEqualClassFive(-2147483645 + 1, 2147483645);
        outOfEqualClassFive(2147483645 + 1, -2147483645);
        outOfEqualClassFive(-2147483645 + 1, -2147483645);
        outOfEqualClassFive(-429496729 + 1, -429496729);
        outOfEqualClassFive(429496729 + 1, -429496729);
        outOfEqualClassFive(-429496729 + 1, 429496729);
        outOfEqualClassFive(429496729 + 1, 429496729);
        outOfEqualClassFive(-858993458 + 1, -858993458);
        outOfEqualClassFive(858993458 + 1, -858993458);
        outOfEqualClassFive(-858993458 + 1, 858993458);
        outOfEqualClassFive(858993458 + 1, 858993458);
        outOfEqualClassFive(-1288490187 + 1, -1288490187);
        outOfEqualClassFive(1288490187 + 1, -1288490187);
        outOfEqualClassFive(-1288490187 + 1, 1288490187);
        outOfEqualClassFive(1288490187 + 1, 1288490187);
        outOfEqualClassFive(-1717986916 + 1, -1717986916);
        outOfEqualClassFive(1717986916 + 1, -1717986916);
        outOfEqualClassFive(-1717986916 + 1, 1717986916);
        outOfEqualClassFive(1717986916 + 1, 1717986916);
        outOfEqualClassFive(-2147483645 + 1, -2147483645);
        outOfEqualClassFive(2147483645 + 1, -2147483645);
        outOfEqualClassFive(-2147483645 + 1, 2147483645);
        outOfEqualClassFive(2147483645 + 1, 2147483645);


        outOfEqualClassFive(429496729 - 1, 429496729);
        outOfEqualClassFive(-429496729 - 1, 429496729);
        outOfEqualClassFive(429496729 - 1, -429496729);
        outOfEqualClassFive(-429496729 - 1, -429496729);
        outOfEqualClassFive(858993458 - 1, 858993458);
        outOfEqualClassFive(-858993458 - 1, 858993458);
        outOfEqualClassFive(858993458 - 1, -858993458);
        outOfEqualClassFive(-858993458 - 1, -858993458);
        outOfEqualClassFive(1288490187 - 1, 1288490187);
        outOfEqualClassFive(-1288490187 - 1, 1288490187);
        outOfEqualClassFive(1288490187 - 1, -1288490187);
        outOfEqualClassFive(-1288490187 - 1, -1288490187);
        outOfEqualClassFive(1717986916 - 1, 1717986916);
        outOfEqualClassFive(-1717986916 - 1, 1717986916);
        outOfEqualClassFive(1717986916 - 1, -1717986916);
        outOfEqualClassFive(-1717986916 - 1, -1717986916);
        outOfEqualClassFive(2147483645 - 1, 2147483645);
        outOfEqualClassFive(-2147483645 - 1, 2147483645);
        outOfEqualClassFive(2147483645 - 1, -2147483645);
        outOfEqualClassFive(-2147483645 - 1, -2147483645);
        outOfEqualClassFive(-429496729 - 1, -429496729);
        outOfEqualClassFive(429496729 - 1, -429496729);
        outOfEqualClassFive(-429496729 - 1, 429496729);
        outOfEqualClassFive(429496729 - 1, 429496729);
        outOfEqualClassFive(-858993458 - 1, -858993458);
        outOfEqualClassFive(858993458 - 1, -858993458);
        outOfEqualClassFive(-858993458 - 1, 858993458);
        outOfEqualClassFive(858993458 - 1, 858993458);
        outOfEqualClassFive(-1288490187 - 1, -1288490187);
        outOfEqualClassFive(1288490187 - 1, -1288490187);
        outOfEqualClassFive(-1288490187 - 1, 1288490187);
        outOfEqualClassFive(1288490187 - 1, 1288490187);
        outOfEqualClassFive(-1717986916 - 1, -1717986916);
        outOfEqualClassFive(1717986916 - 1, -1717986916);
        outOfEqualClassFive(-1717986916 - 1, 1717986916);
        outOfEqualClassFive(1717986916 - 1, 1717986916);
        outOfEqualClassFive(-2147483645 - 1, -2147483645);
        outOfEqualClassFive(2147483645 - 1, -2147483645);
        outOfEqualClassFive(-2147483645 - 1, 2147483645);
        outOfEqualClassFive(2147483645 - 1, 2147483645);


        outOfEqualClassFive(429496729, 429496729 - 1);
        outOfEqualClassFive(-429496729, 429496729 - 1);
        outOfEqualClassFive(429496729, -429496729 - 1);
        outOfEqualClassFive(-429496729, -429496729 - 1);
        outOfEqualClassFive(858993458, 858993458 - 1);
        outOfEqualClassFive(-858993458, 858993458 - 1);
        outOfEqualClassFive(858993458, -858993458 - 1);
        outOfEqualClassFive(-858993458, -858993458 - 1);
        outOfEqualClassFive(1288490187, 1288490187 - 1);
        outOfEqualClassFive(-1288490187, 1288490187 - 1);
        outOfEqualClassFive(1288490187, -1288490187 - 1);
        outOfEqualClassFive(-1288490187, -1288490187 - 1);
        outOfEqualClassFive(1717986916, 1717986916 - 1);
        outOfEqualClassFive(-1717986916, 1717986916 - 1);
        outOfEqualClassFive(1717986916, -1717986916 - 1);
        outOfEqualClassFive(-1717986916, -1717986916 - 1);
        outOfEqualClassFive(2147483645, 2147483645 - 1);
        outOfEqualClassFive(-2147483645, 2147483645 - 1);
        outOfEqualClassFive(2147483645, -2147483645 - 1);
        outOfEqualClassFive(-2147483645, -2147483645 - 1);
        outOfEqualClassFive(-429496729, -429496729 - 1);
        outOfEqualClassFive(429496729, -429496729 - 1);
        outOfEqualClassFive(-429496729, 429496729 - 1);
        outOfEqualClassFive(429496729, 429496729 - 1);
        outOfEqualClassFive(-858993458, -858993458 - 1);
        outOfEqualClassFive(858993458, -858993458 - 1);
        outOfEqualClassFive(-858993458, 858993458 - 1);
        outOfEqualClassFive(858993458, 858993458 - 1);
        outOfEqualClassFive(-1288490187, -1288490187 - 1);
        outOfEqualClassFive(1288490187, -1288490187 - 1);
        outOfEqualClassFive(-1288490187, 1288490187 - 1);
        outOfEqualClassFive(1288490187, 1288490187 - 1);
        outOfEqualClassFive(-1717986916, -1717986916 - 1);
        outOfEqualClassFive(1717986916, -1717986916 - 1);
        outOfEqualClassFive(-1717986916, 1717986916 - 1);
        outOfEqualClassFive(1717986916, 1717986916 - 1);
        outOfEqualClassFive(-2147483645, -2147483645 - 1);
        outOfEqualClassFive(2147483645, -2147483645 - 1);
        outOfEqualClassFive(-2147483645, 2147483645 - 1);
        outOfEqualClassFive(2147483645, 2147483645 - 1);


        outOfEqualClassFive(429496729, 429496729 + 1);
        outOfEqualClassFive(-429496729, 429496729 + 1);
        outOfEqualClassFive(429496729, -429496729 + 1);
        outOfEqualClassFive(-429496729, -429496729 + 1);
        outOfEqualClassFive(858993458, 858993458 + 1);
        outOfEqualClassFive(-858993458, 858993458 + 1);
        outOfEqualClassFive(858993458, -858993458 + 1);
        outOfEqualClassFive(-858993458, -858993458 + 1);
        outOfEqualClassFive(1288490187, 1288490187 + 1);
        outOfEqualClassFive(-1288490187, 1288490187 + 1);
        outOfEqualClassFive(1288490187, -1288490187 + 1);
        outOfEqualClassFive(-1288490187, -1288490187 + 1);
        outOfEqualClassFive(1717986916, 1717986916 + 1);
        outOfEqualClassFive(-1717986916, 1717986916 + 1);
        outOfEqualClassFive(1717986916, -1717986916 + 1);
        outOfEqualClassFive(-1717986916, -1717986916 + 1);
        outOfEqualClassFive(2147483645, 2147483645 + 1);
        outOfEqualClassFive(-2147483645, 2147483645 + 1);
        outOfEqualClassFive(2147483645, -2147483645 + 1);
        outOfEqualClassFive(-2147483645, -2147483645 + 1);
        outOfEqualClassFive(-429496729, -429496729 + 1);
        outOfEqualClassFive(429496729, -429496729 + 1);
        outOfEqualClassFive(-429496729, 429496729 + 1);
        outOfEqualClassFive(429496729, 429496729 + 1);
        outOfEqualClassFive(-858993458, -858993458 + 1);
        outOfEqualClassFive(858993458, -858993458 + 1);
        outOfEqualClassFive(-858993458, 858993458 + 1);
        outOfEqualClassFive(858993458, 858993458 + 1);
        outOfEqualClassFive(-1288490187, -1288490187 + 1);
        outOfEqualClassFive(1288490187, -1288490187 + 1);
        outOfEqualClassFive(-1288490187, 1288490187 + 1);
        outOfEqualClassFive(1288490187, 1288490187 + 1);
        outOfEqualClassFive(-1717986916, -1717986916 + 1);
        outOfEqualClassFive(1717986916, -1717986916 + 1);
        outOfEqualClassFive(-1717986916, 1717986916 + 1);
        outOfEqualClassFive(1717986916, 1717986916 + 1);
        outOfEqualClassFive(-2147483645, -2147483645 + 1);
        outOfEqualClassFive(2147483645, -2147483645 + 1);
        outOfEqualClassFive(-2147483645, 2147483645 + 1);
        outOfEqualClassFive(2147483645, 2147483645 + 1);
        //endregion

        //region Случайные значения класса эквивалентности | Не валидные соседи
        outOfEqualClassFive(181314052 + 1, 181314052);
        outOfEqualClassFive(-181314052 + 1, 181314052);
        outOfEqualClassFive(181314052 + 1, -181314052);
        outOfEqualClassFive(-181314052 + 1, -181314052);
        outOfEqualClassFive(1556552363 + 1, 1556552363);
        outOfEqualClassFive(-1556552363 + 1, 1556552363);
        outOfEqualClassFive(1556552363 + 1, -1556552363);
        outOfEqualClassFive(-1556552363 + 1, -1556552363);
        outOfEqualClassFive(1724713355 + 1, 1724713355);
        outOfEqualClassFive(-1724713355 + 1, 1724713355);
        outOfEqualClassFive(1724713355 + 1, -1724713355);
        outOfEqualClassFive(-1724713355 + 1, -1724713355);
        outOfEqualClassFive(708539683 + 1, 708539683);
        outOfEqualClassFive(-708539683 + 1, 708539683);
        outOfEqualClassFive(708539683 + 1, -708539683);
        outOfEqualClassFive(-708539683 + 1, -708539683);
        outOfEqualClassFive(604284892 + 1, 604284892);
        outOfEqualClassFive(-604284892 + 1, 604284892);
        outOfEqualClassFive(604284892 + 1, -604284892);
        outOfEqualClassFive(-604284892 + 1, -604284892);
        outOfEqualClassFive(-930426268 + 1, -930426268);
        outOfEqualClassFive(930426268 + 1, -930426268);
        outOfEqualClassFive(-930426268 + 1, 930426268);
        outOfEqualClassFive(930426268 + 1, 930426268);
        outOfEqualClassFive(-1378537315 + 1, -1378537315);
        outOfEqualClassFive(1378537315 + 1, -1378537315);
        outOfEqualClassFive(-1378537315 + 1, 1378537315);
        outOfEqualClassFive(1378537315 + 1, 1378537315);
        outOfEqualClassFive(-2145828448 + 1, -2145828448);
        outOfEqualClassFive(2145828448 + 1, -2145828448);
        outOfEqualClassFive(-2145828448 + 1, 2145828448);
        outOfEqualClassFive(2145828448 + 1, 2145828448);
        outOfEqualClassFive(-1885673594 + 1, -1885673594);
        outOfEqualClassFive(1885673594 + 1, -1885673594);
        outOfEqualClassFive(-1885673594 + 1, 1885673594);
        outOfEqualClassFive(1885673594 + 1, 1885673594);
        outOfEqualClassFive(-1401846850 + 1, -1401846850);
        outOfEqualClassFive(1401846850 + 1, -1401846850);
        outOfEqualClassFive(-1401846850 + 1, 1401846850);
        outOfEqualClassFive(1401846850 + 1, 1401846850);

        outOfEqualClassFive(181314052 - 1, 181314052);
        outOfEqualClassFive(-181314052 - 1, 181314052);
        outOfEqualClassFive(181314052 - 1, -181314052);
        outOfEqualClassFive(-181314052 - 1, -181314052);
        outOfEqualClassFive(1556552363 - 1, 1556552363);
        outOfEqualClassFive(-1556552363 - 1, 1556552363);
        outOfEqualClassFive(1556552363 - 1, -1556552363);
        outOfEqualClassFive(-1556552363 - 1, -1556552363);
        outOfEqualClassFive(1724713355 - 1, 1724713355);
        outOfEqualClassFive(-1724713355 - 1, 1724713355);
        outOfEqualClassFive(1724713355 - 1, -1724713355);
        outOfEqualClassFive(-1724713355 - 1, -1724713355);
        outOfEqualClassFive(708539683 - 1, 708539683);
        outOfEqualClassFive(-708539683 - 1, 708539683);
        outOfEqualClassFive(708539683 - 1, -708539683);
        outOfEqualClassFive(-708539683 - 1, -708539683);
        outOfEqualClassFive(604284892 - 1, 604284892);
        outOfEqualClassFive(-604284892 - 1, 604284892);
        outOfEqualClassFive(604284892 - 1, -604284892);
        outOfEqualClassFive(-604284892 - 1, -604284892);
        outOfEqualClassFive(-930426268 - 1, -930426268);
        outOfEqualClassFive(930426268 - 1, -930426268);
        outOfEqualClassFive(-930426268 - 1, 930426268);
        outOfEqualClassFive(930426268 - 1, 930426268);
        outOfEqualClassFive(-1378537315 - 1, -1378537315);
        outOfEqualClassFive(1378537315 - 1, -1378537315);
        outOfEqualClassFive(-1378537315 - 1, 1378537315);
        outOfEqualClassFive(1378537315 - 1, 1378537315);
        outOfEqualClassFive(-2145828448 - 1, -2145828448);
        outOfEqualClassFive(2145828448 - 1, -2145828448);
        outOfEqualClassFive(-2145828448 - 1, 2145828448);
        outOfEqualClassFive(2145828448 - 1, 2145828448);
        outOfEqualClassFive(-1885673594 - 1, -1885673594);
        outOfEqualClassFive(1885673594 - 1, -1885673594);
        outOfEqualClassFive(-1885673594 - 1, 1885673594);
        outOfEqualClassFive(1885673594 - 1, 1885673594);
        outOfEqualClassFive(-1401846850 - 1, -1401846850);
        outOfEqualClassFive(1401846850 - 1, -1401846850);
        outOfEqualClassFive(-1401846850 - 1, 1401846850);
        outOfEqualClassFive(1401846850 - 1, 1401846850);

        outOfEqualClassFive(181314052, 181314052 + 1);
        outOfEqualClassFive(-181314052, 181314052 + 1);
        outOfEqualClassFive(181314052, -181314052 + 1);
        outOfEqualClassFive(-181314052, -181314052 + 1);
        outOfEqualClassFive(1556552363, 1556552363 + 1);
        outOfEqualClassFive(-1556552363, 1556552363 + 1);
        outOfEqualClassFive(1556552363, -1556552363 + 1);
        outOfEqualClassFive(-1556552363, -1556552363 + 1);
        outOfEqualClassFive(1724713355, 1724713355 + 1);
        outOfEqualClassFive(-1724713355, 1724713355 + 1);
        outOfEqualClassFive(1724713355, -1724713355 + 1);
        outOfEqualClassFive(-1724713355, -1724713355 + 1);
        outOfEqualClassFive(708539683, 708539683 + 1);
        outOfEqualClassFive(-708539683, 708539683 + 1);
        outOfEqualClassFive(708539683, -708539683 + 1);
        outOfEqualClassFive(-708539683, -708539683 + 1);
        outOfEqualClassFive(604284892, 604284892 + 1);
        outOfEqualClassFive(-604284892, 604284892 + 1);
        outOfEqualClassFive(604284892, -604284892 + 1);
        outOfEqualClassFive(-604284892, -604284892 + 1);
        outOfEqualClassFive(-930426268, -930426268 + 1);
        outOfEqualClassFive(930426268, -930426268 + 1);
        outOfEqualClassFive(-930426268, 930426268 + 1);
        outOfEqualClassFive(930426268, 930426268 + 1);
        outOfEqualClassFive(-1378537315, -1378537315 + 1);
        outOfEqualClassFive(1378537315, -1378537315 + 1);
        outOfEqualClassFive(-1378537315, 1378537315 + 1);
        outOfEqualClassFive(1378537315, 1378537315 + 1);
        outOfEqualClassFive(-2145828448, -2145828448 + 1);
        outOfEqualClassFive(2145828448, -2145828448 + 1);
        outOfEqualClassFive(-2145828448, 2145828448 + 1);
        outOfEqualClassFive(2145828448, 2145828448 + 1);
        outOfEqualClassFive(-1885673594, -1885673594 + 1);
        outOfEqualClassFive(1885673594, -1885673594 + 1);
        outOfEqualClassFive(-1885673594, 1885673594 + 1);
        outOfEqualClassFive(1885673594, 1885673594 + 1);
        outOfEqualClassFive(-1401846850, -1401846850 + 1);
        outOfEqualClassFive(1401846850, -1401846850 + 1);
        outOfEqualClassFive(-1401846850, 1401846850 + 1);
        outOfEqualClassFive(1401846850, 1401846850 + 1);

        outOfEqualClassFive(181314052, 181314052 - 1);
        outOfEqualClassFive(-181314052, 181314052 - 1);
        outOfEqualClassFive(181314052, -181314052 - 1);
        outOfEqualClassFive(-181314052, -181314052 - 1);
        outOfEqualClassFive(1556552363, 1556552363 - 1);
        outOfEqualClassFive(-1556552363, 1556552363 - 1);
        outOfEqualClassFive(1556552363, -1556552363 - 1);
        outOfEqualClassFive(-1556552363, -1556552363 - 1);
        outOfEqualClassFive(1724713355, 1724713355 - 1);
        outOfEqualClassFive(-1724713355, 1724713355 - 1);
        outOfEqualClassFive(1724713355, -1724713355 - 1);
        outOfEqualClassFive(-1724713355, -1724713355 - 1);
        outOfEqualClassFive(708539683, 708539683 - 1);
        outOfEqualClassFive(-708539683, 708539683 - 1);
        outOfEqualClassFive(708539683, -708539683 - 1);
        outOfEqualClassFive(-708539683, -708539683 - 1);
        outOfEqualClassFive(604284892, 604284892 - 1);
        outOfEqualClassFive(-604284892, 604284892 - 1);
        outOfEqualClassFive(604284892, -604284892 - 1);
        outOfEqualClassFive(-604284892, -604284892 - 1);
        outOfEqualClassFive(-930426268, -930426268 - 1);
        outOfEqualClassFive(930426268, -930426268 - 1);
        outOfEqualClassFive(-930426268, 930426268 - 1);
        outOfEqualClassFive(930426268, 930426268 - 1);
        outOfEqualClassFive(-1378537315, -1378537315 - 1);
        outOfEqualClassFive(1378537315, -1378537315 - 1);
        outOfEqualClassFive(-1378537315, 1378537315 - 1);
        outOfEqualClassFive(1378537315, 1378537315 - 1);
        outOfEqualClassFive(-2145828448, -2145828448 - 1);
        outOfEqualClassFive(2145828448, -2145828448 - 1);
        outOfEqualClassFive(-2145828448, 2145828448 - 1);
        outOfEqualClassFive(2145828448, 2145828448 - 1);
        outOfEqualClassFive(-1885673594, -1885673594 - 1);
        outOfEqualClassFive(1885673594, -1885673594 - 1);
        outOfEqualClassFive(-1885673594, 1885673594 - 1);
        outOfEqualClassFive(1885673594, 1885673594 - 1);
        outOfEqualClassFive(-1401846850, -1401846850 - 1);
        outOfEqualClassFive(1401846850, -1401846850 - 1);
        outOfEqualClassFive(-1401846850, 1401846850 - 1);
        outOfEqualClassFive(1401846850, 1401846850 - 1);
        //endregion
        //endregion
    }

}
