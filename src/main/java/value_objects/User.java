package value_objects;

public class User {
    private String firstName;
    private String lastName;
    private String middleName;
    private String userName;
    private Integer password;
    private String status;
    private String role;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

// with required fields
    public User(String firstName, String lastName, String userName, Integer password, String status, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.role = role;
    }

// with all fields
    public User(String firstName, String lastName, String middleName, String userName, Integer password, String status, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.role = role;
    }
}
