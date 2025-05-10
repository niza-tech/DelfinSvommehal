package File;

import java.io.File;
import java.io.FileWriter;
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

    public static void gemResultat(String registrering){
        try {
            FileWriter writer = new FileWriter("resultater.txt", true);
            writer.write(registrering + "\n");
            writer.close();
            System.out.println("Resultat blev gemt!");
        } catch (IOException e) {
            System.out.println("Der opstod en fejl ved filskrivning.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String path, String tekstTilFil){
        try {
            FileWriter myWriter = new FileWriter(path, true);
            myWriter.write(tekstTilFil);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
