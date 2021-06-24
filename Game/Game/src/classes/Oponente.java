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
		System.out.println("\n!!!!Oponente Colaborou com você!!!\n");
	}
	
	public void naoColaborou() {
		System.out.println("\n!!!Oponente Roubou de você!!!\n");
	}

	public void setColaborou(boolean colaborou) {
		this.colaborou = colaborou;
	}
	
	public void listaTiposPerfis() {
		System.out.println("(1)  Cooperante:Eu sou o seu melhor amigo. Não importa o que aconteça, sempre irei cooperar inserindo a moeda, mesmo que você sempre roube \n");
		System.out.println("(2)  Sempre rouba:Eu quero o seu dinheiro. Em momento algum passa pela minha cabeça inserir sequer uma única moeda durante o jogo. Não importa o que aconteça, por mais que você sempre coopere, eu sempre vou roubar. Aqui é sem dó nem piedade\n");
		System.out.println("(3)  Desconfiado:Vou começar sempre cooperando (inserindo a moeda), mas se em algum momento, não importa quando, você me ferrar e não cooperar, eu nunca mais vou inserir uma moeda novamente. Não colaboro de novo nem se você voltar a inserir as moedas. Sou muito desconfiado.\n");
		System.out.println("(4)  Olho por olho:Meu irmão, o negócio é o seguinte: eu sempre começo cooperando, depois disso vou imitar a sua última jogada. Então se você cooperar eu também coopero. Se você roubar eu também vou e por aí vai. Comigo é sem mistério\n");
	}

	/**Método que verifica o tipo do oponente, conforme o tipo do oponente realiza as ações de setar as moedas para o player e para sí mesmo caso 
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
