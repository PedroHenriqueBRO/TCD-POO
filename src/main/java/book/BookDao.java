/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

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
import user.User;


public class BookDao extends Dao<Book> {
    
      public static final String TABLE="book";
    
     @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(nomelivro,autor,quantidadeex) values(?,?,?)";
    }

    @Override
    public String getUpdateStatment() {
        return " update "+ TABLE + " set nomelivro = ?, autor = ?, quantidadeex= ? , where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id,nomelivro,autor,quantidadeex" + " from "+TABLE+" where id = ?"; 
    }

    @Override
    public String getFindAllStatment() {
        return "select id, nomelivro,autor,quantidadeex" + " from " + TABLE;
    }

    @Override
    public String getDeleteStatment() {
         return "Delete from " + TABLE + " where id = ?";
    }
@Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Book e) {
    try {
        pstmt.setString(1, e.getNomelivro());
        pstmt.setString(2, e.getAutor());
        pstmt.setBigDecimal(3, e.getQuantidadeex());
        if (e.getId() != null) {
            pstmt.setLong(4, e.getId());
        }
    } catch (SQLException ex) {
        Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public Book extractObject(ResultSet resultSet) {

        Book livro = null;

        try {
            
            livro = new Book();
            livro.setId(resultSet.getLong("id"));
            livro.setNomelivro(resultSet.getString("nomelivro"));
            livro.setAutor(resultSet.getString("autor"));
            livro.setQuantidadeex(resultSet.getBigDecimal("quantidadeex"));            
        }catch (Exception ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return livro;
    }


    @Override
public List<Book> extractObjects(ResultSet resultSet) {
    List<Book> BookList = new ArrayList<>();

    try {
        while (resultSet.next()) {
            
            Book livro = new Book(); 
            livro.setId(resultSet.getLong("id"));
            livro.setNomelivro(resultSet.getString("nomelivro"));
            livro.setAutor(resultSet.getString("autor"));
            livro.setQuantidadeex(resultSet.getBigDecimal("quantidadeex"));      
            
            BookList.add(livro);
            
        }
    } catch (Exception ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return BookList;
}
   
}
  


