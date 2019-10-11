import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class LoginHashDAO {
    private HibernateSessionFactoryUtil HibernateSessionFactoryUtil;

    public void save(LoginHashEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(LoginHashEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(LoginHashEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<LoginHashEntity> findAll() {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<LoginHashEntity> users = session.createQuery("from LoginHashEntity").list();
        session.close();
        return users;
    }

    public String getHash(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<LoginHashEntity> users = session.createQuery("from LoginHashEntity").list();
        String hash = null;
        for (LoginHashEntity user : users) {
            if (user.getName().equals(login))
                hash = user.getHash();
        }
        return hash;
    }

    public boolean isContainLoginHash(String login, String hash) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean isContain = false;
        LoginHashEntity user = session.get(LoginHashEntity.class, login);

        if (user != null)
            if (user.getHash().equals(hash))
                isContain = true;
        return isContain;
    }

    public boolean isContainHash(String hash) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean isContain = false;
        List<LoginHashEntity> users = session.createQuery("from LoginHashEntity").list();
        for (LoginHashEntity user : users) {
            if (user.getHash().equals(hash))
                isContain = true;
        }
        return isContain;
    }
}
