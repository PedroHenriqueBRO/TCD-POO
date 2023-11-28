/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import credential.Credential;
import entity.Entity;
import java.time.LocalDate;
import role.Role;

/**
 *
 * @author xtron
 */
public class User extends Entity{
    private String name;
    private String email;
    private LocalDate birthdate;
    private Role role;
    
    
    public User(){
        
    }
    public User(Long id,String name,String email,LocalDate birthdate) throws Exception{
        setId(id);
        setName(name);
        setEmail(email);
        setBirthdate(birthdate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception{
        if(name.length()>150){
            throw new Exception("Nome nao permitido");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception{
        if(email.length()>255){
            throw new Exception("Email nao permitido");
        }
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + ", birthdate=" + birthdate + ", role=" + role+'}';
    }

   

    
}
