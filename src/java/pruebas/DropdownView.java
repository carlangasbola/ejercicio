package pruebas;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {
     
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String country; 
    private String city;  
    private Map<String,String> countries;
    private Map<String,String> cities;
     
    @PostConstruct
    public void init() {
        /*La primer  propiedad es lo que se muestra */
        /*La segunda propiedad es el valor que tiene  */
        countries  = new HashMap<String, String>();
        countries.put("USA", "1");
        countries.put("Germany", "2");
        countries.put("Brazil", "3");
        
         
        Map<String,String> map = new HashMap<String, String>();
        map.put("New York", "11");
        map.put("San Francisco", "12");
        map.put("Denver", "13");
        data.put("1", map);
         
        map = new HashMap<String, String>();
        map.put("Berlin", "21");
        map.put("Munich", "22");
        map.put("Frankfurt", "23");
        data.put("2", map);
         
        map = new HashMap<String, String>();
        map.put("Sao Paolo", "31");
        map.put("Rio de Janerio", "32");
        map.put("Salvador", "33");
        data.put("3", map);
    }
 
    public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public Map<String, String> getCountries() {
        return countries;
    }
 
    public Map<String, String> getCities() {
        return cities;
    }
 
    public void onCountryChange() {
        if(country !=null && !country.equals(""))
            cities = data.get(country);
        else
            cities = new HashMap<String, String>();
    }
     
    public void displayLocation() {
        FacesMessage msg;
        if(city != null && country != null)
            msg = new FacesMessage("CITY ", city + " COUNTRY " + country);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
}