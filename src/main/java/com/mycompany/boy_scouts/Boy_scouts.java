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

    private static int numberCampers = 5;
    private static Location location = new Location("Spain", "Barcelona");
    private static int days = 5;
    private static Amount amount = new Amount(0.0, "euro");

    private static Camper[] nameCampers = new Camper[10];
    private static Activity[] activities = new Activity[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                    addCamper();
                    break;
                case 6:
                    System.out.println("Number of campers: " + countCamper());
                    break;
                case 7:
                    updateAmount();
                    break;
                case 8:
                    System.out.println("Average age of campers: " + averageAge());
                    break;
                case 9:
                    maxAge();
                    break;
                case 10:
                    payAmount();
                    break;
                case 11:
                    addActivity();
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
        System.out.println("7. Update amount");
        System.out.println("8. Average age of campers");
        System.out.println("9. Camper with max age");
        System.out.println("10. Calcute price per camper");
        System.out.println("11. Add activity");
        System.out.println("0. Exit");

        Scanner sc = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Elige una opcion: ");
            opc = sc.nextInt();
        } while (opc < 0 || opc > 11);
        return opc;
    }

    public static void showCamp() {
        System.out.println("====== Camp info ======");
        System.out.println("Number of campers: " + numberCampers);
        System.out.println("Location: " + location.toString());
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
        System.out.println("Update country: ");
        String country = sc.nextLine();
        System.out.println("Update city: ");
        String city = sc.nextLine();
        location.setCity(city);
        location.setCountry(country);
        System.out.println("Thanks! Location changed to: " + location.toString());
    }

    public static void updateDays() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Update days: ");
            days = sc.nextInt();
            if (days < 1 || days > 50) {
                System.out.println("Error! The number has to be between 1 and 50!");
            }
        } while (days < 1 || days > 50);
        System.out.println("Thanks! Days changed to: " + days);
    }

    public static boolean addCamper() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = sc.nextLine();
        System.out.println("Enter an age: ");
        int age = sc.nextInt();
        System.out.println("Is the camper a veteran?");
        boolean veteran = sc.nextBoolean();
        for (int i = 0; i < nameCampers.length; i++) {
            if (nameCampers[i] != null && nameCampers[i].getName().equals(name)) {
                System.out.println("Camper name already exists! Try again!");
                return false;
            }
        }
        for (int i = 0; i < nameCampers.length; i++) {
            if (nameCampers[i] == null) {
                nameCampers[i] = new Camper(name, age, veteran);
                System.out.println("Camper added correctly! Good Job!");
                return true;
            }
        }
        System.out.println("The array of campers is full! No more camper names can be added!");
        return false;
    }

    public static int countCamper() {
        int number = 0;
        for (int i = 0; i < nameCampers.length; i++) {
            if (nameCampers != null) {
                number++;
            }
        }
        return number;
    }

    public static void updateAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the price: ");
        double price = sc.nextDouble();
        amount.setPrice(price);
        System.out.println("Thanks! Amount changed to: " + amount.getPrice() + " " + amount.getCurrency());
    }

    public static double averageAge() {
        int number = 0;
        int age = 0;
        for (int i = 0; i < nameCampers.length; i++) {
            if (nameCampers[i] != null) {
                age += nameCampers[i].getAge();
                number++;
            }
        }
        if (number == 0) {
            System.out.println("There are no registered campers!");
            return 0.0;
        }
        double average = age / number;
        return average;
    }

    public static void maxAge() {
        Camper oldest = null;
        for (int i = 0; i < nameCampers.length; i++) {
            if (nameCampers[i] != null) {
                if (oldest == null || nameCampers[i].getAge() > oldest.getAge()) {
                    oldest = nameCampers[i];
                }
            }
        }
        if (oldest == null) {
            System.out.println("There are no registered campers!");
        } else {
            System.out.println("Oldest Camper: ");
            System.out.println(oldest.toString());
        }
    }

    public static void payAmount() {
        int numCamper = 0;
        for (int i = 0; i < nameCampers.length; i++) {
            if (nameCampers[i] != null) {
                numCamper++;
            }
        }
        if (numCamper <= 0) {
            System.out.println("There are no registered campers!");
            return;
        }
        double price = amount.getPrice() / numCamper;
        System.out.println("Every camper should pay: " + price + " " + amount.getCurrency());
    }

    public static boolean addActivity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an activity: ");
        String name = sc.nextLine();
        System.out.println("Enter activity duration: ");
        double duration = sc.nextDouble();
        for (int i = 0; i < activities.length; i++) {
            if (activities[i] != null && activities[i].getName().equals(name)) {
                System.out.println("Activity already exists! Try again!");
                return false;
            }
        }
        for (int i = 0; i < activities.length; i++) {
            if (activities[i] == null) {
                activities[i] = new Activity(name, duration);
                System.out.println("Activity added correctly! Good Job!");
                return true;
            }
        }
        System.out.println("The array of activities is full! No more activities names can be added!");
        return false;
    }
}
