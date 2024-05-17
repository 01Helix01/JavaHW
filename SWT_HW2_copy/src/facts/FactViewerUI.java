package facts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class FactViewerUI extends JFrame {

	private FactList factList;
	private JLabel factLabel;
	private JButton nextButton;
	private JTextField searchField;
	private JComboBox<String> searchModeComboBox;
	private JButton searchButton;

	public FactViewerUI() {
		factList = new FactList();
		setupUI();
		loadFacts();
		updateFactLabel(factList.getRandom());
	}

	private void setupUI() {
		setTitle("Fact Viewer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel factPanel = new JPanel();
		factPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		factLabel = new JLabel();
		factLabel.setFont(new Font("Arial", Font.BOLD, 16));
		factPanel.add(factLabel);

		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Fact randomFact = factList.getRandom();
				updateFactLabel(randomFact);
			}
		});
		factPanel.add(nextButton);

		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		searchField = new JTextField(20);
		searchPanel.add(searchField);

		String[] searchModes = {"Author", "Text", "Type", "All"};
		searchModeComboBox = new JComboBox<>(searchModes);
		searchPanel.add(searchModeComboBox);

		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchString = searchField.getText();
				int searchMode = searchModeComboBox.getSelectedIndex();
				FactList searchResult = factList.search(searchString, searchMode);
				Fact randomFact = searchResult.getRandom();
				updateFactLabel(randomFact);
			}
		});
		searchPanel.add(searchButton);

		add(factPanel, BorderLayout.CENTER);
		add(searchPanel, BorderLayout.SOUTH);

		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void loadFacts() {
		Parser parser = new Parser("data/facts.xml");
		factList = parser.getFactList();
	}

	private void updateFactLabel(Fact fact) {
		String factText = "<html><b>Author:</b> " + fact.getAuthor() + "<br/>" +
				"<b>Type:</b> " + fact.getType() + "<br/>" +
				"<b>Fact:</b> " + fact.getText() + "</html>";
		factLabel.setText(factText);
	}

	public static void main(String[] args) {
		FactViewerUI viewer = new FactViewerUI();
	}
}