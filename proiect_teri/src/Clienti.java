import java.util.Vector;

public class Clienti {
    private int numarClienti;
    private Vector vec = new Vector();

    public Clienti(){
        this.numarClienti = numarClienti;
    }

    public double Counterclienti(){
        return vec.toArray().length;
    }

    public void adaugareClienti(){
        vec.add(1);
    }

}
