import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            System.out.println("Creating a new User object");
//            User tempUser = new User("Alina Barbieru", "alina.barbieru@gmail.com",
//                    "pumniimeimintenuare", true, "SMS", "2018-08-01 08:45:34");
//
//            session.beginTransaction();
//            System.out.println("Saving object");
//            session.save(tempUser);
//
//            session.getTransaction().commit();
//
//            System.out.println("Saved user. Generated ID: " + tempUser.getUserId());
//            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Getting message with id: 1");

            User myConv = session.get(User.class, 1);
            System.out.println("\nDone! Selected user: " + myConv);


//            System.out.println("Getting user with id: 9");
//            User deleteUser = session.get(User.class, 7);
//            System.out.println("\nSelected user: " + deleteUser);
//            session.delete(deleteUser);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
