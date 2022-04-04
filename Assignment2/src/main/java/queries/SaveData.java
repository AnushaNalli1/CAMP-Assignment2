package queries;

import entity.Catalog;
import entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveData {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Category category = new Category();
        category.setCategoryName("GiftCard");
        category.setStatus("In-Active");
        Catalog catalog = new Catalog();
        catalog.setCatalog_Name("FlipkartCard");
        Catalog catalog1 = new Catalog();
        catalog1.setCatalog_Name("AmazonCard");
        Catalog catalog2 = new Catalog();
        catalog2.setCatalog_Name("DisneyCard");
        category.getCatalogList().add(catalog);
        category.getCatalogList().add(catalog1);
        category.getCatalogList().add(catalog2);
        catalog.setCategory(category);
        catalog1.setCategory(category);
        catalog2.setCategory(category);
        session.save(category);
        session.save(catalog);
        session.save(catalog1);
        session.save(catalog2);
        session.persist(category);
        t.commit();
        System.out.println("Successfully Saved.");
        session.close();
        factory.close();
    }
}