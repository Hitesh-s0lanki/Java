// String -> immutable
// StringBuffer -> Mutable
// StringBuilder

public class MutableString {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hitesh");
        sb.append(" Solanki");

        System.out.println(sb.capacity());
    }
}
