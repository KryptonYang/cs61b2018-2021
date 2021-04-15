package synthesizer;
import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class
TestArrayRingBuffer {
    @Test
    public void Testenqueue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        try {
            for (int i = 0; i < 15; i++) {
                arb.enqueue(i);
            }
        }
        catch(RuntimeException e){

        }
        assertEquals(0,arb.dequeue());
    }
    @Test
    public void TestDequeue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(15);
        for (int i = 0; i < 15; i++) {
            arb.enqueue(i);

        }
        for (int i = 0; i< 13; i++){
            arb.dequeue();
        }
        assertEquals(13,arb.dequeue());
        assertEquals(1,arb.fillCount());
    }
    @Test
    public void TestCapacity(){
        ArrayRingBuffer arb = new ArrayRingBuffer(15);
        assertEquals(15, arb.capacity());
    }
    @Test
    public void TestIterable(){
        //Object[] expected = new Object[20];
        //Object actual = new Object[20];
        ArrayRingBuffer arb = new ArrayRingBuffer(15);
        for (int i = 0; i< 15; i++){
           // expected[i] = i;
            arb.enqueue(i);
        }
        for(Object i:arb){
            System.out.println(i);
            //actual[i] = i;
        }
        //assertArrayEquals(expected,actual);
    }
    @Test
    public void TestisFull(){
        ArrayRingBuffer arb = new ArrayRingBuffer(15);
        for (int i = 0; i < 15; i++) {
            arb.enqueue(i);

        }
        assertTrue(arb.isFull());
        arb.dequeue();
        assertFalse((arb.isFull()));
        for (int i = 0; i < 14; i++) {
            arb.dequeue();

        }
        assertTrue(arb.isEmpty());


    }



    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        //jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
        ArrayRingBuffer arb = new ArrayRingBuffer(15);
        for (int i = 0; i< 15; i++){
            arb.enqueue(i);
        }
        for( Object i:arb){
            System.out.println(i);
        }
    }


} 
