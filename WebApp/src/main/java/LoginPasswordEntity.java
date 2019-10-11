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

    public String getName() {
        return login;
    }

    public void setName(String name) {
        this.login = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "||  userName=" + login +
                "   ;   password=" + password +
                "   ||\n";
    }
}