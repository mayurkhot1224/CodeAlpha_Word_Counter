import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class WordCounter extends JFrame {

	private JTextArea textArea;
	private JLabel countLabel;

	public WordCounter() {
		setTitle("Word Counter");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textArea = new JTextArea();
		countLabel = new JLabel("Word Count: 0");

		JButton countButton = new JButton("Count Words");
		countButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textArea.getText();
				int wordCount = countWords(text);
				countLabel.setText("Word Count: " + wordCount);
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
		panel.add(countButton, BorderLayout.SOUTH);

		add(panel, BorderLayout.CENTER);
		add(countLabel, BorderLayout.SOUTH);
	}

	private int countWords(String text) {
		String[] words = text.split("\\s+");
		return words.length;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				WordCounter wordCounter = new WordCounter();
				wordCounter.setVisible(true);
			}
		});
	}
}
