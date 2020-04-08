public class Block {
    Disc[][] discBlock;

    /**
     * creates a block and allocate space to each disc spot
     */
    public Block() {
        discBlock = new Disc[3][3];
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 3; i++)
                discBlock[j][i] = new Disc();

    }

    /**
     * method rotates the block based on matrix rotating algorithm
     * @param direction is the direction of rotation .
     *                  1 for rotating to right and 2 for rotating to left
     */
    public void rotate(int direction) {
        Disc[][] rotatedBlock = new Disc[3][3];
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 3; i++)
                rotatedBlock[j][i] = new Disc();
        if (direction == 1)
            rotateRight(rotatedBlock);
        else
            rotateLeft(rotatedBlock);
        discBlock=rotatedBlock;
    }

    /**
     * method for rotating to right
     * @param rotatedBlock takes the new block and store rotated block in it
     */
    private void rotateRight(Disc[][] rotatedBlock) {
        //pure formulation
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j >= 0; j--) {
                rotatedBlock[i][2 - j].setId(discBlock[j][i].getId());
            }
        }
    }

    /**
     * method for rotating to left
     * @param rotatedBlock takes the new block and store rotated block in it
     */
    private void rotateLeft(Disc[][] rotatedBlock) {
        //pure formulation
        //i figured this formula and idk if its comprehensible or not ...but it works
        for (int i = 0; i < 3; i++)
            for (int j = 2; j >= 0; j--)
                rotatedBlock[i][2 - j].setId(discBlock[2 - j][2 - i].getId());

    }
    /**
     * this method place disc in block
     * @param id is the id of player placing disc in the spot
     * @param x the horizontal place in board which isn't always the x used in block
     * @param y the vertical place in board which isn't always the x used in block
     */
    public void placeDisc(int id,int x,int y){
        //converting board coordinates to block ones
        x=x%3;
        y=y%3;
        discBlock[y][x].setId(id);
    }

    /**
     * checks if block is symmetrical or not
     * it rotates the block to left and right and compare it which original block
     * @return returns true if block is symmetrical and false if it isn't
     */
    public boolean symmetrical(){
        Disc[][] cloneOne=this.cloneBlock();
        Disc[][] cloneTwo=this.cloneBlock();
        rotateRight(cloneOne);
        rotateLeft(cloneTwo);
        return blockEquality(cloneOne) && blockEquality(cloneTwo);
    }

    /**
     * checks given array with block array
     * @param toCheck takes the 2 dimensional array which is going to be checks with block array
     * @return returns if given array is equal to block array or not
     */
    private boolean blockEquality(Disc[][] toCheck){
        boolean equality=true;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                if(toCheck[i][j].getId()!=discBlock[i][j].getId()){
                    equality=false;
                    break;
                }
            }
        return equality;
    }

    /**
     * clones block array
     * @return returns a cloned array
     */
    public Disc[][] cloneBlock(){
        Disc[][] clonedBlock=new Disc[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                clonedBlock[i][j]=new Disc(discBlock[i][j].getId());
            return clonedBlock;
    }

    /**
     *
     * @return returns array of block's discs
     */
    public Disc[][] getDiscBlock() {
        return discBlock;
    }
}
