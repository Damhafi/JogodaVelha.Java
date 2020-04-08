package joguinho;
import javax.swing.JFrame;

public class TesteGrafico {

	public static void main(String[] args) {
		JFrame tela = new JFrame();
		Velha desenho = new Velha();
		tela.add(desenho);
		tela.setSize(300,300);
		tela.setVisible(true);
	}
	
}
