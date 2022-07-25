import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Week8CSVTest {
    @Test
    public void verifyFileNotFoundExeption() throws IOException {
        FileReader file2 = new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_2.csv");
        String path = "/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/";
        assertThrows(FileNotFoundException.class, () -> {Week8CSV.compareCSV(new FileReader(""),file2,path);});
    }

    @Test
    public void compareOutput() throws Exception {
        FileReader file1 = new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv");
        FileReader file2 = new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_3.csv");
        String path = "/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/";
        Week8CSV.compareCSV(file1, file2, path);
        BufferedReader testoutput = new BufferedReader(new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/comparsiondata.csv"));
        BufferedReader functionoutput = new BufferedReader(new FileReader("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/outputcomparison.csv"));
        assertEquals(testoutput, functionoutput);
    }

}
