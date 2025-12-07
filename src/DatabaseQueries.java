import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueries {
    public static void addEmployeeDetails(Employee employee) {
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2,employee.getDepartmentId());
            preparedStatement.setInt(3,employee.getAge());
            preparedStatement.setDouble(4,employee.getSalary());
            int employeeAdded = preparedStatement.executeUpdate();

            System.out.println(employeeAdded +" Employee added successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showAllEmployees(){
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT e.employee_id, e.employee_name, e.age, e.salary, d.department_name from employee e JOIN departments d on e.department_id = d.department_id");
            ResultSet resultSet = preparedStatement.executeQuery();
            int noOfEmployees = preparedStatement.executeUpdate();

            System.out.println("ID | Name | Age |Salary|Department Name " + "NO OF EMPLOYEES: " + noOfEmployees);

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                int employeeAge = resultSet.getInt("age");
                int employeeSalary = resultSet.getInt("salary");
                String employeeDepartmentName = resultSet.getString("department_name");

                System.out.println( employeeId + " " + employeeName + " " + employeeAge + " " + employeeSalary + " " + employeeDepartmentName);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeEmployeeDetails(int removeId){
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE employee_id = ?");
            preparedStatement.setInt(1, removeId);
            int employeeRemoved = preparedStatement.executeUpdate();
            System.out.println(employeeRemoved + " Employee removed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchEmployeeDetails(int searchId){
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT e.employee_id, e.employee_name, e.age, e.salary, d.department_name from employee e JOIN departments d on e.department_id = d.department_id WHERE employee_id = ?");
            preparedStatement.setInt(1, searchId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                int employeeAge = resultSet.getInt("age");
                double employeeSalary = resultSet.getDouble("salary");
                String employeeDepartmentName = resultSet.getString("department_name");

                System.out.println("ID | Name | Age |Salary|Department Name");
                System.out.println(employeeId + " " + employeeName + " " + employeeAge + " " + employeeSalary + " " + employeeDepartmentName);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int getDepartmentId(String departmentName) {

        String getDeptQuery ="Select department_id from departments where department_name = ?";

        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement  preparedStatement = connection.prepareStatement(getDeptQuery);
            preparedStatement.setString(1, departmentName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt("department_id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;

    }

}
