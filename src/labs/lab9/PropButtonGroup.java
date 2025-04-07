package labs.lab9;

import javax.swing.JRadioButton;

public class PropButtonGroup {
    private Prop proposition;
    private JRadioButton yesButton;
    private JRadioButton noButton;
    
    public PropButtonGroup(Prop proposition, JRadioButton yesButton, JRadioButton noButton) {
    	this.proposition = proposition;
    	this.yesButton = yesButton;
    	this.noButton = noButton;
    }
    
    public void updateProp() {
    	if (yesButton.isSelected()) {
    		proposition.updateYes();
    	}
    	else if (noButton.isSelected()) {
    		proposition.updateNo();
    	}
    }

}