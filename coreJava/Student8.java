//Example of static variable
// http://www.javatpoint.com/static-keyword-in-java
// Date: May 24, 2016
/*
111 Karan ENCS
222 Aryan ENCS
*/


class Student8{  
    int rollno;  
    String name;  
    static String college ="ENCS";  
     
    Student8(int r,String n){  
        rollno = r;  
        name = n;  
    }  
    void display (){
        System.out.println(rollno+" "+name+" "+college);
    }  
  
    public static void main(String args[]){  
        Student8 s1 = new Student8(111,"Karan");  
        Student8 s2 = new Student8(222,"Aryan");  
   
        s1.display();  
        s2.display();  
    }  
}  