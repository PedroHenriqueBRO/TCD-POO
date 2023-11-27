/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifnmg.relacionamentos;

import static repository.DbConnection.getConnection;
import user.*;
import repository.*;
import role.*;
import reader.*;
import librarian.*;
import credential.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class Relacionamentos{

    public static void main(String[] args) throws Exception{
        testeA();
//        testeB();
//        testeC();
//        testeD();
//        testeE();
//        testeF();
    }
    public static void testeA() throws Exception{
        Role Biblio=new Role(null,"Administrador");
        Long biblioid=new RoleDao().save(Biblio);
        Biblio.setId(biblioid);
        //Role setada
        User usuario=new User(null,"Pedro","Pedro20@gmail.com",Biblio,LocalDate.of(2004, Month.MARCH, 20));
        Long userid=new UserDao().save(usuario);
        usuario.setId(userid);
        //usuario setado
        Credential credencial=new Credential(userid,"Peu","123456",LocalDate.of(2023, Month.MARCH, 20),true);  
        Long credencialid=new CredentialDao().save(credencial);
        //credencial setada
        Librarian Bibliotecario=new Librarian(userid,usuario.getName(),usuario.getEmail(),LocalDate.of(2004, Month.MARCH, 20));
        new LibrarianDao().save(Bibliotecario);
        //Librarian setada
        RoleDao buscatodos=new RoleDao();
        buscatodos.printall();
        //printa todos em base ao role, ele tentara printar reader caso seja ou librarian , um dos dois dará nulo
        
         
    }
    public static void testeB() throws Exception{
        Role Biblio=new Role(null,"Leitor");
        Long biblioid=new RoleDao().save(Biblio);
        Biblio.setId(biblioid);
        //Role setada
        User usuario=new User(null,"Ana zayra","Ana90@gmail.com",Biblio,LocalDate.of(2004, Month.MARCH, 23));
        Long userid=new UserDao().save(usuario);
        usuario.setId(userid);
        //usuario setado
        Credential credencial=new Credential(userid,"Anaz","12345678",LocalDate.of(2023, Month.MARCH, 20),true);  
        Long credencialid=new CredentialDao().save(credencial);
        //credencial setada
        Reader leitor=new Reader(userid,usuario.getName(),usuario.getEmail(),LocalDate.of(2004, Month.MARCH, 23));
        new ReaderDao().save(leitor);
        //Librarian setada
        RoleDao buscatodos=new RoleDao();
        buscatodos.printall();
        //printa todos em base ao role, ele tentara printar reader caso seja ou librarian , um dos dois dará nulo
         
    }
    public static void testeC() throws Exception{
        //Teste em baso que voce usou o teste A e B , ja que assim eu vou usar uma role existente para setar esse usuario
        //Role setada
        Role Biblio=new Role(null,"Bibliotecario");
        new RoleDao().save(Biblio);
        User usuario=new User(null,"Cecilia Xerxes","Cecilia90@gmail.com",Biblio,LocalDate.of(2004, Month.MARCH, 25));
        Long userid=new UserDao().save(usuario);
        usuario.setId(userid);
        //usuario setado
        Credential credencial=new Credential(userid,"Cex","123456789",LocalDate.of(2023, Month.MARCH, 23),true);  
        Long credencialid=new CredentialDao().save(credencial);
        //credencial setada
        Reader leitor=new Reader(userid,usuario.getName(),usuario.getEmail(),LocalDate.of(2004, Month.MARCH, 25));
        new ReaderDao().save(leitor);
        //Librarian setada
        RoleDao buscatodos=new RoleDao();
        buscatodos.printall();
        //printa todos em base ao role, ele tentara printar reader caso seja ou librarian , um dos dois dará nulo
        //ira printa o usuario do teste A e B também 
    }
    
    public static void testeE() throws Exception{
        ReaderDao leitor=new ReaderDao();
        leitor.printall();
    }
    public static void testeD() throws Exception{
        LibrarianDao biblio=new LibrarianDao();
        biblio.printall();
        
    }
    public static void testeF() throws Exception{
        
        CredentialDao buscacredencial=new CredentialDao();
        List<Credential> lista=new ArrayList<>();
        lista=buscacredencial.findAll();
        for(Credential cre:lista){
        User usuario=buscacredencial.authenticate(cre);
        System.out.println(">> "+ usuario);
        try{
            System.out.println(buscacredencial.findById(usuario.getId()));
            System.out.println("Usuario autenticado");
        }catch(Exception e){
            System.out.println("Usuario não autenticado");
        }
        }
        
        Credential credencial2=new Credential(null,"Anaa","d7b2c8f91fbcb3584f18d3d8dbe2da05",LocalDate.of(2023, Month.MARCH, 02),true);
        User usuario2=buscacredencial.authenticate(credencial2);
        System.out.println(">> "+ usuario2);
        try{
            System.out.println(buscacredencial.findById(usuario2.getId()));
        }catch(Exception e){
            System.out.println("Usuario não autenticado");
        }
    }
         
         
    }
