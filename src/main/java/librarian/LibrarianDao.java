/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarian;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
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


public class LibrarianDao extends Dao<Librarian> {
    
    public static final String TABLE = "librarian";

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
        return "select id,name,email,birthdate" + " from librarian where id = ?"; 
    }

    @Override
    public String getFindAllStatment() {
        return "select id,name,email,birthdate" + " from librarian";
    }

    @Override
    public String getDeleteStatment() {
         return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Librarian e) {
    try {
            pstmt.setLong(1, e.getId());
            pstmt.setString(2,e.getName());
            pstmt.setString(3, e.getEmail());
            pstmt.setObject(4, e.getBirthdate(), Types.DATE);
        
      }  catch (SQLException ex){
        Logger.getLogger(LibrarianDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public Librarian extractObject(ResultSet resultSet) {
    

        Librarian librarian = null;

        try {
            librarian = new Librarian();
            librarian.setId(resultSet.getLong("id"));
            librarian.setName(resultSet.getString("name"));
            librarian.setEmail(resultSet.getString("email"));
            librarian.setBirthdate(resultSet.getObject("birthdate",LocalDate.class));
        }catch (Exception ex) {
            Logger.getLogger(LibrarianDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return librarian;
    }


    @Override
public List<Librarian> extractObjects(ResultSet resultSet) {
    List<Librarian> librarianList = new ArrayList<>();

    try {
        while (resultSet.next()) {
            Librarian librarian = new Librarian();
            librarian.setId(resultSet.getLong("id"));
            librarian.setName(resultSet.getString("name"));
            librarian.setEmail(resultSet.getString("email"));
            librarian.setBirthdate(resultSet.getObject("birthdate",LocalDate.class));
            librarianList.add(librarian);
        }
    } catch (Exception ex) {
            Logger.getLogger(LibrarianDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return librarianList;
}
  public void printall(){
   LibrarianDao biblio=new LibrarianDao();
   RoleDao papelbusca=new RoleDao();
   CredentialDao buscacredencial=new CredentialDao();
   UserDao userbusca=new UserDao();
   for(Librarian e:biblio.findAll()){
       for(User u:userbusca.findAll()){
           if(u.getId()==e.getId()){
       System.out.println(">>"+papelbusca.findById(u.getRole().getId()));
       System.out.println(">>"+biblio.findById(u.getId()));
       System.out.println(">> "+userbusca.findById(u.getId()) );
       System.out.println(">> "+buscacredencial.findById(u.getId()) );
           }
       }
       
   }
  }

  
}
