import java.io.*;
public class FileTest {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("abc.txt");
        fw.write(100);
        fw.write("abc\ndef");
        fw.write(new char[] {'w', 'q', 'e'});

        fw.flush();
        fw.close();
    }


}
