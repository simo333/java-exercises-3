package pl.main.java.exam1;

public class Main06 {
    public static String replaceStr(String str, String forReplace, String replacement) {
        return str.replaceAll(forReplace, replacement);
    }

    public static void main(String[] args) {
        System.out.println(replaceStr("Ala ma kota", "kota", "psa"));
    }


}
