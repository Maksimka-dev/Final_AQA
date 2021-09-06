package value_objects;

public class AssignLeave {
    private String employeeFullName;
    private String leaveType;
    private String fromDate;
    private String toDate;

    public String getEmployeeFullName() { return employeeFullName; }

    public String getLeaveType() { return leaveType; }

    public String getFromDate() { return fromDate; }

    public String getToDate() { return toDate; }

    public AssignLeave(String employeeFullName, String leaveType, String fromDate, String toDate) {
        this.employeeFullName = employeeFullName;
        this.leaveType = leaveType;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
