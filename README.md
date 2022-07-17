# Testing Campaign Tasks
### Name: Rohit Raghuram Murarishetti, Student ID: 1005398
## Week 8
Hello!

You can find the task 1 - use case diagram in the Week 8 folder in the main branch!
You will also find the CSV files used to test the task 2 code in the same folder.


#### Getting Started:
1. Clone this repository

2. Navigate to the "./TestingCampaign/testingCampaign/src/main/java/com/example/testingcampaign/Week8CSV.java"

3. Edit these 3 lines of code in the main according to the location of your files and where you want the output to be saved:
```
FileReader file1 = new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv");
FileReader file2 = new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_2.csv");
String path = "/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/";
```
4. For the test outputs using sample_file_1.csv and sample_file_2.csv, you can find it in the ./Week8 folder named "comparisondata1_2.csv"

5. For the test outputs using sample_file_1.csv and sample_file_2.csv, you can find it in the ./Week8 folder named "comparisondata.csv"

6. Also do remember to change the file name of your output in the compareCSV method here!

```
try{
            FileWriter fileWriter = new FileWriter(path+"**OUTPUT FILE NAME WITH EXTENSION**");
            for(int i=0; i<file3Content_size; i++){

            };
```

## Week 9

#### Equivalence Classs Paritioning

|   	|  Invalid   |   Valid	|
|---	|---	|---	|
|   no. of files 	|   <2 or >2 ".csv" files or non ".csv" files in the input	|   2 ".csv" files	|
|   path	|   non-existent path or directory (ex. "Desktop#files#week9")	|   path that is existent  (ex. "Desktop/files/week9")         |
|   rows in the files 	|   if no. of rows in file1.csv != file2.csv	            |   no. of rows in file1.csv = file2.csv	|
| column headers        |  column headers != ["Customer ID", "Account No.", "Currency", "Type", "Balance"] | column headers are["Customer ID", "Account No.", "Currency", "Type", "Balance"] |

#### Boundary Values

##### CSV Files

##### Path
