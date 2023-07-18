/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejbbean;

import entity.Brands;
import entity.Categories;
import entity.Products;
import entity.UserInfo;
import java.io.IOException;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author admin
 */
@Stateless
public class Furniture implements FurnitureLocal {

    Pbkdf2PasswordHashImpl pb = new Pbkdf2PasswordHashImpl();
    @PersistenceContext(unitName = "projectsPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }

    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insert(String username, String number, String address, String email, String password, String type) {
 
       
        
        UserInfo uf =new UserInfo();
        String pass = pb.generate(password.toCharArray());
       uf.setUsername(username);
       uf.setNumber(number);
       uf.setAddress(address);
       uf.setEmail(email);
       uf.setPassword(pass);
       uf.setType(type);
       em.persist(uf);
       
       
       
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
@Override
    public void insertproduct(String product_name, String product_desc, int brand_id, int cat_id, String date, String product_stock, String product_price, String product_img) {
        
    
        Products p=new Products();
        Brands bd=em.find(Brands.class, brand_id);
        Categories cd=em.find(Categories.class, cat_id);
        
        p.setProductName(product_name);
        p.setProductDesc(product_desc);
        p.setBrandId(bd);
        p.setCatId(cd);
        p.setDate(date);
        p.setProductStock(product_stock);
        p.setProductPrice(product_price);
        p.setProductImg(product_img);
        em.persist(p);

   
}
    
    

    @Override
    public UserInfo checkuser(String username) {
        
        UserInfo ad = (UserInfo)em.createNamedQuery("UserInfo.findByUsername").setParameter("username", username).getSingleResult();
        return ad;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer product_id) {
       
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Products c1  =(Products) em.createNamedQuery("Products.findByProductId").setParameter("productId", product_id).getSingleResult();
         em.remove(c1);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public List<Products> showproduct() {
        
          List<Products> show=em.createNamedQuery("Products.findAll").getResultList();
        return show;

    }

    @Override
    public void addcat(String cat_name) {
        Categories c=new Categories();
        c.setCatName(cat_name);
        em.persist(c);
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addbrand(String brand_name) {
        Brands b=new Brands();
        b.setBrandName(brand_name);
        em.persist(b);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categories srch(Integer cat_id) {
        Categories c1 = em.find(Categories.class,cat_id);
        return c1;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void catupdate(Integer cat_id, String cat_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Categories c1 = (Categories)em.find(Categories.class,cat_id);
        c1.setCatName(cat_name);
        em.merge(c1);
        
    }

    @Override
    public Brands bsrch(Integer brand_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        Brands c1 = em.find(Brands.class,brand_id);
        return c1;
    }

    @Override
    public void brandupdate(Integer brand_id, String brand_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Brands c1 = (Brands)em.find(Brands.class,brand_id);
        c1.setBrandName(brand_name);
        em.merge(c1);
        
      }
    
    @Override
    public void deletebrand(Integer brand_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Brands b=(Brands) em.createNamedQuery("Brands.findByBrandId").setParameter("brandId",brand_id).getSingleResult();
        em.remove(b);
    }

    @Override
    public void deletecat(Integer cat_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      Categories c=(Categories) em.createNamedQuery("Categories.findByCatId").setParameter("catId", cat_id).getSingleResult();
      em.remove(c);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

 /*   @Override
    public void updatepds(String product_name, String product_desc, Integer brand_id, Integer cat_id, String date, String product_stock, String product_price, String product_img) {
    
        
           Brands pr=em.find(Brands.class, brand_id);
           pr.setBrandId(brand_id);
           Categories cs=em.find(Categories.class, cat_id);
           cs.setCatId(cat_id);
           Products ps= new Products();
           
            ps.getProductName(product_name);
            ps.setProductDesc(product_desc);
            ps.setProductStock(product_stock);
            ps.setProductPrice(product_price);
            ps.setProductImg(product_img);
            
            try {
                        em.merge(ps);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
            }catch (IOException e)
            {
            
                    
            
            }       

//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

    