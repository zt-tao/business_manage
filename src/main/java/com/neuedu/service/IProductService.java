package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
    /**
     * 增加商品
     * */
    public int addProduct(Product product) throws MyException;

    /**
     * 删除商品
     * */
    public int deleteProduct(int productId )throws MyException;
    /**
     * 修改商品
     * */
    public int updateProduct(Product product)throws MyException;
    /**
     * 查询商品
     * */
    public List<Product> findall()throws MyException;

    public Product findProductById(int productId);
    public List<Category> findId()throws MyException;
}
