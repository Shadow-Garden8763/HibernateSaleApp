/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ltgb.repository.impl;

import com.ltgb.hibernatedemo.HibernateUtils;
import com.ltgb.pojo.Product;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {

    private static final int PAGE_SIZE = 5;

    public List<Product> getProducts(Map<String, String> params) {

        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> p = b.createQuery(Product.class);
            Root root = p.from(Product.class);
            p.select(root);

            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            }

            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()) {
                predicates.add(b.greaterThanOrEqualTo(root.get("price"),
                        Double.parseDouble(fromPrice)));
            }

            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()) {
                predicates.add(b.lessThanOrEqualTo(root.get("price"),
                        Double.parseDouble(toPrice)));
            }

            String cateId = params.get("categoryId");
            if (cateId != null && !cateId.isEmpty()) {
                predicates.add(b.equal(root.get("categoryId").as(Integer.class),
                        Integer.parseInt(cateId)));
            }

            p.where(predicates.toArray(Predicate[]::new));
            Query q = s.createQuery(p);

            if(params != null){
                int page = Integer.parseInt(params.getOrDefault("page", "1"));
                int start = (page - 1) * PAGE_SIZE;
                
                q.setFirstResult(start);
                q.setMaxResults(PAGE_SIZE);
            }

            return q.getResultList();
        }
    }
}
