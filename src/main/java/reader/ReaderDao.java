/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import credential.CredentialDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reader.Reader;
import reader.ReaderDao;
import repository.Dao;
import role.RoleDao;
import user.User;
import user.UserDao;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
public class ReaderDao extends Dao<Reader>{

public static final String TABLE = "reader";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(id,name,email,birthdate) values(?,?,?,?)";
    }

    @Override
    public String getUpdateStatment() {
        return " update "+ TABLE + " set name = ?,email = ?,birthdate = ? , where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id,name,email,birthdate" + " from reader where id = ?"; 
    }

    @Override
    public String getFindAllStatment() {
        return "select id" + " from reader";
    }

    @Override
    public String getDeleteStatment() {
         return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Reader e) {
    try {  
            pstmt.setLong(1, e.getId()); 
            pstmt.setString(2,e.getName());
            pstmt.setString(3, e.getEmail());
            pstmt.setObject(4, e.getBirthdate(), Types.DATE);
           
      }  catch (SQLException ex){
        Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public Reader extractObject(ResultSet resultSet) {
    

        Reader reader = null;

        try {
            reader = new Reader();
            reader.setId(resultSet.getLong("id"));
            reader.setName(resultSet.getString("name"));
            reader.setEmail(resultSet.getString("email"));
            reader.setBirthdate(resultSet.getObject("birthdate",LocalDate.class));
        }catch (Exception ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reader;
    }


    @Override
public List<Reader> extractObjects(ResultSet resultSet) {
    List<Reader> readerList = new ArrayList<>();

    try {
        while (resultSet.next()) {
            Reader reader = new Reader();
            reader.setId(resultSet.getLong("id"));
            readerList.add(reader);
        }
    } catch (Exception ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return readerList;
}
public void printall(){
    
   ReaderDao reader=new ReaderDao();
   RoleDao papelbusca=new RoleDao();
   CredentialDao buscacredencial=new CredentialDao();
   UserDao userbusca=new UserDao();
   for(Reader e:reader.findAll()){
       for(User u:userbusca.findAll()){
           if(u.getId()==e.getId()){
       System.out.println(">>"+papelbusca.findById(u.getRole().getId()));
       System.out.println(">>"+reader.findById(u.getId()));
       System.out.println(">> "+userbusca.findById(u.getId()) );
       System.out.println(">> "+buscacredencial.findById(u.getId()) );
           }
       }
   }
}



}