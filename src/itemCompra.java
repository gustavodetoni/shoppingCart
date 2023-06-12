import java.text.DecimalFormat;

public class itemCompra {
    String descricao;
    int qtde;
    double preco;
    DecimalFormat formatador = new DecimalFormat("0.00");

    public itemCompra(String descricao, int qtde, double preco){
        this.descricao = descricao;
        this.qtde = qtde;
        this.preco = preco;
    }
    
    public void mostraItem(){
        System.out.println( descricao+ "\t\t\t" + formatador.format(preco) + "\t\t   " + qtde + "\t\t\t" + formatador.format(calcSubtotal()));
    }
    

    public double calcSubtotal() {
       return qtde*preco;
    }



}
