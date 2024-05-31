package main.java.list.OperacoesBasicas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarrinhoDeCompras {
    // Atributos
    private List<Item> itemList;

    // Construtor
    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    // Método para adicionar um item ao carrinho
    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    // Método para remover um item do carrinho
    public void removerItem(String nome) {
        if (!itemList.isEmpty()) {
            Iterator<Item> iterator = itemList.iterator();
            while (iterator.hasNext()) {
                Item item = iterator.next();
                if (item.getNome().equalsIgnoreCase(nome)) {
                    iterator.remove();
                }
            }
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    // Método para calcular o valor total do carrinho
    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                valorTotal += item.getPreco() * item.getQuantidade();
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    // Método para exibir os itens do carrinho
    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println("Itens no carrinho:");
            for (Item item : itemList) {
                System.out.println(item);
            }
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itens=" + itemList +
                '}';
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("Lápis");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}

class Item {
    // Atributos
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor
    public Item(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Método toString
    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}
