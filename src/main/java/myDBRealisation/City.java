package myDBRealisation;

import java.util.List;

/**
 * Created by Ангелин on 07.10.2015.
 */
public class City{
    private int idCity;
    private String nameCity;
    private String country;

    public City(){
    }
    public City(String nameCity, String country){
        this.nameCity = nameCity;
        this.country = country;
    }
    public City(int idCity, String nameCity, String country){
        this.idCity = idCity;
        this.nameCity = nameCity;
        this.country = country;
    }
    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof City)) return false;
        City city = (City) obj;
        if(!this.nameCity.equals(city.nameCity))
            return false;
        if (!this.country.equals(city.country))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 89;
        result = 34 * result + country.hashCode();
        result = 34 * result + nameCity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City: "+nameCity+"\nID City: "+ idCity+"\nCountry: "+country;
    }
}
