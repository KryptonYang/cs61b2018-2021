import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void TestStudentArray(){
        StudentArrayDeque<Integer> wrong1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> correct1 = new ArrayDequeSolution<>();
        for(int i = 0; i < 20; i++) {
            double randomNumber = StdRandom.uniform();
            if(randomNumber < 0.5){
                wrong1.addFirst(i);
                correct1.addFirst(i);
            }
            else {
                wrong1.addLast(i);
                correct1.addLast(i);
            }

        }
        for(int i = 0; i<20; i++) {
            double randomNumber = StdRandom.uniform();
            if(randomNumber < 0.5){
                Integer studentResult = wrong1.removeFirst();
                Integer CorrectResult = correct1.removeFirst();
                assertEquals("student was " + studentResult +", correct was " + CorrectResult,studentResult,CorrectResult);
            }
            else{
                Integer studentResult = wrong1.removeLast();
                Integer CorrectResult = correct1.removeLast();
                assertEquals("student was " + studentResult +", correct was " + CorrectResult,studentResult,CorrectResult);
            }

        }
    }

}
