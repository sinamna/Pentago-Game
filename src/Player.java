import java.util.Scanner;

public class Player {
    //is the board players play on
    private Board board;
    //the id of the player used for setting disc's id
    private int playerId;

    /**
     * @param mainBlock is the board players play on
     * @param id is the id of the player
     */
    public Player(Board mainBlock, int id) {
        playerId = id;
        this.board = mainBlock;
    }
    //handle turn method

    /**
     * each player's turn consist of placing a disc and rotating a block(if wanted)
     * @return method returns true when end of game condition were true which is used in main class to control changing
     * turns and end of the game
     */
    public boolean playTurn() {
        Scanner input = new Scanner(System.in);
        placeDisc();
        board.print();
        //if placing a disc leads to making a 5 disc in a row for 1 or both players it returns true in this point
        // returning number 3 means both player have won
        if (board.checkEndOfGame() == playerId || board.checkEndOfGame() == 3) return true;
        /*
        if one or more symmetrical found in the board it gives the choice to player to rotate a block or not
         */
        if (board.foundSymmetricalBlock()) {
            System.out.println("You can skip rotating a block . press y if you want to rotate one. ");
            if (input.next().charAt(0) == 'y') {
                rotateBlock();
                // checks if rotating a block cause a end of game condition
                if (board.checkEndOfGame() == playerId || board.checkEndOfGame() == 3) return true;
            }
        } else {
            //no symmetrical blocks were found
            rotateBlock();
            // checks if rotating a block cause a end of game condition
            if (board.checkEndOfGame() == playerId || board.checkEndOfGame() == 3) return true;
        }
        return false;
    }

    /**
     * this method take coordinates from user and if its possible place a disc in that spot
     *  if not it continues to take coordinates
     */
    public void placeDisc() {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s's turn ,use (x,y) format :\n", playerId == 1 ? "White" : "Black");
        while (true) {
            try {
                int x = Integer.parseInt(input.next());
                int y = input.nextInt();
                //checks if numbers are in wanted area
                if (x <= 6 && x >= 1 && y <= 6 && y >= 1)
                    //checks if there is empty spot to place a disc in
                    if (board.checkPlace(x, y)) {
                        board.placeDisc(playerId, x - 1, y - 1);
                        break;
                    } else
                        System.out.println("Chosen spot isn't empty\nEnter another place :");
                else
                    System.out.println("Your chosen spot is not in the map :/ \nchoose correct one");
            } catch (Exception e) {
                System.out.println("Please enter correct format");
            }
        }
    }

    /**
     *takes block number and rotation direction from user and rotate the block in board
     */
    public void rotateBlock() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Choose block and choose :(block,direction) format \n1 for rotating to right " +
                        "or 2 for rotating to left");
                int blockNum = Integer.parseInt(input.next());
                int direction = input.nextInt();
                board.rotateBlock(blockNum - 1, direction);
                break;
            } catch (Exception e) {
                System.out.println("Please enter correct input .");
            }
        }
    }
}
