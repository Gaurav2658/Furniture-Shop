/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beansEjb;


import ejbbean.Furniture;
import ejbbean.FurnitureLocal;
import entity.Brands;
import entity.Categories;
import entity.Products;
import entity.UserInfo;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author admin
 */
@Named(value = "ManagedBean")
@SessionScoped
public class ManagedBean implements Serializable {
    @EJB FurnitureLocal fl;
    boolean valid = true;
    
    
    
    
    String username;
    String number;
    String address;
    String email;
    String password;
    String type="user";
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   

    

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    @PersistenceContext(unitName = "projectsPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    public void insert(){
        
        fl.insert(username, number, address, email, password, type);
         try
              {
                  FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
                  
              }
              catch (IOException e)
                      {
                          java.util.logging.Logger.getLogger(ManagedBean.class.getName()).log(Level.SEVERE,null,e);
                      }
         
        username="";
         number="";
         address="";
         email="";
         password="";
         type="";
          }
        String product_name;
        String product_desc;
        String date;
        String product_stock;
    String product_price;
    String product_img;
   
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(String product_stock) {
        this.product_stock = product_stock;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }
    
    
    
    int cat_id;
    String cat_name;
    int brand_id;
    String brand_name;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
    
    
    
    
    

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

   
    
    
    public void insertproduct(){
        
       fl.insertproduct(product_name, product_desc, brand_id, cat_id, date, product_stock, product_price, product_img);
        
        try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("add-product.jsf");
            } 
        catch (IOException ex)
                {
                 Logger.getLogger(Furniture.class.getName()).log(Level.SEVERE, null, ex);
                
                 
         
            }
        
     product_name="";   
     product_desc="";
     brand_id=0;
     cat_id=0;
     date="";
     product_stock="";
     product_price="";
     product_img="";
     
        
        
    }
    
    public List<Categories> get_category(){
        List<Categories> cd= em.createNamedQuery("Categories.findAll").getResultList();
        return cd;
    }
    
    
    public List<Brands> get_brands(){
        
        List<Brands> bd= em.createNamedQuery("Brands.findAll").getResultList();
        return bd;
    }
    
    
    public void checkuser(){
     UserInfo ad = fl.checkuser(username);
     String aemail = ad.getUsername();
     String pass = ad.getPassword();
     
     
     if(aemail.isEmpty()){
         valid = false;
     }else if( !(aemail.equals(username)) && !(pass.equals(password))){
         valid = false;
     } else {
         try{
             FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
         }catch(IOException e){
             
             
         }}}
   /* public void delete(Integer product_id)
    {
        fl.delete(product_id);
    }*/
    public List<Products>show()
    {
        List<Products>p=em.createNamedQuery("Products.findAll").getResultList();
        return p;
    }
    
    public void delete(Integer product_id)
    {
        fl.delete(product_id);
    }
    public void deletebrand(Integer brand_id)
    {
       fl.deletebrand(brand_id);
    }
    public void deletecat(Integer cat_id)
    {
       fl.deletecat(cat_id);
    }
    
    
    public void addcat()
    {
       fl.addcat(cat_name);
         try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dispcat.jsf");
            } catch (IOException ex) {
                Logger.getLogger(ManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void addbrand()
    {
        fl.addbrand(brand_name);
         try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dispbrand.jsf");
            } catch (IOException ex) {
                Logger.getLogger(ManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    public void srch(Integer cat_id)
        {
            Categories c1=fl.srch(cat_id);
            setCat_id(cat_id);
            cat_name=c1.getCatName();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("edit_cat.jsf");
            } catch (IOException ex) {
                Logger.getLogger(ManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
     public void catupdate(){
        fl.catupdate(cat_id, cat_name);
          try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dispcat.jsf");
            } catch (IOException ex) {
                Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
      public void bsrch(Integer brand_id)
        {
            Brands c1=fl.bsrch(brand_id);
            setBrand_id(brand_id);
            brand_name=c1.getBrandName();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("edit_brand.jsf");
            } catch (IOException ex) {
                Logger.getLogger(ManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
     public void brandupdate(){
        fl.brandupdate(brand_id, brand_name);
          try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dispbrand.jsf");
            } catch (IOException ex) {
                Logger.getLogger(Brands.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    //update
    
   /* public void update(){
    
            fl.updatepds(product_name, product_desc, brand_id, cat_id, date, product_stock, product_price, product_img);
            
            try{
                 FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
            
            }catch (Exception e)
            {
             Logger.getLogger(Furniture.class.getName()).log(Level.SEVERE, null, e);
            
            }
    }*/
    /**
     * Creates a new instance of ManagedBean
     */
    public ManagedBean() {
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } 
        catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
}
