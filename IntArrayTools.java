
/**
 * A variety of tools for working with integer arrays.
 * Everything here is static.
 */

import java.util.Scanner;
import java.io.*;

public class IntArrayTools
{
    /** Opens the file fileName for input. 
     *  PRECONDITION: The file should be a text file organized as follows:
     *  -- The first line is the number of test cases in the file.
     *  -- After that, each case takes up two lines.
     *      -- The first line is the length of the next array to test
     *      -- The next line is the data in that array. There should be exactly as many items
     *         as listed in the previous line.
     *         
     *  @param   fileName  the name of the file to open for input
     *  @return  a Scanner object connected to the file
     */
    public static Scanner openFile (String fileName)
    {
        File file = new File(fileName);
        Scanner sourceFile = null;
        try
        {
            sourceFile = new Scanner(file);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + fileName + " ***");
            System.exit(1);        // quit the program
        } 
    
        return sourceFile;
    }

    
    
    public static void main (String[] args)
    {
        Scanner dataFile = openFile ("ArrayData.txt");
        
        int numExamples = dataFile.nextInt(); // How many examples are there in the file?
        String dummy = dataFile.nextLine();   // Clears the input line
        
        System.out.println("Running " + numExamples + " examples.");
        // Run through each of the examples.
        for (int i = 1; i <= numExamples; i++)
        {
            System.out.println("Example #" + i);
            // The next line says how large the coming array is
            int arraySize = dataFile.nextInt();
            dummy = dataFile.nextLine();
            
            // Read in the array
            
            
            // Do something with the array
            
            
        }        
        
        // Put away your things when you are done.
        dataFile.close();
    }
}
