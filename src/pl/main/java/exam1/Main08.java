package pl.main.java.exam1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main08 {
    static String[][] people;

    public static void create(int max) {
        people = new String[getIntInput("Enter group size:")][2];
        System.out.println("Enter " + people.length + " people:");
        for (int i = 0; i < people.length; i++) {
            addPerson(i);
        }
        saveFile("exam.txt", people);
        String[][] examResults = loadFromFile();
        String[][] passedExam = new String[1][];
        int passedAmount = 0;
        for (String[] examResult : examResults) {
            if (checkIfExamPassed(examResult[1], max)) {
                if (passedAmount > passedExam.length) {
                    passedExam = Arrays.copyOf(passedExam, passedExam.length + 1);
                }
                passedExam[passedAmount++] = examResult;
            }
        }
        saveFile("exam_passed.txt", passedExam);
    }

    public static boolean checkIfExamPassed(String score, int max) {
        int examScore = Integer.parseInt(score);
        return examScore > (0.6 * max);
    }

    public static int getIntInput(String caption) {
        Scanner scan = new Scanner(System.in);
        int value;
        while (true) {
            System.out.println(caption);
            try {
                String input = scan.nextLine();
                value = Integer.parseInt(input);
                if (value < 1) {
                    throw new IllegalArgumentException("Lower than 1 value has been entered.");
                }
                return value;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter positive number. " + e.getMessage());
            }
        }
    }

    public static void addPerson(int index) {
        String[] newPerson = new String[2];
        newPerson[0] = getStringInput();
        newPerson[1] = String.valueOf(getIntInput("Enter points:"));
        people[index] = newPerson;
    }

    private static String getStringInput() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter login:");
            try {
                String input = scan.nextLine();
                if (input.contains(" ")) {
                    throw new IllegalArgumentException("Space not allowed.");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void saveFile(String fileName, String[][] array) {
        String[] peopleInLine = new String[array.length];
        for (int i = 0; i < peopleInLine.length; i++) {
            try {
                peopleInLine[i] = String.join(" ", array[i]);
            } catch (NullPointerException e) {
                System.out.println("No one passed the exam.");
                peopleInLine[0] = "";
            }
        }
        try {
            Files.write(Paths.get(fileName), Arrays.asList(peopleInLine), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Could not save the file. " + e.getMessage());
        }
    }

    private static String[][] loadFromFile() {
        List<String> strings = new ArrayList<>();
        try {
            strings = Files.readAllLines(Paths.get("exam.txt"));
        } catch (IOException e) {
            System.out.println("No file. " + e.getMessage());
        }
        String[][] foundResults = new String[strings.size()][2];
        for (int i = 0; i < foundResults.length; i++) {
            foundResults[i] = Arrays.copyOf(strings.get(i).split(" "), strings.size());
        }
        return foundResults;
    }

    public static void main(String[] args) {
        create(100);
    }


}
