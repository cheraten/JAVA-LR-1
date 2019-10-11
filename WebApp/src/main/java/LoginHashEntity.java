import javax.persistence.*;

@Entity
@Table (name = "login_hash")

public class LoginHashEntity {
    @Id
    private String login;
    private String hash;

    public LoginHashEntity() {
    }

    public LoginHashEntity(String name, String hash) {
        this.login = name;
        this.hash = hash;
    }

    public String getName() {
        return login;
    }

    public void setName(String name) {
        this.login = name;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String password) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "||  login=" + login +
                "   ;   hash=" + hash +
                "   ||\n";
    }
}
