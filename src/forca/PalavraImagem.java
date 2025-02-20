package src.forca;

import java.util.StringTokenizer;

public class PalavraImagem {
	
		private String segredo;
		private String figura;
		
		public PalavraImagem (String s, String f) {
			this.segredo = s;
			this.figura = f;
		}
		
		public PalavraImagem (String linha) {
			StringTokenizer frase = new StringTokenizer (linha,";");
			this.segredo = frase.nextToken();
			this.figura = frase.nextToken();
		}
		
		public PalavraImagem () {
			this.segredo = "";
			this.figura = "";
		}
		
		public String getSegredo () {
			return this.segredo;
		}
		
		public String getFigura () {
			return this.figura;
		}
}