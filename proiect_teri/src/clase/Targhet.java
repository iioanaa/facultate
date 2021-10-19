package clase;

public class Targhet {
    private double conversie;
    private double VMB;

    public Targhet(){
        this.conversie = conversie;
        this.VMB  = VMB;
    }

    public double valoareConversie(double nrClienti){
        conversie = nrClienti / 10;
        return (double) conversie;
    }

    public double valoareVMB(double produseCumparate, double vanzariFinale){
        VMB = (produseCumparate + vanzariFinale ) /2 ;
        return VMB;
    }
}
