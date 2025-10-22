public class ArvoreBinariaMorse {

    private Node raiz;

    public ArvoreBinariaMorse() {
        inicializar(); // quando cria a arvore, ja inicializa a raiz
    }

    public void inicializar() {
        raiz = new Node('\0'); // coloca um nó vazio como raiz
    }

    public void inserirCaractere(String codigoMorse, char caractere) {
        Node atual = raiz; // comeca da raiz

        for (int i = 0; i < codigoMorse.length(); i++) {
            char sinalMorse = codigoMorse.charAt(i); // pega cada ponto ou traço

            if (sinalMorse == '.') {
                if (atual.getEsquerda() == null) { // se nao existe nó esquerdo, cria
                    atual.setEsquerda(new Node('\0'));
                }
                atual = atual.getEsquerda(); // vai descendo pra esquerda
            } else if (sinalMorse == '-') {
                if (atual.getDireita() == null) { // se nao existe nó direito, cria
                    atual.setDireita(new Node('\0'));
                }
                atual = atual.getDireita(); // vai descendo pra direita
            }
        }
        // no final do código morse, coloca o caractere real
        atual.setCaractere(caractere);
    }

    public char buscarCaractere(String codigoMorse) {
        Node atual = raiz; // começa da raiz

        for (int i = 0; i < codigoMorse.length(); i++) {
            char sinalMorse = codigoMorse.charAt(i);

            if (sinalMorse == '.') {
                if (atual.getEsquerda() == null) return '\0'; // nao achou, retorna vazio
                atual = atual.getEsquerda();
            } else if (sinalMorse == '-') {
                if (atual.getDireita() == null) return '\0';
                atual = atual.getDireita();
            }
        }
        return atual.getCaractere(); // retorna a letra achada
    }

    // morse -> texto
    public String decifrarMensagem(String mensagemMorse) {
        String mensagemDecifrada = ""; // vai guardar a mensagem final
        String sinalMorseAtual = ""; // vai juntando os pontos e traços de uma letra

        for(int i = 0; i < mensagemMorse.length(); i++) {
            char c = mensagemMorse.charAt(i);

            if (c == ' ') { // encontrou um espaço
                if (!sinalMorseAtual.isEmpty()) { // se tinha sinal acumulado
                    char letra = buscarCaractere(sinalMorseAtual); // decodifica
                    if (letra != '\0') {
                        mensagemDecifrada += letra; // adiciona na mensagem
                    }
                    sinalMorseAtual = ""; // reseta pro proximo
                }

                int proximo = i + 1;
                boolean proximoEhEspaco = (proximo < mensagemMorse.length() && mensagemMorse.charAt(proximo) == ' ');

                if (proximoEhEspaco) { // se tem 2 espaços seguidos, é espaço entre palavras
                    mensagemDecifrada += " ";
                    i++; // pula o proximo espaço
                }
            } else {
                sinalMorseAtual += c; // vai juntando pontos e traços
            }
        }

        // decodifica a ultima letra se tiver
        if (!sinalMorseAtual.isEmpty()) {
            char letra = buscarCaractere(sinalMorseAtual);
            if (letra != '\0') {
                mensagemDecifrada += letra;
            }
        }

        return mensagemDecifrada; // retorna tudo decodificado
    }

    //texto -> morse
    public String criarMorse(String mensagem) {
        mensagem = mensagem.toUpperCase(); // deixa tudo maiusculo
        String mensagemCodificada = "";

        // lista de sinais e caracteres correspondentes
        String[] sinais = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--..",
                "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
                "---..", "----."
        };
        char[] caracteres = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };
        int tamanhoSinais = 36;

        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);

            if (caractere == ' ') { // espaço entre palavras
                mensagemCodificada += " ";
            } else {
                boolean encontrado = false;
                for (int j = 0; j < tamanhoSinais; j++) { // procura a letra no array
                    if (caractere == caracteres[j]) {
                        mensagemCodificada += sinais[j] + " "; // adiciona o morse
                        encontrado = true;
                        break;
                    }
                }
            }
        }
        return mensagemCodificada.trim(); // tira espaço extra no final
    }

    public void preencherArvore() {
        // mesmo array de sinais e caracteres usado pra criar arvore
        String[] sinais = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--..",
                "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
                "---..", "----."
        };
        char[] caracteres = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };
        int tamanho = 36;

        for (int i = 0; i < tamanho; i++) {
            inserirCaractere(sinais[i], caracteres[i]); // adiciona tudo na arvore
        }
    }

    // RECURSIVA
    public void exibirArvoreMorse() {
        exibirRec(raiz, ""); // começa da raiz, codigo morse vazio
    }

    private void exibirRec(Node raiz, String codigoMorse) {
        if (raiz == null) {
            return; // se nó vazio, volta
        }

        if (raiz.getCaractere() != '\0') { // se nó tem letra
            System.out.println(codigoMorse + " -> " + raiz.getCaractere()); // printa o codigo e letra
        }

        exibirRec(raiz.getEsquerda(), codigoMorse + "."); // vai pra esquerda adicionando ponto
        exibirRec(raiz.getDireita(), codigoMorse + "-"); // vai pra direita adicionando traço
    }
}
