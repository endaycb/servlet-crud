/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.controller;

import com.endaycb.belajar.dao.DaoBuku;
import com.endaycb.belajar.model.Buku;
import com.endaycb.belajar.implement.ImplementBuku;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author mashiro
 */
public class ControllerBuku extends HttpServlet{
    private DaoBuku ib = new DaoBuku();
    
    private String urlRedirect = "";
    final private String urlInsert = "/insert.jsp";
    final private String urlEdit = "/edit.jsp";
    final private String urlBuku = "/buku.jsp";
    
    public ControllerBuku(){
        super();
    }

    public void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
       String action = req.getParameter("action");
       
       if(action != null){
            if(action.equals("FormAdd")){
                urlRedirect = urlInsert;
            } else if(req.getParameter("id") != null && action.equalsIgnoreCase("FormEdit")){
                urlRedirect = urlEdit;
                
            } else if(req.getParameter("id") != null && action.equalsIgnoreCase("Delete")){
                try{
                    ib.delete(Integer.parseInt(req.getParameter("id")));
                } finally{
                    //res.sendRedirect(urlBuku);
                    urlRedirect = urlBuku;
                }
                
            } else if(action.equalsIgnoreCase("Add")){
                //res.sendRedirect(urlInsert);
                
                try{
                    Buku b = new Buku();
                    b.setJudul(req.getParameter("judul"));
                    b.setPenerbit(req.getParameter("penerbit"));
                    b.setPengarang(req.getParameter("pengarang"));
                    b.setJumlah(Integer.parseInt(req.getParameter("jumlah")));

                    ib.insert(b);
                }finally{
                    //res.sendRedirect(urlBuku);
                    urlRedirect = urlBuku;
                }
                
            } else if(req.getParameter("id") != null && action.equalsIgnoreCase("Edit")){
                //res.sendRedirect(urlEdit);
                try{
                    Buku b = ib.getById(Integer.parseInt(req.getParameter("id")));
                    b.setId(Integer.parseInt(req.getParameter("id")));
                    b.setJudul(req.getParameter("judul"));
                    b.setPenerbit(req.getParameter("penerbit"));
                    b.setPengarang(req.getParameter("pengarang"));
                    b.setJumlah(Integer.parseInt(req.getParameter("jumlah")));
                    
                    ib.update(b);
                } finally{
                    //res.sendRedirect(urlBuku);
                    urlRedirect = urlBuku;
                }
                
            } else if(req.getParameter("txtCari") != null){
                urlRedirect = urlBuku+"?txtCari="+req.getParameter("txtCari");
            }else {
                urlRedirect = urlBuku;
                
            }
       }else{
            urlRedirect = urlBuku;
       }
        RequestDispatcher rd = req.getRequestDispatcher(urlRedirect);
        rd.forward(req, res);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }
    
    
}
