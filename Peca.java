public class Peca {

	//Variaveis de instancia
	private boolean vazia;
	private boolean vizinho_direito;
	private boolean vizinho_esquerdo;
	private boolean vizinho_decima;
	private boolean vizinho_debaixo;
	
	//Construtor padrao
	public Peca(boolean vazia, boolean vizinho_direito, boolean vizinho_esquerdo, boolean vizinho_decima, boolean vizinho_debaixo) {
		this.vazia = vazia;
		this.vizinho_direito = vizinho_direito;
		this.vizinho_esquerdo = vizinho_esquerdo;
		this.vizinho_decima = vizinho_decima;
		this.vizinho_debaixo = vizinho_debaixo;
		
	}
	//Construtor espaco vazio
	public Peca() {
		this(true,false,false,false,false);
	}
	//construtor peca com todos os vizinhos
	public Peca(boolean vazia) {
		this(vazia, true, true, true, true);
	}

	//Metodos set e get
		

		//vazia
		public boolean getVazia () {
			return vazia;
		}
		public void setVazia (boolean vazia) {
			this.vazia = vazia;
		}


		//vizinho_direito
		public boolean getVizinho_direito () {
			return vizinho_direito;
		}
		public void setVizinho_direito (boolean vizinho_direito) {
			this.vizinho_direito = vizinho_direito;
		}
		//vizinho_esquerdo
		public boolean getVizinho_esquerdo () {
			return vizinho_esquerdo;
		}
		public void setVizinho_esquerdo (boolean vizinho_esquerdo) {
			this.vizinho_esquerdo = vizinho_esquerdo;
		}


		//vizinho de cima 
		public boolean getVizinho_decima () {
			return vizinho_decima;
		}
		public void setVizinho_decima (boolean vizinho_decima) {
			this.vizinho_decima = vizinho_decima;
		}


		// vizinho de baixo
		public boolean getVizinho_debaixo () {
			return vizinho_debaixo;
		}
		public void setVizinho_debaixo (boolean vizinho_debaixo) {
			this.vizinho_debaixo = vizinho_debaixo;
		}
}
