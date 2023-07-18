package entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-31T13:08:05", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Admin.class)
public class Admin_ { 

    public static volatile SingularAttribute<Admin, String> adminName;
    public static volatile SingularAttribute<Admin, Integer> adminId;
    public static volatile SingularAttribute<Admin, String> adminImg;
    public static volatile SingularAttribute<Admin, String> adminPass;
    public static volatile SingularAttribute<Admin, String> adminEmail;

}