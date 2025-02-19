package src.forca;

import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

public class Jogo {
    private int acertos;
    private int erros;
    private String segredo;
    private String imagem;
    private String palavra;
    private VetorPalavraImagem vetor;

    public Jogo (int level)   {
        LeArquivo arquivo = new LeArquivo ();
        try {
            arquivo.openFile("nivel"+level+".txt");
        }
        catch (FileNotFoundException erro){
            JOptionPane.showMessageDialog (null,erro.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        try {
            this.vetor = arquivo.readFile();
            preparaJogo ();
        }
        catch (NoSuchElementException erro){
            JOptionPane.showMessageDialog (null,erro.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        catch (IllegalStateException erro){
            JOptionPane.showMessageDialog (null,erro.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        catch (ArrayIndexOutOfBoundsException erro){
            JOptionPane.showMessageDialog (null,erro.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception erro){
            JOptionPane.showMessageDialog (null,erro.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }

    public VetorPalavraImagem getVetor () {
        return this.vetor;
    }

    public int getErros () {
        return this.erros;
    }

    public int getAcertos () {
        return this.acertos;
    }

    public String getSegredo () {
        return this.segredo;
    }

    public String getImagem () {
        return this.imagem;
    }

    public String getPalavra () {
        return this.palavra;
    }

    public boolean jogoAcabou () {
        if ((this.erros == 5) || (this.acertos == this.segredo.length())) {
            return true;
        }
        else {
            return false;
        }
    }

    public void preparaJogo () {
        PalavraImagem forca;
        forca = this.vetor.sorteio();
        this.segredo = forca.getSegredo();
        this.segredo = this.segredo.toUpperCase();
        this.imagem = forca.getFigura();
        this.palavra = "";
        for (int i=0; i<this.segredo.length(); i++){
            this.palavra += " ";
        }
        this.erros  = 0;
        this.acertos = 0;
        for (int i=0; i< segredo.length();i++){
            if (segredo.charAt(i)=='-')
                this.acertos++;
        }
    }    

    private boolean temLetra(char letra){
        char[] vetPalavra = new char[palavra.length()];
        boolean temp = false;
        char auxLetra;    
        vetPalavra = this.palavra.toCharArray();
        String letraNormalizada = Normalizer.normalize(String.valueOf(letra), Normalizer.Form.NFD);
        letraNormalizada = letraNormalizada.replaceAll("[^\\p{ASCII}]", "");
        String segredoNormalizado = Normalizer.normalize(this.segredo, Normalizer.Form.NFD);
        segredoNormalizado = segredoNormalizado.replaceAll("[^\\p{ASCII}]", "");
        
        for (int i = 0; i < this.segredo.length(); i++){
            auxLetra = segredo.charAt(i);
            String auxLetraNormalizada = Normalizer.normalize(String.valueOf(auxLetra), Normalizer.Form.NFD);
            auxLetraNormalizada = auxLetraNormalizada.replaceAll("[^\\p{ASCII}]", "");
            if (auxLetraNormalizada.equals(letraNormalizada)){
                temp = atualizaPalavra(vetPalavra, i);                
            }
        }
        this.palavra = String.valueOf(vetPalavra);
        return temp;
    }

    private boolean atualizaPalavra (char[] vetPalavra, int ind){
        vetPalavra[ind] = this.segredo.charAt(ind);
        this.acertos++;
        return true;
    }

    public void acertou (char letra) {
        if (!temLetra(letra)) {
            this.erros++;
        }    
    }
}
