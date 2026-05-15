/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.boy_scouts;

/**
 *
 * @author zyin2
 */
public class Camper {
    
    private String name;
    private int age;
    private boolean veteran;

    public Camper(String name, int age, boolean veteran) {
        this.name = name;
        this.age = age;
        this.veteran = veteran;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setVeteran(boolean veteran) {
        this.veteran = veteran;
    }
    
    public String nameUpperCase(){
        return name.toUpperCase();
    }

    @Override
    public String toString() {
        return "Camper{" + "name=" + name + ", age=" + age + ", veteran=" + veteran + '}';
    }
    
    
}
