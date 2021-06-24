package classes;

public class Oponente extends Player{
	int tipoOponente = 0;
	int derrota = 0;
	boolean colaborou = false;
	
	public int getTipoOponente() {
		return tipoOponente;
	}

	public void setTipoOponente(int tipoOponente) {
		this.tipoOponente = tipoOponente;
	}
	
	public void setDerrota() {
		this.derrota += 1;
	}
	
	public int getDerrota() {
		return derrota;
	}
	
	public void colaborou() {
		System.out.println("\n!!!!Oponente Colaborou com voc�!!!\n");
	}
	
	public void naoColaborou() {
		System.out.println("\n!!!Oponente Roubou de voc�!!!\n");
	}

	public void setColaborou(boolean colaborou) {
		this.colaborou = colaborou;
	}
	
	public void listaTiposPerfis() {
		System.out.println("(1)  Cooperante:Eu sou o seu melhor amigo. N�o importa o que aconte�a, sempre irei cooperar inserindo a moeda, mesmo que voc� sempre roube \n");
		System.out.println("(2)  Sempre rouba:Eu quero o seu dinheiro. Em momento algum passa pela minha cabe�a inserir sequer uma �nica moeda durante o jogo. N�o importa o que aconte�a, por mais que voc� sempre coopere, eu sempre vou roubar. Aqui � sem d� nem piedade\n");
		System.out.println("(3)  Desconfiado:Vou come�ar sempre cooperando (inserindo a moeda), mas se em algum momento, n�o importa quando, voc� me ferrar e n�o cooperar, eu nunca mais vou inserir uma moeda novamente. N�o colaboro de novo nem se voc� voltar a inserir as moedas. Sou muito desconfiado.\n");
		System.out.println("(4)  Olho por olho:Meu irm�o, o neg�cio � o seguinte: eu sempre come�o cooperando, depois disso vou imitar a sua �ltima jogada. Ent�o se voc� cooperar eu tamb�m coopero. Se voc� roubar eu tamb�m vou e por a� vai. Comigo � sem mist�rio\n");
	}

	/**M�todo que verifica o tipo do oponente, conforme o tipo do oponente realiza as a��es de setar as moedas para o player e para s� mesmo caso 
	 * seja o caso.
	 * **/
	public void jogaMoeda(int numRodadas, Player player) {
		int oponenteTipo = getTipoOponente();
		switch (oponenteTipo) {
			case 1: {
				this.setJogada(1);
				this.colaborou();
				if (player.getJogada() > 0) {
					this.addmoedasJusto();
					player.addmoedasJusto();
					player.setTurno(true);
					break;
				} else {
					player.addmoedasRoubo();
					player.setTurno(true);
					break;
				}
			}
			case 2: {
				this.setJogada(0);
				this.naoColaborou();
				if (player.getJogada() > 0) {
					this.addmoedasRoubo(); 
					player.setTurno(true);
					break;
				} else {
					player.setTurno(true);
					break;
				}
			}
			case 3: {
				if (this.getDerrota() > 0) {
					this.setJogada(0);
					this.naoColaborou();
					if (player.getJogada() > 0) {
						this.addmoedasRoubo();
						player.setTurno(true);
						break;
					} else {
						player.setTurno(true);
						break;
					}
				} else {				
					this.setJogada(1);
					this.colaborou();
					if (player.getJogada() > 0) {
						this.addmoedasJusto();
						player.addmoedasJusto();
						player.setTurno(true);
						break;
					} else {
						this.setDerrota();
						player.addmoedasRoubo();
						player.setTurno(true);
						break;
					}
				}
			}
			case 4:{
				if (player.getJogada() > 0) {
					this.setJogada(1);
					this.colaborou();
					this.addmoedasJusto();
					player.addmoedasJusto();
					player.setTurno(true);
					break;
				} else {
					this.setJogada(0);
					this.naoColaborou();
					player.setTurno(true);
					break;
				}
				
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + getTipoOponente());
		}
	}
}
