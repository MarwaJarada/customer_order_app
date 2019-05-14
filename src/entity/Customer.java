package entity;

public class Customer {
    private long id;
    private String fname;
    private String lname;
    private long mobile;
    private String email;
    private String address;
    private String gender;

    public Customer(long id, String fname, String lname, long mobile, String email, String address, String gender) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    public Customer() {
    }

    public Customer(long id) {
        this.id=id;
    }

    public Customer(String fname) {
        this.fname=fname;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public long getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress(String address) {
        return this.address;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return this.fname;
    }
}
