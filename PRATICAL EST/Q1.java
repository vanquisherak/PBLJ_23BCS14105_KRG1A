public class Q1 {
    public static void main(String[] args) {
        try {
            int num = 5/0;  
        }catch(ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }finally{
            System.out.println("Program ended properly.");
        }try{
            checkAge(15);
        }catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    static void checkAge(int age) {
        if(age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }System.out.println("Valid age");
    }
}
