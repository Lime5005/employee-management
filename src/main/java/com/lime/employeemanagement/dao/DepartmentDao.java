package com.lime.employeemanagement.dao;

import com.lime.employeemanagement.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    // Mock a database:
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();
        departments.put(101, new Department(101, "Study"));
        departments.put(102, new Department(101, "Marketing"));
        departments.put(103, new Department(101, "Research"));
        departments.put(104, new Department(101, "Operation"));
        departments.put(105, new Department(101, "Logistics"));
    }

    public Collection<Department> getAllDepartments() {
        return departments.values();
    }

    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
