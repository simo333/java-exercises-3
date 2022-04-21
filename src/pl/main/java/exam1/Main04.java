package pl.main.java.exam1;

import java.util.Arrays;
import java.util.Scanner;

public class Main04 {
    public static int[] returnTab() {
        Scanner scan = new Scanner(System.in);
        int size;
        while (true) {
            System.out.println("Enter array size:");
            try {
                String input = scan.nextLine();
                size = Integer.parseInt(input);
                if (size < 1) {
                    throw new IllegalArgumentException("Lower than 1 value has been entered.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter positive number. " + e.getMessage());
            }
        }
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(returnTab()));
    }

}
