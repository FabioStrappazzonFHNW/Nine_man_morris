package ch.fhnw.algd2.ninemanmorris.imp;

/**
 * A MinNode is a child of a MaxNode
 * 
 * @author christoph.stamm
 * @version 24.11.2009
 *
 */
public class MinNode extends GameNode {
	/**
	 * Create node with action
	 * @param a Action
	 */
	public MinNode(IAction a) {
		super(a);	
	}
	
	/**
	 * Create node with action and score
	 * @param a Action
	 * @param score Score
	 */
	public MinNode(IAction a, int score) {
		super(a, score);	
	}
	
	/**
	 * The children of a MaxNode will be ordered in increasing score order
	 */
	public int compareTo(Node<IAction> v) {
		int score2 = ((GameNode)v).score();
		
		if (m_score == score2) return 0;
		else return (m_score < score2) ? -1 : 1;
	}
	
	/**
	 * Get winner score
	 */
	public int getWinnerScore() {
		return State.BLACKWINS;
	}
}
