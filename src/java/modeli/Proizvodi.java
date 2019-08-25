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
    
public class Proizvodi {
    private String name;  
    private int id_proizvoda;  
      
    public int getId_proizvoda(){  
      return id_proizvoda;  
    }  
    public void setId_proizvoda(int id_proizvoda){  
      this.id_proizvoda=id_proizvoda;  
    }  
    public String getName() {  
      return name;  
    }  
    public void setName(String name) {  
      this.name = name;  
   }  
      
    public static String prikazProizvoda() throws ClassNotFoundException, SQLException {  
      StringBuilder prikaz_proizvoda = new StringBuilder();  
      Class.forName("com.mysql.jdbc.Driver");  
        
      try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prodavnicadb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "Wedaddracic1984");) {  
    
        Statement st = conn.createStatement();  
        st.executeQuery("select proizvodi_id, naziv_proizvoda from proizvodi");  
        ResultSet rs = st.getResultSet();  
    
        while (rs.next()) {  
          prikaz_proizvoda.append(rs.getString("proizvodi_id"));  
          prikaz_proizvoda.append(": ");  
          prikaz_proizvoda.append(rs.getString("naziv_proizvoda"));  
          prikaz_proizvoda.append("\n");  
        }  
    
      } catch (SQLException ex) {  
        prikaz_proizvoda.append(ex.getMessage());  
      }  
      return prikaz_proizvoda.toString();   
    }  
      
    public void kreiranjeProizvoda() throws ClassNotFoundException {  
      Class.forName("com.mysql.jdbc.Driver");  
        
      try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prodavnicadb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "Wedaddracic1984");) {  
    
        if (name != null && !(name.isEmpty())) {  
    
          Statement st = conn.createStatement();  
          st.execute("insert into proizvodi (naziv_proizvoda) values ('" + name + "')");  
        }  
      } catch (SQLException ex) {  
        System.out.println("Error in database connection: \n" + ex.getMessage());  
      }  
    }  
      
    public void brisanjeProizvoda() throws ClassNotFoundException {  
      Class.forName("com.mysql.jdbc.Driver");  
        
      try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prodavnicadb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "Wedaddracic1984");) {  
    
        Statement st = conn.createStatement();  
        st.execute("delete from proizvodi where naziv_proizvoda='" + name + "'");  
        
      } catch (SQLException ex) {  
        System.out.println("Errorrrr: \n" + ex.getMessage());  
      }  
      
    }  
    } 
