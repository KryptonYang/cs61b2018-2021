import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByOne {
    /**
     You must use this CharacterComparator and not instantiate
     new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

     Your tests go here.*/
    @Test
    public void testIsPalindrome() {
         OffByOne offbyone = new OffByOne();
         assertTrue(offbyone.equalChars('a','b'));
        assertTrue(offbyone.equalChars('b','c'));
        assertTrue(offbyone.equalChars('r','q'));
        assertFalse(offbyone.equalChars('a','c'));
        assertFalse(offbyone.equalChars('z','a'));
        assertFalse(offbyone.equalChars('a','a'));

    }

}
