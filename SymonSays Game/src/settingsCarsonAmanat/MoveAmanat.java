package settingsCarsonAmanat;

public class MoveAmanat implements MoveInterfaceAmanat {

	ButtonInterfaceAmanat button;

	public MoveAmanat(ButtonInterfaceAmanat button) {
		this.button = button;
	}
	
	public ButtonInterfaceAmanat getAButton() {
		return button;
	}

}