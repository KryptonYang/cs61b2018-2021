public class OffByOne implements CharacterComparator{
   /** return true if char x and char y are different by exactly one */
    @Override
   public boolean equalChars(char x, char y){
       return Math.abs(x - y) == 1;
    }
}
