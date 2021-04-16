package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

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

        if(mp[convert(row, col)] == 0){
            opensite += 1; //not yet finish

        }


    }
    //private method check if the surrouding of this spot is opened
    private boolean isLinked(int row, int col){

    }
    //covert a two d position into one d
    private int convert(int row, int col){
        return row*n + col;
    }
    /** is the site open? */
    public boolean isOpen(int row, int col){
        return mp[convert(row, col)] != 0;
    }
    /**is the site full?*/
    public boolean isFull(int row, int col){
        return true;
    }
    /**number of open sites*/
    public int numberofOpenSites(){
        return opensite;
    }
    /**does the system percolate*/
    public boolean percolates(){
        return true;
    }
    /**unit testing*/
    public static void mian(String[] args){

    }

}
