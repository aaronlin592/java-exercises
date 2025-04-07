package labs.lab9;

public class Prop {
	
	
	private int prop;
	private int yes;
	private int no;
	
	public Prop(int prop) {
		this.prop = prop;
		yes = 0;
		no = 0;
	}
	
	public int getProp() {
		return prop;
	}
	
	public void updateYes() {
		yes++;
	}
	
	public void updateNo() {
		no++;
	}
	
	public int getYes() {
		return yes;
	}
	
	public int getNo() {
		return no;
	}
	
	public String getPropText() {
		return prop + ": ";
	}
	
	public String getYesText() {
		return "YES: " + yes + " votes, ";
	}
	
	public String getNoText() {
		return "NO: " + no + " votes";
	}
	
	public int getResult() {
		if (yes > no) {
			return 1;
		}
		else if (yes < no) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
}