package pl.main.java.exam1;

public class Main02 {
    public static String shorten(String str, int length) {
        try {
            str = str.substring(0, length);
            return str;
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Length value is invalid. " + e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(shorten("Naucz", -20));
    }

}
