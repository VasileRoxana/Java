package Proiect;

import java.util.Objects;

public class Produs implements Comparable<Produs> {

    private Integer codProdus, pret, anFabricatie, garantie, stoc;
    private String marca, producator, taraProvenienta;
    private final Categorie categorie;

    public Produs(Integer codProdus, Integer pret, Integer anFabricatie, Integer garantie,
            Integer stoc, String marca, String producator, String taraProvenienta) {
        this.codProdus = codProdus;
        this.pret = pret;
        this.anFabricatie = anFabricatie;
        this.garantie = garantie;
        this.stoc = stoc;
        this.marca = marca;
        this.producator = producator;
        this.taraProvenienta = taraProvenienta;
        switch (codProdus / 10000) {
            case 1:
                this.categorie = Categorie.PROCESOR;
                break;
            case 2:
                this.categorie = Categorie.PLACA_VIDEO;
                break;
            case 3:
                this.categorie = Categorie.PLACA_DE_BAZA;
                break;
            case 4:
                this.categorie = Categorie.HARD_DISK;
                break;
            case 5:
                this.categorie = Categorie.PLACA_DE_SUNET;
                break;
            case 6:
                this.categorie = Categorie.RAM;
                break;
            case 7:
                this.categorie = Categorie.CARCASA;
                break;
            case 8:
                this.categorie = Categorie.SURSA;
                break;
            default:
                this.categorie = null;
        }
    }

    public Produs() {
        this.codProdus = 0;
        this.pret = 0;
        this.anFabricatie = 0;
        this.garantie = 0;
        this.stoc = 0;
        this.marca = "NULL";
        this.producator = "NULL";
        this.taraProvenienta = "NULL";
        this.categorie = null;
    }

    public Integer getCodProdus() {
        return codProdus;
    }

    public void setCodProdus(Integer codProdus) {
        this.codProdus = codProdus;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }

    public Integer getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(Integer anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public Integer getGarantie() {
        return garantie;
    }

    public void setGarantie(Integer garantie) {
        this.garantie = garantie;
    }

    public Integer getStoc() {
        return stoc;
    }

    public void setStoc(Integer stoc) {
        this.stoc = stoc;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getTaraProvenienta() {
        return taraProvenienta;
    }

    public void setTaraProvenienta(String taraProvenienta) {
        this.taraProvenienta = taraProvenienta;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.codProdus);
        hash = 61 * hash + Objects.hashCode(this.pret);
        hash = 61 * hash + Objects.hashCode(this.anFabricatie);
        hash = 61 * hash + Objects.hashCode(this.garantie);
        hash = 61 * hash + Objects.hashCode(this.stoc);
        hash = 61 * hash + Objects.hashCode(this.marca);
        hash = 61 * hash + Objects.hashCode(this.producator);
        hash = 61 * hash + Objects.hashCode(this.taraProvenienta);
        hash = 61 * hash + Objects.hashCode(this.categorie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produs other = (Produs) obj;
        if (!Objects.equals(this.codProdus, other.codProdus)) {
            return false;
        }
        if (!Objects.equals(this.pret, other.pret)) {
            return false;
        }
        if (!Objects.equals(this.anFabricatie, other.anFabricatie)) {
            return false;
        }
        if (!Objects.equals(this.garantie, other.garantie)) {
            return false;
        }
        if (!Objects.equals(this.stoc, other.stoc)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.producator, other.producator)) {
            return false;
        }
        if (!Objects.equals(this.taraProvenienta, other.taraProvenienta)) {
            return false;
        }
        if (this.categorie != other.categorie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produs{" + "codProdus=" + codProdus + ", pret=" + pret + ", anFabricatie=" + anFabricatie + ", garantie=" + garantie + ", stoc=" + stoc + ", marca=" + marca + ", producator=" + producator + ", taraProvenienta=" + taraProvenienta + ", categorie=" + categorie + '}';
    }

    @Override
    public int compareTo(Produs o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}