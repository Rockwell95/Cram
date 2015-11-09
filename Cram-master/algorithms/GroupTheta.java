package algorithms;
import org.gamelink.game.Cram;
import org.gamelink.game.Algo;

public class GroupTheta extends Algo{ // Replace TeamName
    private static String teamName = "GroupTheta"; // Replace TeamName

    public static String getTeamName(){
        return teamName;
    }

    public static void main(String[] args){
        Cram game = new Cram(false);
        game.startGame(GroupTheta.class); // Replace TeamName
    }

    public static String algorithm(Cram game)
    {//Algorithm
    	Node top = new Node();
    	int[][] gameBoard = game.getBoard();
    	String[] moves = GroupTheta.getValidMoves(gameBoard);
    	
    	for(int i = 0; i < moves.length; i++)
    	{
    		top.createChild(moves[i]);
    	}
    	

    }
    
    public static String[] getValidMoves(int[][] board)
    {
    	//Position counter for string array of locations
    	int validCount = 0;
    	
    	//String array of all valid moves (gotta figure out the best way to init this
    	String[] validMoves = new String[40]; //Initlialize to max possible number of valid moves.
    	
    	//Checks through entire board
    	for(int i = 0; i < board[0].length; i++)
    	{
    		for(int j = 0; j < board.length; j++)
    		{
    			/*If two consecutive values are 0, and the second value is not the rightmost entry on the board
    			 * the string representation of that location that the board recognizes is stored in the string array
    			 */
    			if((j+1) < board[0].length && board[i][j]==0 && board[i][j+1] == 0)
    			{
    				int k = j+1;
    				validMoves[validCount] = "" + i + j + i + k; //concatinates coordinates into a string (i.e, 4041)
    				validCount++;
    			}
    			if((i+1) < board.length && board[i][j] == 0 && board [i+1][j] == 0)
    			{
    				int l = i+1;
    				validMoves[validCount] = "" + i + j + l + j;
    				validCount++;
    			}
    		}
    	}
    }
    return validMoves;
}
