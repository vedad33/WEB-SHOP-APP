/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import java.sql.DriverManager;  
  import java.sql.ResultSet;  
  import java.sql.SQLException;  
  import java.sql.Statement; 
public class Kupci {
    private int id;  
    private String name;  
    private String korpa;  
      
    public int getId() {  
      return id;  
    }  
    public String getName() {  
      return name;  
   }  
    public String getKorpa(){  
      return korpa;  
    }  
    public void setKorpa(String korpa){  
      this.korpa = korpa;  
    }  
    public void setId(int id) {  
      this.id = id;  
    }  
    public void setName(String name) {  
     this.name = name;  
    }  
      
    public static String prikazKupaca() throws ClassNotFoundException, SQLException {  
     StringBuilder prikaz_kupaca = new StringBuilder();  
      Class.forName("com.mysql.jdbc.Driver");  
        
      try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prodavnicadb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "Wedaddracic1984");) {  
   
        Statement st = conn.createStatement();  
        st.executeQuery("select kupci_id, ime_kupca, korpa from kupci");  
        ResultSet rs = st.getResultSet();  
          
    
       while (rs.next()) {  
         String korpa = rs.getString("korpa");  
          if(rs.getString("korpa")== null)  
           korpa = "Korpa je prazna";  
          prikaz_kupaca.append(rs.getString("kupci_id"));  
         prikaz_kupaca.append(": ");  
         prikaz_kupaca.append(rs.getString("ime_kupca"));  
          prikaz_kupaca.append("  // U korpi: ");  
         prikaz_kupaca.append(korpa);  
         prikaz_kupaca.append("\n");  
       }  
  
      } catch (SQLException ex) {  
        prikaz_kupaca.append(ex.getMessage());  
      }  
      return prikaz_kupaca.toString();   
   }  
      
      
     
    public void kreiranjeKupca() throws ClassNotFoundException {  
      Class.forName("com.mysql.jdbc.Driver");  
       
      try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prodavnicadb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "Wedaddracic1984");) {  
   
        if (name != null && !(name.isEmpty())) {  
    
         Statement st = conn.createStatement();  
          st.execute("insert into kupci (ime_kupca) values ('" + name + "')");  
        }  
      } catch (SQLException ex) {  
        System.out.println("Error in database connection: \n" + ex.getMessage());  
      }  
   }  
     
   public void brisanjeKupca() throws ClassNotFoundException {  
      Class.forName("com.mysql.jdbc.Driver");  
        
      try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prodavnicadb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "Wedaddracic1984");) {  
   
        Statement st = conn.createStatement();  
        st.execute("delete from kupci where ime_kupca='" + name + "'");  
        
      } catch (SQLException ex) {  
       System.out.println("Errorrrr: \n" + ex.getMessage());  
      }  
      } 
}
