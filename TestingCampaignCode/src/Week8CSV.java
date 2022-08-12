
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

import static java.lang.System.exit;


public class Week8CSV {
    public static void main(String[] args) {
        try{
            File file1 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv");
            File file2 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_2.csv");
            String path = "/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/";
            compareCSV(file1, file2, path);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean compareCSV(File file1, File file2, String path) throws Exception {
        FileReader file1_reader = new FileReader(file1);
        FileReader file2_reader = new FileReader(file2);

        if (checkExtensionOfFile(file1)&&checkExtensionOfFile(file2)) {
            BufferedReader file1Reader = new BufferedReader(file1_reader);
            BufferedReader file2Reader = new BufferedReader(file2_reader);
            Integer file1length, file2length;
            ArrayList file1Content = new ArrayList();
            ArrayList file2Content = new ArrayList();
            ArrayList file3Content = new ArrayList();

            String file1Rows = file1Reader.readLine();
            String file2Rows = file2Reader.readLine();

            file1length = 0;
            while (file1Rows != null) {
                String[] fileArray1 = file1Rows.split("\n");
                for (String str1 : fileArray1) {
                    file1Content.add(str1);
                }
                file1Rows = file1Reader.readLine();
                file1length++;
            }
            file1Reader.close();

            file2length = 0;
            while (file2Rows != null) {
                String[] fileArray2 = file2Rows.split("\n");

                for (String str2 : fileArray2) {
                    file2Content.add(str2);
                }
                file2Rows = file2Reader.readLine();
                file2length++;
            }
            file2Reader.close();

            if (file1length.equals(file2length)) {
                for (Object bs : file1Content) {
                    if (!file2Content.contains(bs)) {
                        file3Content.add(bs);
                        file3Content.add(file2Content.get(file1Content.indexOf(bs)));
                    }

                }

                int file3Content_size = file3Content.size();


                FileWriter fileWriter = new FileWriter(path + "outputComparison.csv");

                for (int i = 0; i < file3Content_size; i++) {
                    fileWriter.append("" + file3Content.get(i));
                    fileWriter.append("\n");
                }
                fileWriter.flush();
                fileWriter.close();
                System.out.println("Successfully Written");


            } else {
                System.out.println("File Length Not Same");
                return false;
            }
        }
        else{
            System.out.println("Wrong File Extensions");
            return false;
        }
        return true;
    }

    public static Boolean checkExtensionOfFile(File file)
    {
        String fileExtension="";
        // Get file Name first
        String fileName=file.getName();

        // If fileName do not contain "." or starts with "." then it is not a valid file
        if(fileName.contains(".") && fileName.lastIndexOf(".")!= 0)
        {
            fileExtension=fileName.substring(fileName.lastIndexOf(".")+1);
        }

        return fileExtension.equals("csv");

    }

    public static int getMismatches(File file1, File file2, String path) throws IOException {
        int mismatches = 0;
        FileReader file1_reader = new FileReader(file1);
        FileReader file2_reader = new FileReader(file2);

        if (checkExtensionOfFile(file1)&&checkExtensionOfFile(file2)) {
            BufferedReader file1Reader = new BufferedReader(file1_reader);
            BufferedReader file2Reader = new BufferedReader(file2_reader);
            Integer file1length, file2length;
            ArrayList file1Content = new ArrayList();
            ArrayList file2Content = new ArrayList();
            ArrayList file3Content = new ArrayList();

            String file1Rows = file1Reader.readLine();
            String file2Rows = file2Reader.readLine();

            file1length = 0;
            while (file1Rows != null) {
                String[] fileArray1 = file1Rows.split("\n");
                for (String str1 : fileArray1) {
                    file1Content.add(str1);
                }
                file1Rows = file1Reader.readLine();
                file1length++;
            }
            file1Reader.close();

            file2length = 0;
            while (file2Rows != null) {
                String[] fileArray2 = file2Rows.split("\n");

                for (String str2 : fileArray2) {
                    file2Content.add(str2);
                }
                file2Rows = file2Reader.readLine();
                file2length++;
            }
            file2Reader.close();


            for (Object bs : file2Content) {
                if (!file1Content.contains(bs)) {
                        mismatches++;
                }
            }

        }
        else{
            System.out.println("Wrong File Extensions");
            return -1;
        }
        return mismatches;
    }

}