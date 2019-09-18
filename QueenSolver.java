public class QueenSolver{
	public static void main (String[] args){
		int[][] board = new int[9][9];
		int r = 0;
		int c = 0;
		int x = 0;
		ArrayStack <QueensInfo> stack = new ArrayStack<QueensInfo>();
		
		while(x < 8){
			if (board[r][c] == 0){
				QueensInfo attempt = valid(1,r,c,board);
				while(attempt == null){
					QueensInfo old = stack.pop();
					r = old.getR();
					c = old.getC();
					board[r][c] = 0;
					attempt = valid(old.getV()+1, r, c, board);
				}
				board[r][c] = attempt.getV();
				stack.push(attempt);
			}
			c++;
			if (c==8){
				r++;
				c=0;
			}
		}
		printBoard(board);
	}

	public static QueensInfo valid(int start, int col, int row, int [][] grid){
		boolean found = false;
		for (int i = start; i<8; i++){
			for(int c = 0; c<8; c++){
				if (grid[row][c]==i){found=true;}
				if (!found){return new QueensInfo(row,col,i);}
			}
			for(int r = 0; r<8; r++){
				if (grid[r][col]==i){found = true;}
				if (!found){return new QueensInfo(row,col,i);}
			}
		}
		for(int i = start; i<8; i++){
			for(int j = 0; i<8; i++){
				if ((i+j) == (row + col) || (i-j) == (row - col)){
					if (grid [i][j] == 1){found =true;}
					if (!found){return new QueensInfo(row,col,i);}
				}
			}
		}
		return null;	
	}
	 
	public static void printBoard(int [][] board){
		int rowNumber, colNumber;
		System.out.println("\n\n");
		for(rowNumber = 0; rowNumber < 8; rowNumber++){
			for(colNumber = 0; colNumber < 8; colNumber++){
				System.out.println();
			}
		}
		System.out.printf("\n");
	}


}

/*Assumes in proper format
	public QueenSolver(int[] lines){
        // spots = new int[8][8];
		int row,col;
		for (row = 0; row<8;row++){
			for(col = 0; col<8; col++){
				spots[row][col] = 0;	
			}
		}
		
		
       /* for(int i=0; i<lines.length; i++){
            String[] parts = lines[i].split(",");
            for(int j=0; j<parts.length; j++)
                spots[i][j] = Integer.parseInt(parts[j]);
        }
    }
    
    public int areQueensPlaced(){
		int count = 0;
		int rowNum,colNum;
		for(rowNum = 0; rowNum<8; rowNum++){
			for(colNum = 0; colNum<0; colNum++){
				if (spots[rowNum][colNum] == 1){
					count++;
					break;
				}
			}
		}
		if (count == 8) {return 1;}
		else return 0;
	}
	
	
	/*public int[] getEmpty(int r, int c){
        int[] ind = {-1,-1};
        for(int i=r; i<9; i++){
            for(int j=0; j<9; j++){
                if(spots[i][j]==0){
                    ind[0] = i;
                    return ind;
                  //  ind[1] = j;
                }
			}
        }
        return ind;
	}
*/