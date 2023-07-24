package GroupA.dao.impl;

import GroupA.config.Config;
import GroupA.dao.JobDao;
import GroupA.models.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDaoImpl implements JobDao {
    private final Connection connection = Config.getConnection();

    @Override
    public void createJobTable() {
        String sql="create table jobs("+
                "id serial primary key,"+
                "position varchar (60),"+
                "profession varchar (60),"+
                "description varchar (60),"+
                "experience int )";
       try(Connection connection=Config.getConnection();
        Statement statement = connection.createStatement()) {
           statement.executeUpdate(sql);
           System.out.println("Successfully created table");
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }


    }

    @Override
    public void addJob(Job job) {
   String sql="insert into jobs ("+
           "position,profession,description,experience)"+
           "values(?,?,?,?)";
   try (Connection connection = Config.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql)) {
       preparedStatement.setString(1,job.getPosition());
       preparedStatement.setString(2,job.getProfession());
       preparedStatement.setString(3,job.getDescription());
       preparedStatement.setInt(4,job.getExperience());
       preparedStatement.executeUpdate();
       System.out.println(job.getPosition()+" "+job.getProfession()+" "+job.getDescription()+" "+job.getExperience()+"Successfully added");
   } catch (SQLException e) {
       throw new RuntimeException(e);
   }
    }

    @Override
    public Job getJobById(Long jobId) {
        Job job=null;
        String sql="select * from jobs where id=?;";
        try(Connection connection=Config.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql)) {
            preparedStatement.setLong(1,jobId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                job=new Job();
                job.setId(resultSet.getLong("id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
            }
            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return job;
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        List<Job>jobs=new ArrayList<>();
        String sql="select * from jobs order by experience "+ascOrDesc;
        try(Connection connection=Config.getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Job job=new Job();
                resultSet.getLong("id");
                resultSet.getString("position");
                resultSet.getString("profession");
                resultSet.getInt("experience");
                jobs.add(job);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jobs;
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        Job job = new Job();
        String sql = "select * from employees inner join jobs on employees.job_id=jobs.id where jobs.id = ?";
        try(Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                job = new Job();
                job.setId(resultSet.getLong("id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
            }
            preparedStatement.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return job;
    }

    @Override
    public void deleteDescriptionColumn() {

    }
}
