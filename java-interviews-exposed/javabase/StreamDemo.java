package javabase;
/*
 * Wipro for Apple out sourcing  position, coding questions
 */

import java.util.*;

public class StreamDemo {

    public static void main(String[] args) {

        List<Book> libray= new ArrayList();

        libray.add( new Book("hua","Stream Demo", 5));

        libray.add( new Book("hua","Do more practice", 5));

        libray.add( new Book("hua","Focus on basics", 5));

        String authorName ="hua";

        List<String> collection= new ArrayList<>();

        libray.stream().filter(e->e.getAuthor() ==authorName).forEach(e->collection.add(e.getName()));

        System.out.print(collection);

    }

}

class Book {

    String author;

    String name;

    int number;

    public Book(String authorName, String bookName,int num) {

        author=authorName;

        name=bookName;

        number=num;

    }

    public String getAuthor() {

        return author;

    }

    public String getName() {

        return name;

    }

    public int getNumber() {

        return number;

    }

    public void setNumber(int num) {

        number=num;

    }

}
