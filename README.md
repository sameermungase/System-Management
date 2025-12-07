# System-Management (PracProj)

A small Java CLI application to manage employees backed by PostgreSQL. This workspace contains the original practice project (`PracProj`) with a simple menu-driven interface for adding, listing and removing employees.

**Project Snapshot**
- **Language:** Java (plain JDBC)
- **Database:** PostgreSQL (JDBC)
- **Type:** CLI / console application

**Repository layout (important files)**
- `src/Employee.java` — domain model (POJO) for employees
- `src/DbConnection.java` — database connection helper (JDBC)
- `src/DatabaseQueries.java` — contains SQL operations (INSERT / SELECT / DELETE)
- `src/Main.java` — CLI entry point and menu-driven I/O

**Main features**
- Add a new employee (name, department, age, salary)
- Show all employees (joins `departments` table for department name)
- Remove an employee by ID

**Database assumptions / schema (example)**
The project expects a PostgreSQL database with at least these tables/columns:

```sql
CREATE TABLE departments (
	department_id SERIAL PRIMARY KEY,
	department_name VARCHAR(100) NOT NULL
);

CREATE TABLE employee (
	employee_id SERIAL PRIMARY KEY,
	employee_name VARCHAR(200) NOT NULL,
	department_id INTEGER REFERENCES departments(department_id),
	age INTEGER,
	salary NUMERIC
);
```
