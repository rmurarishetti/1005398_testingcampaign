package com.example.testingcampaign;


import java.io.*;
import java.util.ArrayList;

public class Week8CSV {
    public static void main(String[] args) {
        try{
        FileReader file1 = new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv");
        FileReader file2 = new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_3.csv");
        String path = "/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/";
        compareCSV(file1, file2, path);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void compareCSV(FileReader file1, FileReader file2, String path) throws IOException {
        BufferedReader file1Reader = new BufferedReader(file1);
        BufferedReader file2Reader = new BufferedReader(file2);
        ArrayList file1Content = new ArrayList();
        ArrayList file2Content = new ArrayList();
        ArrayList file3Content = new ArrayList();

        String file1Rows = file1Reader.readLine();
        String file2Rows = file2Reader.readLine();

        while(file1Rows!=null){
            String[] fileArray1 = file1Rows.split("\n");
            for (String str1: fileArray1){
                file1Content.add(str1);
            }
            file1Rows = file1Reader.readLine();
        }
        file1Reader.close();

        while(file2Rows!=null){
            String[] fileArray2 = file2Rows.split("\n");

            for (String str2: fileArray2){
                file2Content.add(str2);
            }
            file2Rows = file2Reader.readLine();
        }
        file2Reader.close();

        for(Object bs:file1Content)
        {
            if(!file2Content.contains(bs)){
                file3Content.add(bs);
                file3Content.add(file2Content.get(file1Content.indexOf(bs)));
            }
        }

        int file3Content_size = file3Content.size();
        try{
            FileWriter fileWriter = new FileWriter(path+"comparsiondata.csv");
            for(int i=0; i<file3Content_size; i++){
                fileWriter.append(""+file3Content.get(i));
                fileWriter.append("\n");
            }
            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
