public class Teste {
    public static void main(String[] args) {
        ArvoreBinariaMorse teste = new ArvoreBinariaMorse();

        // Preenche a árvore com todos os caracteres do Código Morse
        teste.preencherArvore();

        System.out.println(" Árvore");
        teste.exibirArvoreMorse();

        //decodificação de uma mensagem Morse
        String codigoParaDecifrar = "-.. .. ...- . .-. ... .- ---  -- .- - . -- .- - .. -.-. .-";
        String mensagem = teste.decifrarMensagem(codigoParaDecifrar);

        System.out.println("\nTeste de Decodificação:");
        System.out.println("Mensagem Morse: " + codigoParaDecifrar);
        System.out.println("Mensagem Decodificada: " + mensagem);
    }
}
