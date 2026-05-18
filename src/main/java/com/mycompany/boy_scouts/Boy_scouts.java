/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.boy_scouts;

import java.util.ArrayList;
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

    private static ArrayList<Camper> nameCampers = new ArrayList<>();
    private static ArrayList<Activity> activities = new ArrayList<>();

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
                case 12:
                    System.out.println("Number of activities: " + actRegistered());
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
        System.out.println("12. Number of activities registered");
        System.out.println("0. Exit");

        Scanner sc = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Elige una opcion: ");
            opc = sc.nextInt();
        } while (opc < 0 || opc > 12);
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
        for (Camper camper : nameCampers) {
            if (camper.getName().equals(name)) {
                System.out.println("Camper name already exists! Try again!");
                return false;
            }
        }
        nameCampers.add(new Camper(name, age, veteran));
        System.out.println("Camper added correctly! Good Job!");
        return true;

    }

    public static int countCamper() {
        return nameCampers.size();
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
        for (Camper camper : nameCampers) {
            age += camper.getAge();
            number++;
        }
        if (number == 0) {
            System.out.println("There are no registered campers!");
            return 0.0;
        }
        double average = age / number;
        return average;
    }

    public static Camper maxAge() {
        Camper oldest = null;
        for (Camper camper : nameCampers) {
            if (oldest == null || camper.getAge() > oldest.getAge()) {
                oldest = camper;
            }
        }
        if (oldest == null) {
            System.out.println("There are no registered campers!");
        } else {
            System.out.println("Oldest Camper: " + oldest.getName());
        }
        return oldest;
    }

    public static Amount payAmount() {
        int numCamper = nameCampers.size();
        if (numCamper <= 0) {
            System.out.println("There are no registered campers!");
            return new Amount(0.0, amount.getCurrency());
        }
        double price = amount.getPrice() / numCamper;
        System.out.println("Every camper should pay: " + price + " " + amount.getCurrency());
        return new Amount(price, amount.getCurrency());
    }

    public static boolean addActivity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an activity: ");
        String name = sc.nextLine();
        System.out.println("Enter activity duration: ");
        double duration = sc.nextDouble();
        for (Activity act: activities) {
            if (act.getName().equals(name)) {
                System.out.println("Activity already exists! Try again!");
                return false;
            }
        }
        activities.add(new Activity(name, duration));
        System.out.println("Activity added correctly! Good Job!");
        return true;
    }

    public static int actRegistered() {
        return activities.size();
    }
}
