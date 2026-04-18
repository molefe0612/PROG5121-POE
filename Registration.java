/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration;


import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("=== REGISTRATION ===");

            System.out.print("Enter username: ");
            String username = scanner.nextLine();   //  stores input

            System.out.print("Enter password: ");
            String password = scanner.nextLine();   //  stores input

            System.out.print("Enter SA phone number (e.g. +27831234567): ");
            String phoneNumber = scanner.nextLine(); //  stores input

            // FIX: properly create Login object
            Login login = new Login(username, password, phoneNumber);

            System.out.println(login.registerUser());

            System.out.println("\n=== LOGIN ===");
            System.out.print("Enter username to login: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password to login: ");
            String enteredPassword = scanner.nextLine();

            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();

            System.out.println(login.returnLoginStatus(
                enteredUsername, enteredPassword, firstName, lastName));
        }
    }
}
