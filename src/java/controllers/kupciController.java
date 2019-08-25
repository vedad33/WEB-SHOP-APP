/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

  
 import java.sql.SQLException;  
 import modeli.Kupci;  
  import org.springframework.stereotype.Controller;  
 import org.springframework.ui.ModelMap;  
  import org.springframework.web.bind.annotation.ModelAttribute;  
  import org.springframework.web.bind.annotation.RequestMapping;  
  import org.springframework.web.bind.annotation.RequestMethod;  
    
    
    
  @Controller  
  public class kupciController {  
      
    @RequestMapping(value="/kupci", method=RequestMethod.GET)  
    public String prikazSadrzaja(ModelMap model) throws ClassNotFoundException, SQLException {  
        
      model.addAttribute("kupci", new Kupci());  
      model.addAttribute("sviKupci", Kupci.prikazKupaca());  
      return "kupci";  
        
    }  
      
    @RequestMapping(value="/kupci", params="Dodaj" , method=RequestMethod.POST)  
    public String dodajKupca(@ModelAttribute("kupci") Kupci odabraniKupac, ModelMap model) throws ClassNotFoundException, SQLException {  
        
      odabraniKupac.kreiranjeKupca();  
      prikazSadrzaja(model);  
      return "kupci";  
        
    }  
      
    @RequestMapping(value="/kupci", params="Obrisi" , method=RequestMethod.POST)  
    public String obrisiKupca(@ModelAttribute("kupci") Kupci bivsiKupac, ModelMap model) throws ClassNotFoundException, SQLException {  
         
      bivsiKupac.brisanjeKupca();  
      prikazSadrzaja(model);  
      return "kupci";  
        
    }  
      
  }  
    
  
