import java.util.ArrayList; // import the ArrayList class

public class Hailstone {
    public static ArrayList<Long> values;

    public Hailstone(long value) {
        // Ensure that the value being entered into hailstone is at least 1
        if (value <= 0) {
            value = 1;
        }
        values = new ArrayList<>(); // Create an ArrayList object
        Hailstone.sequence(value); // Start recursive call w/ entered values
    }
    public static void sequence(long curValue) {
        if (curValue != 1) { // While value isn't 1 do calculations
            if (curValue % 2 == 0) { // If even divide by 2
                values.add(curValue);
                curValue = curValue / 2;
            }
            else { // If odd multiply by 3 and add 1
                values.add(curValue);
                curValue = (curValue * 3) +1;
            }
            Hailstone.sequence(curValue);
        }
        else {
            values.add(1L); // Add value of one
        }
    }
}