package GroupA.dao.impl;

import GroupA.config.Config;
import GroupA.dao.EmployeeDao;
import GroupA.models.Employee;
import GroupA.models.Job;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {
    private final Connection connection = Config.getConnection();

    @Override
    public void createEmployee() {
        String sql="create table employees ";

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
