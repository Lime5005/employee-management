package com.lime.employeemanagement.dao;

import com.lime.employeemanagement.pojo.Department;
import com.lime.employeemanagement.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001, "AA", "aa@gmail.com", 1, new Department(101, "Study")));
        employees.put(1002, new Employee(1002, "BB", "bb@gmail.com", 0, new Department(102, "Marketing")));
        employees.put(1003, new Employee(1003, "CC", "cc@gmail.com", 1, new Department(103, "Research")));
        employees.put(1004, new Employee(1004, "DD", "dd@gmail.com", 0, new Department(104, "Operation")));
        employees.put(1005, new Employee(1005, "EE", "ee@gmail.com", 1, new Department(105, "Logistics")));
    }

    // Create/Update:
    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId ++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    // Read:
    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    // Get by id:
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    // Delete:
    public void deleteEmployee(Integer id) {
        employees.remove(id);
    }

}
