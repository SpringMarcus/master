package com.kibo.order.data.repository.dao;

import com.kibo.order.data.entity.entity.Employee;

import java.util.List;

/**
 * Created by marcus.chiu on 10/17/16.
 */
public interface EmployeeDao {

    Employee findById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeBySsn(String ssn);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String ssn);

}
