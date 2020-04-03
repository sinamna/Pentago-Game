public class Block {
    Disc[][] discBlock;

    // constructor
    public Block() {
        discBlock = new Disc[3][3];
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 3; i++)
                discBlock[j][i] = new Disc();

    }
    //deepCopy constructor
    public Block(Block blockToClone){
        discBlock=blockToClone.cloneBlock();
    }
    //rotate method ...int rotate and int id
    public void rotate(int direction) {
        Disc[][] rotatedBlock = new Disc[3][3];
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 3; i++)
                rotatedBlock[j][i] = new Disc();
        //direction =1 rotate to right
        //direction =2 rotate to left
        if (direction == 1)
            rotateRight(rotatedBlock);
        else
            rotateLeft(rotatedBlock);
        discBlock=rotatedBlock;
    }

    private void rotateRight(Disc[][] rotatedBlock) {
        //pure formulation
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j >= 0; j--) {
                rotatedBlock[i][2 - j].setId(discBlock[j][i].getId());
            }
        }
    }

    private void rotateLeft(Disc[][] rotatedBlock) {
        for (int i = 0; i < 3; i++)
            for (int j = 2; j >= 0; j--)
                rotatedBlock[i][2 - j].setId(discBlock[2 - j][2 - i].getId());

    }
    //place disc int id x y
    public void placeDisc(int id,int x,int y){
        x=x%3;
        y=y%3;
        discBlock[y][x].setId(id);
    }
    //bool can rotate ->for players turning method
    public boolean symmetrical(){
        Disc[][] cloneOne=this.cloneBlock();
        Disc[][] cloneTwo=this.cloneBlock();
        rotateRight(cloneOne);
        rotateLeft(cloneTwo);
        return blockEquality(cloneOne) && blockEquality(cloneTwo);
    }
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
    //cloning
    public Disc[][] cloneBlock(){
        Disc[][] clonedBlock=new Disc[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                clonedBlock[i][j]=new Disc(discBlock[i][j].getId());
            return clonedBlock;
    }

    public Disc[][] getDiscBlock() {
        return discBlock;
    }
}
