package clase;

import java.util.Vector;

public class Produse {
   private int returnareProduse;
    private  Vector prd = new Vector();
    private Vector retur = new Vector();

    public Produse(){
        //this.sumaProduse = sumaProduse;
        this.returnareProduse = returnareProduse;
    }

    public int produseCumparate(){
        System.out.println(prd.toArray().length);
        return prd.toArray().length;
    }

    public void adaugareProdus(int suma){
        prd.add(suma);
    }

    public int produseReturnte(){
        System.out.println(retur.toArray().length);
        return returnareProduse;
    }
    public void addprodusReturnat(int suma){
        retur.add(suma);
    }

   public int totalVanzari(){
       int suma = 0;
        for(int i=0 ; i < prd.toArray().length; i++){
             suma = suma + (int)prd.get(i);
        }
        return suma;
   }
}
