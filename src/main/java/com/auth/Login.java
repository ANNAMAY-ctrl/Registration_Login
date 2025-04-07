/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.auth;


        
public class Login {
      private static Login instance;  // Singleton instance
   private String[][] users = new String[200][4];
   private int userCount = 0;
   private int index = -1;
   
   private Login() {}  // Private constructor

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }
   
    public boolean checkUserName(String username){
      
       //Check username length>5 and if it contains underscore
       return username.length() <= 5 && username.contains("_");
    }
    
    public boolean checkPasswordComplexity(String password){
       
       return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$");
    }
    
    public String registerUser(String username, String password, String firstName, String lastName){
       boolean isValidUser = checkUserName(username);
        boolean isValidPassword = checkPasswordComplexity(password);
        
        if (!isValidUser){
            return "Username is not correctly formatted, please ensure that you username contains an underscore and is no more than 5 characters.";
        }else if(!isValidPassword){
            return "Password is not correctly formatted, please ensure the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }else{
            
              // Store user details in the 2D array
            if (userCount < users.length) {
                users[userCount][0] = username; // Store username
                users[userCount][1] = password; // Store password
                users[userCount][2] = firstName;
                users[userCount][3] = lastName;
                userCount++;                
            return "User has been successfully registered.";
        }else{
                 return "User database is full. Cannot register more users.";
            }
            
        }
}
      // Authenticating user by search 2D array
    public boolean loginUser(String username, String password){
        for (int i = 0; i < userCount;i++){
            if (users[i][0].equals(username) && users[i][0].equals(password)){
                 index= i;
                return true;
            }
        }
        return false;
    }
    
    public String returnLoginStatus(String username, String password){
        boolean loginStatus = loginUser(username, password);
        
        if(loginStatus && index != -1){
            String firstName = users[index][2];
            String lastName = users[index][3];
            return "Welcome " + firstName + ", " + lastName + "it is great to see you";
        }
        return "Incorrect username or password, please try again.";
    }
}
