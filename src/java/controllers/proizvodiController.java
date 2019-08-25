/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

 import java.sql.SQLException;  
  import modeli.Proizvodi;  
  import org.springframework.stereotype.Controller;  
  import org.springframework.ui.ModelMap;  
  import org.springframework.web.bind.annotation.ModelAttribute;  
  import org.springframework.web.bind.annotation.RequestMapping;  
  import org.springframework.web.bind.annotation.RequestMethod;  
    
  @Controller  
  public class proizvodiController {  
      
    @RequestMapping(value="/proizvodi", method=RequestMethod.GET)  
    public String prikazSadrzaja(ModelMap model) throws ClassNotFoundException, SQLException {  
        
      model.addAttribute("proizvodi", new Proizvodi());  
      model.addAttribute("sviProizvodi", Proizvodi.prikazProizvoda());  
      return "proizvodi";  
        
    }  
      
    @RequestMapping(value="/proizvodi", params="Dodaj" , method=RequestMethod.POST)  
    public String dodajProizvod(@ModelAttribute("proizvodi") Proizvodi odabraniProizvod, ModelMap model) throws ClassNotFoundException, SQLException {  
        
      odabraniProizvod.kreiranjeProizvoda();  
      prikazSadrzaja(model);  
      return "proizvodi";  
        
    }  
      
    @RequestMapping(value="/proizvodi", params="Obrisi" , method=RequestMethod.POST)  
    public String obrisiProizvod(@ModelAttribute("proizvodi") Proizvodi bivsiProizvod, ModelMap model) throws ClassNotFoundException, SQLException {  
         
      bivsiProizvod.brisanjeProizvoda();  
      prikazSadrzaja(model);  
      return "proizvodi";  
        
    }  
      
  }  
