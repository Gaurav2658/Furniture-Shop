/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejbbean;

import entity.Brands;
import entity.Categories;
import entity.Products;
import entity.UserInfo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface FurnitureLocal {
    
    
    
    void insert(String username, String number, String address, String email, String password, String type);
    void insertproduct(String product_name, String product_desc, int brand_id, int cat_id, String date, String product_stock, String product_price, String product_img);
    UserInfo checkuser(String username);
    void delete(Integer product_id);
    public List<Products> showproduct();
    void deletebrand(Integer brand_id);
    void deletecat(Integer cat_id);

    void addcat(String cat_name);
    void addbrand(String brand_name);
    Categories srch(Integer cat_id);
    void catupdate(Integer cat_id, String cat_name);
    Brands bsrch(Integer brand_id);
    void brandupdate(Integer brand_id,String brand_name);
    //void updatepds(String product_name, String product_desc,Integer brand_id,Integer cat_id, String date, String product_stock, String product_price, String product_img);
   
    
}
