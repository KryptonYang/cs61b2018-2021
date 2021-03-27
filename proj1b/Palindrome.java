public class Palindrome {
    /**take a string and turn it to a deque, with every stirng lettle in the deque*/
    public  Deque<Character> wordToDeque(String word) {
        Deque toDeque = new ArrayDeque();
        for(int i = 0; i<word.length();i++) {
            toDeque.addLast(word.charAt(i));
        }
        return toDeque;
    }

    /** return true if the string is palindrome, otherwise false.
     * String with size 0 or 1 is palindrome, capital letter is
     * not sensitive here
     * @param word
     * @return
     */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        //boolean result = true;
        while (wordDeque.size()>1){
            if(!wordDeque.removeFirst().equals((wordDeque.removeLast()))){
                return false;
            }
        }
            return true;
    }

    /**return true if the string is palindrome that behaves as the
     * Charactor comparator
     * @param word
     * @param cc
     * @return
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        //boolean result = true;
        while (wordDeque.size()>1){
            if(!cc.equalChars(wordDeque.removeFirst(),wordDeque.removeLast())){
                return false;
            }
        }
        return true;
    }

}
