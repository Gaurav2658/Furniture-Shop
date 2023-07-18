package entity;

import entity.Products;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-31T13:08:05", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Brands.class)
public class Brands_ { 

    public static volatile SingularAttribute<Brands, String> brandName;
    public static volatile ListAttribute<Brands, Products> productsList;
    public static volatile SingularAttribute<Brands, Integer> brandId;

}