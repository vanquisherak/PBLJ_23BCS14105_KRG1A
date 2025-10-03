import java.util.*;
class EmptyStudentListException extends Exception {
    public EmptyStudentListException(String message) {
        super(message);
    }
}
public class StudentCalculator {
    static ArrayList<String> students = new ArrayList<>();
    static ArrayList<Integer> numbers = new ArrayList<>();
    public static void addStudent(String name) {
        students.add(name);
        System.out.println(name + " added successfully!");
    }
    public static void removeStudent(String name) {
        if (students.remove(name)) {
            System.out.println(name + " removed successfully!");
        } else {
            System.out.println(name + " not found in the list.");
        }
    }
    public static void displayStudents() throws EmptyStudentListException {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("Student list is empty!");
        }
        Collections.sort(students);
        System.out.println("Sorted students: " + students);
    }
    public static void calculateAverage() {
        try {
            if (numbers.isEmpty()) {
                throw new ArithmeticException("Cannot calculate average, list is empty!");
            }
            double sum = 0;
            for (int n : numbers) sum += n;
            double avg = sum / numbers.size();
            System.out.println("Average: " + avg);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Add Numbers for Average (type 'done' to finish)");
            System.out.println("5. Calculate Average");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    addStudent(name);
                    break;
                case "2":
                    System.out.print("Enter student name to remove: ");
                    String removeName = sc.nextLine();
                    removeStudent(removeName);
                    break;
                case "3":
                    try {
                        displayStudents();
                    } catch (EmptyStudentListException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "4":
                    System.out.println("Enter numbers one by one. Type 'done' to finish:");
                    while (true) {
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("done")) break;
                        try {
                            int num = Integer.parseInt(input);
                            numbers.add(num);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid input, please enter a valid integer.");
                        }
                    }
                    break;
                case "5":
                    calculateAverage();
                    break;
                case "6":
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
