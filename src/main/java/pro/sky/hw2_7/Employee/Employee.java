package pro.sky.course2.collectionslistssets.Employee;

public class Employee {
    private String staff;  //Сотрудники
    private int salaryStaff; //Зарплата сотрудников
    private int departmentNumber; //Номер отдела
    private final int id; // ID
    private static int counter;  //Счетчик

    public Employee(String staff, int salaryStaff, int departmentNumber) {
        this.staff = staff;
        this.salaryStaff = salaryStaff;
        this.departmentNumber = departmentNumber;
        this.id = getCounter();
        counter++;
    }

    public int getCounter() {  //геттер счетчика
        return counter;
    }
    public String getStaff() {  //геттер сотрудника
        return staff;
    }

    public void setStaff(String staff) {   //сеттер сотрудника
        this.staff = staff;
    }
    public int getSalaryStaff() {  //геттер зарплаты
        return salaryStaff;
    }
    public void setSalaryStaffStaff(int salaryStaff) { //сеттер зарплаты
        this.salaryStaff = salaryStaff;
    }
    public int getDepartmentNumber() {  //геттер номера отдела
        return departmentNumber;
    }
    public void setDepartmentNumber(int departmentNumber) { //сеттер номера отдела
        this.departmentNumber = departmentNumber;
    }
    public int getId() {  //геттер сотрудника
        return id;
    }

    @Override
    public String toString() {
        return  "ФИО сотрудника: " + staff + " / " +
                "Зарплата сотрудника: " + salaryStaff + " /  " +
                "Номера отдела: " + departmentNumber + " / " +
                "Идентификационный номер: " + id;
    }
}
