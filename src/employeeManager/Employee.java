package employeeManager;

/**
 * Created by Péter on 2016. 03. 16..
 */
public class Employee extends Person {
    int salary;
    String jobTitle;

    public int getSalary() {
        return salary;

    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Salary: " + salary + ", " + "Job title: " + jobTitle;
    }
}
