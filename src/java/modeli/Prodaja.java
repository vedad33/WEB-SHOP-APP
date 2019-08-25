/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import java.sql.Connection;
import java.sql.DriverManager;  
  import java.sql.ResultSet;  
  import java.sql.SQLException;  
import java.sql.Statement;  
public class Prodaja {
    private int kupac;  
    private int proizvod;  


      
    public int getKupac(){  
      return kupac;  
    }  
    public int getProizvod(){  
      return proizvod;  
    }  
    public void setKupac(int kupac) {  
      this.kupac = kupac;  
    }  
    public void setProizvod(int proizvod) {  
      this.proizvod= proizvod;  
    }  
      
    public static void prodaja(int kupac, int proizvod) throws ClassNotFoundException {  
        
      Class.forName("com.mysql.jdbc.Driver");  
      try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prodavnicadb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "Wedaddracic1984");) {  
          
       Statement st = conn.createStatement();  
         
        st.executeQuery("select korpa from kupci where kupci_id='" + String.valueOf(kupac) + "'");  
        ResultSet rs = st.getResultSet();  
        String korpa = null;  
        while(rs.next())  
          korpa = rs.getString("korpa");  
          
        st.executeQuery("select naziv_proizvoda from proizvodi where proizvodi_id='" + String.valueOf(proizvod) + "'");  
        ResultSet rs2 = st.getResultSet();  
        String imeProizvoda = null;  
        while(rs2.next())  
          imeProizvoda = rs2.getString("naziv_proizvoda");  
          
        if (korpa == null)   
          st.execute("update kupci set korpa='" + imeProizvoda + ", " + "' where kupci_id='" + String.valueOf(kupac) + "'");  
        else  
          st.execute("update kupci set korpa='" + korpa + imeProizvoda + ", " + "' where kupci_id='" + String.valueOf(kupac) + "'");  
          
        st.execute("delete from proizvodi where proizvodi_id='" + String.valueOf(proizvod) + "'");  
              
      } catch (SQLException ex) {  
        System.out.println("Error in database connection: \n" + ex.getMessage());  
      }  
      
    }  
     } 
