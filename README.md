# Testing Campaign Tasks
### Name: Rohit Raghuram Murarishetti, Student ID: 1005398
## Week 8
Hello!

You can find the task 1 - use case diagram in the Week 8 folder in the main branch!
You will also find the CSV files used to test the task 2 code in the same folder.


#### Getting Started:
1. Clone this repository

2. Navigate to the "./TestingCampaignCode/src/Week8CSV.java"

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

##### Path
1. Valid - "./files/week9" (relative path, middle value)
2. Valid - "/Users/rmurarishetti/Downloads/ISTD/Term5/ESC/CohortExercises/Week9/Readme.md" (absolute path, boundary)
3. Invalid - "$/\Desktop##file^^^Week9" (middle value)
4. Invalid - "./1005398_testingcampaign/\readme.md" (only one extra "\", boundary value)

##### CSV

|   | Invalid   | Valid  |
|---|---|---|
| Middle Value  |   <img width="1371" alt="Screenshot 2022-07-18 at 3 16 50 PM" src="https://user-images.githubusercontent.com/64725000/179463331-c63fb077-4da0-4a53-aeff-7529245251fc.png"> |  <img width="328" alt="Screenshot 2022-07-18 at 3 08 12 PM" src="https://user-images.githubusercontent.com/64725000/179463058-1baa3226-0a78-4c69-9ddf-7f4049b4056c.png"> |
| Boundary Value  |  <img width="330" alt="Screenshot 2022-07-18 at 3 08 23 PM" src="https://user-images.githubusercontent.com/64725000/179463401-1847cdee-d3e4-47ef-a48f-1fa52234df15.png"> | <img width="328" alt="Screenshot 2022-07-18 at 3 08 12 PM" src="https://user-images.githubusercontent.com/64725000/179463058-1baa3226-0a78-4c69-9ddf-7f4049b4056c.png"> |
| Reason  | In the invalid middle value, there's vastly different column headers | In the boundary valid and invalid values, the rows differ by just 1 unit   |

|   | Invalid  | Valid  |
|---|---|---|
|  Middle Value | -  |  <img width="324" alt="Screenshot 2022-07-18 at 3 13 58 PM" src="https://user-images.githubusercontent.com/64725000/179464133-b4e94db6-1d98-4249-938f-9d563a577161.png">|   
| Boundary Value  |  <img width="413" alt="Screenshot 2022-07-18 at 3 13 50 PM" src="https://user-images.githubusercontent.com/64725000/179464198-d970c9ee-8df1-4992-928e-6b67925e7f5c.png">|  - |
| Reasons  | The boundary invalid value is just having one extra column as compared to the middle valid value (i.e different column header)  |  The column headers are as specified in the equivalence class partitioning |

|   |  Invalid |  Valid |
|---|---|---|
| Middle Value  |  ".pdf" file extension | ".csv" file extension  |
| Boundary Value  | ".xlsx" file extension |  ".csv" file extension |
|  Reason | The .pdf file is vastly different from .csv type file and hence is a middle value  |  The .csv file can be extracted from a .xlsx file and parsed through, hence is a boundary invalid value |

## Week 10

1. For running the unit tests, open the repository in Intellij or Visual Studio Code.

2. Navigate to "./TestingCampaignCode/src/Week8CSVTest.java"

3. Verify the above mentioned boundary conditions and system tests as specified.

4. For running the parameterized tests, navigate to "./TestingCampaignCode/src/ComparisonParameterizedTest.java" or "./TestingCampaignCode/src/ExtensionParameterizedTest.java"

5. The former compares the function outputs with real outputs of files sample_file_1.csv and sample_file_2.csv, sample_file_1.csv and sample_file_3.csv. The latter checks the file extension of the input files.

## Week 13

The fuzzing file can be found in the "./TestingCampaignCode/src/FeedbackFuzzing.java"

After fuzzing the input csvs and checking comparison for 10K iterations, the Week8CSVCompare.java hasn't failed.
It has been tested for its robustness.

For running the fuzzer, follow the steps below

1. Navigate to "./TestingCampaignCode/src/FeedbackFuzzing.java"

2. Run the main method in the file and observe the feedback in the terminal.

3. In Week 8 foler, you can see the mismatches from the fuzzedComparison1, it is the comparison between sample_file_1 and input_file_1.
   You can also see the mismatches from the fuzzedComparison3, it is the comparison between sample_file_3 and input_file_3.
