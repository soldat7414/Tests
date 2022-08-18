package tests.nok;

import org.junit.jupiter.api.Test;
import tests.lukas.Lukas;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static tests.nok.NOK.nok;

/**
 * @author Ihor Soldatenko
 * @project Tests
 * @date 09.08.2022
 */
public class TestNOK {
    static int count = 0;

    void nokTest(int one, int two, int three, int four, long result) {
        System.out.print(++count + "; ");
        mainTest(one, two, three, four);
        assertEquals(result, nok(one, two, three, four));
    }
    void mainTest(int one, int two, int three, int four){
        InputStream argsStream = new ByteArrayInputStream((one+"\n"+two+"\n"+three+"\n"+four).getBytes(StandardCharsets.UTF_8));
        System.setIn(argsStream);
        NOK.main(null);
    }

    void testAllVariants(int one, int two, int three, int four, long result) {
        nokTest(one, two, three, four, result);
        nokTest(one, two, four, three, result);
        nokTest(one, three, two, four, result);
        nokTest(one, four, two, three, result);
        nokTest(one, four, three, two, result);
        nokTest(one, three, four, two, result);

        nokTest(two, one, three, four, result);
        nokTest(two, one, four, three, result);
        nokTest(three, one, two, four, result);
        nokTest(four, one, two, three, result);
        nokTest(four, one, three, two, result);
        nokTest(three, one, four, two, result);

        nokTest(two, three, one, four, result);
        nokTest(two, four, one, three, result);
        nokTest(three, two, one, four, result);
        nokTest(four, two, one, three, result);
        nokTest(four, three, one, two, result);
        nokTest(three, four, one, two, result);

        nokTest(two, three, four, one, result);
        nokTest(two, four, three, one, result);
        nokTest(three, two, four, one, result);
        nokTest(four, two, three, one, result);
        nokTest(four, three, two, one, result);
        nokTest(three, four, two, one, result);
    }




