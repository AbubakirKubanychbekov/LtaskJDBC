package GroupA.service.impl;

import GroupA.dao.JobDao;
import GroupA.dao.impl.JobDaoImpl;
import GroupA.models.Job;
import GroupA.service.JobService;

import java.util.List;

public class JobServiceImpl implements JobService {
  JobDao jobDao=new JobDaoImpl();

    @Override
    public void createJobTable() {
    jobDao.createJobTable();
    }

    @Override
    public void addJob(Job job) {
     jobDao.addJob(job);
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobDao.getJobById(jobId);
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        return jobDao.sortByExperience(ascOrDesc);
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        return jobDao.getJobByEmployeeId(employeeId);
    }

    @Override
    public void deleteDescriptionColumn() {

    }
}
