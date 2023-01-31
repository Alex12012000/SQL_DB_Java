import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Database;
import model.Computer;


public class GestoreFileTxt{

    private FileReader filein;

    public GestoreFileTxt(){

    }

    public void read(){
        try {       
              filein = new FileReader("prova.txt");
              int next;
            do {
                next = filein.read(); // legge il prossimo carattere
                
                if (next != -1) { // se non e' finito il file
                    char nextc = (char) next;
                    System.out.print(nextc); // stampa il carattere
                }

            } while (next != -1);
            
            filein.close(); // chiude il file
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /*
     * nome metodo -> recuperaComputersDaTxt
     * 
     * nel metodo :
     * 1 recupera dal file txt tutti i record e divide in chiachi le parole precedenti ai : mentre in valori le parole prima dei ;
     * 
     */

    public List<Computer> recuperaComputersDaTxt(){
        List<String> chiavi =  new ArrayList<String>();
        List<String> valori =  new ArrayList<String>();
        List<Computer> com =  new ArrayList<Computer>();

        try {       
            filein = new FileReader("file.txt");
            int next;
            String text = "";
          do {
              next = filein.read(); // legge il prossimo carattere
                
              if (next != -1) { // se non e' finito il file
                    char nextc = (char) next;
                    if (nextc == ':') {
                        chiavi.add(text);
                        text = "";
                    }else if (nextc == ';'){
                        valori.add(text);
                        text = "";
                    }else if (nextc == ' ') {
                        //non fa nulla
                    }else{
                        text += nextc;
                    }

              }

          } while (next != -1);
          
          filein.close(); // chiude il file

          for (int i = 0; i < valori.size(); i = i+6) {
            Computer comp = new Computer(valori.get(i), valori.get(i+1), valori.get(i+2), Double.parseDouble(valori.get(i+3)), valori.get(i+4), Double.parseDouble(valori.get(i+5)));
            com.add(comp);
          }


      } catch (IOException e) {
          System.out.println(e);
      }
    
      com.forEach(el -> System.out.println(el.toString()));


        return com;
    }
}