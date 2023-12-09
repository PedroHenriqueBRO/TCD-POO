/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emprestimo;

import entity.Entity;
import java.time.LocalDate;
import reader.Reader;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */
public class Emprestimo extends Entity{
    private String nomelivro;
    private LocalDate dataEmprestimo;
    private Reader leitor;
    private boolean autenticado;
    private LocalDate dataDevolução;
    
    public Emprestimo(){
        
    } 
    public Emprestimo(Long id,String nomedolivro,LocalDate datadeemprestimo,LocalDate datadedevolucao){
        setId(id);
        setNomelivro(nomedolivro);
        setDataEmprestimo(datadeemprestimo);
        setDataDevolução(datadedevolucao);
    }

    public String getNomelivro() {
        return nomelivro;
    }

    public void setNomelivro(String nomelivro) {
        this.nomelivro = nomelivro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public LocalDate getDataDevolução() {
        return dataDevolução;
    }

    public void setDataDevolução(LocalDate dataDevolução) {
        this.dataDevolução = dataDevolução;
    }

    public Reader getLeitor() {
        return leitor;
    }

    public void setLeitor(Reader leitor) {
        this.leitor = leitor;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "nomelivro=" + nomelivro + ", dataEmprestimo=" + dataEmprestimo + ", autenticado=" + autenticado + ", dataDevolu\u00e7\u00e3o=" + dataDevolução + '}';
    }
    
}
