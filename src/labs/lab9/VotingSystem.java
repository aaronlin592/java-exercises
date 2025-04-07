package labs.lab9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class VotingSystem {
	
	// instance variables
	private String electionName;
	private Candidate a;
	private Candidate b;
	private List<Prop> props;
	private double donations;
	private String notes;
	private boolean noteExists;
	private JTextArea notesTextArea;
	
	private static final int NO = 0;
	private static final int YES = 1;
	
	
	// main method and create election screen from JOptionPane
	public static void main(String[] args) {
		VotingSystem.createElectionTexts();
	}
	
	public VotingSystem(String electionName, Candidate a, Candidate b, int numProps, double donations) {
		this.electionName = electionName;
		this.a = a;
		this.b = b;
		this.props = new ArrayList<>();
		for (int i = 1; i <= numProps; i++) {
			this.props.add(new Prop(i));
		}
		this.donations = donations;
		this.notes = "";
		this.noteExists = false;
	}
	
	public static void createElectionTexts() { 
		// Initial values (can be empty or preset) 
		String initialElectionName = ""; 
		String initialCandidateA = ""; 
		String initialCandidateB = ""; // Function to display and handle the election creation dialog 
		createElection(initialElectionName, initialCandidateA, initialCandidateB); 
	}
	
	public static void createElection(String electionName, String candidateAName, String candidateBName) {
		final int FIELD_WIDTH = 20;
		
		// create labels and text fields
		JLabel electionNameLabel = new JLabel("Election Name:");
		final JTextField electionNameInput = new JTextField(electionName, FIELD_WIDTH);
		
		JLabel candidateA = new JLabel("Candidate A Name:");
		final JTextField candidateAInput = new JTextField(candidateAName, FIELD_WIDTH);
		
		JLabel candidateB = new JLabel("Candidate B Name:");
		final JTextField candidateBInput = new JTextField(candidateBName, FIELD_WIDTH);
		
		JLabel propositionsText = new JLabel("Num propositions:");
		JComboBox propositionsBox = new JComboBox();
		for (int i = 1; i < 16; i++) {
			propositionsBox.addItem(i);
		}
		
		JPanel eName = new JPanel();
		eName.add(electionNameLabel);
		eName.add(electionNameInput);
		
		JPanel candA = new JPanel();
		candA.add(candidateA);
		candA.add(candidateAInput);
		
		JPanel candB = new JPanel();
		candB.add(candidateB);
		candB.add(candidateBInput);
		
		JPanel props = new JPanel();
		props.add(propositionsText);
		props.add(propositionsBox);
		
		JPanel electionInfoPanel = new JPanel(new GridLayout(4, 1));
		
		electionInfoPanel.add(eName);
		electionInfoPanel.add(candA);
		electionInfoPanel.add(candB);
		electionInfoPanel.add(props);
		
		
		int choice = JOptionPane.showConfirmDialog(
                null,
                electionInfoPanel,
                "Election Info",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
		
		if (choice == JOptionPane.OK_OPTION) {
			if (electionNameInput.getText().trim().isEmpty() || candidateAInput.getText().trim().isEmpty() || candidateBInput.getText().trim().isEmpty()) {
				// prompt again
				createElection(electionNameInput.getText(), candidateAInput.getText(), candidateBInput.getText());
			}
			else { // display voting system
				VotingSystem votingSystem = new VotingSystem(electionNameInput.getText().trim(), new Candidate(candidateAInput.getText().trim()), new Candidate(candidateBInput.getText().trim()), (int) propositionsBox.getSelectedItem(), 0.00);
				votingSystem.displayOrUpdateVotingSystem(new JFrame(), false);
			}
		}
		else {
			System.exit(0);
		}
	}
	
	
	public void displayOrUpdateVotingSystem(JFrame votingSystemFrame, boolean alreadyCreated) {
		
		if (alreadyCreated) { // if voting system already exists
			votingSystemFrame.getContentPane().removeAll(); 
			displayOrUpdateVotingSystem(votingSystemFrame, false);
		}
		else {
			// frame creation
			votingSystemFrame.setSize(875, 1080);
			votingSystemFrame.setLayout(new BorderLayout());
			votingSystemFrame.setTitle("Voting System - Aaron Lin - 83048320");
			
			// cast vote button action listener
			class CastVoteButton implements ActionListener {
				public void actionPerformed(ActionEvent event) {
					displayCastVote(votingSystemFrame);
				}
			}
			
			// exit menu item action listener
			class ExitItemListener implements ActionListener {
				public void actionPerformed(ActionEvent event) {
					System.exit(0);
				}
			}
			
			// fonts
			Font regText = new Font("Regular", Font.PLAIN, 14);
			Font boldedText = new Font("Bold", Font.BOLD, 14);
			
			// button
			JButton castVoteButton = new JButton("Cast Vote");
			ActionListener listener = new CastVoteButton();
			castVoteButton.addActionListener(listener);
			castVoteButton.setSize(20, 5);
			
			
			// JLabel for election name
			JLabel electionNameText = new JLabel(electionName);
			electionNameText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // padding 5px
			votingSystemFrame.add(electionNameText, BorderLayout.NORTH);
			
			// candidate panel creation
			JPanel candidateAndPropPanel = new JPanel();
			candidateAndPropPanel.setLayout(new GridLayout(2, 1));
			
			JPanel candidatePanel = new JPanel();
	        candidatePanel.setLayout(new GridLayout(2, 0));
	        candidatePanel.setBorder(BorderFactory.createTitledBorder("Candidates:"));
	        JLabel aLabel = new JLabel(a.toString());
	        JLabel bLabel = new JLabel(b.toString());
	        if (Candidate.getWinner(a, b).equals("a")) {
	        	aLabel.setFont(boldedText);
	        	bLabel.setFont(regText);
	        }
	        else if (Candidate.getWinner(a, b).equals("b")) {
	        	bLabel.setFont(boldedText);
	        	aLabel.setFont(regText);
	        }
	        else {
	        	aLabel.setFont(boldedText);
	        	bLabel.setFont(boldedText);
	        }
	        candidatePanel.add(aLabel);
	        candidatePanel.add(bLabel);
	        candidateAndPropPanel.add(candidatePanel);
	        
	        
			// prop panel creation
	        JPanel propositionPanel = new JPanel();
	        propositionPanel.setLayout(new GridLayout(props.size(), 1));
	        propositionPanel.setBorder(BorderFactory.createTitledBorder("Propositions:"));
	        for (Prop p : props) {
	        	JLabel propNum = new JLabel(p.getPropText());
	        	JLabel yesText = new JLabel(p.getYesText());
	        	JLabel noText = new JLabel(p.getNoText());
	        	
	        	if (p.getResult() == YES) {
	        		yesText.setFont(boldedText);
	        		noText.setFont(regText);
	        	}
	        	else if (p.getResult() == NO) {
	        		noText.setFont(boldedText);
	        		yesText.setFont(regText);
	        	}
	        	else {
	        		yesText.setFont(boldedText);
	        		noText.setFont(boldedText);
	        	}
	        	
	        	JPanel propPanel = new JPanel();
	        	propPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	        	
	        	propPanel.add(propNum);
	        	propPanel.add(yesText);
	        	propPanel.add(noText);
	        	
	        	propositionPanel.add(propPanel);
	        	
	        }
	        candidateAndPropPanel.add(propositionPanel);
	        
	        votingSystemFrame.add(candidateAndPropPanel, BorderLayout.CENTER);
	        
	        
			// donations + notes panel creation
	        JPanel donationAndNotesPanel = new JPanel();
	        donationAndNotesPanel.setLayout(new GridLayout(3, 1));
	        
	        // notes
	        JPanel notesPanel = new JPanel();
	        JLabel notesText = new JLabel("Notes:");
	        
	        if (noteExists) { // saves the note regardless of action
	        	notes = notesTextArea.getText();
	        	notesTextArea.setText(notes);
	        }
	        else {
	        	notesTextArea = new JTextArea(6, 55);
	        	noteExists = true;
	        }
	        
	        notesTextArea.setEditable(true);
	        JScrollPane scrollPane = new JScrollPane(notesTextArea);
	        notesTextArea.setLineWrap(true);
	        notesTextArea.setWrapStyleWord(false);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        notesPanel.add(notesText);
	        notesPanel.add(scrollPane);
	        
	        // donations
	        String donationsText = String.format("%.2f", donations);
	        JLabel donationText = new JLabel("Donation total: $" + donationsText);
	        JPanel donoPanel = new JPanel();
	        donoPanel.add(donationText);
	        
	        // add cast vote button
	        JPanel castVotePanel = new JPanel();
	        castVotePanel.add(castVoteButton);
	        
	        donationAndNotesPanel.add(donoPanel);
	        donationAndNotesPanel.add(notesPanel);
	        donationAndNotesPanel.add(castVotePanel);
	        
	        votingSystemFrame.add(donationAndNotesPanel, BorderLayout.SOUTH);
	        
	        
	        // menu creation
	        JMenuBar menuBar = new JMenuBar();
	        JMenu fileMenu = new JMenu("File");
	        JMenuItem exitItem = new JMenuItem("Exit");
	        ActionListener exitListener = new ExitItemListener();
	        exitItem.addActionListener(exitListener);
	        fileMenu.add(exitItem);
	        menuBar.add(fileMenu);
	        votingSystemFrame.setJMenuBar(menuBar);
		}
		
        
        // show frame
        votingSystemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		votingSystemFrame.setVisible(true);
	}
	
	
	public void displayCastVote(JFrame votingSystemFrame) {
		
		// candidate choices panel creation:
		// panel
		JPanel candidateChoicePanel = new JPanel();
		JLabel candidateChoiceText = new JLabel("Candidate: ");
		candidateChoicePanel.setBorder(BorderFactory.createTitledBorder("Candidates:"));
		candidateChoicePanel.add(candidateChoiceText);
		
		// buttons
		JRadioButton aButton = new JRadioButton(a.getCandidate());
		JRadioButton bButton = new JRadioButton(b.getCandidate());
		ButtonGroup abButtonGroup = new ButtonGroup();
		abButtonGroup.add(aButton);
		abButtonGroup.add(bButton);
		candidateChoicePanel.add(aButton);
		candidateChoicePanel.add(bButton);
		
		// castVoteFrame.add(candidateChoicePanel, BorderLayout.NORTH);
		
		// proposition choices and donation option panel creation:
		// PROPS:
		// storage
		ArrayList<PropButtonGroup> propButtonGroups = new ArrayList<>();
		// panel
		JPanel propositionChoicePanel = new JPanel();
		propositionChoicePanel.setLayout(new GridLayout(props.size(), 0));
		propositionChoicePanel.setBorder(BorderFactory.createTitledBorder("Propositions:"));
		
		// choices
		for (Prop p : props) {
			JPanel propChoice = new JPanel();
			JLabel propChoiceText = new JLabel("Prop " + p.getProp() + ": ");
			propChoice.add(propChoiceText);
			
			JRadioButton yesButton = new JRadioButton("YES");
			JRadioButton noButton = new JRadioButton("NO");
			ButtonGroup propYesNo = new ButtonGroup();
			propYesNo.add(yesButton);
			propYesNo.add(noButton);
			propChoice.add(yesButton);
			propChoice.add(noButton);
			
			propButtonGroups.add(new PropButtonGroup(p, yesButton, noButton));
			
			propositionChoicePanel.add(propChoice);
			
		}
		
		// DONATIONS:
		JPanel donationOptionPanel = new JPanel();
		donationOptionPanel.setBorder(BorderFactory.createTitledBorder("Donation:"));
		JCheckBox donoCheckBox = new JCheckBox("I would like to make a donation");
		JTextField donoAmountBox = new JTextField(20); // 1 row, 20 columns
		donoAmountBox.setText("0.00");
		donoAmountBox.setEditable(false);
		
		// ItemListener for donation check box
		class CheckBoxListener implements ItemListener {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					donoAmountBox.setEditable(true);
				}
				else {
					donoAmountBox.setText("0.00");
					donoAmountBox.setEditable(false);
				}
			}
		}
		
		// add listener to check box
		ItemListener checkBoxListener = new CheckBoxListener();
		donoCheckBox.addItemListener(checkBoxListener);
		
		// add boxes to donation panel
		donationOptionPanel.add(donoCheckBox);
		donationOptionPanel.add(donoAmountBox);
		

		
		// create panel for JOptionPane
		JPanel castVotePanel = new JPanel();
		castVotePanel.setLayout(new BorderLayout());
		castVotePanel.add(candidateChoicePanel, BorderLayout.NORTH);
		castVotePanel.add(propositionChoicePanel, BorderLayout.CENTER);
		castVotePanel.add(donationOptionPanel, BorderLayout.SOUTH);
		
		int option = JOptionPane.showConfirmDialog(
				votingSystemFrame,
                castVotePanel,
                "Cast Vote",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

		// checks if user selects OK, then update voting system
		if (option == JOptionPane.OK_OPTION) {
			
			// custom exception type for negative donations
			class NegativeDonationException extends Exception {
				public NegativeDonationException() {}
				public NegativeDonationException(String message) {
					super(message);
				}
			}
			// update voting system
			try {
				// update donation
				double donationToAdd = Double.parseDouble(donoAmountBox.getText());
				if (donationToAdd >= 0) {
					donations += donationToAdd;
				}
				else {
					throw new NegativeDonationException("Donation cannot be a negative number!"); // throws exception if donation is negative
				}
				
				// update candidate votes if applicable
				if (aButton.isSelected()) {
					a.updateVote();
				}
				else if (bButton.isSelected()) {
					b.updateVote();
				}
				
				// update prop votes if applicable
				for (PropButtonGroup pb : propButtonGroups) {
					pb.updateProp();
				}
				
				// update system
				displayOrUpdateVotingSystem(votingSystemFrame, true);
			} catch (NegativeDonationException e) { // negative donation exception
				JOptionPane.showMessageDialog(null, "Please enter a valid donation amount.", "Negative Number Donation Error", JOptionPane.ERROR_MESSAGE);
			} catch (NumberFormatException e) { // number formating error if Double.parseDouble encounters non-numeric characters
				JOptionPane.showMessageDialog(null, "Please enter a valid donation amount.", "Number Formatting Error", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) { // any other exceptions
				JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}