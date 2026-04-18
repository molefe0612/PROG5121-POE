package com.mycompany.registration;


public class Login {

    private final String username;
    private final String password;
    private final String cellPhoneNumber;

    // Constructor
    public Login(String username, String password, String cellPhoneNumber) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // Checks username contains underscore and is 5 chars or less
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5; 
    }

    // Checks password meets complexity rules
    public boolean checkPasswordComplexity() {
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }
        return password.length() >= 8 && hasUpper && hasNumber && hasSpecial;
    }

   
    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber.matches("\\+27\\d{9}");
    }

    // Returns registration message based on all three checks
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username " +
                   "contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password " +
                   "contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        //  return individual success confirmations as the task implies
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }

    // Checks if entered login details match stored details
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    //  welcome message matches task spec exactly
    public String returnLoginStatus(String enteredUsername, String enteredPassword,
                                    String firstName, String lastName) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
