package tests.flats;

import java.util.Scanner;

/**
 * @author Ihor Soldatenko
 * @project Tests
 * @date 01.08.2022
 */
public class Flats {
//    private static int floors = 9;
//    private static int flatsOnFloor = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flatNumber = 0;
        int floors = 0;
        int flatsOnFloor = 0;
        if (scanner.hasNextInt()) flatNumber=scanner.nextInt();
        if (scanner.hasNextInt()) floors=scanner.nextInt();
        if (scanner.hasNextInt()) flatsOnFloor=scanner.nextInt();
        System.out.println("|"+flatNumber + ": " + count(flatNumber, floors, flatsOnFloor)[0] + " этаж, " + count(flatNumber, floors, flatsOnFloor)[1] + " подъезд");
    }

    static int[] count(int flatNumber, int floors, int flatsOnFloor) {
        if (flatNumber < 1 || floors < 1 || flatsOnFloor < 1) return new int[]{-1, -1};
        if ((long)floors*flatsOnFloor > Integer.MAX_VALUE) return new int[]{-1, -1};
        int flatsOnEntrance = flatsOnFloor * floors;

        int entranceNumber;
        if (flatNumber <= flatsOnEntrance) entranceNumber = 1;
        else entranceNumber = (flatNumber - 1) / flatsOnEntrance + 1;

        int floorNumber;
        floorNumber = ((flatNumber - (flatsOnEntrance * (entranceNumber - 1))) - 1) / flatsOnFloor + 1;


        return new int[]{entranceNumber, floorNumber};
    }
}
