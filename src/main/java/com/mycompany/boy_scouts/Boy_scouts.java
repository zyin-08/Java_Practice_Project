/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.boy_scouts;

import java.util.Scanner;

/**
 *
 * @author zyin2
 */
public class Boy_scouts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====== Welcome to Scout Camp Manager ======");
        
        System.out.println("Enter your scout leader name:");
        String name = sc.nextLine();
        System.out.println("Enter your camp name:");
        String campName = sc.nextLine();
        System.out.println("Leader name: " + name);
        System.out.println("Camp name: " + campName);
        
        int numberCampers = 10;
        String location = "Barcelona";
        int days = 5;
        
        System.out.println("====== Camp info ======");
        System.out.println("Number of campers: " + numberCampers);
        System.out.println("Location: " + location);
        System.out.println("Days: " + days);
        
        System.out.println("Update number of campers: ");
        numberCampers = sc.nextInt();
        System.out.println("Thanks! Number of campers changed to: " + numberCampers);
        
        System.out.println("Update location: ");
        location = sc.nextLine();
        System.out.println("Thanks! Location changed to: " + location);
        
        System.out.println("Update days: ");
        days = sc.nextInt();
        System.out.println("Thanks! Days changed to: " + days);
        
        if (numberCampers > 50){
            System.out.println("Large Camp");
        }
    }
}
