public class Board {
    Block[] blocks;

    //constructor
    public Board() {
        blocks = new Block[4];
        for (int i = 0; i < 4; i++)
            blocks[i] = new Block();

    }

    //check winning situation
    public boolean checkEndOfGame() {
        Disc[][] discBoard = blockTable();
        int redCounter = 0, blackCounter = 0;
        boolean intrupted = false;
        //checking horizontal lines
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                if (discBoard[j][i].getId() == 1) redCounter++;
                else if (discBoard[j][i].getId() == 2) blackCounter++;
            }
            if (redCounter == 5 || blackCounter == 5) {
                for (int i = 0; i < 4; i++) {
                    if (discBoard[j][i].getId() == 1 && discBoard[j][i + 1].getId() == 2 && discBoard[j][i + 2].getId() == 1)
                        intrupted = true;
                    else if (discBoard[j][i].getId() == 2 && discBoard[j][i + 1].getId() == 1 && discBoard[j][i + 2].getId() == 2)
                        intrupted = true;
                }
                if (!intrupted)
                    return true;
            }

        }
        redCounter = 0;
        blackCounter = 0;
        //checking vertical lines
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (discBoard[j][i].getId() == 1) redCounter++;
                else if (discBoard[j][i].getId() == 2) blackCounter++;
            }
            if (redCounter == 5 || blackCounter == 5) {
                for (int j = 0; j < 4; j++) {
                    if (discBoard[j][i].getId() == 1 && discBoard[j + 1][i].getId() == 2 && discBoard[j + 2][i].getId() == 1)
                        intrupted = true;
                    else if (discBoard[j][i].getId() == 2 && discBoard[j + 1][i].getId() == 1 && discBoard[j + 2][i].getId() == 2)
                        intrupted = true;
                }
                if (!intrupted)
                    return true;
            }
        }
        //checking X shaped lines
        //checking '\' shaped paths
        redCounter = 0;
        blackCounter = 0;
        for (int i = 0, j = 0; i < 6; i++, j++) {
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) blackCounter++;
        }
        if (redCounter == 5 || blackCounter == 5) {
            for (int j = 0, i = 0; i < 4; j++, i++) {
                if (discBoard[j][i].getId() == 1 && discBoard[j + 1][i + 1].getId() == 2 && discBoard[j + 2][i + 2].getId() == 1)
                    intrupted = true;
                else if (discBoard[j][i].getId() == 2 && discBoard[j + 1][i + 1].getId() == 1 && discBoard[j + 2][i + 2].getId() == 2)
                    intrupted = true;
            }
            if(!intrupted)return true;
        }
        ////////////////////////////////////////////////////////////////////
        redCounter = 0;
        blackCounter = 0;
        for (int i = 0, j = 1; j < 6; i++, j++) {
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) blackCounter++;
        }
        if (redCounter == 5 || blackCounter == 5) {
            for (int j = 1, i = 0; j < 4; j++, i++) {
                if (discBoard[j][i].getId() == 1 && discBoard[j + 1][i + 1].getId() == 2 && discBoard[j + 2][i + 2].getId() == 1)
                    intrupted = true;
                else if (discBoard[j][i].getId() == 2 && discBoard[j + 1][i + 1].getId() == 1 && discBoard[j + 2][i + 2].getId() == 2)
                    intrupted = true;
            }
            if(!intrupted)return true;
        }
        ////////////////////////////////////////////////////////////////////
        redCounter = 0;
        blackCounter = 0;
        for (int i = 1, j = 0; i < 6; i++, j++) {
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) blackCounter++;
        }
        if (redCounter == 5 || blackCounter == 5) {
            for (int j = 0, i = 1; i < 4; j++, i++) {
                if (discBoard[j][i].getId() == 1 && discBoard[j + 1][i + 1].getId() == 2 && discBoard[j + 2][i + 2].getId() == 1)
                    intrupted = true;
                else if (discBoard[j][i].getId() == 2 && discBoard[j + 1][i + 1].getId() == 1 && discBoard[j + 2][i + 2].getId() == 2)
                    intrupted = true;
            }
            if(!intrupted)return true;
        }
        ////////////////////////////////////////////////////////////////////
        redCounter=0;
        blackCounter=0;
        for(int i=0,j=5;i<6;i++,j--){
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) blackCounter++;
        }
        if(redCounter==5||blackCounter==5){
            for(int i=0,j=5;i<4;i++,j--){
                if (discBoard[j][i].getId() == 1 && discBoard[j - 1][i + 1].getId() == 2 && discBoard[j - 2][i + 2].getId() == 1)
                    intrupted = true;
                else if (discBoard[j][i].getId() == 2 && discBoard[j - 1][i + 1].getId() == 1 && discBoard[j - 2][i + 2].getId() == 2)
                    intrupted = true;
            }
            if(!intrupted)return true;
        }
        ///////////////////////////////////////////////////////////////////
        redCounter=0;
        blackCounter=0;
        for(int i=1,j=5;i<6;i++,j--){
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) blackCounter++;
        }
        if(redCounter==5||blackCounter==5){
            for(int i=1,j=5;i<4;i++,j--){
                if (discBoard[j][i].getId() == 1 && discBoard[j - 1][i + 1].getId() == 2 && discBoard[j - 2][i + 2].getId() == 1)
                    intrupted = true;
                else if (discBoard[j][i].getId() == 2 && discBoard[j - 1][i + 1].getId() == 1 && discBoard[j - 2][i + 2].getId() == 2)
                    intrupted = true;
            }
            if(!intrupted)return true;
        }
        ////////////////////////////////////////////////////////////////////
        redCounter=0;
        blackCounter=0;
        for(int i=0,j=4;j>=0;i++,j--){
            if (discBoard[j][i].getId() == 1) redCounter++;
            else if (discBoard[j][i].getId() == 2) blackCounter++;
        }
        if(redCounter==5||blackCounter==5){
            for(int i=0,j=4;j>=2;i++,j--) {
                if (discBoard[j][i].getId() == 1 && discBoard[j - 1][i + 1].getId() == 2 && discBoard[j - 2][i + 2].getId() == 1)
                    intrupted = true;
                else if (discBoard[j][i].getId() == 2 && discBoard[j - 1][i + 1].getId() == 1 && discBoard[j - 2][i + 2].getId() == 2)
                    intrupted = true;
            }
            if(!intrupted)return true;
        }
        ////////////////////////////////////////////////////////////////////
        return false;
    }
        //Rotate
        /**
         * @param blockNum  the number of block user wish to rotate
         * @param direction number 1 is for rotating to right and number 2 is for rotating to left
         */
        public void rotateBlock ( int blockNum, int direction){
            blocks[blockNum].rotate(direction);
        }
        //placeDisc % thing

        /**
         * this method finds the block based on coordinates and
         * execute its placeDisc method
         *
         * @param id the id of player who place the disc
         * @param x  the horizontal place in map
         * @param y  the vertical place in map
         */
        public void placeDisc ( int id, int x, int y){
            if (x < 3) {
                if (y >= 3) blocks[2].placeDisc(id, x, y);
                else blocks[0].placeDisc(id, x, y);
            } else {
                if (y >= 3) blocks[3].placeDisc(id, x, y);
                else blocks[1].placeDisc(id, x, y);
            }
        }
        //print

        /**
         * prints whole board
         */
        public void print () {
            System.out.print("   |  1    2    3  |"
                    + "  4    5    6   |\n");
            System.out.println("---  ---  ---  ---   ---  ---  ---  -");
            Block blockOne = blocks[0];
            Block blockTwo = blocks[1];
            for (int j = 0; j < 3; j++) {
                System.out.printf(" %d |", j + 1);
                for (int i = 0; i < 3; i++) {
                    if (blockOne.getDiscBlock()[j][i].getId() == 1)
                        System.out.print("  1  ");
                    else if (blockOne.getDiscBlock()[j][i].getId() == 2)
                        System.out.print("  2  ");
                    else
                        System.out.print("  .  ");
                }
                System.out.print("|");
                for (int i = 0; i < 3; i++) {
                    if (blockTwo.getDiscBlock()[j][i].getId() == 1)
                        System.out.print("  1  ");
                    else if (blockTwo.getDiscBlock()[j][i].getId() == 2)
                        System.out.print("  2  ");
                    else
                        System.out.print("  .  ");
                }

                if (j == 2)
                    System.out.println(" |");
                else
                    System.out.println(" |\n");
            }
            System.out.println("    --------------- ---------------");
            Block blockThree = blocks[2];
            Block blockFour = blocks[3];
            for (int j = 0; j < 3; j++) {
                System.out.printf(" %d |", j + 4);
                for (int i = 0; i < 3; i++) {
                    if (blockThree.getDiscBlock()[j][i].getId() == 1)
                        System.out.print("  1  ");
                    else if (blockThree.getDiscBlock()[j][i].getId() == 2)
                        System.out.print("  2  ");
                    else
                        System.out.print("  .  ");
                }
                System.out.print("|");
                for (int i = 0; i < 3; i++) {
                    if (blockFour.getDiscBlock()[j][i].getId() == 1)
                        System.out.print("  1  ");
                    else if (blockFour.getDiscBlock()[j][i].getId() == 2)
                        System.out.print("  2  ");
                    else
                        System.out.print("  .  ");
                }
                if (j == 2)
                    System.out.println(" |");
                else
                    System.out.println(" |\n");
            }
            System.out.println("    --------------- ---------------");

        }

        /**
         * this method makes a 6*6 block using summing up all four blocks
         *
         * @return returns the sum of 4 blocks on board as 2 dimensional array
         */
        private Disc[][] blockTable () {
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
        public boolean checkPlace ( int x, int y){
            Disc[][] discBoard = blockTable();
            return discBoard[y - 1][x - 1].getId() == 0;
        }

        /**
         * @return returns whether there is a possibility for player to skip rotating part
         * based on if there is any symmetrical block or not
         */
        public boolean foundSymmetricalBlock () {
            boolean foundBlock = false;
            for (Block block : blocks)
                if (block.symmetrical())
                    foundBlock = true;
            return foundBlock;
        }
    }
