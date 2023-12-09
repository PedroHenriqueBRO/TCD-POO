/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

import entity.Entity;
import java.math.BigDecimal;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
public class Book extends Entity {
    private String nomelivro;
    private String autor;
    private BigDecimal quantidadeex;

    public Book(){
    }
    public Book(Long id,String nomelivro,String autor,BigDecimal quantidadeex){
        setNomelivro(nomelivro);
        setId(id);
        setAutor(autor);
        setQuantidadeex(quantidadeex);
    }
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNomelivro() {
        return nomelivro;
    }

    public void setNomelivro(String nomelivro) {
        this.nomelivro = nomelivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public BigDecimal getQuantidadeex() {
        return quantidadeex;
    }

    public void setQuantidadeex(BigDecimal quantidadeex) {
        this.quantidadeex = quantidadeex;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "Book{" + "nomelivro=" + nomelivro + ", autor=" + autor + ", quantidadeex=" + quantidadeex + '}';
    }
    
   
    
    
    
}
