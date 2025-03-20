///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.ltgb.repository.impl;
//
//import com.ltgb.hibernatedemo.HibernateUtils;
//import com.ltgb.pojo.OrderDetail;
//import com.ltgb.pojo.Product;
//import jakarta.persistence.Query;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Join;
//import jakarta.persistence.criteria.JoinType;
//import jakarta.persistence.criteria.Root;
//import java.util.List;
//import org.hibernate.Session;
//
///**
// *
// * @author admin
// */
//public class StateRepositoryImpl {
//
//    public List<Object[]> stateRevenueByProduct() {
//        try (Session s = HibernateUtils.getFACTORY().openSession()) {
//            CriteriaBuilder b = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> p = b.createQuery(Object[].class);
//            Root root = p.from(OrderDetail.class);
//            Join<OrderDetail, Product> join = root.join("productId", JoinType.LEFT);
//
//            p.multiselect(join.get("id"), join.get("name"), b.sum(b.prod(root.get("quantity"), root.get("unitPrice"))));
//            p.groupBy(join.get("id"));
//
//            Query q = s.createQuery(p);
//            return q.getResultList();
//        }
//
//    }
//}
