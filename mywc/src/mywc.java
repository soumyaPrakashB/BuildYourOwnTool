import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Objects;

public class mywc {

    static File f;

    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("display help page");
        } else if(args[0].charAt(0) == '-') {
            if(args.length < 2) {
                System.out.println("Please enter a file");
                System.exit(0);
            }
            handleOptions(args);
        } else {
            File f = new File(args[0]);
            if(f.exists()) {
                System.out.println(f.length() + " " + f.getName());
            }
        }
    }

    private static void handleOptions(String[] args) throws IOException {
        if(Objects.equals(args[0], "-c")) {
            f = new File(args[1]);
            if(f.exists()) {
                System.out.println(f.length() + " " + f.getName());
            } else {
                System.out.println(args[1] + ": " + "No such file or directory");
            }
        } else if(args[0].equals("-l")) {
            f = new File(args[1]);
            if(f.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(f));

                int lineCount = 0;

                while(br.readLine() != null) {
                    System.out.println(br.readLine());
                    lineCount++;
                }
                br.close();

                System.out.println(lineCount + " " + f.getName());
            } else {
                System.out.println(args[1] + ": " + "No such file or directory");
            }
        } else if(args[0].equals("-w")) {
            f = new File(args[1]);
            if(f.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(f));

                int wordCount = 0;

                String s = br.readLine();

                while(s != null) {
                    wordCount += s.split("\\s+").length;
                    s = br.readLine();
                }
                br.close();

                System.out.println(wordCount + " " + f.getName());
            } else {
                System.out.println(args[1] + ": " + "No such file or directory");
            }
        } else if(args[0].equals("-m")) {
            f = new File(args[1]);
            if(f.exists()) {
                FileReader fr = new FileReader(f);

                int charCount = 0;

                int i = fr.read();

                while(i != -1) {
                    charCount++;
                    i = fr.read();
                }
                fr.close();

                System.out.println(charCount + " " + f.getName());
            } else {
                System.out.println(args[1] + ": " + "No such file or directory");
            }
        }
    }
}
