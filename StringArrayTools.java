
/**
 * A variety of tools for working with arrays of Strings.
 * Everything here is static.
 */

import java.util.Scanner;
import java.io.*;

public class StringArrayTools
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

    // Prints the array in nice brackets with commas.
    public static void printArray(String[] words)
    {
        String str = "[";
        
        for (int i = 0; i < words.length - 1; i++)
        {
            str += words[i] + ", ";
        }
        str += words[words.length - 1] + "]";
        
        System.out.println(str);
    }
    
        
    
    public static int linearSearch (int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    
    /* PRECONDITION: List is sorted from lowest to highest! */
    public static int binarySearch (int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;
        int guess;
        while (high >= low)
        {
            guess = (low + high) / 2;
            if (nums[guess] == target)
            {
                return guess;
            }
            else if (nums[guess] > target)
            {
                high = guess - 1;
            }
            else
            {
                low = guess + 1;
            }
        }
        return -1;
    }

    
    public static void main (String[] args)
    {
        Scanner dataFile = openFile ("StringArrayData.txt");
        
        int numExamples = dataFile.nextInt(); // How many examples are there in the file?
        String dummy = dataFile.nextLine();   // Clears the input line
        
        System.out.print("Search for what word: ");
        Scanner kbd = new Scanner(System.in);
        String target = kbd.nextLine();
        
        System.out.println("Running " + numExamples + " examples.");
        // Run through each of the examples.
        for (int i = 1; i <= numExamples; i++)
        {
            System.out.println("\nExample #" + i);
            // The next line says how large the coming array is
            int arraySize = dataFile.nextInt();
            dummy = dataFile.nextLine();
            
            // Read in the array
            String[] myArray = new String[arraySize];
            for (int k = 0; k < arraySize; k++)
            {
                myArray[k] = dataFile.nextLine();
            }
            
            // Do something with the array
            printArray(myArray);
            
            //System.out.println("Linear search: Location of " + target + " is index " + linearSearch(myArray, target));
            //System.out.println("Binary search: Location of " + target + " is index " + binarySearch(myArray, target));
            
        }        
        
        // Put away your things when you are done.
        dataFile.close();
        kbd.close();
    }
}
