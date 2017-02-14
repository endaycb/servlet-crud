/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.dao;

import com.endaycb.belajar.config.Conn;
import com.endaycb.belajar.implement.ImplementBuku;
import com.endaycb.belajar.model.Buku;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author mashiro
 */
public class DaoBuku implements ImplementBuku  {
    private Connection connection;
    
    final private String search = "SELECT * FROM buku";
    final private String searchJudul = "SELECT * FROM buku WHERE judul LIKE ?";   
    final private String insert = "INSERT INTO buku (judul, pengarang, penerbit, jumlah) VALUES (?, ?, ?, ?)";
    final private String update = "UPDATE buku SET judul=?, pengarang=?, penerbit=?, jumlah=? WHERE id=?";
    final private String delete = "DELETE FROM buku WHERE id=?";
    final private String searchId = "SELECT * FROM buku WHERE id=?";
    
    public void DaoBuku(){
        Conn conn = new Conn();
        this.connection = conn.Conn();
        System.out.println("ok");
    }
    
  
    @Override
    public List<Buku> getAll() {
        List<Buku> lb = null;
        Statement s = null;
        
        try{
            lb = new ArrayList<Buku>();
            s = connection.createStatement();
            
            ResultSet rs = s.executeQuery(search);
            while(rs.next()){
                Buku b = new Buku();
                
                b.setId(rs.getInt("id"));
                b.setJudul(rs.getString("judul"));
                b.setPengarang(rs.getString("pengarang"));
                b.setPenerbit(rs.getString("penerbit"));
                b.setJumlah(rs.getInt("jumlah"));
                
                lb.add(b);
            }
            
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(s != null) s.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        
        return lb;
    }

    @Override
    public List<Buku> getByJudul() {
        List<Buku> lb = null;
        PreparedStatement ps = null;
        
        try{
            lb = new ArrayList<Buku>();
            ps = connection.prepareStatement(searchJudul);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Buku b = new Buku();
                
                b.setId(rs.getInt("id"));
                b.setJudul(rs.getString("judul"));
                b.setPengarang(rs.getString("pengarang"));
                b.setPenerbit(rs.getString("penerbit"));
                b.setJumlah(rs.getInt("jumlah"));
                
                lb.add(b);
            }
            
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(ps != null) ps.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        
        return lb;
    }

    @Override
    public Buku getById(Integer id){
        Buku b = new Buku();
        PreparedStatement ps = null;
        
        try{
            ps = connection.prepareStatement(searchId);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             
                b.setId(id);
                b.setJudul(rs.getString("judul"));
                b.setPenerbit(rs.getString("penerbit"));
                b.setPengarang(rs.getString("pengarang"));
                b.setJumlah(rs.getInt("jumlah"));
                
               
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(ps != null) ps.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        
        return b;
    }
    
    @Override
    public void insert(Buku b) {
        PreparedStatement ps = null;
        
        try{
            ps = connection.prepareStatement(insert);
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPengarang());
            ps.setString(3, b.getPenerbit());
            ps.setInt(4, b.getJumlah());
            
            ps.executeUpdate();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(ps != null) ps.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    
    }

    @Override
    public void update(Buku b) {
        PreparedStatement ps = null;
         
        try{
            ps = connection.prepareStatement(update);
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPengarang());
            ps.setString(3, b.getPenerbit());
            ps.setInt(4, b.getJumlah());
            ps.setInt(5, b.getId());
            ps.executeUpdate();
            
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(ps != null) ps.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = null;
         
        try{
            ps = connection.prepareStatement(update);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally{
            try{
                if(ps != null) ps.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
