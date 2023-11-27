/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package role;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
import credential.CredentialDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import librarian.LibrarianDao;
import reader.Reader;
import reader.ReaderDao;
import repository.Dao;
import user.User;
import user.UserDao;


public class RoleDao extends Dao<Role> {
    
    public static final String TABLE = "role";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(name) values(?)";
    }

    @Override
    public String getUpdateStatment() {
        return " update "+ TABLE + " set name = ?, where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, name" + " from role where id = ?"; 
    }

    @Override
    public String getFindAllStatment() {
        return "select id, name" + " from role";
    }

    @Override
    public String getDeleteStatment() {
         return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Role e) {
    try {
        pstmt.setString(1, e.getName());        
      }  catch (SQLException ex){
        Logger.getLogger(RoleDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public Role extractObject(ResultSet resultSet) {
    

        Role role = null;

        try {
            role = new Role();
            role.setId(resultSet.getLong("id"));
            role.setName(resultSet.getString("name"));
        }catch (Exception ex) {
            Logger.getLogger(RoleDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return role;
    }


    @Override
public List<Role> extractObjects(ResultSet resultSet) {
    List<Role> roleList = new ArrayList<>();

    try {
        while (resultSet.next()) {
            Role role = new Role();
            role.setId(resultSet.getLong("id"));
            role.setName(resultSet.getString("name"));
            roleList.add(role);
        }
    } catch (Exception ex) {
            Logger.getLogger(RoleDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return roleList;
}
  public void printall(){
    
   ReaderDao reader=new ReaderDao();
   RoleDao papelbusca=new RoleDao();
   CredentialDao buscacredencial=new CredentialDao();
   UserDao userbusca=new UserDao();
   LibrarianDao bibliobusca=new LibrarianDao();
   
   for(Role e:papelbusca.findAll()){
       System.out.println("Usuarios da role id= "+e.getId());
       for(User u:userbusca.findAll()){
           if(u.getRole().getId()==e.getId()){
       System.out.println(">>"+papelbusca.findById(e.getId()));
       System.out.println(">>"+reader.findById(u.getId()));
       System.out.println(">>"+bibliobusca.findById(u.getId()));
       System.out.println(">> "+userbusca.findById(u.getId()) );
       System.out.println(">> "+buscacredencial.findById(u.getId()));
       
           }
       }
   }
}
  
}