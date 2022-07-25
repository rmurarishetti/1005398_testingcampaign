import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.File;
import java.util.*;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ExtensionParameterizedTest {
    public File file;

    public ExtensionParameterizedTest(File file){
        this.file = file;
    }

    @Parameters public static Collection<Object[]> parameters() {
        return Arrays.asList (new Object [][] {{new File("./Week8/Comparsiondata.csv")}, {new File("./Week8/outputComparison.csv")}, {new File("./Week8/sample_file_1.csv")}});
    }

    @Test
    public void checkExtension(){
        assertTrue(Week8CSV.checkExtensionOfFile(file));
    }

}
