package pl.main.java.exam1;

public class Main07 {
    public static int countNumbers(String str) {
        int sum = 0;
        System.out.println("Enter array size:");
        for (int i = 0; i < str.length(); i++) {
            try {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            } catch (NumberFormatException e) {
                System.out.println("LOG: NaN. " + e.getMessage());
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countNumbers("Wynik dodawania 1 i 2 to 3"));
        System.out.println(countNumbers("PO5ZUK4J I DOD4J UKRYT3 CYFRY"));
    }


}
