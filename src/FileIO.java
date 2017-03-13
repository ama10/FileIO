import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * This program opens a data file (text) using the character stream classes.
 * these (reusable) classes are seen throughout the Java API
 * they have other uses beyond these simple examples
 * check them out in the Java API - especially if they are mentioned by other classes you want to use
 *
 * this program will convert lower case text data to upper case text and writes the data to another file
 * @author marek
 */
public class FileIO {

    public static void main(String[] args){
        //declare references for the appropriate buffered IO stream objects
        //BufferedReader is for input
        BufferedReader inputStream =null;
        //also a buffered stream for output
        PrintWriter outputStream = null;

        //let's get a filename from the user (this is a shortcut for dealing with file paths)
        final JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        //TODO: logic do deal with user "mistakes"
        String inputFileName = fileChooser.getSelectedFile().getAbsolutePath();
        System.out.println("user chose file: " + inputFileName);

        

    }
}
