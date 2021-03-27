import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /** You must use this palindrome, and not instantiate
     new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("hello"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("Noon"));
    }
    @Test
    public void testIsPalindromeOffByOne() {
        CharacterComparator byone = new OffByOne();
        assertFalse(palindrome.isPalindrome("hello",byone));
        assertTrue(palindrome.isPalindrome("",byone));
        assertTrue(palindrome.isPalindrome("a",byone));
        assertFalse(palindrome.isPalindrome("rancor",byone));
        assertTrue(palindrome.isPalindrome("abcddcb",byone));
        assertTrue(palindrome.isPalindrome("abcdcb",byone));
        assertFalse(palindrome.isPalindrome("efghi",byone));

    }
    @Test
    public void testIsPalindromeOffBy5(){
        CharacterComparator byFive = new OffByN(5);
        assertFalse(palindrome.isPalindrome("hello",byFive));
        assertTrue(palindrome.isPalindrome("",byFive));
        assertTrue(palindrome.isPalindrome("a",byFive));
        assertFalse(palindrome.isPalindrome("rancor",byFive));
        assertTrue(palindrome.isPalindrome("abchgf",byFive));
        assertTrue(palindrome.isPalindrome("abcdhgf",byFive));
        assertFalse(palindrome.isPalindrome("efghi",byFive));


    }
}
