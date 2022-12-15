package com.tweet.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    //valid email
    private String email;
    @Column(nullable = false,unique = true,length = 100)
    //alphanmeric character
    private String userName;
    
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @Column(nullable = false)
    @JsonIgnore
    private String conPassword;
    @Column(nullable = false)
    private String coontactNum;
    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", userName=" + userName + ", password=" + password + ", conPassword=" + conPassword
                + ", coontactNum=" + coontactNum + "]";
    }
    public User(int id, String firstName, String lastName, String email, String userName, String password,
            String conPassword, String coontactNum) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.conPassword = conPassword;
        this.coontactNum = coontactNum;
    }
    public void setfirstName(Object getfirstName) {
        // TODO Auto-generated method stub
        
    }
    public void setlastName(Object getlastName) {
        // TODO Auto-generated method stub
        
    }
    public void setuserName(Object getuserName) {
        // TODO Auto-generated method stub
        
    }
    public void setemail(Object getemail) {
        // TODO Auto-generated method stub
        
    }
    public void setconpassword(Object getconpassword) {
        // TODO Auto-generated method stub
        
    }
    public void setpassword(Object getpassword) {
        // TODO Auto-generated method stub
        
    }
    public void setcontactNum(Object getcontactNum) {
        // TODO Auto-generated method stub
        
    }
   
    
    

}
