//Tic Tac Toe(Karan)

import java.util.*;
class tictactoekaran
{
	static char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	static char current_player = 'X';
	static int r,c;
	
	//Printing TicTacToe Boxes...
	public static void printboard()
	{
		System.out.println("-------------");
		for(int c=0;c<3;c++)
		{
			System.out.print("| ");
			for(int r=0;r<3;r++)
			{
				System.out.print(board[c][r]+" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	//For Swithching Player using Conditional Operator
	public static void SwitchPlayer()
	{
		current_player = (current_player == 'X') ? 'O' : 'X'; 
	}
	
	//For Moving Validation
	// public static boolean ValidMove(int c,int r)
	// {
		// return r >= 0 && c >=0 && r < 3 && c < 3;
	// }
	
	// For Changing Place
	public static void ChangePlace()
	{
		while(true)
		{	
			Scanner sc = new Scanner(System.in);
			System.out.println("Player " + current_player + " choose your Row : ");
			r = sc.nextInt() - 1;
			System.out.println("Player " + current_player + " choose your Column : ");
			c = sc.nextInt() - 1;
		
			if(r >= 0 && r < 3 && c >=0 && c < 3 && board[r][c] == ' ')
			{
				board[r][c] = current_player;
				break;
			}
			else
			{
				System.out.println("Invalid Choice...");
			}
		}
	}
	
	//For checking board is full or not
	public static boolean BoardCheck()
	{
		for(c=0;c<3;c++)
		{
			for(r=0;r<3;r++)
			{
				if(board[r][c] == ' ')
				{
					return false;
				}
			}
		}
		System.out.println("All boxes are filled..!");
		return true;
	}
	
	// For checking Winners
	public static boolean WinnersChecking()
	{
		for(c=0;c<3;c++)
		{
			if(board[0][c] == current_player && board[1][c] == current_player && board[2][c] == current_player)
			{
				System.out.println("Congratulations Player " + current_player + " you are win..!");
				return true;
			}
			if(board[0][0] == current_player && board[1][1] == current_player && board[2][2] == current_player)
			{
				System.out.println("Congratulations Player " + current_player + " you are win..!");
				return true;
			}
			
		}
		// return false;
		for(r=0;r<3;r++)
		{
			if(board[r][0] == current_player && board[r][1] == current_player && board[r][2] == current_player)
			{
				System.out.println("Congratulations Player " + current_player + " you are win..!");
				return true;
			}
			if(board[0][2] == current_player && board[1][1] == current_player && board[2][0] == current_player)
			{
				System.out.println("Congratulations Player " + current_player + " you are win..!");
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		while(true)
		{
			printboard();
			ChangePlace();
			if(BoardCheck() || WinnersChecking())
			{
				printboard();
				break;
			}
			SwitchPlayer();
		}
	}
}