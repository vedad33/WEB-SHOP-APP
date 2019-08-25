/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;  
  import modeli.Kupci;  
  import modeli.Prodaja;  
 import modeli.Proizvodi;  
  import org.springframework.stereotype.Controller;  
 import org.springframework.ui.ModelMap;  
  import org.springframework.web.bind.annotation.ModelAttribute;  
  import org.springframework.web.bind.annotation.RequestMapping;  
  import org.springframework.web.bind.annotation.RequestMethod;  
    
  @Controller  
  public class ProdajaController {  
      
    @RequestMapping(value="/prodaja", method=RequestMethod.GET)  
    public String prikazSadrzaja(ModelMap model) throws ClassNotFoundException, SQLException {  
          
      model.addAttribute("kupci", new Kupci());  
      model.addAttribute("sviKupci", Kupci.prikazKupaca());  
      model.addAttribute("proizvodi", new Proizvodi());  
      model.addAttribute("sviProizvodi", Proizvodi.prikazProizvoda());  
      model.addAttribute("prodaja", new Prodaja());  
      return "prodaja";  
        
    }  
      
    @RequestMapping(value="/prodaja", params="Prodaj",method=RequestMethod.POST)  
    public String prodaja(@ModelAttribute("kupci") Kupci kupci, @ModelAttribute("proizvodi") Proizvodi proizvodi, @ModelAttribute("prodaja") Prodaja prodaja, ModelMap model) throws ClassNotFoundException, SQLException{  
            
      int proizvod = prodaja.getProizvod();  
      int kupac = prodaja.getKupac();  
      Prodaja.prodaja(kupac, proizvod);  
      prikazSadrzaja(model);  
      return "prodaja";  
        
    }  
      
  }  
