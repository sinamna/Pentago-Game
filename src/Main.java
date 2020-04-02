public class Main {
    public static void main(String[] args){
        Board gameBoard =new Board();
        gameBoard.print();
        Player playerOne=new Player(gameBoard,1);
        Player playerTwo=new Player(gameBoard,2);
        boolean turnChanger=true;
        while(!gameBoard.checkEndOfGame()){
            if(turnChanger){
                playerOne.playTurn();
                gameBoard.print();
                turnChanger=false;
            }else{
                playerTwo.playTurn();
                gameBoard.print();
                turnChanger=true;
            }
        }
    }
}
