import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class NeiborghLauncher {
    /**takes a array of int and return the array that are the biggest among its four neibourghs
     * two in the front and two at the back
     * @param Dogs
     * @return
     */
    public static ArrayList<Integer> LargestNeiborgh(int[] Dogs){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for(int i = 0; i <Dogs.length; i++) {
            if (isLargest(Dogs,i)){
              integers.add(Dogs[i]);
            }

        }
        return integers;
    }
    /**private helper method, to determining whether specific int is the largest*/
    private static Boolean isLargest(int[] integers, int i) {
        boolean isBiggest = true;
        for (int j = -2; j<=2; j++ ){
            if(isValid(j+i, integers)){
                if(integers[j+i] > integers[i]){
                    isBiggest = false;
                }
                /*avoid comparing to itself*/
                if(j == 0){
                    continue;
                }

            }

        }
        return isBiggest;
    }
    /**private helper method to determine if j is valid index, meaning not larger than 0 and less than length*/
    private static Boolean isValid (int index, int[] array) {
        int length = array.length;
        return !(index < 0 || index>=length);
    }
    public static void main (String[] args) {
        int[] Dogs = new int[]{5,10,15,8,4,20,9,16};
        ArrayList<Integer>dogs = LargestNeiborgh(Dogs);
        System.out.println(dogs.size());
        for(int i = 0; i < dogs.size(); i++){
            System.out.println(dogs.get(i));
        }
    }
}
