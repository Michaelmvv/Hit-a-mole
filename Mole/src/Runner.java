import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Runner {
	Game game = new Game();
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		for (int i = 0; i < 3; i++) {
			JButton b = new JButton();
			b.setText(i + "");
			panel.add(b);
		}
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		
		if (buttonPressed.getText().equals("0")) {
			game.start(1);
		}else if (buttonPressed.getText().equals("1")) {
			game.start(2);
		}else {
			game.start(3);
		}
	}
}
