package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.List;

public class Percolation {
    /**create N by N grid, with all sites initially blocked */
    int[] mp;
    int opensite;
    int n;

    public Percolation(int N){
        if(N <=0){
            throw new IllegalArgumentException("N should bigger than 0");
        }
        mp = new int[N*N];
        opensite = 0;
        n = N;

    }
    /**open the site(row, col) if it is not open already*/
    public void open(int row, int col){
        int currentspot = convert(row, col);
        if(mp[currentspot] == 0){
            opensite += 1; //not yet finish
            
        }


    }
    //private method return a list of neighbours position
    //every spot can have 2,3,4 neighbours
    private List<Integer> neighbours(int row, int col){

        List neighbourList = new ArrayList();
        int currentspot = convert(row, col);
        int[] updownNeighbours = new int[]{currentspot - n, currentspot + n};
        for(int i = 0; i< 2; i++){
            if(updownNeighbours[i]>= 0 && updownNeighbours[i] <= n*n-1 ){
                neighbourList.add(updownNeighbours[i]);
            }
        }
        if(col == 0){
            neighbourList.add(currentspot + 1);
        }
        else if(col == n - 1){
            neighbourList.add(currentspot - 1);
        }
        else{
            neighbourList.add(currentspot + 1);
            neighbourList.add(currentspot - 1);
        }
            return neighbourList;
    }
    //covert a two d position into one d
    private int convert(int row, int col){
        return row*n + col;
    }
    /** is the site open? */
    public boolean isOpen(int row, int col){
        return mp[convert(row, col)] != 0;
    }
    /**is the site full?*///is connected to top?(array position 0~N-1
    public boolean isFull(int row, int col){
        return true;
    }
    /**number of open sites*/
    public int numberofOpenSites(){
        return opensite;
    }
    /**does the system percolate*/ //if any of the top(array position 0~N-1) is connected
    //with any of the bottom (array position N*(N-1)~N*N - 1
    public boolean percolates(){
        return true;
    }
    /**unit testing*/
    public static void main(String[] args){
        Percolation p = new Percolation(6);
        List<Integer> a = p.neighbours(2,5);
        for(int i : a){
        System.out.println(i);}

    }

}
