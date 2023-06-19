public class Produto {
    int codigo;
    String descricao;
    Double preco;

    public Produto(int codigo, String descricao, Double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", descrição: " + descricao + ", preço: " + preco;
    }
}
