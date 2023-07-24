package GroupA;

import GroupA.models.Job;
import GroupA.service.EmployeeService;
import GroupA.service.JobService;
import GroupA.service.impl.EmployeeServiceImpl;
import GroupA.service.impl.JobServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JobService jobService=new JobServiceImpl();
        EmployeeService employeeService=new EmployeeServiceImpl();

        Scanner scannerDigit =new Scanner(System.in);
        Scanner scannerWord =new Scanner(System.in);

        try {
        while (true) {
            switch (new Scanner(System.in).nextLine()) {
                case "1", "created table" -> {
                    jobService.createJobTable();
                }
                case "2", "add job" -> {
                    System.out.println("Write position:");
                    String position = scannerWord.nextLine();
                    System.out.println("Write profession :");
                    String profession = scannerWord.nextLine();
                    System.out.println("Write description :");
                    String desc = scannerWord.nextLine();
                    System.out.println("Write experience :");
                    int experience = scannerDigit.nextInt();
                    jobService.addJob(new Job(position, profession, desc, experience));
                }
                case "3", "get job by id" -> {
                    System.out.println(jobService.getJobById(1L));
                }case "4","sort by experience" -> {

                }case "5",""->{
                    jobService.getJobByEmployeeId()
                }

            }
        }




    }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
