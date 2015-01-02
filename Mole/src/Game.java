import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game implements ActionListener {
	JButton lastButton;
	JFrame frame;
	JPanel panel;
	int molesHit = 0;
	int notHit = 0;
	int presses = 0;
	Date start = new Date();
	Random rand = new Random();
	int diff;

	public void start(int diff) {
		this.diff = diff;
		System.out.println("Diff is: " + this.diff);
		setup();
	}

	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		int mole = rand.nextInt(300);
		System.out.println(mole);
		frame.setName("Hity thingy");
		frame.add(panel);
		for (int i = 0; i < 300; i++) {
			JButton b = new JButton();
			b.setPreferredSize(new Dimension(80, 25));
			b.addActionListener(this);
			if (i == mole) {

				b.setText("Mole");

				panel.add(b);
			} else {

				if (diff == 1) {
					// noting to do
				} else if (diff == 2) {
					b.setText(i + 1 + "");

				} else if (diff == 3) {
					int ButtonRandom = rand.nextInt(3);
					if (ButtonRandom==0) {
						b.setText("M0le");
					}else if (ButtonRandom == 1) {
						b.setText("Mole!");
					}else if (ButtonRandom ==2) {
						b.setText("M0le!");
					}else {
						b.setText("Moles");
					}

				}
				panel.add(b);
			}
		}
		frame.setVisible(true);
		frame.setSize(1000, 900);
	}

	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();

		presses++;
		if (buttonPressed.getText().equals("Mole")) {
			molesHit++;

			frame.dispose();
			setup();
			speak("Hit");
		} else {
			speak("Miss");
			notHit++;
			if (lastButton == buttonPressed) {
				speak("You clicked the same button dumb dumb");
			}
		}

		if (presses == 10) {
			endGame(start, molesHit);
		}

		lastButton = buttonPressed;
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane
				.showMessageDialog(
						null,
						"Your whack rate is "
								+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
								+ " moles per second.");
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
