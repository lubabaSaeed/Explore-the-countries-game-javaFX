/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author توتا
 */
import javax.persistence.*;
@Entity
   @Table(name="user")
public class username implements java.io.Serializable {
    @Id
   @Column(name="username")
   public  String username;
   
   @Column(name="pass")
   public  String pass;
   
   public username(){}

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
   
   
}
