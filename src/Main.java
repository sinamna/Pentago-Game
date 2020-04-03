public class Main {
    public static void main(String[] args){
        Board gameBoard =new Board();
        gameBoard.print();
        Player playerOne=new Player(gameBoard,1);
        Player playerTwo=new Player(gameBoard,2);
        boolean turnChanger=true;
        while(true){
            if(turnChanger){
                if(playerOne.playTurn()) {
                    ///gameBoard.print();
                    System.out.println("WHITE PLAYER WON");
                    break;
                }
                    gameBoard.print();
                    turnChanger=false;
            }else{
                if(playerTwo.playTurn()){
                    //gameBoard.print();
                    System.out.println("BLACK PLAYER WON");
                    break;
                }
                gameBoard.print();
                turnChanger=true;
            }
        }
    }
}
