package tests.swap;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ihor Soldatenko
 * @project Tests
 * @date 01.08.2022
 */
public class Swap {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x=0,y=0;
//        if(scanner.hasNext()) x = Integer.parseInt(scanner.nextLine().trim());
        if(scanner.hasNextInt()) x = scanner.nextInt();
//        if(scanner.hasNext()) y = Integer.parseInt(scanner.nextLine().trim());
        if(scanner.hasNextInt()) y = scanner.nextInt();

        int[] rebased = rebase(x, y);
        System.out.println("x = " + rebased[0] + " y = " + rebased[1]);

    }

    public static int[] rebase(int x, int y) {

        if (x == y) return new int[]{x, y};
        y = y - x;
        x = x + y;
        y = x - y;

        return new int[]{x, y};
    }
}
