package Yogesh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

    public class Reader {
        public static ArrayList<Entry> sort(String Path) {

            ArrayList<Entry> entries = new ArrayList<>();
            String currentLine;

            try {
                BufferedReader br = new BufferedReader(new FileReader(Path));
                while ((currentLine = br.readLine())!=null) {
                    String[] values = currentLine.split(",");
                    if (values[0].equals("\"ID#\"")) {
                        continue;
                    }
                    String id = values[0].substring(1, values[0].length()-1);
                    String accountNo = values[1].substring(1, values[1].length()-1);
                    String currency = values[2].substring(1, values[2].length()-1);
                    String type = values[3].substring(1, values[3].length()-1);
                    String balance = values[4].substring(1, values[4].length()-1);
                    entries.add(new Entry(id,accountNo,currency,type,balance));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Collections.sort(entries);
            return entries;
        }

        public static int main() {



            int mismatches = 0;

            String line1 = "";
            String line2 = "";

            try {
                File csvFile = new File("exceptions.csv");
                PrintWriter out = new PrintWriter(csvFile);
                BufferedReader br1 = new BufferedReader(new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv"));
                BufferedReader br2 = new BufferedReader(new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/input_file_1.csv"));


                // assume both files same number of rows first
                while ((line1=br1.readLine())!=null && (line2=br2.readLine())!=null) {
                    String[] values1 = line1.split(",");
                    String[] values2 = line2.split(",");
                    if (!Arrays.equals(values1, values2)) {
                        mismatches++;
                        System.out.print(Arrays.toString(values1));
                        System.out.println(Arrays.toString(values2));
                    }
                }
                br1.close();
                br2.close();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return mismatches;
        }
    }
