package View;
import Dao.*;
import model.*;

import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;

public class VistaUtente{
    ComputerDAOImpl CDAO;
    Scanner scan;

       
    public VistaUtente(){
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
    public void menu() {
        //da implementare
        System.out.println("-----menu-----\n"
                            + " 1) ricerca \n"
                            + " 2) inserisci nuovo computer nel DB\n"
                            + " 3) cancella computer dal DB\n"
                            + " 4) modifica computer nel DB\n"
                            + " 0) esci  " );
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
                System.out.println("prego inserire un numero esistente nel menu");
            }
        }
    }

    /*
     * nome -> menuRicerca
     * 
     * descrizione -> mostra i modi possibili di ricercare un computer 
     * e restituisce il computer ricercato 
    */
    public void menuRicerca(){
        //da implementare
        System.out.println("-----menu ricerca-----\n"
                            + " 1) ricerca per marca \n"
                            + " 2) ricerca per nome");
        int selezione = ritornaScelta();

        //da implementare
        switch (selezione) {
            case 1:
                System.out.println("inserire marca da cercare");
                String marca = scan.nextLine();
                List<Computer> computerMarca = CDAO.cercaPerMarca(marca); 
                computerMarca.forEach(el -> System.out.println(el.toString());
                menu();        
                break;
            case 2:
                System.out.println("inserire nome");
                String nome = scan.nextLine();
                List<Computer> computerNome = CDAO.cercaPerMarca(marca); 
                computerNome.forEach(el -> System.out.println(el.toString());
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
        System.out.println("inserire la marca ");
        String marca = scan.next();

        System.out.println("inserire la ram ");
        String ram = scan.next();

        System.out.println("inserire la CPU");
        String cpu = scan.next();

        System.out.println("inserire le dimenzioni dello schermo");
        double schermo = 0.00;
        while (true) {
            if(scan.hasNextDouble()){
                schermo = scan.nextDouble();
                break;
            }else{
                System.out.println("è accettabile solo un numero con la virgola, usare il punto");
            }
        }

        System.out.println("Inserire la GPU");
        String gpu = scan.next();


        System.out.println("inserire prezzo");
        double prezzo = 0.00;
        while (true) {
            if(scan.hasNextDouble()){
                prezzo = scan.nextDouble();
                break;
            }else{
                System.out.println("è accettabile solo un numero con la virgola, usare il punto");
            }
        }
        scan.nextLine();

        Computer comp = new Computer(marca,ram,cpu,schermo,gpu,prezzo);

        CDAO.inserisciPc(comp);

    }


    /*
     * nome metodo -> menuElimina
     *
     *  descrizione -> richiede l'id, se non si conosce l'id avvia il menu di ricerca
     */
    public void menuElimina()throws SQLException{
        List<Computer> comp= CDAO.vediTutti();
        comp.forEach(el ->  System.out.println(el.toString()));
        System.out.println(" inserire l'id del computer da eliminare");
        int scelta = 0;

        if (scan.hasNextInt()) {
            scelta = scan.nextInt();
            scan.nextLine();
        }else{
            System.out.println("valore inserito non valido riprovare");
            menuElimina();
        }

        CDAO.eliminaPc(comp.get(scelta));
    }


    
    public void fineApp(){
        System.out.println("grazie e arrivederci");
        scan.close();
    }
}