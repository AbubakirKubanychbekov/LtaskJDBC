package GroupA.service.impl;

import GroupA.dao.EmployeeDao;
import GroupA.dao.impl.EmployeeDaoImpl;
import GroupA.models.Employee;
import GroupA.models.Job;
import GroupA.service.EmployeeService;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
   EmployeeDao employeeDao=new EmployeeDaoImpl();

    @Override
    public void createEmployee() {

    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void dropTable() {

    }

    @Override
    public void cleanTable() {

    }

    @Override
    public void updateEmployee(Long id, Employee employee) {

    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee findByEmail(String email) {
        return null;
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        return null;
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        return null;
    }
}
