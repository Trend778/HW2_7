package pro.sky.course2.collectionslistssets.Service;

import pro.sky.course2.collectionslistssets.exception.EmployeeAlreadyAddedException;
import pro.sky.course2.collectionslistssets.exception.EmployeeNotFoundException;
import pro.sky.course2.collectionslistssets.exception.EmployeeStorageIsFullException;
import pro.sky.course2.collectionslistssets.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final int Limit = 10;

    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public Employee addEmployee(String name, String surname) {

        Employee employee = new Employee(name, surname);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < Limit) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String name, String surname) {

        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;

    }

    public Employee removeEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }
}
