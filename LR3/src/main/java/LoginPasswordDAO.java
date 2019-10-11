import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class LoginPasswordDAO {

    public LoginPasswordEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(LoginPasswordEntity.class, id);
    }

    public void save(LoginPasswordEntity loginPasswordEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(loginPasswordEntity);
        tx1.commit();
        session.close();
    }

    public void update(LoginPasswordEntity loginPasswordEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(loginPasswordEntity);
        tx1.commit();
        session.close();
    }

    public void delete(LoginPasswordEntity loginPasswordEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(loginPasswordEntity);
        tx1.commit();
        session.close();
    }

    public List<LoginPasswordEntity> findAll() {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<LoginPasswordEntity> loginPasswordEntities = session.createQuery("from LoginPasswordEntity").list();
        session.close();
        return loginPasswordEntities;
    }

    public boolean isContainUserName(String login) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean isContain = false;
        LoginPasswordEntity loginPasswordEntity = session.get(LoginPasswordEntity.class, login);
        if (loginPasswordEntity != null)
            isContain = true;
        return isContain;
    }

    public boolean isRightPassword(String login, String password) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean isRight = false;
        LoginPasswordEntity loginPasswordEntity = session.get(LoginPasswordEntity.class, login);
        if (loginPasswordEntity.getPassword().equals(password))
            isRight = true;
        return isRight;
    }
}
