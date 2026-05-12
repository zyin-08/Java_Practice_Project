/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.boy_scouts;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author zyin2
 */
public class Boy_scouts {

    private static int numberCampers = 10;
    private static String location = "Barcelona";
    private static int days = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nameCampers = new String[10];
        Arrays.fill(nameCampers, "null");
        int opc;
        do {
            opc = menu();
            switch (opc) {
                case 1:
                    showCamp();
                    break;
                case 2:
                    updateNumber();
                    break;
                case 3:
                    updateLocation();
                    break;
                case 4:
                    updateDays();
                    break;
                case 5:
                    addCamper(nameCampers);
                    break;
                case 6:
                    countCamper(nameCampers);
                    break;
            }
        } while (opc != 0);

        System.out.println("Enter your scout leader name:");
        String name = sc.nextLine();
        System.out.println("Enter your camp name:");
        String campName = sc.nextLine();
        System.out.println("Leader name: " + name);
        System.out.println("Camp name: " + campName);

    }

    public static int menu() {
        System.out.println("====== Welcome to Scout Camp Manager ======");
        System.out.println("1. Show camp info");
        System.out.println("2. Update number of campers");
        System.out.println("3. Update location");
        System.out.println("4. Update days");
        System.out.println("5. Add camper");
        System.out.println("6. Count campers");
        System.out.println("0. Exit");

        Scanner sc = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Elige una opcion: ");
            opc = sc.nextInt();
        } while (opc < 0 || opc > 5);
        return opc;
    }

    public static void showCamp() {
        System.out.println("====== Camp info ======");
        System.out.println("Number of campers: " + numberCampers);
        System.out.println("Location: " + location);
        System.out.println("Days: " + days);
    }

    public static void updateNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Update number of campers: ");
        numberCampers = sc.nextInt();
        System.out.println("Thanks! Number of campers changed to: " + numberCampers);

        if (numberCampers > 50) {
            System.out.println("Large Camp");
        }
    }

    public static void updateLocation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Update location: ");
        location = sc.nextLine();
        System.out.println("Thanks! Location changed to: " + location);
    }

    public static void updateDays() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Update days: ");
        days = sc.nextInt();
        System.out.println("Thanks! Days changed to: " + days);
    }

    public static void addCamper(String[] nameCampers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = sc.nextLine();
        for (int i = 0; i < nameCampers.length; i++) {
            if (nameCampers[i].equals(name)) {
                System.out.println("Camper name already exists! Try again!");
                return;
            }
        }
        for (int i = 0; i < nameCampers.length; i++) {
            if (nameCampers[i].equals("null")) {
                nameCampers[i] = name;
                System.out.println("Camper name added correctly! Good Job!");
                return;
            }
        }
        System.out.println("The array of strings is full!No more camper names can be added!");
    }

    public static int countCamper(String[] nameCampers) {
        int number = 0;
        for (int i = 0; i < nameCampers.length; i++) {
            if (!nameCampers.equals("null")) {
                number++;
            }
        }
        System.out.println("Number of campers: " + number);
        return number;
    }
}
