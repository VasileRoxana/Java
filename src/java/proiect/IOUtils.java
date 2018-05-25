package proiect;

import Proiect.Produs;
import crud.CrudProdus;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class IOUtils {

    private static final String FISIER = "F:\\fak\\Java\\ProduseWeb\\produse.txt";

    public static void writeProd(ArrayList<Produs> prod) throws FileNotFoundException, IOException {

        try (FileOutputStream fos = new FileOutputStream(FISIER)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(prod);
        }
    }
    
    public static ArrayList<Produs> readProd() throws SQLException, ClassNotFoundException { //serializez liste
        ArrayList<Produs> produse = new ArrayList<>();
        CrudProdus crudProd = new CrudProdus();
        produse = crudProd.readAllProduse();
        return produse;
    }

    public static void updateProd(Produs prod) throws IOException, SQLException, ClassNotFoundException {
        ArrayList<Produs> produse = readProd();
        produse.add(prod);
        writeProd(produse);
    }

    public static void deleteProd(Produs prod) throws IOException, SQLException, ClassNotFoundException {
        CrudProdus crudProd = new CrudProdus();
        crudProd.deleteByCodProdus(prod.getCodProdus());
    }

    public static void addProd(Produs prod) throws IOException, SQLException, ClassNotFoundException{
        CrudProdus crudProd = new CrudProdus();
        System.out.println("urmeaza inserare produs.....");
        crudProd.insert(prod);
        System.out.println("IOUtils -> produs adaugat");
    }
}
