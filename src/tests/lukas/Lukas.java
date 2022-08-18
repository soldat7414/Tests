package tests.lukas;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Ihor Soldatenko
 * @project Tests
 * @date 01.08.2022
 */
public class Lukas {

    public static void main(String[] args) {
        int num = -2;


        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) num = scanner.nextInt();
        System.out.println(luksNumIter(num));

    }

    static BigInteger luksNumIter(int num) {

        if (num < 0) {
            System.out.println("Not valid input");
            return BigInteger.valueOf(-1);
        }

        BigInteger result = BigInteger.valueOf(3);
        BigInteger prev = BigInteger.ONE;
        BigInteger next = BigInteger.ZERO;


        if (num == 0) return BigInteger.valueOf(2);
        if (num == 1) return BigInteger.valueOf(1);
        if (num == 2) return BigInteger.valueOf(3);
        else {
            for (int i = 2; i < num; i++) {
                next = result;
                result = result.add(prev);
                prev = next;

            }
        }
        return result;

    }
}
