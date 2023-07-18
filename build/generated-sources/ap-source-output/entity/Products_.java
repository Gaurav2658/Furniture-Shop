package entity;

import entity.Brands;
import entity.Categories;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-31T13:08:05", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> productDesc;
    public static volatile SingularAttribute<Products, String> date;
    public static volatile SingularAttribute<Products, Categories> catId;
    public static volatile SingularAttribute<Products, Integer> productId;
    public static volatile SingularAttribute<Products, Brands> brandId;
    public static volatile SingularAttribute<Products, String> productStock;
    public static volatile SingularAttribute<Products, String> productImg;
    public static volatile SingularAttribute<Products, String> productName;
    public static volatile SingularAttribute<Products, String> productPrice;

}