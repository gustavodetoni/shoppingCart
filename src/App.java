import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        try(BufferedReader linha = new BufferedReader(new FileReader("listaProdutos.txt"))){
            String aux = linha.readLine();
            while(aux != null) {    
                String[] dados = aux.split(";");
                Produto c1 = new Produto(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]));
                produtos.add(c1);
                aux = linha.readLine();
            }
            System.out.println("Arquivo lido com sucesso!");
            System.out.println("========= Carrinho de comprar =========");
            System.out.println("|       1- Ver Lista de Produtos      |");
            System.out.println("|       2- Adicionar ao carrinho      |");
            System.out.println("|       3- Ver carrinho               |");
            System.out.println("=======================================");
            int codigoDigitado = 0;
            ArrayList<itemCompra> itens = new ArrayList<>();
            while(codigoDigitado != 0) {
            System.out.println("Digite o codigo do produto: ");
            codigoDigitado = sc.nextInt();
            if (codigoDigitado==0) {
                break;
            }
            System.out.println("Quantidade que deseja comprar: ");
            int qtdeDigitado = sc.nextInt();
            int flag = 0;
            itemCompra item = null;
                for(int i=0; i<produtos.size();i++){
                    if(codigoDigitado == produtos.get(i).codigo){
                        flag = 1;
                        item = new itemCompra(produtos.get(i).descricao, qtdeDigitado, produtos.get(i).preco);
                        itens.add(item);
                        System.out.println("Item adicionado ao carrinho: " + produtos.get(i).descricao);
                        break;
                    } 
                } if (flag == 0) {
                    System.out.println("Codigo do produto inexistente.");
                }
                
            } sc.close();
                Carrinho carrinho = new Carrinho(itens, 10);
                carrinho.mostraCarrinho();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }

