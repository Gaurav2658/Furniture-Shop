package entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-31T13:08:05", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(UserInfo.class)
public class UserInfo_ { 

    public static volatile SingularAttribute<UserInfo, String> number;
    public static volatile SingularAttribute<UserInfo, String> password;
    public static volatile SingularAttribute<UserInfo, String> address;
    public static volatile SingularAttribute<UserInfo, Integer> id;
    public static volatile SingularAttribute<UserInfo, String> type;
    public static volatile SingularAttribute<UserInfo, String> email;
    public static volatile SingularAttribute<UserInfo, String> username;

}