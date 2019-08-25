<%-- 
    Document   : proizvodi
    Created on : Jun 22, 2019, 8:13:59 PM
    Author     : Vedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>  
        #lista_proizvoda {  
          background-color: white;  
          color:dodgerblue;  
          border: 0px;  
        }  
        h1 {  
          color:cadetblue;  
          border-bottom: 1px solid cadetblue;  
        }  
        #div1 {  
          text-align: right; 
          
        }  
        #div1 a {  
          margin: 10px;  
          font-size: 12px;  
          color:blue;  
          text-decoration: none;  
        }  
        #forma{  
          position: absolute;  
          bottom: 350px;  
          border-top: 1px dotted dodgerblue;  
          padding: 5px;  
        }  
      </style>  
    </head>
    <body>
        <div id="div1">  
        <a href="kupci.htm">KUPCI</a>  
        <a href="prodaja.htm">PRODAJA</a>  
      </div>  
     <h1>Proizvodi</h1>  
      </br>  
      <textarea id="lista_proizvoda" rows="20" cols="45" readonly>${sviProizvodi}</textarea>  
      </br>  
      <form:form action="proizvodi.htm" method="post" commandName="proizvodi" id="forma">  
        <form:input type="text" id="name" path="name" placeholder="naziv proizvoda..."></form:input>  
        <input type="submit" name="Dodaj" value="Dodaj" />  
        <input type="submit" name="Obrisi" value="Obrisi" />  
      </form:form> 
    </br>
    </body>
</html>
