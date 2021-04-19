package hw2;


import org.junit.Assert;
import org.junit.Test;

public class TestPercolation {
    @Test
    public void TestisOpen(){


    }
    @Test
    public void TestisFull(){
        Percolation p = new Percolation(6);
        boolean b = p.isFull(0,1);
        Assert.assertFalse(b);

    }
    @Test
    public void TestFindParent(){

    }



}
