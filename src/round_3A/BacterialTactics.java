package round_3A;

import java.util.*;
import java.io.*;


public class BacterialTactics {

	public static void main(String[] args) throws FileNotFoundException {
		//for google submissions
    	//Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
  
		//For Eclipse Testing        
		File file = new File("input.txt");
		@SuppressWarnings("resource")
        Scanner scan = new Scanner(file);
		
		int caseNumber = scan.nextInt();
		for(int i=1;i<=caseNumber;i++) {
			int R = scan.nextInt();
			int C = scan.nextInt();
			char[][] board = new char[R][C];
			for(int row = 0; row < R; row++) {
				String line = scan.next();
				for(int col = 0; col < C; col++) {
					board[row][col] = line.charAt(col);
				}
			}
			int answer = bacterialTactics(board);
			System.out.println("Case #" + i + ":" + " " + answer);
		}
       

	}
	
	public static int bacterialTactics(char[][] board) {
		int ways = 0;
		char[] rows = new char[board.length];
		char[] cols = new char[board[0].length];
		ArrayList<int[]> emptySpaces = new ArrayList<int[]>();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == '#') {
					rows[i] = 'X';
					cols[j] = 'X';
				} else {
					int[] temp = new int[2];
					temp[0] = i;
					temp[1] = j;
					emptySpaces.add(temp);
				}
			}
		}
		
		char[] rowsBCK = rows;
		char[] colsBCK = cols;
		ArrayList<int[]> BCK = emptySpaces;
		return helper(ways, emptySpaces, 'H', 1, rows, cols, 0, rowsBCK, colsBCK, BCK);
		/*
		for(int i = 0; i < emptySpaces.size();i++) {
			ways = ways + counter(emptySpaces, i, 'H', rows, cols);
			ways = ways + counter(emptySpaces, i, 'V', rows, cols);
		}
		return ways;
		*/
		
	}
	
	
	public static int counter(ArrayList<int[]> emptySpaces, int start, char move, char[] rows, char[] cols) {
		int player = 1;
		
		while(!emptySpaces.isEmpty()) {
			int rowVal = emptySpaces.get(start)[0];
			int colVal = emptySpaces.get(start)[1];
			if((rows[rowVal] == 'X' || rows[rowVal] == 'H') && (cols[colVal] == 'X' || cols[colVal] == 'V')) {
				emptySpaces.remove(start);
				continue;
			}
			else if((rows[rowVal] == 'X' || rows[rowVal] == 'H') && (cols[colVal] != 'X' || cols[colVal] != 'V')) {
				cols[colVal] = 'V';
			}
			else if((rows[rowVal] != 'X' || rows[rowVal] != 'H') && (cols[colVal] == 'X' || cols[colVal] == 'V')) {
				rows[rowVal] = 'H';
			}
			else {
				if(move == 'H') {
					rows[rowVal] = 'H';
				} else {
					cols[colVal] = 'V';
				}
			}
			if(player == 1) {
				player = 2;
			} else {
				player = 1;
			}
		}
		if(player == 1) {
			return 0;
		} else {
			return 1;
		}
	}
//}
	
	
	public static int helper(int paths, ArrayList<int[]> emptySpaces, char move, int playerTurn, char[] rows, char[] cols, int i, char[] colsBackup, char[] rowsBackup, ArrayList<int[]> backup) {
		
		//BASE CASE: NO MORE EMPTY SPACES
		if(i > emptySpaces.size()) {
			return 0;
		}
		//BASE CASE: NO MORE EMPTY SPACES AND IS P2's turn, so P1 WINS
		if(emptySpaces.isEmpty() && playerTurn == 2) {
			return 1;
		}
		
		//gets available empty spaces
		int rowVal = emptySpaces.get(i)[0];
		int colVal = emptySpaces.get(i)[1];
		
		
		//if the last person's move made certain spaces unavailable, remove them from empty spaces
		if((rows[rowVal] == 'X') && (cols[colVal] == 'X')) {
			emptySpaces.remove(i);
		}
		//if the row is invalid, BUT the col is valid, you can play a V at this space
		else if((rows[rowVal] == 'X') && (cols[colVal] != 'X')) {
			cols[colVal] = 'X'; // played a V
		}
		//if the row is valid, BUT the col is invalid, you can play a H at this space.
		else if((rows[rowVal] != 'X') && (cols[colVal] == 'X')) {
			rows[rowVal] = 'X'; // played a H
		}
		
		
		//Changes player turn
		if(playerTurn == 1) {
			playerTurn = 2;
		} else {
			playerTurn = 1;
		}
		
		
		
		
		
		paths = helper(paths, emptySpaces, 'H', playerTurn, rows, cols, i + 1, rowsBackup, colsBackup, backup)
			 	+
			 	helper(paths, emptySpaces, 'V', playerTurn, rows, cols, i + 1, rowsBackup, colsBackup, backup)
			 	;
		emptySpaces = backup;
		rows = rowsBackup;
		cols = colsBackup;	 
		
		return paths;
	}
}
	
	
	
	/*
	while(!emptySpaces.isEmpty()) {
		for(int i = 0; i < emptySpaces.size();i++) {
			int rowVal = emptySpaces.get(i)[0];
			int colVal = emptySpaces.get(i)[1];
			if((rows[rowVal] == 'X' || rows[rowVal] == 'H') && (cols[colVal] == 'X' || cols[colVal] == 'V')) {
				emptySpaces.remove(i);
				continue;
			}
			else if((rows[rowVal] == 'X' || rows[rowVal] == 'H') && (cols[colVal] != 'X' || cols[colVal] != 'V')) {
				cols[colVal] = 'V';
			}
			else if((rows[rowVal] != 'X' || rows[rowVal] != 'H') && (cols[colVal] == 'X' || cols[colVal] == 'V')) {
				rows[rowVal] = 'H';
				
			}
			if(playerTurn == 1) {
				playerTurn = 2;
			} else {
				playerTurn = 1;
			}
		}
	}
}
*/
