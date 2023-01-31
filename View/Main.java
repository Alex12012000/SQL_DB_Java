package View;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.ComputerDAOImpl;
import Dao.Database;
import OfflineDb.*;
import model.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        VistaUtente ui = new VistaUtente();
        ui.menu();
    }
}