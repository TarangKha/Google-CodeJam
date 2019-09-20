package round_1A;

import java.util.*;
import java.io.*;

public class Pylons {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//for google submissions
    	//Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
  
		//For Eclipse Testing        
		File file = new File("input.txt");
		@SuppressWarnings("resource")
        Scanner scan = new Scanner(file);
		
		int caseNumber = scan.nextInt();
        for (int i = 1; i <= caseNumber; i++){
            int maxR = scan.nextInt();
            int maxC = scan.nextInt();
            boolean answer = false;
            for(int row = 0; row < maxR; row++) {
            	for(int col = 0; col < maxC; col++) {
            		ArrayList<Integer> xValues = new ArrayList<Integer>();
                    ArrayList<Integer> yValues = new ArrayList<Integer>();
                    int[] flag = new int[1];
            		answer = pylons(row, col, xValues, yValues, maxR, maxC, flag);
            		if(answer == true) {
            			System.out.println("Case #" + i + ":" + " " + "POSSIBLE");
            			for(int iterator = 0; iterator < xValues.size(); iterator++) {
            				System.out.println((xValues.get(iterator)+1) + " " + (yValues.get(iterator)+1));
            			}
            			break;
            		}
            	}
            	if(answer == true) {
            		break;
            	}
            }
            if(answer == false) {
            	System.out.println("Case #" + i + ":" + " " + "IMPOSSIBLE");
            }
        }
	}
	
	public static boolean pylons(int row, int col, ArrayList<Integer> xValues, ArrayList<Integer> yValues, int maxR, int maxC, int[] flag) {
		int[][] grid = new int[maxR][maxC];
		int tempR = row;
		int tempC = col;
		int listSize = xValues.size();
		//marking invalid and visited spaces
		//grid[xValues.get(k)][yValues.get(k)] = 2;
		if(listSize >= 1) {
			tempR = xValues.get(listSize-1);
			tempC = yValues.get(listSize-1);
		}
		for(int i=0;i<maxR;i++) {
			for(int j=0;j<maxC;j++) {
				for(int k = 0; k<listSize;k++) {
					grid[xValues.get(k)][yValues.get(k)] = 2;
				}
				if(i == tempR) {
					grid[i][j] = 1;
				}
				if(j == tempC) {
					grid[i][j] = 1;
				}
				if(i-j == tempR-tempC) {
					grid[i][j] = 1;
				}
				if(i+j == tempR+tempC) {
					grid[i][j] = 1;
				}
			}
		}
		if(flag[0] != 0) {
			if(grid[row][col] == 2) {
				return false;
			}
			if(grid[row][col] == 1) {
				return false;
			}
		}
		xValues.add(row);
		yValues.add(col);
		flag[0] = 1;
		for(int x=0;x<maxR;x++) {
			for(int y=0;y<maxC;y++) {
				if(xValues.size() == (maxR*maxC)) {
					return true;
				}
				pylons(x,y,xValues,yValues,maxR,maxC,flag);
			}
		}
		return false;
	}
}
