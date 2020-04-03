import java.util.Scanner;

public class Player {
    private Board board;
    private int playerId;
    public Player(Board mainBlock,int id){
        playerId=id;
        this.board=mainBlock;
    }
    //handle turn method
    public boolean playTurn(){
        Scanner input=new Scanner(System.in);
        placeDisc();
        board.print();
        if(board.checkEndOfGame()) return true;
        if(board.foundSymmetricalBlock()){
            System.out.println("Do you want to rotate block? press y for yes ");
            if(input.next().charAt(0)=='y') {
                rotateBlock();
                if(board.checkEndOfGame()) return true;
            }
        }else {
            rotateBlock();
            if(board.checkEndOfGame()) return true;
        }
        return false;
        //board.print();
    }
    //method for placing disc
    public void placeDisc(){
        Scanner input=new Scanner(System.in);
        System.out.printf("%s's turn ,use (x,y) format :\n",playerId==1? "White":"Black");
        while (true){
            try{
                int x=Integer.parseInt(input.next());
                int y=input.nextInt();
                if(x<=6&&x>=1 &&y<=6 &&y>=1)
                    if(board.checkPlace(x,y)) {
                        board.placeDisc(playerId, x - 1, y - 1);
                        break;
                    }else
                        System.out.println("Chosen spot isn't empty\nEnter another place :");
                else
                    System.out.println("Your chosen spot is not in the map :/ \nchoose correct one");
            }catch(Exception e){
                System.out.println("Please enter correct format");
            }
        }
    }

    //method for rotating board
    public void rotateBlock(){
        Scanner input=new Scanner(System.in);
       while(true){
           try{
               System.out.println("Choose block and choose :1 for rotating to right " +
                       "and 2 for rotating to left");int blockNum=Integer.parseInt(input.next());
               int direction=input.nextInt();
               board.rotateBlock(blockNum-1,direction);
               break;
           }catch(Exception e){
               System.out.println("Please enter correct input .");
           }
       }



    }
}
