package labs.lab6;

import java.util.ArrayList;

/**
 * An email messaging system.
 */
public class MessagingSystem {
	// ADD YOUR INSTANCE VARIABLES HERE

	private ArrayList<Mailbox> mailboxes;
	/**
	 * Constructs a MessagingSystem object
	 */
	public MessagingSystem() {
		// FILL IN
		mailboxes = new ArrayList<>();
	}


	/**
	 * Delivers a message to the recipient
	 * 
	 * @param sender		message sender
	 * @param recipient		message recipient
	 * @param text			text of the message
	 */
	public void deliver(String sender, String recipient, String text) {
		// FILL IN
		Message msg = new Message(sender, recipient, text);
		boolean mailboxExists = false;
		for (Mailbox m : mailboxes) {
			if (m.getUser().equals(recipient)) {
				m.addMessage(msg);
				mailboxExists = true;
			}
		}
		if (!mailboxExists) {
			Mailbox newMailBox = new Mailbox(recipient);
			mailboxes.add(newMailBox);
			newMailBox.addMessage(msg);
		}
	}

	
	/**
	 * Retrieves the messages for a user
	 * 
	 * @param user the user
	 */
	public String getMessages(String user) {
		for (Mailbox m : mailboxes) {
			if (m.getUser().equals(user)) {
				return m.getAllMessages();
			}
		}
		return ""; // FIX ME
	}
}
