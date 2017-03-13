import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.*;

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

        //OPEN THE INPUT FILE

        //let's get a filename from the user (this is a shortcut for dealing with file paths)
        final JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        //TODO: logic do deal with user "mistakes"
        /*
        the line below demonstrates "method call chaining" in java.
        .getAbsolutePath() is being called on an object returned by getSelectedFile()
         */
        String inputFileName = fileChooser.getSelectedFile().getAbsolutePath();
        System.out.println("user chose file: " + inputFileName);

        //file operations can throw exceptions (think of what could go wrong...)
        //use the try-catch approach
        try{
            FileReader fileReader = new FileReader(inputFileName);
            inputStream = new BufferedReader(fileReader);
            System.out.println("input file was opened successfully");
        } catch (IOException e){
            e.printStackTrace();
        }


        //OPEN OUTPUT FILE
        //use a buffered stream writer of some kind
        try{
            //demonstrate instantiating an "anonymous object" in the constructor call to PrintWriter
            outputStream = new PrintWriter(new FileWriter("output_data.txt"));
            /*
            use a loop to iterate through each line of the data and turn everything lowercase into uppercase
            read in lines from the input file until the end of file is reached
            each line will be stored in a variable "lineOfData"
             */
            String lineOfData;
            //loop until the end of file is reached (inputStream.readline() will return null)
            while((lineOfData = inputStream.readLine()) != null){ //note: inputStream.readLine() will get the next line of data
                //at this point in execution lineOfData already stores the next line
                //we can be certain it's not null, because of the while() condition above

                //let's transform the input as required
                String temp = lineOfData.toUpperCase();
                //display for debugging
                System.out.println("DEBUG:" + temp);
                //write to the output file
                outputStream.println(temp);
            }
            //once we're done, flush the buffer
            outputStream.flush();
            //close files when finished to avoid corrupted data
            inputStream.close();
            outputStream.close();


        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
