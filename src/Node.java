public class Node {
    public char caractere;
    public Node esquerda;
    public Node direita;

    public Node(char caractere) {
        this.caractere = caractere;
        this.esquerda = null;
        this.direita = null;
    }

    public char getCaractere() {
        return caractere;
    }
    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }
    public Node getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }
    public Node getDireita() {
        return direita;
    }
    public void setDireita(Node direita) {
        this.direita = direita;
    }
}
