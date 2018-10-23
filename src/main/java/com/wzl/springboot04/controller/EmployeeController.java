package com.wzl.springboot04.controller;

import com.wzl.springboot04.dao.DepartmentDao;
import com.wzl.springboot04.dao.EmployeeDao;
import com.wzl.springboot04.entities.Department;
import com.wzl.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", employees);
        //Thymeleaf会默认拼串
        //prefix：classpath:/templates suffix:.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //来到添加页面
        return "emp/add";
    }

    //员工添加
    //SpringMvc将请求参数和入参对象的属性进行一一绑定：要求请求参数的名字和javaBean入参对象的属性名要一致
    @PostMapping("emp")
    public String addEmployee(Employee employee) {
        //来到员工列表页面
        System.out.println("保存的员工信息：" + employee);
        //保存员工
        employeeDao.save(employee);
        //redirect重定向到一个页面 /代表当前项目路径
        //forward转发到另一个页面
        return "redirect:/emps";
    }

    @GetMapping("emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面(修改添加是一个页面)
        return "emp/add";
    }

    //员工修改：需要提交id
    @PutMapping("emp")
    public String updateEmp(Employee employee) {
        System.out.println("修改的员工数据:" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("emp/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
