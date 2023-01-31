package Dao;

import model.Computer;
import java.util.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class ComputerDAOImpl implements ComputerDAO {

    /* 
    * @param brand (String)
    * 
    * funzione che data una stringa ritorna la corrispondente
    * lista di Computer con la stessa stringa
    *
     */
    @Override
    public List<Computer> cercaPerMarca(String brand) throws SQLException {
        Connection con = Database.getConnection();
        List<Computer> computers = new ArrayList<>();

        String sql = "SELECT id, Marca, Ram, CPU, Schermo, GPU, Prezzo FROM computers WHERE Marca=?";
        PreparedStatement ps = con.prepareStatement(sql);  
        ps.setString(1, brand);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            int oid = rs.getInt("id");
            String marca = rs.getString("Marca");
            String ram = rs.getString("Ram");
            String cpu = rs.getString("CPU");
            double schermo = rs.getDouble("Schermo");
            String gpu = rs.getString("GPU");
            double prezzo = rs.getDouble("Prezzo");

            Computer computer = new Computer(marca, ram, cpu, schermo, gpu, prezzo);
            computers.add(computer);
        }

    
        return computers;
    }

    /* 
    * @param prezzo (int)
    * 
    * funzione che dato un prezzo ritorna una lista di elementi
    * pari o superiore al prezzo richiesto
    *
    *
    * */

    @Override
    public List<Computer> cercaPerPrezzo(int prezzo) throws SQLException {
        Connection con = Database.getConnection();
        List<Computer> computers = new ArrayList<>();
        String sql = "SELECT id, Marca, Ram, CPU, Schermo, GPU, Prezzo FROM computers WHERE Prezzo >= ?";
        PreparedStatement ps = con.prepareStatement(sql);  
        ps.setDouble(1, prezzo);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            int oid = rs.getInt("id");
            String marca = rs.getString("Marca");
            String ram = rs.getString("Ram");
            String cpu = rs.getString("CPU");
            double schermo = rs.getDouble("Schermo");
            String gpu = rs.getString("GPU");
            double prezzoScelto = rs.getDouble("Prezzo");

            Computer computer = new Computer(marca, ram, cpu, schermo, gpu, prezzoScelto);
            computers.add(computer);
        }

    
        return computers;
    }

    /* 
    * @param pc (Computer)
    * 
    * funzione che si occupa di aggiungere un computer al db
    *
    *
    * */
    
    @Override
    public int inserisciPc(Computer pc) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "INSERT INTO computers (id, Marca, Ram, CPU, Schermo, GPU, Prezzo) VALUES (?, ?, ?, ?, ?, ?, ?) ";
        
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, pc.getPcId());
        ps.setString(2, pc.getMarca());
        ps.setString(3, pc.getRam());
        ps.setString(4, pc.getCpu());
        ps.setDouble(5, pc.getSchermo());
        ps.setString(6, pc.getGpu());
        ps.setDouble(7, pc.getPrezzo());

        int result = ps.executeUpdate();

        return result;

    }

    /* 
    * @param pc (Computer)
    * 
    * funzione per aggiornare un computer 
    * tutti i campi sono settabili ad eccezione di id che è Auto increment
    */

    @Override
    public int modificaPc(Computer pc) throws SQLException {
        Connection conn = Database.getConnection();
        String sql = "UPDATE computers SET Marca = ?, Ram = ?, CPU = ?, Schermo = ?, GPU = ?, Prezzo = ? WHERE id = ?";
        
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, pc.getPcId());
        ps.setString(2, pc.getMarca());
        ps.setString(3, pc.getRam());
        ps.setString(4, pc.getCpu());
        ps.setDouble(5, pc.getSchermo());
        ps.setString(6, pc.getGpu());
        ps.setDouble(7, pc.getPrezzo());

        int result = ps.executeUpdate();

        return result;

    }

    /* 
    * @param pc (Computer) 
    *
    * funzione per eliminare un computer
    *
     */

    @Override
    public int eliminaPc(Computer pc) throws SQLException {
        Connection conn = Database.getConnection();
        String sql = "DELETE FROM computers WHERE id=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, pc.getPcId());

        int result = ps.executeUpdate();

        return result;
    }

    /* 
    *
    *  seleziona TUTTO dalla tabella COMPUTER
    *  
    *   funzione che ritorna tutti gli elementi della
    *   tabella Computer 
    *
     */
    @Override
    public List<Computer> vediTutti() throws SQLException {
        Connection conn = Database.getConnection();
        String sql = "SELECT * FROM COMPUTER";
        
        List<Computer> computers = new ArrayList<>();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            String marca = rs.getString("Marca");
            String ram = rs.getString("Ram");
            String cpu = rs.getString("CPU");
            double schermo = rs.getDouble("Schermo");
            String gpu = rs.getString("GPU");
            double prezzoScelto = rs.getDouble("Prezzo");

            Computer computer = new Computer(marca, ram, cpu, schermo, gpu, prezzoScelto);

            computers.add(computer);
        }

        return computers;

    }
}