/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package credential;

import entity.Entity;
import java.time.LocalDate;
import user.User;

/**
 *
 * @author Pedro Henrique
 */
public class Credential extends Entity{
    
    private String username; // 15 max length
    private String password;
    private LocalDate lastAcess;
    private boolean enabled;
    private User user;
    public Credential(){
        
    }
    public Credential(Long id,String username, String password) throws Exception {
        setId(id);
        setUsername(username);
        setPassword(password);
        setEnabled(true);
        
    }
    //<editor-fold defaultstate="collapsed" desc="comment">
    public String getUsername() {
        return username;
    }

    public void setUsername(String username)throws Exception {
        if(username.length() > 15){
            throw new Exception("Username não permitido");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)throws Exception {
        if(password.length() > 32){
            throw new Exception("Password não permitido");
        }
        this.password = password;
    }

    public LocalDate getLastAcess() {
        return lastAcess;
    }

    public void setLastAcess(LocalDate lastAcess) {
        this.lastAcess = lastAcess;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
//</editor-fold>

    @Override
    public String toString() {
        return "Credential{" + "username=" + username + ", password=" + password + ", lastAcess=" + lastAcess + ", enabled=" + enabled + ", user=" + user + '}';
    }

    

}
