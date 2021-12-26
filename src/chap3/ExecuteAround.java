package chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {

    public static void main(String[] args) throws Exception{

        String result = processFileLimited();
        System.out.println(result);

        System.out.println("==========================");

        String oneLines = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLines);

        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(twoLines);
    }

    public static String processFileLimited() throws Exception{
        try (BufferedReader br = new BufferedReader(new FileReader("src/chap3/data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcess p) throws Exception{
        try (BufferedReader br = new BufferedReader(new FileReader("src/chap3/data.txt"))) {
            return p.process(br);
        }
    }

    public interface BufferedReaderProcess {
        public String process(BufferedReader br) throws IOException;
    }
}

