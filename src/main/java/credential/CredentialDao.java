/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package credential;

 import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.DbConnection;
import repository.Dao;
import user.User;
import user.UserDao;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
public class CredentialDao extends Dao<Credential> {
    
    public static final String TABLE = "credential";
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNamePassword(){
        return "SELECT * from credential where username = ? and password = md5(?)";
    }
    public String getAuthenticateStatment(){
        return "select * from credential where username=? and password=? ";
    }
    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(id,username, password, lastAcess, enabled,user_id) values(?,?, md5(?), ?, ?,?)";
    }

    @Override
    public String getUpdateStatment() {
        return " update "+ TABLE + " set id = ?,username = ?, password = md5(?), lastAcess = ?, enabled = ?,user_id = ? where id = "+id;
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, username, password, lastAcess, enabled,user_id" + " from credential where id = ?"; 
    }

    @Override
    public String getFindAllStatment() {
        return "select id, username, password, lastAcess, enabled,user_id" + " from credential";
    }

    @Override
    public String getDeleteStatment() {
         return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Credential e) {
    try {
        String salt=e.getPassword()+"_123dfertywqsaasq";
        pstmt.setString(2, e.getUsername());
        pstmt.setString(3, salt);
        pstmt.setObject(4, e.getLastAcess());
        pstmt.setBoolean(5, e.isEnabled());
        pstmt.setLong(6, e.getId());
   
        if (e.getId() != null) {
            pstmt.setLong(1, e.getId());
            
        }
      }  catch (SQLException ex){
        Logger.getLogger(CredentialDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public Credential extractObject(ResultSet resultSet) {
    

        Credential credential = null;

        try {
            credential = new Credential();
            credential.setId(resultSet.getLong("id"));
            credential.setUsername(resultSet.getString("username"));
            credential.setPassword(resultSet.getString("password"));
            credential.setLastAcess( resultSet.getObject("lastAcess", LocalDate.class));
            credential.setEnabled(resultSet.getBoolean("enabled"));
            credential.setUser(new UserDao().findById(resultSet.getLong("user_id")));
        }catch (Exception ex) {
            Logger.getLogger(CredentialDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return credential;
    }


    @Override
public List<Credential> extractObjects(ResultSet resultSet) {
    List<Credential> credentialList = new ArrayList<>();

    try {
        while (resultSet.next()) {
            Credential credential = new Credential();
            credential.setId(resultSet.getLong("id"));
            credential.setUsername(resultSet.getString("username"));
            credential.setPassword(resultSet.getString("password"));
            credential.setLastAcess(resultSet.getObject("lastAcess", LocalDate.class));
            credential.setEnabled(resultSet.getBoolean("enabled"));
            credential.setUser(new UserDao().findById(resultSet.getLong("user_id")));
            credentialList.add(credential);
        }
    } catch (Exception ex) {
            Logger.getLogger(CredentialDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return credentialList;
}
public User authenticate(Credential e){
    
   try ( PreparedStatement preparedStatement
                = repository.DbConnection.getConnection().prepareStatement(getAuthenticateStatment())) {                     
            preparedStatement.setString(1, e.getUsername());
            preparedStatement.setString(2, e.getPassword());
            
            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                Credential credencialencontrada=extractObject(resultSet);
                UserDao usuariorespectivo=new UserDao();
                return usuariorespectivo.findById(credencialencontrada.getId());
                
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;    
}
  


 public Credential guiAuthenticate(Credential e){
    
   try ( PreparedStatement preparedStatement
                = repository.DbConnection.getConnection().prepareStatement(getNamePassword())) {   
            String salt=e.getPassword()+"_123dfertywqsaasq";
            preparedStatement.setString(1, e.getUsername());
            preparedStatement.setString(2, salt);
            
            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                Credential credencialencontrada=extractObject(resultSet);
                
                return credencialencontrada;
                
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;    
}
  
}

