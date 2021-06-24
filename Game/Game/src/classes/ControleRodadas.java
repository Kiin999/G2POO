/**
 * 
 */
package classes;


public class ControleRodadas {
	
	private int NumRodadas = 0;

	public int getNumRodadas() {
		return NumRodadas;
	}

	public void setNumRodadas(int numRodadas) {
		NumRodadas = numRodadas;
	}
	
	public void diminuiRodada() {
		this.NumRodadas -= 1;
	}

}
