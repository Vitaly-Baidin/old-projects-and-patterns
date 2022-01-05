import models.*;
import net.bytebuddy.build.Plugin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

import static org.hibernate.id.PersistentIdentifierGenerator.PK;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM " + PurchaseList.class.getSimpleName();

        List<PurchaseList> purchaseLists = session.createQuery(hql).getResultList();



        purchaseLists.forEach(e -> {
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setId(e.getId());
            linkedPurchaseList.setStudentName(e.getStudentName());
            linkedPurchaseList.setCourseName(e.getCourseName());
            linkedPurchaseList.setPrice(e.getPrice());
            linkedPurchaseList.setSubscriptionDate(e.getSubscriptionDate());
            session.save(linkedPurchaseList);
        });


        transaction.commit();
        sessionFactory.close();
    }
}
