import java.util.ArrayList;
import java.util.Scanner;

// Names: Shane Smith, Chad Green
// Purpose: Calculate Hailstone sequence for every number down starting from a user defined number

public class Driver {
    public static ArrayList<ArrayList> driverValues;
    public static long driver;
    public static int large;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        driverValues = new ArrayList<>();

        // Get driver value
        System.out.print("Please enter the largest number: ");
        driver = input.nextLong();

        for(long i=1; i<=driver; i++) {
            // Create hailstone object and run recursive calculation
            Hailstone hail = new Hailstone(i);

            // Store hailstone arraylist in arraylist
            driverValues.add(hail.values);
        }
        //printArray();
        findLargest(); // Find largest hailstone sequence
        printValues(); // Print the lengths of every hailstone sequence
    }

    // Figure out what hailstone inside the arraylist has the longest sequence
    public static void findLargest(){
        int temp = 0;

        // Loop through all hailstone sequences & find the largest
        for (int i = 0; i < driverValues.size(); i++) {
            if (driverValues.get(i).size() > temp) {
                large = i;
                temp = driverValues.get(i).size();
            }
        }

        // Print largest sequence length & what number it started with
        System.out.println("The longest sequence was " + temp + " starting with " + driverValues.get(large).get(0));
    }

    // Print arraylist of every hailstone pass
    public static void printArray(){
        for (int i = 0; i < driverValues.size(); i++) {
            System.out.println(driverValues.get(i) + " ");
        }
    }

    // Print arraylist of every hailstone pass
    public static void printValues(){
        if(!driverValues.get(large).isEmpty()) {
            System.out.println(driverValues.get(large).get(0)); // Print Values
            driverValues.get(large).remove(0); // Remove first index

            printValues();
        }
    }
}