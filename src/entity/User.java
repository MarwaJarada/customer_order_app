package entity;

import sun.security.util.Password;

public class User {
    private long id;
    private String name;
    private Password password;

    public User(long id, String name, Password password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }
}
