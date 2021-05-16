package mynotes.shortConcepts;

public enum MachineState {

	BUSY(1), IDLE(0), BLOCKED(-1);
	private int state;

	private MachineState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

}
