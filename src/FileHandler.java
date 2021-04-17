import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileHandler {
    private static final String path = "D:\\Programing\\TA-JAVA\\JamesBand\\src\\Resource\\validWord.txt";
    private final Set<String> validWords ;

    public FileHandler() {
        validWords = new HashSet<>();
        extractData();
    }

    private void extractData() {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                validWords.add(s);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Set<String> getValidWords() {
        return validWords;
    }
}
