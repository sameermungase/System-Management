import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO EMP MANAGER");
        boolean isActive = true;

        do{
            System.out.println("\n=== MENU ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Show All Employees");
            System.out.println("3. Remove Employee by ID");
            System.out.println("4. Search Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Deptartment Name: ");
                    String departmentName = sc.nextLine();
                    int departmentId = DatabaseQueries.getDepartmentId(departmentName);

                    System.out.print("Age: ");
                    int age = sc.nextInt();

                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    Employee employee = new Employee(name, departmentId, age, salary);

                    DatabaseQueries.addEmployeeDetails(employee);

                    break;

                case 2:
                    DatabaseQueries.showAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter ID to be removed: ");
                    int removeId = sc.nextInt();
                    sc.nextLine();

                    DatabaseQueries.removeEmployeeDetails(removeId);
                    break;

                case 4:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    DatabaseQueries.searchEmployeeDetails(searchId);
                    break;

                case 5:
                    System.out.println("Thank you for using EMP Manager!");
                    sc.close();
                    isActive = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-5.");
            }
        }while (isActive);

    }
}