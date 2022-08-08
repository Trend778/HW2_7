package pro.sky.hw2_7.Service;

import org.springframework.stereotype.Service;
import pro.sky.hw2_7.exception.EmployeeAlreadyAddedException;
import pro.sky.hw2_7.exception.EmployeeNotFoundException;
import pro.sky.hw2_7.exception.EmployeeStorageIsFullException;
import pro.sky.hw2_7.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private static final int Limit = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey (String name, String surname) {  //Возвращает ключ в виде имени фамилии
        return name + " " + surname;
    }
    public Employee addEmployee(String name, String surname) { //Если ключ имеется, эксепшн, иначе вбиваем по ключу нового сотрудника

        Employee employee = new Employee(name, surname);
        String key = getKey(name, surname);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < Limit) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String name, String surname) { //Если ключа нет, эксепшн

        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);

    }

    public Employee removeEmployee(String name, String surname) {  //Если ключа нет, эксепшн
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
}
