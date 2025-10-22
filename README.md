# Árvore Binária com Código Morse
Resolução de Problemas Estruturados em Computação `-` Bacharelado em Ciência da Computação PUCPR

### Estudantes:
- Lissa Deguti
- Andressa de Oliveira
- Melissa Weiss
- Fernanda Moraes

## Estrutura do Projeto
```
src/
|- Main.java                 #interface do terminal
|- ArvoreBinariaMorse.java   #classe principal da árvore com o morse
|- Node.java                 #classe do nó
|- Teste.java                #testes
```

## Funcionalidades
### 1. Preenchimento automático da árvore
Adiciona as letras (A-Z) e os números (0-9) com os códigos morse.

### 2. Codificação
Converte texto em Código Morse.
- As letras são separadas por um espaço.
- As palavras são separadas por dois espaços.

### 3. Decodificação
Converte uma mensagem Morse de volta para texto.

### 4. Busca
Permite encontrar uma letra a partir do código Morse.

### 5. Exibição visual da árvore
Mostra estrutura binária com caracteres e seus caminhos (ponto e traço).

### 6. Remoção
Permite apagar um caractere da árvore (sem remover os nós filhos).

## Exemplo de Execução
Entrada (texto):
```
DIVERSAO MATEMATICA
```
Saída (morse):
```
-.. .. ...- . .-. ... .- ---  -- .- - . -- .- - .. -.-. .-
```
Entrada (morse):
```
-.. .. ...- . .-. ... .- ---  -- .- - . -- .- - .. -.-. .-
```
Saída (texto):
```
DIVERSAO MATEMATICA
```

## Como Executar
1. Compilar arquivo
2. Executar Main (O arquivo Teste foi só para teste)
3. Usar menu interativo

## Explicação Meio Geral
- Cada nó da árvore representa uma letra/número
- .-> filho da esquerda | --> filho da direita
- preencherArvore() insere todos os caracteres nos caminhos corretos
- codificar: percorre a árvore para gerar o código morse de cada caractere
- decodificar: percorre o código morse e encontra o caractere correspondente
- Permite buscar, deletar e exibir a árvore completa
- A árvore é montada uma única vez e serve como base para todas as operações.
