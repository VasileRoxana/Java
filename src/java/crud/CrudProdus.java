package crud;

import Proiect.Produs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudProdus extends Crud {

    public CrudProdus() throws SQLException, ClassNotFoundException {
        super();
    }
    private final String SELECT = " select * from produsedb.produs";
    private final String UPDATE = " UPDATE produsedb.produs\n"
            + "SET\n"
            + "codProdus = ?,\n"
            + "pret = ?,\n"
            + "anFabricatie = ?,\n"
            + "garantie = ?,\n"
            + "stoc = ?,\n"
            + "marca = ?,\n"
            + "producator = ?,\n"
            + "taraProvenienta = ?,\n"
            + "categorie = ?\n"
            + "WHERE codProdus = ?;";

    private final String INSERT = "INSERT INTO `produsedb`.`produs`\n"
            + "(`codProdus`,\n"
            + "`pret`,\n"
            + "`anFabricatie`,\n"
            + "`garantie`,\n"
            + "`stoc`, \n"
            + "`marca`,\n"
            + "`producator`,\n"
            + "`taraProvenienta`,\n"
            + "`categorie`)\n"
            + "VALUES\n"
            + "(?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?);";

    private final String DELETE_BY_CODPRODUS = "delete from `produsedb`.`produs` where `codProdus` = ?;";
    private final String VANZARE = "UPDATE `produsedb`.`produs` SET `stoc`= `stoc` - 1 WHERE `codProdus`= ?;";
    private final String ACTUALIZARE_STOC = "UPDATE `produsedb`.`produs` SET `stoc`= `stoc` + 1 WHERE `codProdus`= ?;";

    private final String AFISARE_PROCESOR = "select * from `produsedb`.`produs` where `categorie` = 'PROCESOR' ";
    private final String AFISARE_PLACA_VIDEO = "select * from `produsedb`.`produs` where `categorie` = 'PLACA_VIDEO' ";
    private final String AFISARE_PLACA_DE_BAZA = "select * from `produsedb`.`produs` where `categorie` = 'PLACA_DE_BAZA' ";
    private final String AFISARE_HARD_DISK = "select * from `produsedb`.`produs` where `categorie` = 'HARD_DISK' ";
    private final String AFISARE_PLACA_DE_SUNET = "select * from `produsedb`.`produs` where `categorie` = 'PLACA_DE_SUNET' ";
    private final String AFISARE_RAM = "select * from `produsedb`.`produs` where `categorie` = 'RAM' ";
    private final String AFISARE_CARCASA = "select * from `produsedb`.`produs` where `categorie` = 'CARCASA' ";
    private final String AFISARE_SURSA = "select * from `produsedb`.`produs` where `categorie` = 'SURSA' ";

    private final String CAUTARE_PRODUCATOR = "select * from `produsedb`.`produs` where `producator` = ?;";
    //private final String AFISARE_PRODUCATOR = "select * from `produsedb`.`produs` where `producator` = " + producator;

    public Produs read(ResultSet rs) throws SQLException {
        int codProdus = (rs.getInt("codProdus"));
        int pret = (rs.getInt("pret"));
        int anFabricatie = (rs.getInt("anFabricatie"));
        int garantie = (rs.getInt("garantie"));
        int stoc = (rs.getInt("stoc"));
        String marca = (rs.getString("marca"));
        String producator = (rs.getString("producator"));
        String taraProvenienta = (rs.getString("taraProvenienta"));
        Produs produs = new Produs(codProdus, pret, anFabricatie, garantie, stoc, marca, producator, taraProvenienta);
        return produs;
    }

    public ArrayList<Produs> readAllProduse() throws SQLException {
        ArrayList<Produs> result = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(SELECT);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public void update(Produs produs) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE)) {
            preparedStmt.setInt(1, produs.getCodProdus());
            preparedStmt.setInt(2, produs.getPret());
            preparedStmt.setInt(3, produs.getAnFabricatie());
            preparedStmt.setInt(4, produs.getGarantie());
            preparedStmt.setInt(5, produs.getStoc());
            preparedStmt.setString(6, produs.getMarca());
            preparedStmt.setString(7, produs.getProducator());
            preparedStmt.setString(8, produs.getTaraProvenienta());
            preparedStmt.setString(9, produs.getCategorie().toString());
            preparedStmt.setInt(10, produs.getCodProdus());
            preparedStmt.executeUpdate();
        }
    }

    public void insert(Produs produs) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(INSERT)) {
            preparedStmt.setInt(1, produs.getCodProdus());
            preparedStmt.setInt(2, produs.getPret());
            preparedStmt.setInt(3, produs.getAnFabricatie());
            preparedStmt.setInt(4, produs.getGarantie());
            preparedStmt.setInt(5, produs.getStoc());
            preparedStmt.setString(6, produs.getMarca());

            preparedStmt.setString(7, produs.getProducator());
            preparedStmt.setString(8, produs.getTaraProvenienta());

            preparedStmt.setString(9, produs.getCategorie().toString());
            preparedStmt.executeUpdate();

        }
    }

    public ArrayList<Produs> cautareProducator(String prod) throws SQLException, ClassNotFoundException {
        ArrayList<Produs> result = new ArrayList<>();

        PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(CAUTARE_PRODUCATOR);//de la addProdus
        preparedStmt.setString(1, prod);
        preparedStmt.execute();

        ResultSet rs = preparedStmt.executeQuery();//de la readProduse

        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public void deleteByCodProdus(Integer codProdus) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(DELETE_BY_CODPRODUS);
        preparedStmt.setInt(1, codProdus);
        preparedStmt.execute();
    }

    public void delete(Produs produs) throws SQLException, ClassNotFoundException {
        deleteByCodProdus(produs.getCodProdus());
    }

    public void vanzare(Produs produs) throws ClassNotFoundException, SQLException {
        int stoc = produs.getStoc();
        if (stoc > 0) {
            produs.setStoc(stoc - 1);
            PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(VANZARE);
            preparedStmt.setInt(1, produs.getCodProdus());
            preparedStmt.execute();
        }
    }

    public void actualizareStoc(Produs produs) throws ClassNotFoundException, SQLException {

        produs.setStoc(produs.getStoc() + 1);
        PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(ACTUALIZARE_STOC);
        preparedStmt.setInt(1, produs.getCodProdus());
        preparedStmt.execute();
    }

    public ArrayList<Produs> readProcesoare() throws SQLException {
        ArrayList<Produs> result = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(AFISARE_PROCESOR);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public ArrayList<Produs> readPlaciVideo() throws SQLException {
        ArrayList<Produs> result = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(AFISARE_PLACA_VIDEO);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public ArrayList<Produs> readPlaciDeBaza() throws SQLException {
        ArrayList<Produs> result = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(AFISARE_PLACA_DE_BAZA);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public ArrayList<Produs> readHardDisk() throws SQLException {
        ArrayList<Produs> result = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(AFISARE_HARD_DISK);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public ArrayList<Produs> readPlaciDeSunet() throws SQLException {
        ArrayList<Produs> result = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(AFISARE_PLACA_DE_SUNET);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public ArrayList<Produs> readRAM() throws SQLException {
        ArrayList<Produs> result = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(AFISARE_RAM);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public ArrayList<Produs> readCarcase() throws SQLException {
        ArrayList<Produs> result = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(AFISARE_CARCASA);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public ArrayList<Produs> readSurse() throws SQLException {
        ArrayList<Produs> result = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(AFISARE_SURSA);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

}
