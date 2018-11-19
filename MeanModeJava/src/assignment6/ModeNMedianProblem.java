/*
 * Accepts Array of String or Integer and provides methods to return the mode and median
 * Note: Do not attempt to treat odd and even number of items differently.
 *
 CSIS 312 Assignment 6
* @Isaac Craig & Nick Romnano
* 
* - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
* - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
* - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted *   with a proper citation in the comments of my program. 
* - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce     apparently correct results when in fact it does not.
*
**/
package assignment6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModeNMedianProblem<E extends Comparable<? super E>> {

    private E median, mean;

    ModeNMedianProblem(E[] inputArray) {
        orderList(inputArray);
        printArray(inputArray);
        medianList(inputArray);
        modeList(inputArray);
    }

    // You'll need this
    // Sort your list with Collections.sort(elements, new GenericComparator());
    private class GenericComparator implements Comparator<E> {

        @Override
        public int compare(E o1, E o2) {
            if (o1.getClass() == Integer.class) {
                Integer v1 = (Integer) o1;
                Integer v2 = (Integer) o2;
                return v1.compareTo(v2);
            } else if (o1.getClass() == String.class) {
                String v1 = (String) o1;
                String v2 = (String) o2;
                return v1.compareTo(v2);
            } else {
                throw new IllegalArgumentException("Classes of type " + o1.getClass().toGenericString() + " are not supported.");
            }
        }
    }

    // generic order list
    public <E> void orderList(E[] inputArray) {
        List listS = Arrays.asList(inputArray);
        Collections.sort(listS, new GenericComparator());
    }

    //generic median
    public <E> void medianList(E[] inputArray) {
        int size = (inputArray.length / 2);
        System.out.println("Median:  " + inputArray[size]);
    }

    //generic mode
    public <E extends Comparable<? super E>> void modeList(E[] inputArray) {
        HashMap<E, Integer> frequency = new HashMap<>();
        // Sets the values in the HasMap****************************************
        for (int i = 0; inputArray.length > i; i++) {
            int val = 0;
            for (int iterator = 0; inputArray.length > iterator; iterator++) {
                if (inputArray[i] == inputArray[iterator]) {
                    frequency.put(inputArray[i], val++);
                }
            }
        }
        //**********************************************************************
    
        // Finds and prints the highest value in the HashMap********************
        E highestMap = null;
        int highestVote = 0;
        for (Map.Entry<E, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > highestVote) {
                highestMap = entry.getKey();
                highestVote = entry.getValue();
            }
        }
        System.out.println("Mode: " + highestMap);
        //**********************************************************************
    }

    // generic print method
    public static <E> void printArray(E[] inputArray) {
        // display array elements***********************************************
        System.out.printf("List: [ ");
        for (E element : inputArray) {
            System.out.printf("%s, ", element);
        }
        System.out.printf("]");
        System.out.println();
        //**********************************************************************
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] s = {"and", "an", "the", "my", "but", "may", "an", "the", "the"};
        Integer[] x = {1, 5, 9, 2, 4, 3, 7, 100, 2};

        ModeNMedianProblem mn1 = new ModeNMedianProblem(s);
        mn1 = new ModeNMedianProblem(x);

        /*
        Should Produce:
            List: [an, an, and, but, may, my, the, the, the]
            Median: may
            Mode: the
            List: [1, 2, 2, 3, 4, 5, 7, 9, 100]
            Median: 4
            Mode: 2
         */
    }
}
