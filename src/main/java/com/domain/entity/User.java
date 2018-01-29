package com.domain.entity;


import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Set;

//import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Peter Xu on 01/10/2015.
 */
@Entity
@Table(name = "user")
public class User extends BaseDomain {

    @Transient

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_TYPE")
    private String userType;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "signup_mode")
    private String signupMode;



    @Transient
    private String nickName;




    @Transient
    private Set<String> userRoles;



    @Transient
    private Integer companyId;
    @Transient
    private ArrayList<String> scene = new ArrayList<String>();

    public ArrayList<String> getScene() {
        return scene;
    }

    public void setScene(ArrayList<String> scene) {
        this.scene = scene;
    }

    private String userId;

    public User(String username) {

        this.userName = username;
    }

    public User(String username, String password) {

        this.userName = username;
        this.password = password;

    }


    public boolean  OpenIdBeBinded() {
        return false;
    }



    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSignupMode() {
        return signupMode;
    }

    public void setSignupMode(String signupMode) {
        this.signupMode = signupMode;
    }

    public User() {
    }

   // public User(String username, String password, Collection<? extends GrantedAuthority> grantedAuthorities) {


    //}


    public String getUserName() {
        return userName;
    }



    public String getUserType() {
        return userType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public void setUserRoles(Set<String> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<String> getUserRoles() {
        return userRoles;
    }



    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }











    @Transient
    private long expires;





    //@NotNull
    @Transient
    private boolean accountExpired;

   // @NotNull
    @Transient
    private boolean accountLocked;

   // @NotNull
    @Transient
    private boolean credentialsExpired;

   // @NotNull
    @Transient
    private boolean accountEnabled;

  //  @Transient
    @Transient
    private String newPassword;






    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }





    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }




    @Transient
    private boolean isWeixinBinded;

    public boolean isWeixinBinded() {
        return isWeixinBinded;
    }

    public void setWeixinBinded(boolean isWeixinBinded) {
        this.isWeixinBinded = isWeixinBinded;
    }




    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }
}
