package Yogesh;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Yogesh_FeedbackFuzzing {
    public static String generateRandomString(int len){
        // len is the length of the random string generated by this function
        byte[] array = new byte[len];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
    public static int mutateCSV(File file, int errno) throws IOException {

        File fileInput = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/input_file_1.csv");
        FileWriter fileWriter = new FileWriter(fileInput);
        fileWriter.append("\"Customer ID#\",\"Account No.\",\"Currency\",\"Type\",\"Balance\"\n");

        Scanner sc = new Scanner(file);
        int numMutations = 0;
        int counter = 0;
        boolean [] fallacy = {false, true};
        while (sc.hasNext()){

            if (counter<3){
                counter++;
                sc.next();
            }
            else{
                boolean falseLine = fallacy[new Random().nextInt(2)]; // to choose true or false
                if (falseLine && errno > 0){ // if you want to insert false line here, then errno must be > 0 and the falseLine must be true
                    String lineRandom = generateRandomString(10);
                    String line = sc.next().split(",")[0];
                    String mutation = line+","+lineRandom;
                    fileWriter.append(mutation);
                    fileWriter.append("\n");
                    errno--;
                    numMutations++;
                }
                else { // otherwise
                    String line = sc.next();
                    fileWriter.append(line);
                    fileWriter.append("\n");
                }
            }
        }
        sc.close();
        fileWriter.flush();
        fileWriter.close();

        return numMutations;


    }


    public static void mutationFuzzer() throws Exception{
        File file1 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv");
        File file2 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv");
        File mutatedInput = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/input_file_1.csv");

        int flag = 0;

        int FuzzingIterations = 1000; //running fuzzer integer times
        for (int i= 0 ; i< FuzzingIterations; i++){
            System.out.println("\n\nIteration "+ i);
            int numberOfMutations = mutateCSV(file1, i);
            int realMismatches = Reader.main();
            if (numberOfMutations!=realMismatches){
                flag=1;
            }
            System.out.println("\nNumber of mismatches: "+ realMismatches + "\nNumber of mutations : "+ numberOfMutations);
        }
        if (flag == 0){
            System.out.println("\n\nCode runs perfectly!");
        }
        else{
            System.out.println("\n\nYour code needs refinement as the fuzzer has found an error!");
        }
    }

    public static void main(String[] args) throws Exception{
        mutationFuzzer();
    }
}
