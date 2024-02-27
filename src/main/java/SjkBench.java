

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.gridkit.jvmtool.stacktrace.StackTraceCodec;
import org.gridkit.jvmtool.stacktrace.StackTraceReader;

public class SjkBench {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        while(true) {
            long ts = System.nanoTime();
            process();
            long time = System.nanoTime() - ts;
            System.out.println("Processing time - " + TimeUnit.NANOSECONDS.toMillis(time) + "ms");
        }
    }

    public static void process() throws FileNotFoundException, IOException {
        StackTraceReader str = StackTraceCodec.newReader(new FileInputStream(new File("src/main/resources/jboss-10k.std")));
        while(str.loadNext()) {};
    }
}
