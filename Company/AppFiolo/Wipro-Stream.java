importjava.util.*;

publicclassStreamDemo {

    publicstaticvoidmain(String[]args) {

        //TODOAuto-generated method stub

        Listlibray=newArrayList();

        libray.add(newBook("hua","Stream Demo", 5));

        libray.add(newBook("hua","Do more practice", 5));

        libray.add(newBook("hua","Focus on basics", 5));

        StringauthorName="hua";

        Listcollection=newArrayList();

        libray.stream().filter(e->e.getAuthor() ==authorName).forEach(e->collection.add(e.getName()));

        System.out.print(collection);

    }

}

classBook {

    Stringauthor;

    Stringname;

    intnumber;

    publicBook(StringauthorName, StringbookName,intnum) {

        author=authorName;

        name=bookName;

        number=num;

    }

    publicString getAuthor() {

        returnauthor;

    }

    publicString getName() {

        returnname;

    }

    publicintgetNumber() {

        returnnumber;

    }

    publicvoidsetNumber(intnum) {

        number=num;

    }

}
