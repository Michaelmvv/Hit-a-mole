import javax.swing.JOptionPane;



public class Runner {
public static void main(String[] args) {
	Game game = new Game();
	
	
	game.start(Integer.parseInt(JOptionPane.showInputDialog("How hard? 0 1 2")));
}
}
