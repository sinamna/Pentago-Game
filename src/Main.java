public class Main {
    public static void main(String[] args){
        Board gameBoard =new Board();
        gameBoard.print();
        Player playerOne=new Player(gameBoard,1);
        Player playerTwo=new Player(gameBoard,2);
        // turn changer is used to switch turns in loop
        boolean turnChanger=true;
        while(true){
            if(turnChanger){
                if(!playerOne.playTurn()) {
                    gameBoard.print();
                    turnChanger=false;
                }else break;

            }else{
                if(!playerTwo.playTurn()){
                    gameBoard.print();
                    turnChanger=true;
                }else break;
            }
        }
        gameBoard.print();
        if(gameBoard.checkEndOfGame()==3) System.out.println("BOTH PLAYERS WON.");
        else if(gameBoard.checkEndOfGame()==1) System.out.println("RED PLAYER WON");
        else System.out.println("YELLOW PLAYER WON");
    }
}
