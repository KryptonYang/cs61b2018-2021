package hw2;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    PercolationFactory pf;
    int times;
    int gridsize;
    /**perform T independent experiments on an N by N grid*/
    public PercolationStats(int N, int T, PercolationFactory pf){
        if(N == 0 || T == 0){
            throw new IllegalArgumentException();
        }
        times = T;
        gridsize = N;
        this.pf = pf;


    }
    private int threshold(){
        Percolation target = pf.make(gridsize);

        while(!target.percolates()){
            target.open(StdRandom.uniform(0,gridsize),(StdRandom.uniform(0,gridsize)));
        }
        return target.numberOfOpenSites();
    }

    /**sample mean of percolation threshold*/
    public double mean(){
        int[] meanlist = new int[times];
        for(int i = 0; i < times; i++){
            meanlist[i] = threshold();
        }
        double mean = StdStats.mean(meanlist);
        return mean;
    }
    /**sample standard deviation of percolation threshold*/
    public double stddev(){
        int[] stddevlist = new int[times];
        for(int i = 0; i < times; i++){
            stddevlist[i] = threshold();
        }
        double stddev = StdStats.mean(stddevlist);
        return stddev;
    }
    /**low endpoint of 95% confidence interval*/
    public double confidenceLow(){

        double mean = mean();
        double stddev = stddev();
        double result = mean - 1.96*stddev/Math.sqrt(times);
        return result;
    }
    /**high endpoint of 95% confidence interval*/
    public double confidenceHigh(){
        double mean = mean();
        double stddev = stddev();
        double result = mean + 1.96*stddev/Math.sqrt(times);
        return result;
    }


}
