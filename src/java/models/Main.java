package models;

import Proiect.Produs;
import crud.CrudProdus;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        CrudProdus crudProd = new CrudProdus();
        Produs a = crudProd.readAllProduse().get(0);
        ArrayList<Produs> produse = crudProd.readAllProduse();
        a.setCodProdus(99999);
        a.setAnFabricatie(5);
        crudProd.insert(a);
        System.out.println("\n\n");
        crudProd.readAllProduse().forEach(e -> System.out.println(e));
    }
}
