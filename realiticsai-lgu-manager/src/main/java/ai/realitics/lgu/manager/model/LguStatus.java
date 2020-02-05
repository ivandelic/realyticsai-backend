package ai.realitics.lgu.manager.model;

public enum LguStatus {	
	Municipality(1),
	City(2);
	
	private int value;
	
	LguStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
