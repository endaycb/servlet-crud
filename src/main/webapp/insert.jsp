<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Buku</title>
    </head>
    <body>
        <h1>Insert Buku</h1>
        <form method="POST" action="ControllerBuku" name="Add">
            <table>
                <tr>
                    <td>Judul Buku</td>
                    <td><input type="text" name="judul" /></td>
                </tr>
                <tr>
                     <td>Pengarang</td>
                     <td><input type="text" name="pengarang" /></td>
                </tr>
                <tr>
                     <td>Penerbit</td>
                     <td><input type="text" name="penerbit" /></td>
                </tr>

                 <tr>
                     <td>Jumlah</td>
                     <td><input type="text" name="jumlah" /></td>
                 </tr>
                 <tr>
                     <td></td>
                     <td><input type="submit" value="Submit" /> <a href="">Batal</a></td>
                 </tr>
            </table>  
        </form>
    </body>
</html>
