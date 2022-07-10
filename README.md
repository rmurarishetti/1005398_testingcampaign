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

6. Also do remember to change the file name of your output here!
'''
FileWriter fileWriter = new FileWriter(path+"**OUTPUT FILE NAME WITH EXTENSION**");
'''
