/*
Date: May 5, 2016
Company: LendingClub 
Sr. Software Engineer - Engineering Efficiency
http://chj.tbe.taleo.net/chj06/ats/careers/requisition.jsp?org=LNDC&cws=1&rid=1527
*/

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class LendingClubInterview {
  public static void main(String[] args) {
//     ArrayList<String> strings = new ArrayList<String>();
//     strings.add("Hello, World!");
//     strings.add("Welcome to CoderPad.");
//     strings.add("This pad is running Java 8.");

//     for (String string : strings) {
//       System.out.println(string);
//     }
    UserAccountService service = new UserAccountService();
    User user = new User("hua.zhang@wsu.edu", "98$$22pt", 22);
    service.createUser(user);
   
    User user2 = new User("hua.zhang2@wsu.edu", "98$$22pt", 20);
    service.createUser(user2);
    
    User user3 = new User("hua.zhang3@wsu.edu", "98", 22);
    service.createUser(user3);
    
  }
}

//Create User Account Service that creates user based on first name, last name, email, password and age. Email cannot be empty, age has to be at least 21 and password has to be at least 6 characters. 
class UserAccountService {
  public List<User> userList = new ArrayList<User>();
  
  public void createUser(User user) {
    System.out.println("Creating user");
    String result = validateUser(user);
    System.out.println(result);
    
    if (isValidUser(user)) {
      System.out.println("Created user: " + user.getEmail());
      userList.add(user);
    }
    
    System.out.println("Users DB: " + userList.size());
    
    //TODO
  }
  
  public boolean isValidUser(User user) {
    String email = user.getEmail();
    String password = user.getPassword();
    
    return user.getAge() >= 21 && !email.isEmpty()  && password.length() >= 6? true : false;
  }
  
   public String validateUser(User user) {
    String result = "";
    String email = user.getEmail();
    String password = user.getPassword();
    
    if (user.getAge() < 21 ) {
      result += "age has to be at least 21";
    }
      
     return result;
     // !email.isEmpty()  && password.length() >= 6? true : false;
  }
  
}

class User {
  private String firstName;
  private String lastName;
  
  private String email;
  private String password;
  private int age;
  
  public User(String emailAddr, String password, int age) {
    this.email = emailAddr;
    this.age = age;
    this.password = password;
  }
  
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
    
}


