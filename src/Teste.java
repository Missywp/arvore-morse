public class Teste {
    public static void main(String[] args) {
        ArvoreBinariaMorse teste = new ArvoreBinariaMorse();
        teste.preencherArvore();

        System.out.println("Árvore:");
        teste.exibirArvoreMorse();

        // TESTE DE CODIFICAÇÃO
        String mensagemParaCodificar = "DIVERSAO MATEMATICA";
        String morse = teste.criarMorse(mensagemParaCodificar);

        System.out.println("\nCodificação:");
        System.out.println("Mensagem: " + mensagemParaCodificar);
        System.out.println("Código Morse: " + morse);

        // TESTE DE DECODIFICAÇÃO
        String codigoParaDecifrar = "-.. .. ...- . .-. ... .- ---  -- .- - . -- .- - .. -.-. .-";
        String mensagemDecodificada = teste.decifrarMensagem(codigoParaDecifrar);

        System.out.println("\nDecodificação:");
        System.out.println("Mensagem Morse: " + codigoParaDecifrar);
        System.out.println("Mensagem Decodificada: " + mensagemDecodificada);

        teste.deleteCaractere(".-"); // remove A

        System.out.println("\nLetra A apagada:");
        teste.exibirArvoreMorse();
    }
}
