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
