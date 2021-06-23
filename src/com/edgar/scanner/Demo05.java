package com.edgar.scanner;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i < 10; i++) {
            for(int j = 1; j <= i; j++){
                System.out.printf(j + "*" + i + "=" + (i*j) + "\t");
            }
            System.out.printf("\n");
        }

        scanner.close();
    }
}
 