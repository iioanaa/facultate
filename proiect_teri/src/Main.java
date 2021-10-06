import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        // am adaugat in plus revenirea la meniu
        System.out.println("\n \n Buna ziua, sunt programul Ruty \n \n");
        String meniu = ("Vizualizati meniul si alegeti optiunea \n "
                       + "1.WMB-ul magazinului (momentan indisponibila)\n"
                       + "2.Conversia magazinului \n"
                       + "3.Cati clienti au fost in magazin\n"
                       + "4.Cate produse au fost returnate\n"
                       + "5.Cati bani sunt in sertar\n"
                       + "6.Cate poduse au fost cumparate \n"
                       + "7.EXIT .  MULTUMESC\n");
        System.out.println(meniu);


        Scanner sc = new Scanner(System.in);
        int optiune = sc.nextInt();

        while (optiune < 1 || optiune > 9) {
            System.out.print("\n Error! Alegere incorecta.\n");
            System.out.println(meniu);
            optiune = sc.nextInt();
        }


        while(optiune != 7) {
            switch (optiune) {
                case 1:
                    Targhet tr = new Targhet();
                    Clienti cl = new Clienti();

                    cl.adaugareClienti();
                    cl.adaugareClienti();
                    cl.Counterclienti();
                    Produse pi = new Produse();
                    pi.adaugareProdus(56);
                    pi.adaugareProdus(12);
                    pi.adaugareProdus(85);
                    pi.totalVanzari();
                    tr.valoareVMB(pi.produseCumparate(), pi.totalVanzari());
                    System.out.println(" WMB este : " + tr.valoareVMB(pi.produseCumparate(), pi.totalVanzari()));
                    break;
                case 2:
                    Targhet tq = new Targhet();
                    System.out.println("Conversia este ");
                    Clienti lll = new Clienti();
                    lll.adaugareClienti();
                    lll.adaugareClienti();
                    System.out.println(tq.valoareConversie(lll.Counterclienti()));
                    break;
                case 3:
                    Clienti ll = new Clienti();
                    ll.adaugareClienti();
                    ll.adaugareClienti();
                    System.out.println("Au fost in magazin " + ll.Counterclienti() + " clienti");
                    break;
                case 4:
                    Produse po = new Produse();
                    System.out.print("Numarul de produse returnate este: ");
                    po.addprodusReturnat(43);
                    po.produseReturnte();
                    break;
                case 5:
                    Produse pp = new Produse();
                    System.out.println("Totalul incasarilor este : ");
                    pp.adaugareProdus(56);
                    pp.adaugareProdus(12);
                    int sumaVanzari = pp.totalVanzari();
                    System.out.println(sumaVanzari);
                    break;
                case 6:
                    System.out.println("Numarul de produse cumparate este : ");
                    Produse pt = new Produse();
                    pt.adaugareProdus(56);
                    pt.adaugareProdus(12);
                    pt.produseCumparate();
                    System.out.println();
                default:
                    System.out.println("OpTIUNE NEVALIDA");
            }
            System.out.println(meniu);
            optiune = sc.nextInt();
        }
    }
}
