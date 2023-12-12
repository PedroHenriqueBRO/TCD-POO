/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
    public abstract class Dao<E> implements IDao<E> {
    
    public static final String DB = "mydb";

    @Override
    public Long save(E e) {

        // Primary key
        Long id = 0L;
            // Insert a new register
            // try-with-resources
            try ( PreparedStatement preparedStatement
                    = repository.DbConnection.getConnection().prepareStatement(
                            getSaveStatment(),
                            Statement.RETURN_GENERATED_KEYS)) {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs insertion into the database
                preparedStatement.executeUpdate();

                // Retrieve the generated primary key
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                // Moves to first retrieved data
                if (resultSet.next()) {

                    // Retrieve the returned primary key
                    id = resultSet.getLong(1);
                }

            } catch (Exception ex) {
                System.out.println(">> " + ex);
            }

        return id;
    }
   @Override
    public Long Update(E e){
        Long id = 0L;
        // Update existing record
            try ( PreparedStatement preparedStatement
                    = repository.DbConnection.getConnection().prepareStatement(
                            getUpdateStatment())) {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs the update on the database
                preparedStatement.executeUpdate();

                // Keep the primary key
                id = ((Entity) e).getId();

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        return id;
    }
    
    @Override
    public E findById(Long id) {

        try ( PreparedStatement preparedStatement
                = repository.DbConnection.getConnection().prepareStatement(
                        getFindByIdStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, id);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObject(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }

    @Override
    public List<E> findAll() {

        try ( PreparedStatement preparedStatement
                = repository.DbConnection.getConnection().prepareStatement(
                        getFindAllStatment())) {

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object
            return extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        
        try (PreparedStatement preparedStatement = repository.DbConnection.getConnection().prepareStatement(getDeleteStatment())) {
        // Set the ID of the entity to be deleted in the DELETE statement
        preparedStatement.setLong(1, id);

        System.out.println(">> SQL: " + preparedStatement);

        // Execute the DELETE statement
        preparedStatement.executeUpdate();

    } catch (Exception ex) {
        System.out.println("Exception: " + ex);
    }
         
    }
         
}


