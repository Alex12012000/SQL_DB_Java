package Dao;

import model.Computer;
import java.sql.SQLException;
import java.util.*;

public interface BaseDAO<T> {

    /* 
    *   Dichiaro dei metodi con valore di ritorno e parametri 
    *   generici.
    *   Questa classe estenderà ComputerDAO.java
    *
     */


    public List<T> cercaPerMarca(String brand) throws SQLException;
    public List<T> cercaPerPrezzo(double prezzo) throws SQLException;
    public int inserisciPc(T pc) throws SQLException;
    public int modificaPc(T pc) throws SQLException; 
    public int eliminaPc(T pc) throws SQLException; 
    public List<T> vediTutti() throws SQLException;
}