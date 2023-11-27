/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import entity.Entity;
import java.time.LocalDate;
import user.User;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
public class Reader extends User{
    
 private String name;
    private String email;
    private LocalDate birthdate;
    
    public Reader(){
    }
    public Reader(Long id,String name,String email,LocalDate birthdate){
        setId(id);
        setName(name);
        setEmail(email);
        setBirthdate(birthdate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Reader{id = " +getId()+" ,name = "+getName()+", email = "+getEmail()+", birthdate = "+getBirthdate()+ '}';
    }
    
    
}