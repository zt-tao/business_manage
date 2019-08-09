package com.neuedu.controller;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;
import com.neuedu.service.ICategoryService;
import com.neuedu.service.IProductService;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping("/user/product/")
public class ProductController {

    @Autowired
    IProductService productService;


    @RequestMapping(value = "find")
    public String findall(HttpSession session) {
        List<Product> productList = productService.findall();
        List<Category> categoryList=productService.findId();
        session.setAttribute("productlist", productList);
        session.setAttribute("categoryList",categoryList);
        return "/product/productlist";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer productId, HttpServletRequest request) {
        Product product = productService.findProductById(productId);
        request.setAttribute("product", product);
        return "/product/productupdate";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int count = productService.updateProduct(product);
        if (count > 0) {
            return "redirect:/user/product/find";
        }
        return "/product/productupdate";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer productId) {
        int count = productService.deleteProduct(productId);
        return "redirect:/user/product/find";
    }
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(){
        return "/product/productinsert";
    }
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(HttpServletRequest request,HttpServletResponse response,Product product) throws UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int count=productService.addProduct(product);
        if (count>0){
            return "redirect:/user/product/find";
        }
        return "/product/productinsert";

    }
}
