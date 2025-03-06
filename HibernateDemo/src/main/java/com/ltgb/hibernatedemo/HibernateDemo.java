/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.ltgb.hibernatedemo;

import com.ltgb.repository.impl.CategoryRepositoryImpl;
import com.ltgb.repository.impl.ProductRepositoryImpl;
import com.ltgb.repository.impl.StateRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCategorys().forEach(c -> System.out.println(c.getName()));

//        Map<String, String> params = new HashMap<>();
//
//        params.put("kw", "iPhone");
//        params.put("page", "1");
//        ProductRepositoryImpl s2 = new ProductRepositoryImpl();
//        s2.getProducts(params).forEach(p -> System.out.printf("%d-%s-%d\n", p.getId(), p.getName(), p.getPrice()));

        StateRepositoryImpl s3 = new StateRepositoryImpl();
        s3.stateRevenueByProduct().forEach(p -> System.out.printf("%d-%s-%d\n", p[0], p[1], p[2]));
    }
}
