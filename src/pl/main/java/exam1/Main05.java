package pl.main.java.exam1;

import java.util.Scanner;

public class Main05 {
    public static double sphere() {
        Scanner scan = new Scanner(System.in);
        double radius;
        while (true) {
            System.out.println("Enter radius:");
            try {
                String input = scan.nextLine();
                radius = Double.parseDouble(input);
                if (radius <= 0) {
                    throw new IllegalArgumentException("Lower or equal to 0 value has been entered.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter positive number. " + e.getMessage());
            }
        }

        return 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
    }

    public static void main (String[]args){
        System.out.println(sphere());
    }


}
