import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Runner implements ActionListener {
	Game game = new Game();
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();

	public static void main(String[] args) {
		new Runner().start();

	}

	public void start() {
		panel.add(new JTextArea("How hard?"));
		for (int i = 0; i < 3; i++) {
			JButton b = new JButton();
			b.addActionListener(this);
			b.setText(i + "");
			panel.add(b);
		}
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed.getText().equalsIgnoreCase("0")) {
			game.start(1);
			frame.dispose();
		} else if (buttonPressed.getText().equalsIgnoreCase("1")) {
			game.start(2);
			frame.dispose();
		} else {
			game.start(3);
			frame.dispose();
		}
	}
}
