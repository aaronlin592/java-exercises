package labs.lab9;

public class Candidate {
	
	private String candidate;
	private int votes;
	
	
	public Candidate(String name) {
		this.candidate = name;
		this.votes = 0;
	}
	
	public void updateVote() {
		votes++;
	}
	
	public int getVotes() {
		return votes;
	}
	
	public String getCandidate() {
		return candidate;
	}
	
	public static String getWinner(Candidate a, Candidate b) {
		if (a.getVotes() > b.getVotes()) {
			return "a";
		}
		else if (a.getVotes() < b.getVotes()) {
			return "b";
		}
		return "";
	}
	
	@Override
	public String toString() {
		return candidate + ": " + votes;
	}
	
}