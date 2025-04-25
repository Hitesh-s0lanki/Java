public class ExceptionHandling {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int j = a / b;
            System.out.println("The Value after divide : " + j);
        } catch (Exception e) {
            System.out.println("Something went Wrong!" + e.getMessage());
        }

        try {
            Class.forName("Hello");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        }

        System.out.println("I m here");
    }
}
