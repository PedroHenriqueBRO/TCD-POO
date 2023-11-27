/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package role;

import entity.Entity;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
public class Role extends Entity {

    private String name;
     
    public Role(){
    }
    public Role(Long id,String name)throws Exception{
        setId(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.length()>20){
            throw new Exception("Nome nao permitido");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" + "name = " + name +", id = "+getId()+ '}';
    }    
    
    

}

