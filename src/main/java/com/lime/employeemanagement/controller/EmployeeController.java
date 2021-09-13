package com.lime.employeemanagement.controller;

import com.lime.employeemanagement.dao.DepartmentDao;
import com.lime.employeemanagement.dao.EmployeeDao;
import com.lime.employeemanagement.pojo.Department;
import com.lime.employeemanagement.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAllEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有部门信息，再对应进入<select>:
        Collection<Department> departments = departmentDao.getAllDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //添加成功后才跳转页面
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
