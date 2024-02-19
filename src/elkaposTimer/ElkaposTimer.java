package elkaposTimer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JButton;

public class ElkaposTimer {

	private JFrame frame;

	private Timer idozito;

	private static Random r = new Random();

	private long startIdo;
	private JButton btnEztKapdEl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElkaposTimer window = new ElkaposTimer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ElkaposTimer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ActionListener feladatFigyelo = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				akcio();

			}
		};

		idozito = new Timer(500, feladatFigyelo);
		idozito.setRepeats(true);
		idozito.start();

		startIdo = System.nanoTime();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnEztKapdEl = new JButton("Ide kattints");
		btnEztKapdEl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				elkapva();

			}
		});
		btnEztKapdEl.setBounds(54, 76, 37, 23);
		frame.getContentPane().add(btnEztKapdEl);

	}

	private void akcio() {

		btnEztKapdEl.setVisible(false);

		int ujXPozicio = r.nextInt(frame.getLayeredPane().getWidth() - btnEztKapdEl.getWidth());
		int ujYPozicio = r.nextInt(frame.getLayeredPane().getHeight() - btnEztKapdEl.getHeight());

		btnEztKapdEl.setBounds(ujXPozicio, ujYPozicio, btnEztKapdEl.getWidth() + 1, btnEztKapdEl.getHeight() + 1);

		btnEztKapdEl.setVisible(true);
	}

	private void elkapva() {

		idozito.stop();
		long stopIdo = System.nanoTime();
		double elteltIdo = (double) (stopIdo - startIdo) / 1000000000;

		JOptionPane.showMessageDialog(frame,
				"Gratulalok, elkaptad!\n" + String.format("Az eredmeny: %.3f mp", elteltIdo));
		System.exit(0);

	}

}
