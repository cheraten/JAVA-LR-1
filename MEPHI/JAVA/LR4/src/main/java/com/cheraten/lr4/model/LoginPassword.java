package com.cheraten.lr4.model;

import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.NotEmpty;
import javax.persistence.*;

@Data
@Entity
@Table(name = "user_login_password")
public class LoginPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public LoginPassword() {
    }

    @ModelAttribute("loginPassword")
    public LoginPassword getLoginPassword(){
        return new LoginPassword();
    }

    public LoginPassword(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "||  login=" + login +
                "   ;   password=" + password +
                "   ||\n";
    }
}