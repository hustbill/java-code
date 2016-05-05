#Interview Questions list

Q1: Hive schema   
**Answer:**    
 hive> CREATE SCHEMA userdb;  

Q2: Hive ORC and Hive ETL  
**Answer:**    
ORC <The Optimized Row Columnar> file format provides a highly efficient way to store Hive data. It was designed to overcome limitations of the other Hive file formats. Using ORC files improves performance when Hive is reading, writing and processing data.  

Hive ETL : [Example: How to use Hive for ELT](http://www.ibm.com/developerworks/library/bd-hivetool/)  


Q3:  MongoDB and JSON format  
**Answer:** 
Storing JSON data from Java/ Node.js to MongoDB  

Q4: Java **finally**
**Answer:**  
The finally block always execute in Java  

Q5: Time complexity of  recursive implementation   
```java
Integer foo( Integer a, Integer b) {
 	return a == 0 ? foo(a - 1, b) + b;
}
```
**Answer:**
 Time complexity should be   O (n^2)   because the function computes the sum 1 + 2 + ... + n
n+1 <which is n/2.>  


Q6: Shell Script:  print the third word in the third line of each file under the folder   
**Answer:**
```shell
#!/bin/bash
#!/bin/sh  
#============ Print 3rd word in 3rd line under the folder ===========  
Folder_A="./"  
Output_file="output.txt"
for file in ${Folder_A}/*.log; do  
    filename=`basename $file`  
    awk 'NR==3 {print$3}' $filename
    awk 'NR==3 {print$3}' $filename >> $Output_file
done     
## Result
#huazhang@huas-MacBook-Pro Macys (master) $ ./PrintWordInLineShell.sh
#system
#FTP
```

Q7. Scala question:  convert lists to list of tuple    
**Answer:**    
```scala
scala> val lists = List(((1,52),7), ((1,82),6))
lists: List[((Int, Int), Int)] = List(((1,52),7), ((1,82),6))

scala> lists map { case ((a,b),c ) => (a,b,c) }
res7: List[(Int, Int, Int)] = List((1,52,7), (1,82,6))
``` 