    @Test
    void nokTest() {
//Всего 271 значение из которых 51 не валидных
        //region Граничные значения области определения
        testAllVariants(1, 1, 1, 1, 1L);
        testAllVariants(2, 1, 1, 1, 2L);
        testAllVariants(0, 1, 1, 1, -1L);
        testAllVariants(1, 2, 1, 1, 2L);
        testAllVariants(1, 0, 1, 1, -1L);
        testAllVariants(1, 1, 2, 1, 2L);
        testAllVariants(1, 1, 0, 1, -1L);
        testAllVariants(1, 1, 1, 2, 2L);
        testAllVariants(1, 1, 1, 0, -1L);

        testAllVariants(2147483647, 2147483647, 2, 1, 4294967294L);
        testAllVariants(2147483646, 2147483647, 2, 1, 4611686011984936962L);
        testAllVariants(-2147483648, 2147483647, 2, 1, -1L);
        testAllVariants(2147483647, 2147483646, 2, 1, 4611686011984936962L);
        testAllVariants(2147483647, -2147483648, 2, 1, -1L);
        testAllVariants(2147483647, 2147483647, 1, 1, 2147483647L);
        testAllVariants(2147483647, 2147483647, 3, 1, -1L);
        testAllVariants(2147483647, 2147483647, 2, 0, -1L);
        testAllVariants(2147483647, 2147483647, 2, 1, 4294967294L);

        testAllVariants(2147483647, 1, 1, 1, 2147483647L);
        testAllVariants(2147483647, 1, 1, 2, 4294967294L);
        testAllVariants(2147483647, 1, 1, 0, -1L);
        testAllVariants(2147483647, 1, 2, 1, 4294967294L);
        testAllVariants(2147483647, 1, 0, 1, -1L);
        testAllVariants(2147483647, 2, 1, 1, 4294967294L);
        testAllVariants(2147483647, 0, 1, 1, -1L);
        testAllVariants(2147483646, 1, 1, 1, 2147483646L);
        testAllVariants(-2147483648, 1, 1, 1, -1L);

        //region +3 на поверхности
        testAllVariants(2147483647, 926838, 4634, 1, 4611686011984936962L);
        testAllVariants(2147483647, 926839, 4634, 1, -1L);
        testAllVariants(2147483647, 926837, 4634, 1, 9223362072530653726L);
        testAllVariants(2147483647, 926838, 4635, 1, -1L);
        testAllVariants(2147483647, 926838, 4633, 1, 9221381654521455738L);
        testAllVariants(2147483647, 926838, 4634, 0, -1L);
        testAllVariants(2147483647, 926838, 4634, 2, -1L);

        testAllVariants(2147483647, 7880673, 545, 1, 9223370935195664895L);
        testAllVariants(2147483647, 7880674, 545, 1, -1L);
        testAllVariants(2147483647, 7880672, 545, 1, 9223369764817077280L);
        testAllVariants(2147483647, 7880673, 546, 1, -1L);
        testAllVariants(2147483647, 7880673, 544, 1, 541555724635341792L);
        testAllVariants(2147483647, 7880673, 545, 0, -1L);
        testAllVariants(2147483647, 7880673, 545, 2, -1L);

        testAllVariants(2147483647, 463419, 9268, 1, 9223372023969873924L);
        testAllVariants(2147483647, 463420, 9268, 1, -1L);
        testAllVariants(2147483647, 463418, 9268, 1, 4611676060545716764L);
        testAllVariants(2147483647, 463419, 9269, 1, -1L);
        testAllVariants(2147483647, 463419, 9267, 1, 3074125613081888277L);
        testAllVariants(2147483647, 463419, 9268, 0, -1L);
        testAllVariants(2147483647, 463419, 9268, 2, -1L);
        //endregion

        testAllVariants(92680, 46341, 46341, 46341, 4294883880L);
        testAllVariants(92681, 46341, 46341, 46341, 4294930221L);
        testAllVariants(92679, 46341, 46341, 46341, 1431612513L);
        testAllVariants(92680, 46342, 46341, 46341, -1L);
        testAllVariants(92680, 46340, 46341, 46341, 4294883880L);
        testAllVariants(92680, 46341, 46342, 46341, -1L);
        testAllVariants(92680, 46341, 46340, 46341, 4294883880L);
        testAllVariants(92680, 46341, 46341, 46342, -1L);
        testAllVariants(92680, 46341, 46341, 46340, 4294883880L);

        testAllVariants(2147483647, 46340, 46340, 2, 99514392201980L);
        testAllVariants(2147483647, 46340, 46340, 1, 99514392201980L);
        testAllVariants(2147483647, 46340, 46340, 3, -1L);
        testAllVariants(2147483647, 46340, 46341, 3, -1L);
        testAllVariants(2147483647, 46340, 46339, 3, -1L);
        testAllVariants(2147483647, 46341, 46340, 3, -1L);
        testAllVariants(2147483647, 46339, 46340, 3, -1L);
        testAllVariants(2147483646, 46340, 46340, 3, -1L);
        testAllVariants(-2147483648, 46340, 46340, 3, -1L);

        testAllVariants(2147483647, 92680, 46341, 1, 9223192898063910360L);
        testAllVariants(2147483647, 92680, 46341, 0, -1L);
        testAllVariants(2147483647, 92680, 46341, 2, -1L);
        testAllVariants(2147483647, 92680, 46342, 1, -1L);
        testAllVariants(2147483647, 92680, 46340, 1, 199028784403960L);
        testAllVariants(2147483647, 92681, 46341, 1, 9223292414603595987L);
        testAllVariants(2147483647, 92679, 46341, 1, 3074364460508074911L);
        testAllVariants(2147483646, 92680, 46341, 1, 221147865865080L);
        testAllVariants(-2147483648, 92680, 46341, 1, -1L);


        //endregion

        //region Классы "Эквивалентности"
        testAllVariants(2, 1, 1, 1, 2L);
        testAllVariants(2, 2, 1, 1, 2L);
        testAllVariants(2, 2, 2, 1, 2L);
        testAllVariants(2, 2, 2, 2, 2L);
        testAllVariants(2, 2, 2, 3, 6L);
        testAllVariants(2, 2, 2, 0, -1L);
        testAllVariants(2, 2, 0, 0, -1L);
        testAllVariants(2, 2, 3, 3, 6L);
        testAllVariants(2, 3, 3, 3, 6L);

        testAllVariants(5, 1, 1, 1, 5L);
        testAllVariants(4, 1, 1, 1, 4L);
        testAllVariants(5, 1, 1, 0, -1L);
        testAllVariants(5, 1, 0, 0, -1L);
        testAllVariants(5, 5, 1, 1, 5L);
        testAllVariants(5, 5, 5, 1, 5L);
        testAllVariants(5, 5, 5, 5, 5L);
        testAllVariants(5, 5, 5, 6, 30L);
        testAllVariants(5, 5, 6, 6, 30L);

        testAllVariants(18, 1, 1, 1, 18L);
        testAllVariants(18, 1, 1, 0, -1L);
        testAllVariants(17, 1, 1, 1, 17L);
        testAllVariants(18, 2, 1, 1, 18L);
        testAllVariants(18, 2, 2, 1, 18L);
        testAllVariants(18, 2, 2, 2, 18L);
        testAllVariants(18, 9, 2, 2, 18L);
        testAllVariants(18, 3, 2, 2, 18L);
        testAllVariants(18, 3, 3, 2, 18L);
        testAllVariants(18, 3, 3, 3, 18L);
        testAllVariants(18, 6, 3, 3, 18L);
        testAllVariants(18, 6, 6, 3, 18L);
        testAllVariants(18, 6, 6, 6, 18L);
        testAllVariants(18, 9, 6, 6, 18L);
        testAllVariants(18, 9, 9, 6, 18L);
        testAllVariants(18, 9, 9, 9, 18L);
        testAllVariants(18, 18, 9, 9, 18L);
        testAllVariants(18, 18, 18, 9, 18L);
        testAllVariants(18, 18, 18, 18, 18L);
        testAllVariants(18, 18, 18, 19, 342L);
        testAllVariants(18, 18, 19, 19, 342L);
        testAllVariants(18, 19, 19, 19, 342L);
        testAllVariants(19, 19, 19, 19, 19L);

        testAllVariants(74, 1, 1, 1, 74L);
        testAllVariants(74, 2, 1, 1, 74L);
        testAllVariants(74, 2, 2, 1, 74L);
        testAllVariants(74, 2, 2, 2, 74L);
        testAllVariants(74, 37, 2, 2, 74L);
        testAllVariants(74, 37, 3, 2, 222L);
        testAllVariants(74, 37, 37, 2, 74L);
        testAllVariants(74, 37, 37, 37, 74L);
        testAllVariants(74, 74, 37, 37, 74L);
        testAllVariants(74, 74, 74, 37, 74L);
        testAllVariants(74, 74, 74, 74, 74L);
        testAllVariants(74, 37, 2, 1, 74L);
        testAllVariants(74, 38, 2, 1, 1406L);
        testAllVariants(75, 1, 1, 1, 75L);
        testAllVariants(75, 75, 1, 1, 75L);
        testAllVariants(75, 75, 75, 1, 75L);
        testAllVariants(75, 75, 75, 75, 75L);
        testAllVariants(73, 73, 73, 73, 73L);

        testAllVariants(752, 1, 1, 1, 752L);
        testAllVariants(752, 2, 1, 1, 752L);
        testAllVariants(752, 2, 1, 1, 752L);
        testAllVariants(752, 2, 376, 1, 752L);
        testAllVariants(752, 2, 376, 188, 752L);
        testAllVariants(752, 2, 376, 189, 142128L);
        testAllVariants(752, 2, 377, 188, 283504L);
        testAllVariants(752, 3, 376, 188, 2256L);
        testAllVariants(753, 2, 376, 188, 283128L);

        testAllVariants(357913941, 1, 1, 1, 357913941L);
        testAllVariants(357913941, 7, 1, 1, 357913941L);
        testAllVariants(357913941, 7, 51130563, 1, 357913941L);
        testAllVariants(357913941, 7, 51130563, 2, 715827882L);
        testAllVariants(357913941, 7, 51130564, 1, 18300341666792724L);
        testAllVariants(357913941, 8, 51130563, 1, 2863311528L);
        testAllVariants(357913942, 7, 51130563, 1, 128102389520065422L);
        testAllVariants(357913941, 7, 51130563, 1, 357913941L);
        testAllVariants(357913941, 6, 51130563, 1, 715827882L);
        testAllVariants(357913940, 7, 51130562, 1, 9150170449917140L);
        testAllVariants(357913941, 7, 51130562, 0, -1L);

        testAllVariants(715827882, 1, 1, 1, 715827882L);
        testAllVariants(715827882, 2, 1, 1, 715827882L);
        testAllVariants(715827882, 2, 7, 1, 715827882L);
        testAllVariants(715827882, 2, 7, 357913941, 715827882L);
        testAllVariants(715827882, 2, 7, 357913940, 128102388804237540L);
        testAllVariants(715827882, 2, 7, 357913942, 128102389520065422L);
        testAllVariants(715827882, 2, 6, 357913941, 715827882L);
        testAllVariants(715827882, 2, 8, 357913941, 2863311528L);
        testAllVariants(715827882, 3, 7, 357913941, 715827882L);
        testAllVariants(715827882, 1, 7, 357913941, 715827882L);
        testAllVariants(715827883, 2, 7, 357913941, 512409557364433806L);
        testAllVariants(715827881, 2, 7, 357913941, 512409555932778042L);

        testAllVariants(1431655764, 1, 1, 1, 1431655764L);
        testAllVariants(1431655764, 2, 1, 1, 1431655764L);
        testAllVariants(1431655764, 2, 4, 1, 1431655764L);
        testAllVariants(1431655764, 2, 4, 715827882, 1431655764L);
        testAllVariants(1431655764, 2, 4, 715827883, 1024819114728867612L);
        testAllVariants(1431655764, 2, 4, 715827881, 1024819111865556084L);
        testAllVariants(1431655764, 2, 5, 715827882, -1L);
        testAllVariants(1431655764, 2, 3, 715827882, 1431655764L);
        testAllVariants(1431655764, 3, 4, 715827882, -1L);
        testAllVariants(1431655764, 1, 4, 715827882, 1431655764L);
        testAllVariants(1431655765, 2, 4, 715827882, 2049638228026079460L);
        testAllVariants(1431655763, 2, 4, 715827882, 2049638225162767932L);

        testAllVariants(1789569705, 1, 1, 1, 1789569705L);
        testAllVariants(1789569705, 5, 1, 1, 1789569705L);
        testAllVariants(1789569705, 5, 357913941, 1, 1789569705L);
        testAllVariants(1789569705, 5, 357913941, 2, 3579139410L);
        testAllVariants(1789569705, 5, 357913941, 0, -1L);
        testAllVariants(1789569705, 5, 357913942, 1, 640511947600327110L);
        testAllVariants(1789569705, 5, 357913940, 1, 128102388804237540L);
        testAllVariants(1789569705, 6, 357913941, 1, 3579139410L);
        testAllVariants(1789569705, 7, 357913941, 1, 1789569705L);
        testAllVariants(1789569704, 5, 357913941, 1, 3202559727264217320L);
        testAllVariants(1789569706, 5, 357913941, 1, 3202559730843356730L);

        testAllVariants(2147483647, 1, 1, 1, 2147483647L);
        testAllVariants(2147483647, 2147483647, 1, 1, 2147483647L);
        testAllVariants(2147483646, 2147483647, 1, 1, 4611686011984936962L);
        testAllVariants(2147483647, 2147483647, 2, 1, 4294967294L);
        testAllVariants(2147483647, 2147483647, 0, 1, -1L);
        //endregion

        //region Предметная область - смеси из кратных составляющих
        testAllVariants(300, 12, 42, 25, 2100L);
        testAllVariants(1000, 250, 400, 750, 6000L);
        testAllVariants(1, 4, 3, 5, 60L);
        testAllVariants(32, 25, 28, 27, 151200L);
        testAllVariants(18, 72, 350, 8, 12600L);
        testAllVariants(1880, 17, 311, 250, 248489000L);
        //endregion

        //region Реализация
        testAllVariants(1, 1, 1, -1, -1L);
        testAllVariants(1, 1, -1, -1, -1L);
        testAllVariants(2147483647, 1073741823, 4, 1, 9223372023969873924L);
        testAllVariants(2147483647, 1073741823, 5, 1, -1L);
        testAllVariants(92680, 46340, 46340, 46341, 4294883880L);
        //endregion

        //region Случайные значения!!!!!!!!!
        testAllVariants(48299033, 1636, 1312642, 61, 3163500231153231028L);
        testAllVariants(605819, 38241, 56156, 5124, 79359355234254564L);
        testAllVariants(103869, 19506, 110093, 30661, 2279706497543018574L);
        testAllVariants(74788083, 39191, 54795, 2, 107070151863960090L);
        testAllVariants(885350317, 34807, 61696, 2, 1901247903897697024L);
        testAllVariants(247614, 28561, 75189, 14689, 2603597764936205778L);
        testAllVariants(28653430, 19571, 109727, 25, 307661493571306550L);
        testAllVariants(1903759169, 7005, 306564, 1, 1362762100442212860L);
        testAllVariants(115379, 27731, 77439, 19473, 146207941126985991L);
        testAllVariants(342071, 11417, 188095, 7919, 5817224873471573135L);
        testAllVariants(693449107, 15982, 134368, 5, 286377061749432160L);
        testAllVariants(384736883, 36290, 59175, 3, 165241471063968450L);
        testAllVariants(1478392, 31699, 67746, 2389, 3792320009441536776L);
        testAllVariants(59518665, 34860, 61603, 15, 8521011815668380L);
        testAllVariants(159800, 9140, 234954, 3989, 34222352379535800L);
        testAllVariants(680500136, 8440, 254441, 4, 182670227534694680L);
        //endregion

        //region Другие особые значения
        testAllVariants(2147483647, 2147483647, 1, 2, 4294967294L);
        testAllVariants(46341, 2147483647, 46340, 2, 4611596449031955180L);
        testAllVariants(46341, 46341, 2147395600, 2, 99512459499600L);
        testAllVariants(2147483647, 2147483647, 1, 2, 4294967294L);
        testAllVariants(2147483647, 122608, 17515, 2, 4611676292473950640L);
        testAllVariants(2147483647, 86696, 24770, 2, 2305817530393964120L);
        testAllVariants(2147483647, 70787, 30337, 2, 9223292880607547386L);
        testAllVariants(2147483647, 61304, 35030, 2, 2305838146236975320L);
        testAllVariants(2147483647, 54831, 39165, 2, 1177486758486570L);
        testAllVariants(2147483647, 50054, 42903, 2, 4611649753871041014L);
        testAllVariants(113515, 2147483647, 18918, 2, 4611671245887380190L);
        testAllVariants(113515, 122608, 331348770, 2, 461166152426004240L);
        testAllVariants(113515, 86696, 468598860, 2, 230581014635302920L);
        testAllVariants(113515, 70787, 573915366, 2, 4611631672185462630L);
        testAllVariants(113515, 61304, 662697540, 2, 230583076213002120L);
        testAllVariants(113515, 54831, 740923470, 2, 117748298775870L);
        testAllVariants(113515, 50054, 811638954, 2, 2305817492871059370L);
        testAllVariants(80267, 2147483647, 26754, 2, 4611642357937360746L);
        testAllVariants(80267, 122608, 468596310, 2, 2305816318185460080L);
        testAllVariants(80267, 86696, 662696580, 2, 1152897851268803640L);
        testAllVariants(80267, 70787, 811636098, 2, 4611602784483336642L);
        testAllVariants(80267, 61304, 937192620, 2, 1152908159092730040L);
        testAllVariants(80267, 54831, 1047820410, 2, 84105400849470L);
        testAllVariants(80267, 50054, 1147826862, 2, 2305803049009618158L);
        testAllVariants(65535, 2147483647, 32768, 2, 4611615647535759360L);
        testAllVariants(65535, 122608, 573931520, 2, 57645074075320320L);
        testAllVariants(65535, 86696, 811663360, 2, 115289117374218240L);
        testAllVariants(65535, 70787, 994082816, 2, 4611576074310942720L);
        testAllVariants(65535, 61304, 1147863040, 2, 115290148150640640L);
        testAllVariants(65535, 54831, 1283358720, 2, 39248959733760L);
        testAllVariants(65535, 50054, 1405845504, 2, 768596564637941760L);
        testAllVariants(56756, 2147483647, 37837, 2, 4611671250182347484L);
        testAllVariants(56756, 122608, 662715055, 2, 1152915382138750160L);
        testAllVariants(56756, 86696, 937222490, 2, 576452537125122280L);
        testAllVariants(56756, 70787, 1147861069, 2, 4611631676480393068L);
        testAllVariants(56756, 61304, 1325430110, 2, 576457691069375080L);
        testAllVariants(56756, 54831, 1481886105, 2, 84105927775380L);
        testAllVariants(56756, 50054, 1623320811, 2, 329402499288360876L);
        testAllVariants(50764, 2147483647, 42303, 2, 4611655616501397324L);
        testAllVariants(50764, 122608, 740937045, 2, 1152911473726751760L);
        testAllVariants(50764, 86696, 1047845310, 2, 576450582936595080L);
        testAllVariants(50764, 70787, 1283346111, 2, 4611616042933598748L);
        testAllVariants(50764, 61304, 1481874090, 2, 576455736863375880L);
        testAllVariants(50764, 54831, 1656796995, 2, 12015091807740L);
        testAllVariants(50764, 50054, 1814925609, 2, 329401382605644636L);

        testAllVariants(777, 666, 555, 444, 46620L);
        testAllVariants(95, 393, 35, 8, 2090760L);
        testAllVariants(1, 2, 3, 4, 12L);
        testAllVariants(36, 35, 8, 2, 2520L);
        testAllVariants(29, 4, 19, 86, 94772L);
        //endregion


    }

}

