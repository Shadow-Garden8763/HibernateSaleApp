/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ltgb.controllers;


import com.ltgb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
public class IndexController {
    
    @Autowired
    private CategoryService cateSer;
    @RequestMapping("/")
    public String index(Model model){
        
        model.addAttribute("categories", this.cateSer.getCates());
        return "index";
    }
}
