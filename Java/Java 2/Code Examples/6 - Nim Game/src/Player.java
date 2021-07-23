
public abstract class Player {

	private String name;
	
	protected Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract int[] getMove(int[] pileSizes);
	
	public void notifyIllegalMove(String moveInfo) {
		return;
	}
	
	public void notifyOpponentMove(String name, int[] move) {
		return;
	}
	
	public void notifyWin() {
		return;
	}
	
	public void notifyLose() {
		return;
	}
}
