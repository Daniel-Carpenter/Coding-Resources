
public class MockPlayer extends Player {

	private String illegalMoveInfo = null;
	private int[] opponentMove = null;
	private String opponentName = null;
	
	private int[][] moves;
	private int nextMoveIdx;
	
	protected MockPlayer(String name, int[][] moves) {
		super(name);
		this.moves = moves;
		nextMoveIdx = 0;
	}

	@Override
	public int[] getMove(int[] pileSizes) {
		int[] move = moves[nextMoveIdx];
		nextMoveIdx = (nextMoveIdx + 1) % moves.length;
		return move;
	}

	@Override
	public void notifyIllegalMove(String moveInfo) {
		illegalMoveInfo = moveInfo;
	}
	
	@Override
	public void notifyOpponentMove(String name, int[] move) {
		opponentName = name;
		opponentMove = move;
	}
	
	public String getIllegalMoveInfo() {
		return illegalMoveInfo;
	}
	
	public int[] getOpponentMove() {
		return opponentMove;
	}
	
	public String getOpponentName() {
		return opponentName;
	}
}
