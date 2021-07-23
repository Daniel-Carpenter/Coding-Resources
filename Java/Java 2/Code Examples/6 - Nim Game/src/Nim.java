
public class Nim {

	private Player currentPlayer;
	private Player waitingPlayer;
	private Piles piles;
	private Player winner = null;
	private Player loser = null;
	
	public Nim(Player p1, Player p2) throws InvalidInitPilesException {
		this(p1, p2, new int[] {3, 4, 5});
	}
	
	public Nim(Player p1, Player p2, int[] initSizes) throws 
	InvalidInitPilesException {
		currentPlayer = p1;
		waitingPlayer = p2;
		piles = new Piles(initSizes);
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public Player getWaitingPlayer() {
		return waitingPlayer;
	}
	
	public int[] getPileSizes() {
		return piles.getSizes();
	}
	
	public Player getWinner() {
		return winner;
	}
	
	public Player getLoser() {
		return loser;
	}
	
	public void takeTurn()
	{		
		boolean hasError = true;
		int[] currPlayerMove = {};
		
		while (hasError)
		{
			// Get move from current player
				currPlayerMove = this.getCurrentPlayer().getMove(this.getPileSizes());
			
			// Try to remove objects from pile (from above move)
				try
				{
					if (currPlayerMove[1] > 0) 
					{
						this.piles.removeObjects(currPlayerMove);
					}
					else
					{
						throw new IllegalMoveException("Nonpositive object number: " + currPlayerMove[1]);
					}
					
					hasError = false;
				}
			
			// Catch Illegal move and tell current plater to redo their move
				catch (IllegalMoveException excpt)
				{
					this.currentPlayer.notifyIllegalMove(excpt.getMessage());
					
					hasError = true;
				}			
		}
		
		// Notify Successful Move to Waitng Player
			this.getWaitingPlayer().notifyOpponentMove(	this.getCurrentPlayer().getName(), 
														currPlayerMove);	
	}
	
	public void checkGameOver() {
		if (piles.isEmpty()) {
			winner = waitingPlayer;
			loser = currentPlayer;
		}
	}
	
	public void swapPlayers() {
		Player temp = currentPlayer;
		currentPlayer = waitingPlayer;
		waitingPlayer = temp;
	}
	
	public void play() {
		while (winner == null || loser == null) {
			takeTurn();
			checkGameOver();
			swapPlayers();
		}
		winner.notifyWin();
		loser.notifyLose();
	}
}
