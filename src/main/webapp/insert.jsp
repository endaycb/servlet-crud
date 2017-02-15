<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Buku</title>
    </head>
    <body>
        <h1>Insert Buku</h1>
        <form method="POST" action="buku?action=Add">
            <table>
                <tr>
                    <td>Judul Buku</td>
                    <td><input type="text" name="judul"  required/></td>
                </tr>
                <tr>
                     <td>Pengarang</td>
                     <td><input type="text" name="pengarang" required/></td>
                </tr>
                <tr>
                     <td>Penerbit</td>
                     <td><input type="text" name="penerbit" required/></td>
                </tr>

                 <tr>
                     <td>Jumlah</td>
                     <td><input type="text" name="jumlah" required/></td>
                 </tr>
                 <tr>
                     <td></td>
                     <td><input type="submit" value="Submit" /> <a href="buku">Batal</a></td>
                 </tr>
            </table>  
        </form>
    </body>
</html>
