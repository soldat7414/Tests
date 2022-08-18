package tests.nok;


import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

/**
 * @author Ihor Soldatenko
 * @project Tests
 * @date 11.08.2022
 */
public class NOK {


    public static void main(String[] args) {
        int one = -1;
        int two = - 1;
        int three = -1;
        int four = -1;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt())one=scanner.nextInt();
        if (scanner.hasNextInt())two=scanner.nextInt();
        if (scanner.hasNextInt())three=scanner.nextInt();
        if (scanner.hasNextInt())four=scanner.nextInt();
        System.out.println(nok(one,two,three,four));
    }

    static long nok(int one, int two, int three, int four) {
        if (one <= 0 || two <= 0 || three <= 0 || four <= 0) return -1;
        BigInteger mult = valueOf(one).multiply(valueOf(two).multiply(valueOf(three).multiply(valueOf(four))));
        long range = MAX_VALUE;
        if (mult.compareTo(ZERO) < 1 || (valueOf(Long.MAX_VALUE).divide(mult)).longValue() < 1) return -1;

        long lcmOne = lcm(one, two);
        long lcmTwo = lcm(four, three);
        return lcm(lcmOne, lcmTwo);
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }


}
