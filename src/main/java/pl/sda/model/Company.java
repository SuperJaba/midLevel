package pl.sda.model;

/**
 * id
 * adress
 * nip
 * regon
 * <p>
 * get/set
 * toString
 * construktry
 */
public class Company {

    private String name;
    private String id;
    private Adress adress;
    private String regon;
    private String nip;

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Adress getAdress() {
        return adress;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Company() {
    }

    public Company(String name, String id, Adress adress, String regon, String nip) {
        this.name = name;
        this.id = id;
        this.adress = adress;
        this.regon = regon;
        this.nip = nip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", adress=" + adress +
                ", regon='" + regon + '\'' +
                ", nip=" + nip +
                '}';
    }


}
