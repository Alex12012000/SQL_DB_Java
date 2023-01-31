package View;
import Dao.*;
import model.*;

import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;

public class VistaUtente{
    ComputerDAOImpl CDAO;
    Scanner scan;

       
    public VistaUtente()  throws SQLException {
        scan = new Scanner(System.in);
        this.CDAO = new ComputerDAOImpl();     
        menu();
    }


    /*
     * nome -> menu
     * descrizione -> menu principale del applicazione, tutti i menu seguenti e 
     * le funzioni richiamate devono tornare sempre a questo menu
     *
     * nella funzione:
     * swich che indirizza nei vari menu 
    */
    public void menu()  throws SQLException {
        //da implementare
        System.out.println("-----menu-----\n\n"
                            + " 1) Ricerca \n"
                            + " 2) Inserisci nuovo computer nel DB\n"
                            + " 3) Cancella computer dal DB\n"
                            + " 4) Modifica computer nel DB\n"
                            + " 0) Esci  \n" );
        int selezione = ritornaScelta();

        //da implementare
        switch (selezione) {
            case 1:
                menuRicerca();
                break;
            case 2:
                creaNuovoComputer();
                break;
            case 3:
                menuElimina();
                break;
            case 4:
                //da fare
                break;
            default:
                fineApp();
                break;
        }

    }

    //controllo sulla scelta del utente che sia un numero
    public int ritornaScelta(){
        while (true) {
            if(scan.hasNextInt()){
                int selezione = scan.nextInt();
                scan.nextLine();
                return selezione;
                
            }else{
                System.out.println("Prego inserire un numero esistente nel menu");
            }
        }
    }

    /*
     * nome -> menuRicerca
     * 
     * descrizione -> mostra i modi possibili di ricercare un computer 
     * e restituisce il computer ricercato 
    */
    public void menuRicerca() throws SQLException {
        //da implementare
        System.out.println("-----Menu Ricerca-----\n\n"
                            + " 1) Ricerca per marca \n"
                            + " 2) Ricerca per prezzo\n");
        int selezione = ritornaScelta();

        //da implementare
        switch (selezione) {
            case 1:
                System.out.println("Inserire marca da cercare\n");
                String marca = scan.nextLine();
                List<Computer> computerMarca = CDAO.cercaPerMarca(marca); 
                computerMarca.forEach(el -> System.out.println(el.toString()));
                menu();        
                break;
            case 2:
                System.out.println("Inserire il prezzo \n");
                double prezzo = scan.nextDouble();
                List<Computer> computersPrezzo = CDAO.cercaPerPrezzo(prezzo); 
                computersPrezzo.forEach(el -> System.out.println(el.toString()));
                menu();
                break;
            default:
                break;
        }
    }

    /*
     * nome metodo -> creaNuovoComputer
     *
     *  descrizione -> permette di creare un nuovo computer che verra aggiunto
     *  al database chiedendo i parametri al utente
     */
    public void creaNuovoComputer() throws SQLException {
        System.out.println("\nInserire la marca");
        String marca = scan.next();

        System.out.println("Inserire la ram ");
        String ram = scan.next();

        System.out.println("Inserire la CPU");
        String cpu = scan.next();

        System.out.println("Inserire le dimensioni dello schermo");
        double schermo = 0.00;
        while (true) {
            if(scan.hasNextDouble()){
                schermo = scan.nextDouble();
                scan.nextLine();
                break;
            }else{
                System.out.println("è accettabile solo un numero con la virgola, usare il punto");
                scan.nextLine();
            }
        }

        System.out.println("Inserire la GPU");
        String gpu = scan.nextLine();


        System.out.println("Inserire prezzo");
        double prezzo = 0.00;
        while (true) {
            if(scan.hasNextDouble()){
                prezzo = scan.nextDouble();
                break;
            }else{
                System.out.println("è accettabile solo un numero con la virgola, usare il punto");
                scan.nextLine();
            }
        }
        scan.nextLine();

        Computer comp = new Computer(marca,ram,cpu,schermo,gpu,prezzo);

        CDAO.inserisciPc(comp);
        System.out.println("\n\n--------------------------------");
        System.out.println("Inserimento riusciuto\n");

       System.out.println(comp.toString());


    }


    /*
     * nome metodo -> menuElimina
     *
     *  descrizione -> richiede l'id, se non si conosce l'id avvia il menu di ricerca
     */
    public void menuElimina() throws SQLException {
        List<Computer> comp= CDAO.vediTutti();
        comp.forEach(el ->  System.out.println("\n" + el.toString() + el.getPcId()));
        System.out.println("Inserire l'id del computer da eliminare");
        int scelta = 0;

        if (scan.hasNextInt()) {
            scelta = scan.nextInt();
            scan.nextLine();
        }else{
            System.out.println("Valore inserito non valido riprovare");
            menuElimina();
        }

        CDAO.eliminaPc(comp.get(scelta - 1));
        comp.forEach(el ->  System.out.println("\n" + el.toString()));
    }


    
    public void fineApp(){
        System.out.println("grazie e arrivederci");
        scan.close();
    }
}