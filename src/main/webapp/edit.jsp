<%-- 
    Document   : listBuku
    Created on : Feb 14, 2017, 1:34:20 PM
    Author     : mashiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.endaycb.belajar.dao.DaoBuku" %>
<%@page import="com.endaycb.belajar.model.Buku" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Buku</title>
    </head>
    <body>
        <%
            Buku buku = new Buku();
            DaoBuku dBuku = new DaoBuku();
        %>
        
        <%
            Integer id = Integer.parseInt(request.getParameter("id"));
            if(id != null){
                buku = dBuku.getById(id);
        %>
        <h1>Edit Buku</h1>
        <form method="POST" action="buku?action=Edit" name="">
            <table>
                <tr>
                    <td>Judul Buku</td>
                    <td><input type="text" name="judul" value="<%=buku.getJudul() %>" required/></td>
                </tr>
                <tr>
                     <td>Pengarang</td>
                     <td><input type="text" name="pengarang" value="<%=buku.getPengarang() %>" required/></td>
                </tr>
                <tr>
                     <td>Penerbit</td>
                     <td><input type="text" name="penerbit" value="<%=buku.getPenerbit() %>" required/></td>
                </tr>

                 <tr>
                     <td>Jumlah</td>
                     <td><input type="text" name="jumlah" value="<%=buku.getJumlah() %>" required/></td>
                 </tr>
                 <tr>
                     <td><input type="hidden" name="id" value="<%=buku.getId() %>"></input></td>
                     <td><input type="submit" value="Submit" /> <a href="buku">Batal</a></td>
                 </tr>
            </table>  
        </form>
        <% }else{  %>
        <c:out value="Tidak ditemukan"/>
        <br/>
        <a href="">Ke daftar buku</a>
        <% } %>
        
    </body>
</html>
