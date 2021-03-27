
public class OffByN implements CharacterComparator{
    private int different;
    public OffByN(int x) {
        different = x;

    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == different;
    }
}
