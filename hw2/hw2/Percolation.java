package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.List;

public class Percolation  {
    /**create N by N grid, with all sites initially blocked */
    int[] mp;
    int opensite;
    int n;

    public Percolation(int N){
        if(N <=0){
            throw new IllegalArgumentException("N should bigger than 0");
        }
        mp = new int[N*N];
        for(int i = 0; i< N*N; i++){
            mp[i] = -(N*N);
        }
        opensite = 0;
        n = N;

    }
    //connect smaller set to larger set, store the negative size of set in mp[parent]
    private void connect(int x, int y){
        if(isConnected(x,y)){
            return;
        }
        int xparent = findParent(x);
        int yparent = findParent(y);//find their parents
        int xvalue = Math.abs(mp[xparent]);
        int yvalue = Math.abs(mp[yparent]);
        if (xvalue > yvalue){ //attach smaller to larger
            mp[xparent] = 0-(xvalue + yvalue);
            mp[yparent] = xparent;
        }
        else{
        mp[yparent] = 0-(xvalue + yvalue);
        mp[xparent] = yparent;}


    }
    //return the position of its parent
    private int findParent(int x){

        if(mp[x]< 0 && mp[x] > -n*n){
            return x;
        }
        while(mp[x] >= 0){
            x = mp[x];
        }
        return x;
    }
    private boolean isConnected(int x, int y){

       return findParent(x) == findParent(y);
    }
    /**open the site(row, col) if it is not open already*/
    public void open(int row, int col){//should throw error if not in vaid space
        if(row < 0 || row >= n || col < 0 || col >=n){
            throw new IllegalArgumentException("should open spot within the grid");
        }
        int currentspot = convert(row, col);
        if(mp[currentspot] == -n*n){
            opensite += 1;
            mp[currentspot] = -1;
            List<Integer> neighbours = neighbours(row, col);
            for(int i:neighbours){//connect with neighbours who are open
                if(isOpen(i)){
                    connect(i,currentspot);
                }
            }
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
        return isOpen(convert(row,col));
    }
    private boolean isOpen(int x){
        return mp[x] != -n*n;
    }
    /**is the site full?*///is connected to top?(array position 0~N-1
    public boolean isFull(int row, int col){
        return isFull(convert(row,col));
    }
    //determine if this spot connected to the top of the grid.
    private boolean isFull(int x){
        if(!isOpen(x)){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(isConnected(i,x)){
                return true;
            }

        }
        return false;
    }
    /**number of open sites*/
    public int numberOfOpenSites(){
        return opensite;
    }
    /**does the system percolate*/ //if any of the top(array position 0~N-1) is connected
    //with any of the bottom (array position N*(N-1)~N*N - 1
    public boolean percolates(){
        for (int i = (n - 1)*n; i < n* n; i++){
            if(isFull(i)){
                return true;
            }
        }
        return false;
    }
    /**unit testing*/
    public  void main(String[] args){
        Percolation p = new Percolation(6);
        System.out.print(p.isOpen(0,0));
        System.out.print(p.isFull(0,1));


    }

}
