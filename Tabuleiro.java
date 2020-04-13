public class Tabuleiro {

	
	// Variaveis de instancia
	int ainda_em_jogo;
	Peca[][] jogo = new Peca[7][7];


	//Construtor novo tabuleiro
	public Tabuleiro () {
		ainda_em_jogo = 32;
		//numero de pecas no comeco do jogo
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				jogo[i][j] = new Peca(false);
			}
		}
		for (int i=0;i<2;i++) {
			for (int j=0;j<2;j++) {
				jogo[i][j] = new Peca();
			}
		}
		for (int i=5;i<7;i++) {
			for (int j=5;j<7;j++) {
				jogo[i][j] = new Peca();
			}
		}
		for (int i=0;i<2;i++) {
			for (int j=5;j<7;j++) {
				jogo[i][j] = new Peca();
				jogo[j][i] = new Peca();
			}
		}
		jogo[3][3] = new Peca();
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				atualizaPeca(j,i);
			}
		}
		
	}
		

	//Retorna quantas pecas ainda estao no jogo
	public int getAinda_em_jogo() {
		return ainda_em_jogo;
	}


	// Printar tabuleiro
	public void printTabuleiro() {
		for (int i=jogo.length-1;i>=0;i--) {
			System.out.printf("%d",i+1);
			for (int j=0;j<jogo.length;j++) {
				if (jogo[i][j].getVazia()) {
					System.out.printf(" ");
				}
				else {
					System.out.printf("P");
				}
			}
			System.out.println("");
		}
		System.out.printf(" ");
		for (int i=0;i<7;i++) {
			System.out.printf("%c", 'a'+i);
		}
		System.out.println("");
	}


	//Funcao para ver se a posicao final e valida
	public boolean valida(int cx_final, int cy_final) {
		if ((cx_final==0||cx_final==1||cx_final==5||cx_final==6)&&(cy_final==0||cy_final==1||cy_final==5||cy_final==6)) {
			return false;
		}
		else {
			return true;
		}
	}


	//Funcao para mover as pecas
	public void mover (char[] pos) {
		int cx_inicio = pos[0] - 'a';
		int cy_inicio = pos[1] - '1';
		int cx_final = pos[3]  - 'a';
		int cy_final = pos[4] - '1';
		//Mover na vertical
		if (valida(cx_final, cy_final)&&jogo[cy_final][cx_final].getVazia()) {
			if (cx_inicio == cx_final) {
				// mover para cima
				if (cy_final==cy_inicio+2 && jogo[cy_inicio][cx_inicio].getVizinho_decima()) {
					jogo[cy_inicio][cx_inicio] = new Peca();
					jogo[cy_inicio+1][cx_inicio] = new Peca();
					jogo[cy_final][cx_final].setVazia(false);
                                        for (int i=-1;i<4;i++) {
						if (cy_inicio+i>=0&&cy_inicio+i<=6) {
                                                	atualizaPeca(cx_inicio,cy_inicio+i);
						}
                                                if (i>=0&&i<=2) {
							if (cx_inicio>0) {
                                                        	atualizaPeca(cx_inicio-1,cy_inicio+i);
							}
                                                        if (cx_inicio<6) {
								atualizaPeca(cx_inicio+1,cy_inicio+i);
                                                	}
						}
                                        }
					ainda_em_jogo--;
				}
				//mover para baixo
				else if (cy_final==cy_inicio-2 && jogo[cy_inicio][cx_inicio].getVizinho_debaixo()) {
					jogo[cy_inicio][cx_inicio] = new Peca();
					jogo[cy_inicio-1][cx_inicio] = new Peca();
					jogo[cy_final][cx_final].setVazia(false);
                                        for (int i=1;i>-4;i--){
                                                if (cy_inicio+i>=0&&cy_inicio+i<=6) {
                                                        	atualizaPeca(cx_inicio,cy_inicio+i);
                                                }
                                                if (i<=0&&i>=-2) {
							if (cx_inicio<6) {
                                                        	atualizaPeca(cx_inicio+1,cy_inicio+i);
                                                        }
							if (cx_inicio>0) {
								atualizaPeca(cx_inicio-1,cy_inicio+i);
                                                	}
						}
                                        }
					ainda_em_jogo--;
				}
			}
			//Mover na horizontal
			else if (cy_inicio == cy_final) {
				//mover para a direita
				if (cx_final == cx_inicio+2 && jogo[cy_inicio][cx_inicio].getVizinho_direito()) {
					jogo[cy_inicio][cx_inicio] = new Peca();
					jogo[cy_inicio][cx_inicio+1] = new Peca();
					jogo[cy_final][cx_final].setVazia(false);
                                        for (int i=-1;i<4;i++) {
						if (cx_inicio+i>=0&&cx_inicio+i<=6) {
								atualizaPeca(cx_inicio+i,cy_inicio);
						}
						if (i>=0&&i<=2) {
							if (cy_inicio>0) {
								atualizaPeca(cx_inicio+i,cy_inicio-1);
							}
							if (cy_inicio<6) {
								atualizaPeca(cx_inicio+i,cy_inicio+1);
							}
						}
					}
					ainda_em_jogo--;
				}
				// mover para a esquerda
				else if (cx_final == cx_inicio-2 && jogo[cy_inicio][cx_inicio].getVizinho_esquerdo()) {
					jogo[cy_inicio][cx_inicio] = new Peca();
					jogo[cy_inicio][cx_inicio-1] = new Peca();
					jogo[cy_final][cx_final].setVazia(false);
                                        for (int i=1;i>-4;i--){
						if (cx_inicio+i>=0&&cx_inicio+i<=6) {
								atualizaPeca(cx_inicio+i,cy_inicio);
						}
						if (i<=0&&i>=-2) {
							if (cy_inicio<6) {
								atualizaPeca(cx_inicio+i,cy_inicio+1);
							}
							if (cy_inicio>0) {
								atualizaPeca(cx_inicio+i,cy_inicio-1);
							}
						}
					}
					ainda_em_jogo--;
				}
			}
			//Movimento invalido
			else {

			}
		}
		//Movimento invalido
		else {

		}
	}

	
	//Funcao para atualizar pecas 
	public void atualizaPeca (int cx,int cy) {
		if (valida(cx,cy)) {
			if (cy<6) {
		 		jogo[cy][cx].setVizinho_decima(!jogo[cy+1][cx].getVazia());
			}
			else {
				jogo[cy][cx].setVizinho_decima(false);
			}
			if (cy>0) {
                 		jogo[cy][cx].setVizinho_debaixo(!jogo[cy-1][cx].getVazia());
			}
			else {
				jogo[cy][cx].setVizinho_debaixo(false);
			}
			if (cx<6) {
                		 jogo[cy][cx].setVizinho_direito(!jogo[cy][cx+1].getVazia());
			}
			else {
				 jogo[cy][cx].setVizinho_direito(false);
			}
			if (cx>0) {
                 		jogo[cy][cx].setVizinho_esquerdo(!jogo[cy][cx-1].getVazia());
			}
			else {
				jogo[cy][cx].setVizinho_esquerdo(false);
			}
		}
	}
}
