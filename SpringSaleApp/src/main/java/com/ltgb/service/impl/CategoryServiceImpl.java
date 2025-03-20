/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ltgb.service.impl;

import com.ltgb.pojo.Category;
import com.ltgb.repository.CategoryRepository;
import com.ltgb.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service

public class CategoryServiceImpl implements CategoryService{
    @Autowired
   
    private CategoryRepository cateRepos;
    
    @Override
    public List<Category> getCates() {
        return this.cateRepos.getCates();
    }
    
    
    
}
