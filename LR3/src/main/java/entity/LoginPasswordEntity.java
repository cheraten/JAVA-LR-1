package entity;

import javax.persistence.*;

@Entity
@Table (name = "login_password")

public class LoginPasswordEntity {
    @Id
    private String login;
    private String password;

    public LoginPasswordEntity() {
    }

    public LoginPasswordEntity(String name, String password) {
        this.login = name;
        this.password = password;
    }

   public String getPassword() {
        return password;
    }

    public String toString() {
        return "||  userName=" + login +
                "   ;   password=" + password +
                "   ||\n";
    }
}