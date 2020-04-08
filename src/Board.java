public class Board {
    Block[] blocks;

    //constructor
    public Board() {
        blocks = new Block[4];
        for (int i = 0; i < 4; i++)
            blocks[i] = new Block();
    }


    /**
     * this method checks all the lines and returns int value
     * @return it returns 0 if non of the player won , returns 1 if white player win ,return 2 if
     * black player win ,returns 3 if both player had the 5 discs in one line
     */
    public int checkEndOfGame() {
        /*
          * the logic of this method is that it checks all the vertical and horizontal and X shape lines and counts
          * the number of red and yellow discs and if it found 5 disc in a row checks for any interruption between same player discs
          * and if it was match to pattern returns the number of player who pattern matched for.
         */
        Disc[][] discBoard = blockTable();
        int redCounter = 0, yellowCounter = 0;
        boolean interrupted = false;
        boolean redWon = false, yellowWon = false;
        //checking horizontal lines
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                if (discBoard[j][i].getId() == 1) redCounter++;
                else if (discBoard[j][i].getId() == 2) yellowCounter++;
            }
            if (redCounter >= 5 || yellowCounter >= 5) {
                for (int i = 0; i < 4; i++) {
                    if (discBoard[j][i].getId() == 1 && discBoard[j][i + 1].getId() == 2 && discBoard[j][i + 2].getId() == 1)
                        interrupted = true;
                    else if (discBoard[j][i].getId() == 2 && discBoard[j][i + 1].getId() == 1 && discBoard[j][i + 2].getId() == 2)
                        interrupted = true;
                }
                if (!interrupted)
                    {
                        if (redCounter >= 5) redWon = true;
                        else if(yellowCounter>=5)yellowWon=true;
                    }
            }
            redCounter = 0;
            yellowCounter = 0;
        }
        redCounter = 0;
        yellowCounter = 0;
        interrupted = false;
        //checking vertical lines
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (discBoard[j][i].getId() == 1) redCounter++;
                if (discBoard[j][i].getId() == 2) yellowCounter++;
            }
            if (redCounter >= 5 || yellowCounter >= 5) {
                for (int j = 0; j < 4; j++) {
                    if (discBoard[j][i].getId() == 1 && discBoard[j + 1][i].getId() == 2 && discBoard[j + 2][i].getId() == 1)
                        interrupted = true;
                    else if (discBoard[j][i].getId() == 2 && discBoard[j + 1][i].getId() == 1 && discBoard[j + 2][i].getId() == 2)
                        interrupted = true;
                }
                if (!interrupted)
                    {
                        if (redCounter >= 5) redWon = true;
                    else if(yellowCounter>=5)yellowWon=true;
                    }
            }
            redCounter = 0;
            yellowCounter = 0;
        }
        //checking X shaped lines
        //checking '\' shaped paths
        redCounter = 0;
        yellowCounter = 0;
        for (int i = 0, j = 0; i < 6; i++, j++) {
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) yellowCounter++;
        }
        if (redCounter == 5 || yellowCounter == 5) {
            for (int j = 0, i = 0; i < 4; j++, i++) {
                if (discBoard[j][i].getId() == 1 && discBoard[j + 1][i + 1].getId() == 2 && discBoard[j + 2][i + 2].getId() == 1)
                    interrupted = true;
                else if (discBoard[j][i].getId() == 2 && discBoard[j + 1][i + 1].getId() == 1 && discBoard[j + 2][i + 2].getId() == 2)
                    interrupted = true;
            }
            if (!interrupted) {
                if (redCounter >= 5) redWon = true;
                else if(yellowCounter>=5)yellowWon=true;
            }
        }
        ////////////////////////////////////////////////////////////////////
        redCounter = 0;
        yellowCounter = 0;
        for (int i = 0, j = 1; j < 6; i++, j++) {
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) yellowCounter++;
        }
        if (redCounter == 5) redWon=true ;
        else if(yellowCounter==5)yellowWon=true;
        ////////////////////////////////////////////////////////////////////
        redCounter = 0;
        yellowCounter = 0;
        for (int i = 1, j = 0; i < 6; i++, j++) {
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) yellowCounter++;
        }
        if (redCounter == 5) redWon=true ;
        else if(yellowCounter==5)yellowWon=true;

        ////////////////////////////////////////////////////////////////////
        redCounter = 0;
        yellowCounter = 0;
        for (int i = 0, j = 5; i < 6; i++, j--) {
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) yellowCounter++;
        }
        if (redCounter == 5 || yellowCounter == 5) {
            for (int i = 0, j = 5; i < 4; i++, j--) {
                if (discBoard[j][i].getId() == 1 && discBoard[j - 1][i + 1].getId() == 2 && discBoard[j - 2][i + 2].getId() == 1)
                    interrupted = true;
                else if (discBoard[j][i].getId() == 2 && discBoard[j - 1][i + 1].getId() == 1 && discBoard[j - 2][i + 2].getId() == 2)
                    interrupted = true;
            }
            if (!interrupted)
            {
                if(redCounter>=5)redWon=true;
                else if(yellowCounter>=5)yellowWon=true;
            }
        }
        ///////////////////////////////////////////////////////////////////
        redCounter = 0;
        yellowCounter = 0;
        for (int i = 1, j = 5; i < 6; i++, j--) {
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) yellowCounter++;
        }
        if (redCounter == 5) redWon=true ;
        else if(yellowCounter==5)yellowWon=true;
        ////////////////////////////////////////////////////////////////////
        redCounter = 0;
        yellowCounter = 0;
        for (int i = 0, j = 4; j >= 0; i++, j--) {
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) yellowCounter++;
        }
        if (redCounter == 5) redWon=true ;
        else if(yellowCounter==5)yellowWon=true;
        ////////////////////////////////////////////////////////////////////*/
        return redWon &&yellowWon ? 3:redWon ? 1 :yellowWon?2:0;
    }
    //Rotate

    /**
     * @param blockNum  the number of block user wish to rotate
     * @param direction number 1 is for rotating to right and number 2 is for rotating to left
     */
    public void rotateBlock(int blockNum, int direction) {
        blocks[blockNum].rotate(direction);
    }
    /**
     * this method finds the block based on coordinates and
     * execute its placeDisc method
     *
     * @param id the id of player who place the disc
     * @param x  the horizontal place in map
     * @param y  the vertical place in map
     */
    public void placeDisc(int id, int x, int y) {
        if (x < 3) {
            if (y >= 3) blocks[2].placeDisc(id, x, y);
            else blocks[0].placeDisc(id, x, y);
        } else {
            if (y >= 3) blocks[3].placeDisc(id, x, y);
            else blocks[1].placeDisc(id, x, y);
        }
    }
    /**
     * prints whole board
     */
    public void print() {
        Disc[][] map=this.blockTable();
        System.out.print("   |  1    2    3  |"
                + "  4    5    6   |\n");
        System.out.println("---  ---  ---  ---   ---  ---  ---  -");
        System.out.println("        Block 1          Block 2       ");
        for(int j=0;j<6;j++){
            System.out.printf(" %d |",j+1);
            for(int i=0;i<6;i++){
                if(map[j][i].getId()==1) System.out.printf("  \u001B[31m%c\u001B[0m  ",'\u25cf');
                else if(map[j][i].getId()==2) System.out.printf("  \u001B[33m%c\u001B[0m  ",'\u25cf');
                else System.out.printf("  %c  ",'.');
                if(i==2)
                    System.out.printf("|");
                if(i==5)
                    System.out.printf("|");
            }
            System.out.println();
            if(j!=2&&j!=5)
                System.out.println("   |               |               |");
            else{
                if(j==5)
                    System.out.println("        Block 3          Block 4       ");
                System.out.println("    --------------- ----------------");
            }

        }
    }
    /**
     * this method makes a 6*6 block using summing up all four blocks
     *
     * @return returns the sum of 4 blocks on board as 2 dimensional array
     */
    private Disc[][] blockTable() {
        Disc[][] boardDiscs = new Disc[6][6];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                boardDiscs[j][i] = new Disc(this.blocks[0].discBlock[j][i].getId());
            }
        for (int i = 3; i < 6; i++)
            for (int j = 0; j < 3; j++)
                boardDiscs[j][i] = new Disc(blocks[1].getDiscBlock()[j][i % 3].getId());

        for (int i = 0; i < 3; i++)
            for (int j = 3; j < 6; j++)
                boardDiscs[j][i] = new Disc(blocks[2].getDiscBlock()[j % 3][i].getId());

        for (int i = 3; i < 6; i++)
            for (int j = 3; j < 6; j++)
                boardDiscs[j][i] = new Disc(blocks[3].getDiscBlock()[j % 3][i % 3].getId());
        return boardDiscs;
    }

    /**
     * @param x the horizontal place in map
     * @param y the vertical place in mao
     * @return returns if the given coordinates are empty or not
     */
    public boolean checkPlace(int x, int y) {
        Disc[][] discBoard = blockTable();
        return discBoard[y - 1][x - 1].getId() == 0;
    }

    /**
     * @return returns whether there is a possibility for player to skip rotating part
     * based on if there is any symmetrical block or not
     */
    public boolean foundSymmetricalBlock() {
        boolean foundBlock = false;
        for (int i = 0; i < 4; i++)
            if (blocks[i].symmetrical())
                foundBlock = true;
        return foundBlock;
    }
}
