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
   @Table(name="score")
public class score implements java.io.Serializable{
  
    @Column(name="username")
   public  String username;
    
    
   @Id
    @Column(name="id")
   public  int id;
   @Column(name="score")
   public  String score;
   
   @Column(name="level")
   public  String level;
   
   
   public score(){}

    public String getUsername() {
        return username;
    }

    public String getScore() {
        return score;
    }

    public String getLevel() {
        return level;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setLevel(String level) {
        this.level = level;
    }
   
   
   
    
}
