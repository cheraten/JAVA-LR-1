import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class LoginPasswordDAO {
    public void save(LoginPasswordEntity loginPasswordEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(loginPasswordEntity);
        tx1.commit();
        session.close();
    }

    public List<LoginPasswordEntity> findAll() {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<LoginPasswordEntity> loginPasswordEntities = session.createQuery("from LoginPasswordEntity").list();
        tx1.commit();
        session.close();
        return loginPasswordEntities;
    }

    public boolean isContainUserName(String login) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        boolean isContain = false;
        LoginPasswordEntity loginPasswordEntity = session.get(LoginPasswordEntity.class, login);
        if (loginPasswordEntity != null)
            isContain = true;
        tx1.commit();
        session.close();
        return isContain;
    }

    public boolean isRightPassword(String login, String password) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        boolean isRight = false;
        LoginPasswordEntity loginPasswordEntity = session.get(LoginPasswordEntity.class, login);
        if (loginPasswordEntity.getPassword().equals(password))
            isRight = true;
        tx1.commit();
        session.close();
        return isRight;
    }
}
