package gameStarter;

import java.util.Scanner;

import classes.ControleRodadas;
import classes.Oponente;
import classes.Player; 


public class GameStart {
	public int NumRodadas = 0;
	Player player = new Player();
	Oponente oponente = new Oponente();
	ControleRodadas CtrlRodadas = new ControleRodadas();
	Scanner in = new Scanner(System.in);
	int oponenteEsc = 0;
	
	/**Contrutor iniciando as classes e capturando a numero de rodadas e definindo qual oponente e setando nas classes**/
	public GameStart() {
		while (CtrlRodadas.getNumRodadas() == 0 && oponenteEsc == 0) {
			System.out.println("Bem vindo ao game da confiança\n\nEstes são os adversários disponíveis: \n\n");
			oponente.listaTiposPerfis();
			System.out.println("\n\nDigite a quantidade de rodadas que o jogo deve possuir e logo após o numero do perfil de jogador que voce quer jogar ex:(20 'Enter para confirmar', 1 'Enter para confirmar') !: \n\n");
			try {
				int rodadas = in.nextInt();
				oponenteEsc = in.nextInt(); 
				if (rodadas > 0 && oponenteEsc > 0 && oponenteEsc <= 4) {					
					CtrlRodadas.setNumRodadas(rodadas);
					oponente.setTipoOponente(oponenteEsc);
					break;
				}
			} catch(Exception e) {
				System.out.println("Digite numeros!");
				in.nextLine();
			}
		}
		loop();
	}
	
	/**Metedo que faz o loop das rodadas do jogos, pedindo qual a sua jogada, e setando o turno do jogador ou não, as verificações de 
	 * ação do oponente são feitas dentro daa propria classe do oponente quando chamado o metedo oponente.jogaMoeda() 
	 * **/
	public void loop() {
		System.out.println("Agora que definiu o numero de rodadas e oponente, vamo ao jogo.\n\n\n");
		while (CtrlRodadas.getNumRodadas() > 0) {
			if (this.player.isTurno()) {
				try {
					System.out.println("\n\nVoce tem duas opções:\nDigite 1 para apostar uma moeda \nDigite 0 para não apostar nada!");
					int jogada = in.nextInt();
					if (jogada == 1 || jogada == 0) {
						this.player.setJogada(jogada);
						this.player.setTurno(false);
					} else {
						System.out.println("Digite 1 ou 0.\n1 para jogar a moeda e 0 para não jogar!");
					}
				} catch(Exception e) {
					System.out.println("Digite numeros!");
					in.nextLine();
				}
				
			} else {
				oponente.jogaMoeda(CtrlRodadas.getNumRodadas(), this.player);
				System.out.printf("--->Voce tem %s moedas\n--->O Oponente tem %s Moedas",this.player.getmoedas(), oponente.getmoedas());
				CtrlRodadas.diminuiRodada();
			}
			
		} if(CtrlRodadas.getNumRodadas() == 0) {
			System.out.printf("\n>>>>>A partida encerrou<<<<<\n",this.player.getmoedas(), oponente.getmoedas());
			System.out.printf("\nAs rodadas da partida terminaram, Você terminou com %s Moedas e seu oponente com %s Moedas!", player.getmoedas(), oponente.getmoedas());
		}
	}

	
	public static void main(String[] args) {
		
		GameStart gameStart = new GameStart();		
		
	}
	
}