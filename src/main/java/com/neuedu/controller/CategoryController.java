package com.neuedu.controller;
import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
@Controller
@RequestMapping("/user/category/")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @RequestMapping(value = "find")
    public  String  findAll(HttpSession session){
        List<Category> categoryList=categoryService.findAll();
        List<Integer> integerList=categoryService.findParentId();
        session.setAttribute("categorylist",categoryList);
        session.setAttribute("integerList",integerList);
        return "/category/categorylist";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public  String  update(@PathVariable("id") Integer categoryId, HttpServletRequest request){
        Category category=categoryService.findCategoryById(categoryId);
        request.setAttribute("category",category);
        return "/category/categoryupdate";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public  String  update(Category category, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
       //
       int count= categoryService.updateCategory(category);
       if(count>0){
           //修改成功
           return "redirect:/user/category/find";
       }
        return "/category/categoryupdate";
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public  String  delete(@PathVariable("id") Integer categoryId){
       int count=categoryService.deleteCategory(categoryId);
       return "redirect:/user/category/find";

    }

    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(){
        return "/category/categoryinsert";
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(Category category, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int count= categoryService.addCategory(category);
        if(count>0){
            //修改成功
            return "redirect:/user/category/find";
        }
        return "/category/categoryinsert";
    }

}
