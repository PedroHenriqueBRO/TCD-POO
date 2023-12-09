/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */

public interface IDao<E> {
    
    public String getSaveStatment();

    public String getUpdateStatment();
    
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, E e);
    
    public Long save(E e);
    
    public Long Update(E e);
    
    public String getFindByIdStatment();
    
    public String getFindAllStatment();
    
    public String getDeleteStatment();

    public E extractObject(ResultSet resultSet);

    public List<E> extractObjects(ResultSet resultSet);

    public E findById(Long id);

    public List<E> findAll();

    public void delete(Long id);


}

