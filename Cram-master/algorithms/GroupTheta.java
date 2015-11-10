package algorithms;
import org.gamelink.game.Cram;
import java.util.Random;
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
/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------      ALGORITHMS AND METHODS      ---------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    //Gets game board for the first time, and checks to see if someone else has put something on the board. If player 1, no one will have.
    private static int[][] gameBoard = game.getBoard();
    private static int init = GroupTheta.initCheck(gameBoard);

//==================================================================================================================================================================================================================
    public static String algorithm(Cram game)
    {//Algorithm
        String[] moves;
        if(init == 0)
        {
            //If board is empty, there should be around 37 different locations to place a block, so one of these locations is arbitrarily chosen.
            Random rn = new Random();
            int i = rn.nextInt(37);
            return moves[i];
        }

    	Node top = new Node();
    	gameBoard = game.getBoard();
    	moves = GroupTheta.getValidMoves(gameBoard);
    	
    	for(int i = 0; i < moves.length; i++)
    	{
    		top.createChild(moves[i]);
    	}
    	

    }
    
//==================================================================================================================================================================================================================
    //Complexity = O(n^2)
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
    				validMoves[validCount] = "" + i + j + i + k; //Concatenates coordinates into a string (i.e, 4041)
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
        return validMoves;
    }

//==================================================================================================================================================================================================================
    //Complexity = O(n^2)
    public static int initCheck(int[][] board)
    {
        int init = 0;
        for(int i = 0; i < board[0].length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                //If init = 1, the algorithm will skip the arbitrary block placement.
                if(board[i][j] != 0 || board[i][j] != 99)
                {
                    init = 1;
                    return init;
                    break;
                }
            }
        }
    }
    
}
