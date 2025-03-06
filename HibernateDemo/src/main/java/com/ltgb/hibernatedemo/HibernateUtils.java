/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ltgb.hibernatedemo;

import com.ltgb.pojo.Category;
import com.ltgb.pojo.Comment;
import com.ltgb.pojo.OrderDetail;
import com.ltgb.pojo.ProdTag;
import com.ltgb.pojo.Product;
import com.ltgb.pojo.SaleOrder;
import com.ltgb.pojo.Tag;
import com.ltgb.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernateUtils {
    private static final SessionFactory FACTORY;

    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
    static {
        Configuration conf = new  Configuration();
        
        Properties pros = new Properties();
        pros.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        pros.setProperty(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/saledb");
        pros.setProperty(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
        pros.setProperty(Environment.JAKARTA_JDBC_USER, "root");
        pros.setProperty(Environment.JAKARTA_JDBC_PASSWORD, "root");
        pros.setProperty(Environment.SHOW_SQL, "true");
        
        conf.setProperties(pros);
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Comment.class);
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(ProdTag.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(SaleOrder.class);
        
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
       
        
        FACTORY = conf.buildSessionFactory(serviceRegistry);
    }
}
