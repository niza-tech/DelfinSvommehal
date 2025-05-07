package File;

import java.io.File;
import java.io.IOException;

public class FileHandling {
    public static void createFile(String path) {
        try {
            File fil = new File(path);
            if (fil.createNewFile()) {
                System.out.println("File created: " + fil.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}
