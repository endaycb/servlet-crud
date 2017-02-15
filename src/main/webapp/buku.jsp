<%-- 
    Document   : buku
    Created on : Feb 14, 2017, 1:28:15 PM
    Author     : mashiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.endaycb.belajar.dao.DaoBuku" %>
<%@page import="com.endaycb.belajar.model.Buku" %>
<%@page import="java.util.List" %>
<%
DaoBuku dBuku = new DaoBuku();
String txtCari = "";
List<Buku> lBuku = null;
//dBuku.DaoBuku();
if(request.getParameter("txtCari") != null){
    txtCari = request.getParameter("txtCari");
    lBuku = dBuku.getByJudul(txtCari);
}else{
    lBuku = dBuku.getAll();
}

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buku</title>
    </head>
    <body>
        <h1>Daftar Buku</h1>
        <form method='GET' action='buku'>
            cari <input type='text' placeholder='Judul' name='txtCari' value="<%=txtCari %>"/> <input type='submit' value='cari'/>
            
        </form>
        
        <a href="buku?action=FormAdd">Tambah Buku</a> 
        <table>
            <tr>
                <td>id</td>
                <td>Judul</td>
                <td>Pengarang</td>
                <td>Penerbit</td>
                <td>Jumlah</td>
                <td>Action</td>
            </tr>
            <% 
                for(Buku buku: lBuku){
            %>
            <tr>
            <td><%=buku.getId() %></td>
            <td><%=buku.getJudul() %></td>
            <td><%=buku.getPengarang() %></td>
            <td><%=buku.getPenerbit() %></td>
            <td><%=buku.getJumlah() %></td>
            <td><a href="buku?action=FormEdit&id=<%=buku.getId() %>">Edit</a> | <a href="buku?action=Delete&id=<%=buku.getId() %>">Delete</a></td>
            </tr>
            <% } %>
        </table>  
    </body>
</html>
