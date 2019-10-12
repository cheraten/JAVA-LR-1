import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class LoginHashDAO {
    public void save(LoginHashEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public String getHash(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<LoginHashEntity> users = session.createQuery("from LoginHashEntity").list();
        String hash = null;
        for (LoginHashEntity user : users) {
            if (user.getName().equals(login))
                hash = user.getHash();
        }
        tx1.commit();
        session.close();
        return hash;
    }

    public boolean isContainLoginHash(String login, String hash) {
        Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        boolean isContain = false;
        LoginHashEntity user = session.get(LoginHashEntity.class, login);

        if (user != null)
            if (user.getHash().equals(hash))
                isContain = true;
        tx1.commit();
        session.close();
        return isContain;
    }
}
