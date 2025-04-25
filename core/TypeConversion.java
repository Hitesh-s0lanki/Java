public class TypeConversion {
    public static void main(String[] args) {
        int a = 258;

        byte k = (byte) a;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }

        int i = 100;
        int j = 300;

        while (++i < --j)
            ;
        System.out.println(i);
    }
}