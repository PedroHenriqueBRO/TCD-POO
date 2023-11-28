/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;


import credential.CredentialDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.Dao;
import role.RoleDao;


/**
 *
 * @author Pedro Henrique;
 */

public class UserDao extends Dao<User> {
      public static final String TABLE="user";
    
     @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(name,email,role_id,birthdate) values(?,?,?,?)";
    }

    @Override
    public String getUpdateStatment() {
        return " update "+ TABLE + " set name = ?, email = ?, role_id = ? , birthdate = ? where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id,name,email,role_id,birthdate" + " from "+TABLE+" where id = ?"; 
    }

    @Override
    public String getFindAllStatment() {
        return "select id, name, email, role_id,birthdate" + " from " + TABLE;
    }

    @Override
    public String getDeleteStatment() {
         return "Delete from " + TABLE + " where id = ?";
    }
@Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, User e) {
    try {
        pstmt.setString(1, e.getName());
        pstmt.setString(2, e.getEmail());
        pstmt.setObject(4, e.getBirthdate());
        pstmt.setLong(3, e.getRole().getId());
        if (e.getId() != null) {
            pstmt.setLong(5, e.getId());
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public User extractObject(ResultSet resultSet) {

        User usuario = null;

        try {
            usuario = new User();
            usuario.setId(resultSet.getLong("id"));
            usuario.setName(resultSet.getString("name"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setBirthdate(resultSet.getObject("birthdate", LocalDate.class));
            usuario.setRole(new RoleDao().findById((resultSet.getLong("role_id"))));            
        }catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }


    @Override
public List<User> extractObjects(ResultSet resultSet) {
    List<User> UserList = new ArrayList<>();

    try {
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setBirthdate(resultSet.getObject("birthdate", LocalDate.class));
            user.setRole(new RoleDao().findById((resultSet.getLong("role_id"))));
            UserList.add(user);
        }
    } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return UserList;
}
}
  
