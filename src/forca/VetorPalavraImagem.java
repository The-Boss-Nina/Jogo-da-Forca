package src.forca;

import java.util.Random;

public class VetorPalavraImagem {
	
	private int tamanho; 
	private PalavraImagem vetor[]; 

	public VetorPalavraImagem (int t) {
		this.vetor = new PalavraImagem [t];
		this.tamanho = 0;
	}
	
	public void insereVetor(PalavraImagem registro){
		this.vetor[this.tamanho] = registro;
		this.tamanho++;
	}
	
	public PalavraImagem sorteio () {
		Random posicao = new Random ();
		int ind = posicao.nextInt (this.tamanho);
		return this.vetor[ind];
	}
	
	public int getTamanho () {
		return this.vetor.length;
	}
	
	public PalavraImagem getIndVetor (int ind) {
		return this.vetor[ind];
	}
}
