/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emprestimo;

import book.Book;
import credential.Credential;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reader.ReaderDao;
import repository.Dao;
import role.RoleDao;
import user.User;


public class EmprestimoDao extends Dao<Emprestimo> {
    
      public static final String TABLE="emprestimo";
      
      private Long setid;
      
    public Long getSetid() {
        return setid;
    }
      
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public void setSetid(Long setid) {
        this.setid = setid;
    }

//</editor-fold>
    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(nomelivro,id_leitor,datadeemprestimo,entrega,autenticado) values(?,?,?,?,?)";
    }

    @Override
    public String getUpdateStatment() {
        return " update "+ TABLE + " set nomelivro = ?, id_leitor = ?,datadeemprestimo = ?,entrega = ?,autenticado = ? where id = " + setid;
    }

    @Override
    public String getFindByIdStatment() {
        return "select id,nomelivro,id_leitor,datadeemprestimo,entrega,autenticado" + " from "+TABLE+" where id = ?"; 
    }

    @Override
    public String getFindAllStatment() {
        return "select id,nomelivro,id_leitor,datadeemprestimo,entrega,autenticado" + " from " + TABLE;
    }

    @Override
    public String getDeleteStatment() {
         return "Delete from " + TABLE + " where id = ?";
    }
    
    
@Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Emprestimo e) {
    try {
        pstmt.setString(1, e.getNomelivro());
        pstmt.setLong(2, e.getLeitor().getId());
        pstmt.setObject(3, e.getDataEmprestimo());
        pstmt.setObject(4, e.getDataDevolução());
        pstmt.setBoolean(5, e.isAutenticado());
        if (e.getId() != null) {
            pstmt.setLong(6, e.getId());
        }
    } catch (SQLException ex) {
        Logger.getLogger(EmprestimoDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public Emprestimo extractObject(ResultSet resultSet) {

        Emprestimo livro = null;

        try {
            
            livro = new Emprestimo();
            livro.setId(resultSet.getLong("id"));
            livro.setNomelivro(resultSet.getString("nomelivro"));
            livro.setLeitor(new ReaderDao().findById(resultSet.getLong("id_leitor")));
            livro.setDataDevolução(resultSet.getObject("entrega", LocalDate.class));
            livro.setAutenticado(resultSet.getBoolean("autenticado"));
            livro.setDataEmprestimo(resultSet.getObject("datadeemprestimo", LocalDate.class));
        }catch (Exception ex) {
            Logger.getLogger(EmprestimoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return livro;
    }


    @Override
public List<Emprestimo> extractObjects(ResultSet resultSet) {
    List<Emprestimo> EmprestimoList = new ArrayList<>();

    try {
        while (resultSet.next()) {
            
            Emprestimo livro = new Emprestimo(); 
           livro.setId(resultSet.getLong("id"));
            livro.setNomelivro(resultSet.getString("nomelivro"));
            livro.setLeitor(new ReaderDao().findById(resultSet.getLong("id_leitor")));
            livro.setDataDevolução(resultSet.getObject("entrega", LocalDate.class));
            livro.setAutenticado(resultSet.getBoolean("autenticado"));
            livro.setDataEmprestimo(resultSet.getObject("datadeemprestimo", LocalDate.class));     
            
            EmprestimoList.add(livro);
            
        }
    } catch (Exception ex) {
            Logger.getLogger(EmprestimoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return EmprestimoList;
}
}
  


