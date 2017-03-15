package pl.sda.model;

/**
 * enum StreetPrefix ul al. pl.
 * houseNumber
 * streetName
 * postalCode
 * city
 * country
 *
 * get/set
 * constructor() i drugi ze wszystkim
 */
public class Adress {
    public enum StreetPrefix { STREET("ul."), AVENUE("al."), SQUARE("pl.");

        private final String prefix;

        StreetPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }
    }

    private StreetPrefix streetPrefix;
    private String streetName;
    private String houseNumber;
    private String postalCode;
    private String city;
    private String country;

    public Adress() {
    }

    public Adress(StreetPrefix streetPrefix, String houseNumber, String streetName, String postalCode, String city, String country) {
        this.streetPrefix = streetPrefix;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public StreetPrefix getStreetPrefix() {
        return streetPrefix;
    }

    public void setStreetPrefix(StreetPrefix streetPrefix) {
        this.streetPrefix = streetPrefix;
    }

    @Override
    public String toString() {
        return streetPrefix.getPrefix() + streetName + " " + houseNumber + "\n" + postalCode  + " " + city;
    }
}
