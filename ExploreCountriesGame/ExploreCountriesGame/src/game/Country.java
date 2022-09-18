
package game;

public class Country {
    
    private String countryname ;
    private String countryStyleImg ;
    private String countryflag;
    private String countryIconPlace;
    private String countryAnimal;
    private String countryCostume;
    private String countryFood;
    public static Boolean[] saudiScoreGames ={false,false,false,false};  
    public static Boolean[] chinaScoreGame ={false,false,false,false}; 
    public static Boolean[] brazilScoreGame ={false,false,false,false};
    public static Boolean[] russiaScoreGame ={false,false,false,false};
    
    public static int saudiScore;
    public static int chinaScore;
    public static int brazilScore;
    public static int russiaScore;
    
    public Country(String countryname,String countryStyleImg , String countryflag, String countryIconPlace) {
        this.countryname = countryname;
        this.countryStyleImg = countryStyleImg;
        this.countryflag = countryflag;
        this.countryIconPlace = countryIconPlace;
    }
    
      

    public String getCountryStyleImg() {
        return countryStyleImg;
    }

    public void setCountryStyleImg(String countryStyleImg) {
        this.countryStyleImg = countryStyleImg;
    }

    public Country() {
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountryflag() {
        return countryflag;
    }

    public void setCountryflag(String countryflag) {
        this.countryflag = countryflag;
    }

    public String getCountryIconPlace() {
        return countryIconPlace;
    }

    public void setCountryIconPlace(String countryIconPlace) {
        this.countryIconPlace = countryIconPlace;
    }

    public String getCountryAnimal() {
        return countryAnimal;
    }

    public void setCountryAnimal(String countryAnimal) {
        this.countryAnimal = countryAnimal;
    }

    public String getCountryCostume() {
        return countryCostume;
    }

    public void setCountryCostume(String countryCostume) {
        this.countryCostume = countryCostume;
    }

    public String getCountryFood() {
        return countryFood;
    }

    public void setCountryFood(String countryFood) {
        this.countryFood = countryFood;
    }

    @Override
    public String toString() {
        return "Country{" + "countryname=" + countryname + ", countryflag=" 
               + countryflag + ", countryIconPlace=" + countryIconPlace +
                ", countryAnimal=" + countryAnimal + ", countryCostume=" +
                countryCostume + ", countryFood=" + countryFood + '}';
    }
    
    
    
    
    
    
    
    
}
