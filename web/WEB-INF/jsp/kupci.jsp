<%-- 
    Document   : kupci
    Created on : Jun 22, 2019, 8:13:44 PM
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
        #lista_kupaca {  
         background-color: white;  
         color:dodgerblue;  
         border: 0px;  
       }  
        h1 {  
        color:white;  
          border-bottom: 1px solid cadetblue;  
       }  
        #div1 {  
         text-align: right;  
        }  
        #div1 a {  
          margin: 10px;  
         font-size: 12px;           color:blue;  
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
        <a href="proizvodi.htm">PROIZVODI</a>  
       <a href="prodaja.htm">PRODAJA</a>  
     </div>  
      <h1>Kupci</h1>  
      </br>  
      <textarea id="lista_kupaca" rows="15" cols="150" readonly>${sviKupci}</textarea>  
     </br>  
      <form:form action="kupci.htm" method="post" commandName="kupci" id="forma">  
        <form:input type="text" id="name" path="name" placeholder="ime i prezime kupca..."></form:input>  
        <input type="submit" name="Dodaj" value="Dodaj" />  
        <input type="submit" name="Obrisi" value="Obrisi" />  
      </form:form>  
    </body>
</html>
