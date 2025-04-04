/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.data;

/**
 *
 * @author mpoul
 */
public class User {
    private static int userCount = 0; // Auto-incremented ID
    private final int userId;
    private String username;
    private String password; // Stored as plain text

    public User(String username, String password) {
        this.userId = ++userCount; // Assign unique ID
        this.username = username;
        this.password = password;
    }
    
   public int getUserId(){
       return userId;
   }
   public String getUserName(){
       return username;
   }
   public String getPassword(){
       return password;
   }
}
