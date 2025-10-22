import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // cria scanner
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse(); // cria a arvore

        arvore.preencherArvore(); // adiciona todas letras e numeros na arvore

        System.out.println("Árvore Binária Com Código Morse");
        int opcao = -1; // inicializa a opcao

        while (opcao != 0) { // loop do menu
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Codificar texto para código morse");
            System.out.println("2 - Decodificar mensagem morse para texto");
            System.out.println("3 - Buscar caractere por código morse");
            System.out.println("4 - Exibir Árvore");
            System.out.println("5 - Deletar Caractere");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (sc.hasNextInt()) { // verifica se digitou numero
                opcao = sc.nextInt();
            } else {
                System.out.println("Inválido.");
                sc.next(); // descarta entrada invalida
                continue;
            }
            sc.nextLine(); // consome a quebra de linha

            if (opcao == 1) {
                // codificar texto pra morse
                System.out.print("Digite a mensagem sem acentos: ");
                String mensagem = sc.nextLine();
                String morse = arvore.criarMorse(mensagem);
                System.out.println("Código Morse: " + morse);
            } else if (opcao == 2) {
                // decodificar morse pra texto
                System.out.print("Digite a mensagem em código morse, separe letras com espaço: ");
                String morse = sc.nextLine();
                String texto = arvore.decifrarMensagem(morse);
                System.out.println("Mensagem decodificada: " + texto);
            } else if (opcao == 3) {
                // buscar letra por morse
                System.out.print("Digite o código morse do caractere: ");
                String codigoMorse = sc.nextLine();
                char caractere = arvore.buscarCaractere(codigoMorse);

                if (caractere == '\0') {
                    System.out.println("Inválido ou não encontrado.");
                } else {
                    System.out.println("Caractere encontrado: " + caractere);
                }
            } else if (opcao == 4) {
                // mostrar a arvore toda
                System.out.println("\n Árvore Binária com Código Morse");
                arvore.exibirArvoreMorse();
            } else if (opcao == 0) {
                System.out.println("Encerrando."); // sair do programa
            } else if (opcao == 5) {
                System.out.print("Digite o código morse do caractere a deletar: ");
                String codigo = sc.nextLine();
                arvore.deleteCaractere(codigo);
                System.out.println("Caractere removido.");
            }else {
                System.out.println("Inválido"); // se digitou numero fora do menu
            }
        }

        sc.close(); // fecha scanner
    }
}
