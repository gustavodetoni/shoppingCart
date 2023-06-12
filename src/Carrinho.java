import java.text.DecimalFormat;
import java.util.ArrayList;

public class Carrinho {
    ArrayList<itemCompra> listaItens = new ArrayList<>();
    double totalCompra;
    double porcDesconto;
    double valorPagar;
    DecimalFormat formatador = new DecimalFormat("0.00");

    public Carrinho(ArrayList<itemCompra> listaItens, double porcDesconto) {
        this.listaItens = listaItens;
        this.porcDesconto = porcDesconto;
        totalCompra = 0;
        valorPagar = 0;
    }

    public void mostraCarrinho() {
        System.out.println("\t\t\tItem\t\t\t\tPreço\t\tQuantidade\t\tSubtotal");
        int count = 1;
        for(itemCompra item : listaItens) {
            System.out.print(count + ".");
            item.mostraItem();
            count++;
        }
        System.out.println("\n\t\t\t\t\t\t\tSubtotal: \t\t\t\t" + formatador.format(somaValores()));
        System.out.println("\t\t\t\t\t\t\tDesconto: \t\t\t\t" + formatador.format(calcDesconto(totalCompra)));
        System.out.println("\t\t\t\t\t\t\t-----------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tValor a pagar: \t\t\t\t" + formatador.format(somaValores() - calcDesconto(totalCompra)));
    }

    public double calcDesconto(double totalCompra){
        return (totalCompra * porcDesconto) / 100;
    }  
    
    public double somaValores() {
        double soma = 0;
        for(itemCompra item : listaItens) {
            soma += item.calcSubtotal();
        }
        totalCompra = soma;
        return soma;
    }

}
