import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ComparisonParameterizedTest {
    public File file1, file2, testOutput;
    public String path;

    public ComparisonParameterizedTest(File file1, File file2, File testOutput, String path){
        this.file1 = file1;
        this.file2 = file2;
        this.testOutput = testOutput;
        this.path = path;
    }

    @Parameters public static Collection<Object[]> parameters() {
        File sample_file1 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_1.csv");
        File sample_file2 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_2.csv");
        File sample_file3 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/sample_file_3.csv");
        File testOutput = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/comparsiondata.csv");
        File testOutput2 = new File("/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/comparsiondata1_2.csv");
        String path = "/Users/rmurarishetti/Documents/ISTD Term 4/1005398_testingcampaign/Week 8/";
        return Arrays.asList (new Object [][] {{sample_file1, sample_file3, testOutput, path}, {sample_file1,sample_file2,testOutput2, path}});
    }

    @Test public void checkOutput() throws Exception {
        Week8CSV.compareCSV(file1, file2, path);
        assertTrue(outputEquals(testOutput, new File(path+"outputComparison.csv")));
    }

    private boolean outputEquals(File testOutput, File realOutput) throws IOException {
        BufferedReader testOutputReader = new BufferedReader(new FileReader(testOutput));
        BufferedReader realOutputReader = new BufferedReader(new FileReader(realOutput));

        ArrayList testOutputContent = new ArrayList();
        ArrayList realOutputContent = new ArrayList();

        String testOutputRows = testOutputReader.readLine();
        String realOutputRows = realOutputReader.readLine();

        while (testOutputRows != null) {
            String[] testArray = testOutputRows.split("\n");
            for (String str1 : testArray) {
                testOutputContent.add(str1);
            }
            testOutputRows = testOutputReader.readLine();
        }
        testOutputReader.close();

        while (realOutputRows != null) {
            String[] realArray = realOutputRows.split("\n");
            for (String str1 : realArray) {
                realOutputContent.add(str1);
            }
            realOutputRows = realOutputReader.readLine();
        }
        realOutputReader.close();

        return Objects.equals(testOutputRows, realOutputRows);
    }
}
