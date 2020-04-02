public class Board {
    Block[] blocks;
    //constructor
    public Board(){
        blocks=new Block[4];
        for(int i=0;i<4;i++)
            blocks[i]=new Block();

    }
    //check winning situation
    public boolean checkEndOfGame(){
        return false;
    }
    //Rotate
    public void rotateBlock(int blockNum,int direction){
        blocks[blockNum].rotate(direction);
    }
    //placeDisc % thing
    public void placeDisc(int id,int x,int y){
        if(x<3){
            if(y>=3)blocks[2].placeDisc(id,x,y);
            else blocks[0].placeDisc(id,x,y);
        }else{
            if(y>=3)blocks[3].placeDisc(id,x,y);
            else blocks[1].placeDisc(id,x,y);
        }
    }
    //print
    public void print(){
        System.out.print("   |  1    2    3  |"
         +"  4    5    6   |\n");
        System.out.println("---  ---  ---  ---   ---  ---  ---  -");
        Block blockOne=blocks[0];
        Block blockTwo=blocks[1];
        for(int j=0;j<3;j++){
            System.out.printf(" %d |",j+1);
            for(int i=0;i<3;i++){
                if(blockOne.getDiscBlock()[j][i].getId()==1)
                    System.out.print("  1  ");
                else if(blockOne.getDiscBlock()[j][i].getId()==2)
                    System.out.print("  2  ");
                else
                    System.out.print("  .  ");
            }
            System.out.print("|");
            for(int i=0;i<3;i++){
                if(blockTwo.getDiscBlock()[j][i].getId()==1)
                    System.out.print("  1  ");
                else if(blockTwo.getDiscBlock()[j][i].getId()==2)
                    System.out.print("  2  ");
                else
                    System.out.print("  .  ");
            }

            if(j==2)
                System.out.println(" |");
            else
                System.out.println(" |\n");
        }
        System.out.println("    --------------- ---------------");
        Block blockThree=blocks[2];
        Block blockFour=blocks[3];
        for(int j=0;j<3;j++){
            System.out.printf(" %d |",j+4);
            for(int i=0;i<3;i++){
                if(blockThree.getDiscBlock()[j][i].getId()==1)
                    System.out.print("  1  ");
                else if(blockThree.getDiscBlock()[j][i].getId()==2)
                    System.out.print("  2  ");
                else
                    System.out.print("  .  ");
            }
            System.out.print("|");
            for(int i=0;i<3;i++){
                if(blockFour.getDiscBlock()[j][i].getId()==1)
                    System.out.print("  1  ");
                else if(blockFour.getDiscBlock()[j][i].getId()==2)
                    System.out.print("  2  ");
                else
                    System.out.print("  .  ");
            }
            if(j==2)
                System.out.println(" |");
            else
                System.out.println(" |\n");
        }
        System.out.println("    --------------- ---------------");

    }
    private Disc[][] blockTable(){
        Disc[][] boardDiscs=new Disc[6][6];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                boardDiscs[j][i]=new Disc(this.blocks[0].discBlock[j][i].getId());
            }
        for(int i=3;i<6;i++)
            for(int j=0;j<3;j++)
                boardDiscs[j][i]=new Disc(blocks[1].getDiscBlock()[j][i%3].getId());

        for(int i=0;i<3;i++)
            for(int j=3;j<6;j++)
                boardDiscs[j][i]=new Disc(blocks[2].getDiscBlock()[j%3][i].getId());

        for(int i=3;i<6;i++)
            for(int j=3;j<6;j++)
                boardDiscs[j][i]=new Disc(blocks[3].getDiscBlock()[j%3][i%3].getId());
        return boardDiscs;
    }
    public boolean checkPlace(int x,int y){
        Disc[][] boardDisc=blockTable();
        return boardDisc[y-1][x-1].getId()==0;
    }
    public boolean foundSymmetricalBlock(){
        boolean foundBlock=false;
        for(Block block:blocks)
            if(block.symmetrical())
                foundBlock=true;
        return foundBlock;
    }
}
