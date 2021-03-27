import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();


    @Test
    public void testIsPalindrome() {

         assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('b','c'));
        assertTrue(offByOne.equalChars('r','q'));
        assertFalse(offByOne.equalChars('a','c'));
        assertFalse(offByOne.equalChars('z','a'));
        assertFalse(offByOne.equalChars('a','a'));

    }

}
