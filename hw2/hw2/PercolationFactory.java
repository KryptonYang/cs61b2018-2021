package hw2;

public class PercolationFactory {
    public PercolationFactory(int gridsize) {
    }

    public Percolation make(int N) {
        return new Percolation(N);
    }
}
