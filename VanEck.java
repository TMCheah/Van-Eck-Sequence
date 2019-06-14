package vaneck;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author TMCheah
 */
public class VanEck {

    public static void main(String[] args) {
        
        //Array list to see every non repeat number;
        ArrayList<Integer> newNumber = new ArrayList<>();
        
        //set the number of run
        final int numberOfRun = 10000;
        
        //hold the largest gap's number
        int largestDiffernt = -1;
        
        //hold the largest gap's index
        int largestDifferntIndex = -1;
        
        //hold the entire sequence
        int[] sequence = new int[numberOfRun];
        
        //set the first seqeunce to 0;
        sequence[0] = 0;
        
        //call the vam eck sequence algorithm within the number of run set on top.
        for(int i = 0; i < numberOfRun-1; i++)
        {   
            //assign the next array to the previous occurance
            sequence[i+1] = vaneck(sequence, i+1, sequence[i], i+1);
            
            //having fun determine anything i want haha
            if(sequence[i+1] == 9344)
            {
                largestDifferntIndex = i;
                largestDiffernt = sequence[i];
            }
        }
        
        //print the sequence
        printSequence(sequence, numberOfRun);
        
        //add all the new number to the arrayList 
        for(int k = 0; k < numberOfRun-1; k++)
        {   
            //by checking if the next value in the array == 0;
            //if is 0, means that the number never came out before
            if(sequence[k+1] == 0)
            {
                newNumber.add(sequence[k]);
            }
            
            //sort the newNumber
            Collections.sort(newNumber);
        }
        
        //display
        System.out.println("All number within " + numberOfRun + " of run is: ");
        System.out.println(newNumber);
        System.out.println("");
        System.out.println("The largest number's index is: " + largestDifferntIndex + " within " + numberOfRun + " run.");
        System.out.println("The largest number appart is: " + largestDiffernt + " within " + numberOfRun + " run.");
        
    }

    /**
     * 
     * This method output the van eck sequence
     * 
     * @param sequence
     * this sequence hold the current sequence to be check
     * 
     * @param index
     * this index act as the pointer to check the previous number
     * 
     * @param currentNumber
     * this hold the current number to check the with the previous number 
     * to determine how many number apart it occur before.
     * 
     * @param oriIndex
     * original Index will be used to calculate the number gap
     * 
     * @return 
     * return the next number of the sequence.
     * 
     */
    public static int vaneck(int[] sequence, int index, int currentNumber, int oriIndex)
    {  
       //check if it reach the first index
       if(index == 0 || index-1 == 0)
       {
           return 0;
       }
       
       //return the gap if the number had occur before in the sequence
       if(sequence[index-2] == currentNumber)
       {
           return oriIndex-index+1;
       }
       // run the check again by moving the index to previous index
       else
       {
           return 0 + vaneck(sequence, index - 1, currentNumber, oriIndex);
       }
        
    }
    
    public static void printSequence(int[] array, int range)
    {
        for(int i = 0; i < range; i++)
        {
            System.out.print(array[i] + ", ");
        }
        
        System.out.println("");
    }

}
