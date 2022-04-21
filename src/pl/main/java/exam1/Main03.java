package pl.main.java.exam1;

import java.util.Arrays;
import java.util.Random;

public class Main03 {
    public static int[] div(int size, int interval) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] == 0) {
                int value = new Random().nextInt(interval) + 1;
                if (value % 2 == 0 && value % 3 == 0) {
                    arr[i] = value;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(div(10, 30)));
    }


}
