# Jogo-da-Forca

**Jogo da Forca** é uma versão simples do clássico jogo da forca desenvolvido em **Java**. O jogo permite que o usuário tente adivinhar uma palavra secreta, escolhendo letras. O jogador tem um número limitado de tentativas para adivinhar as letras da palavra antes de ser "enforcado".

## Funcionalidades

- **Teclado Virtual**: O usuário pode clicar nas letras no teclado virtual para tentar adivinhar a palavra secreta.
- **Níveis**: O jogo possui 4 níveis de dificuldade. O nível é selecionado no menu.
- **Resposta**: O usuário pode ver a solução se desejar, após o término do jogo.
- **Tela de Enforcado**: Uma imagem é atualizada conforme o número de tentativas erradas do jogador.

## Como Executar

### Passo 1: Instalar o Java

Certifique-se de ter o **Java 17** ou superior instalado. Para verificar se você já tem o Java instalado, execute o seguinte comando:

```bash
java -version
```

Caso não tenha o Java instalado, você pode fazer o download e seguir as instruções de instalação no [site oficial do Java](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

### Passo 2: Compilar os Arquivos Java

Depois de ter o Java instalado, abra o terminal ou o prompt de comando na pasta onde os arquivos do projeto estão localizados e execute o seguinte comando para compilar os arquivos `.java`:

```bash
javac -d bin src/forca/*.java
```

### Passo 3: Rodar o Jogo

Após a compilação, execute o jogo com o seguinte comando:

```bash
java -cp bin forca.Interface
```

A janela do jogo será aberta e você poderá começar a jogar.

### Passo 4: Interagir com o Jogo

- **Escolher Nível**: No menu, selecione um dos níveis para começar a jogar.
- **Teclado Virtual**: Clique nas letras para adivinhar a palavra.

### Passo 5: Jogo Finalizado

O jogo termina quando o jogador adivinha todas as letras da palavra ou é "enforcado" após cometer 5 erros. Após o término, você pode ver a solução clicando em "Resposta" no menu.