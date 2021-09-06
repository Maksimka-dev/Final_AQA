package value_objects;

public class JobTitle {
    private String jobTitle;
    private String jobDescription;
    private String jobSpecificationPath;
    private String note;

    public JobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public JobTitle(String jobTitle, String jobDescription, String note) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.note = note;
    }

    public void setJobDescription(String jobDescription) { this.jobDescription = jobDescription; }

    public void setJobSpecificationPath(String jobSpecificationPath) { this.jobSpecificationPath = jobSpecificationPath; }

    public void setNote(String note) { this.note = note; }

    public String getJobTitle() { return jobTitle; }

    public String getJobDescription() { return jobDescription; }

    public String getJobSpecificationPath() { return jobSpecificationPath; }

    public String getNote() { return note; }

}
