package Acqquilaa;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class csvCompare {
    public static int main() throws IOException {
        String row_in_first;
        String row_in_second;
        int mismatches=0;
        List<List<String>> records_first = new ArrayList<>();
        List<List<String>> records_second = new ArrayList<>();
        List<List<String>> store_different = new ArrayList<>();


        try {
            BufferedReader first_file = new BufferedReader(new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv"));
            while ((row_in_first = first_file.readLine()) != null) {
                String[] first_excel_data = row_in_first.split(",");
                records_first.add(Arrays.asList(first_excel_data));
            }
            first_file.close();
            BufferedReader second_file = new BufferedReader(new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/input_file_1.csv"));
            while ((row_in_second = second_file.readLine()) != null) {
                String[] second_excel_data = row_in_second.split(",");
                records_second.add(Arrays.asList(second_excel_data));
            }
            second_file.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < records_first.size(); i++) {
            if (records_first.get(i) != records_second.get(i)) {
                mismatches++;
                store_different.add(records_first.get(i));
                store_different.add(records_second.get(i));
                System.out.println(records_first.get(i));
                System.out.println(records_second.get(i));
            } else {
                continue;
            }
        }
        File newFile = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/Acquilaa.csv");
        FileWriter fw = new FileWriter(newFile);
        BufferedWriter outputCSV = new BufferedWriter(fw);

        for (int k = 0; k < store_different.size(); k++) {
            outputCSV.write(String.valueOf(store_different.get(k+1)) + "," + store_different.get(k++));
            outputCSV.newLine();
        }
        outputCSV.close();
        return mismatches;
    }
}
