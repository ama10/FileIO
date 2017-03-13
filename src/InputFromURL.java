import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * this program shows how to open a URL (as in a web-resource) and read data from it.
 * in this example we'll open up an HTML file (which we will learn is a type of XML)
 * as an exercise to you, use the XML parsing code (we'll learn later) to parse the XML returned here
 * @author marek
 */
public class InputFromURL {

    //demonstrate's the "pass the buck" approach to exceptions
    public static void main(String[] args) throws IOException{
        //look! no try-catch blocks here

        URL myURL = new URL("https://en.wikipedia.org/wiki/Java_(programming_language)");
        System.out.println("DEBUG: connecting to: " + myURL.toString());

        //instantiate an object to represent the URL connection
        URLConnection urlConnection = myURL.openConnection();
        //use the standard (buffered) stream classes to interact with the data source
        //notice, the approach is roughly the same regardless of the data source
        //this lets us re-use our code regardless of the data source!
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String inputLine;
        while(( inputLine = inputReader.readLine() ) != null ){
            //for now just display the data, but you can do whatever you want with it instead
            System.out.println(inputLine);
        }
        //once done, close the input stream
        inputReader.close();
    }
}
