package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("You might already be familiar with many smartphones that allow you to use a geometric pattern as a security measure. To unlock the device, you need to connect a sequence of dots/points in a grid by swiping your finger without lifting it as you trace the pattern through the screen. This program able to count a You might already be familiar with many smartphones that allow you to use a geometric pattern as a security measure. To unlock the device, you need to connect a sequence of dots/points in a grid by swiping your finger without lifting it as you trace the pattern through the screen.");
        System.out.println("Enter 0 for exit at any time");
        String str;
        int size;
        char point;
        int patternLength;
        Scanner in = new Scanner(System.in);
        while (true) {
            while (true) {
                System.out.println("Enter size of field: ");
                str = in.nextLine();
                if (str.equals("0"))
                    return;
                try {
                    size = Integer.parseInt(str);
                    if (size < 1)
                        throw new RuntimeException();
                    break;
                } catch (Exception e) {
                    System.out.println("Size of field should be integer > 0");
                }
            }
            for (int i = 0; i < size * size; i++) {
                if (i != 0 && i % size == 0)
                    System.out.println();
                System.out.printf("%c ", 'A' + i);
            }
            System.out.println();
            while (true) {
                System.out.println("Enter start Point of field: ");
                str = in.nextLine();
                if (str.equals("0"))
                    return;
                try {
                    if (str.length() != 1 || str.charAt(0) < 'A' || str.charAt(0) >= 'A' + size * size) {
                        throw new RuntimeException();
                    }
                    point = str.charAt(0);
                    break;
                } catch (Exception e) {
                    System.out.println("Start point should be a capital letter of field");
                }
            }
            while (true) {
                System.out.println("Enter pattern length: ");
                str = in.nextLine();
                if (str.equals("0"))
                    return;
                try {
                    patternLength = Integer.parseInt(str);
                    if (patternLength < 1)
                        throw new RuntimeException();
                    break;
                } catch (Exception e) {
                    System.out.println("Pattern length should be an integer > 0");
                }
            }
            System.out.printf("Available combinations: %d%n", Screenlocker.calculateCombinations(point, patternLength, size));
        }
    }
}
