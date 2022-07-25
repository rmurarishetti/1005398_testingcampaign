import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;

public class Week8CSVTest {

    //Checks for FileNotFoundException
    @Test
    public void verifyFileNotFoundExeption() throws IOException {
        File file2 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_2.csv");
        String path = "/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/";
        assertThrows(FileNotFoundException.class, () -> {Week8CSV.compareCSV(new File(""),file2,path);});
    }

    //Checks CSV Headers for Output
    @Test
    public void compareHeaders() throws Exception {
        File file1 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv");
        File file2 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_3.csv");
        String path = "/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/";
        Week8CSV.compareCSV(file1, file2, path);
        BufferedReader testoutput = new BufferedReader(new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/comparsiondata.csv"));
        BufferedReader functionoutput = new BufferedReader(new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/outputcomparison.csv"));
        assertEquals(testoutput.readLine(), functionoutput.readLine());
    }

    //Failure if wrong file extension is given
    @Test
    public void wrongFileType() throws Exception {
        File file1 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/W8Q1.jpeg");
        File file2 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_3.csv");
        String path = "/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/";
        assertFalse(Week8CSV.compareCSV(file1,file2,path));
    }

    @Test
    public void nonExistentPath(){
        File file1 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv");
        File file2 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_2.csv");
        assertThrows(IOException.class,()->{Week8CSV.compareCSV(file1, file2, "/Users/userdoesntdoesntexist/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/");});
    }

}
