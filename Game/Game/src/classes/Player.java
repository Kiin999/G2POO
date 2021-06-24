package classes;

public class Player {
		int moedas = 0;
		boolean turn = true;
		int jogada = 0;
		
		public int getmoedas() {
			return moedas;
		}
		public void setmoedas(int moedas) {
			this.moedas = moedas;
		}
		
		public void addmoedasRoubo() {
			this.moedas += 3;
		}
		
		public void addmoedasJusto() {
			this.moedas += 2;
		}
		
		public boolean isTurno() {
			return turn;
		}
		public void setTurno(boolean turn) {
			this.turn = turn;
		}
		
		public void setJogada(int jogada) {
			this.jogada = jogada;
		}
		
		public int getJogada() {
			return this.jogada;
		}

}
