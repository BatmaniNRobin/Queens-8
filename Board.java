public class Board{
    private int[][] spots;
    
    //Assumes in proper format
    public Board(int[] lines){
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
        }*/
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
            int j=i==r?c:0;
            for(; j<9; j++){
                if(spots[i][j]==0){
                    ind[0] = i;
                    return ind;
                  //  ind[1] = j;
                }
			}
        }
        return ind;
    }*/
    
    public int getSpot(int rowNum, int colNum){
		int rowCounter, colCounter;
		
		rowCounter = rowNum;
		
		for(colCounter=0; colCounter<8;colCounter++){
			if (spots[rowCounter][colCounter] == 1){return 0;}
		}
		
		colCounter = colNum;
		
		for (colCounter = 0; colCounter < 8; colCounter++){
			if (spots[rowCounter][colCounter] == 1){ return 0;}
		}
		
		rowCounter = rowNum-1; colCounter = colNum-1;
		
		while (rowCounter>=0 && colCounter>=0){
			if (spots[rowCounter][rowCounter]==1) {return 0;}
			else {rowCounter--;colCounter--;}
		}
		
		rowCounter = rowNum-1; colCounter = colNum+1;
		
		while (rowCounter>=0 && colCounter<8){
			if (spots[rowCounter][rowCounter]==1) {return 0;}
			else {rowCounter--;colCounter++;}
		}
		
		rowCounter = rowNum+1; colCounter = colNum-1;
		
		while (rowCounter<8 && colCounter>=0){
			if (spots[rowCounter][rowCounter]==1) {return 0;}
			else {rowCounter++;colCounter--;}
		}
		
		rowCounter = rowNum+1; colCounter = colNum+1;
		
		while (rowCounter<8 && colCounter<8){
			if (spots[rowCounter][rowCounter]==1) {return 0;}
			else {rowCounter++;colCounter++;}
		}
		return 1;
	}
		
    public void placeQueens(int r, int c){
        spots[r][c]=1;
    }
    
    public void printBoard(){
		int rowNumber, colNumber;
		system.out.println("\n\n");
		for(rowNumber = 0; rowNumber < 8; rowNumber++){
			for(colNumber = 0; colNumber < 8; colNumber++){
			system.out.printf("| %d |",chessBoard[rowNumber][colNumber]);
			}
		}
	printf("\n");
	}
	/*public boolean[] getPossibleVals(int r, int c){
        boolean[] isPossible = new boolean[10]; //0-9
        for(int i=0; i<10; i++) isPossible[i]=true;
        //iterating columns in row r
        for(int i=0; i<spots[r].length; i++){
            isPossible[spots[r][i]] = false;
        }
        //iterating rows in column c
        for(int i=0; i<spots.length; i++){
            isPossible[spots[i][c]] = false;
        }
        //iterating box
        int rowGroup = r/3;
        int colGroup = c/3;
        for(int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                isPossible[spots[rowGroup*3+i][colGroup*3+j]]=false;
            }
        }
        return isPossible;
    }*/
}



