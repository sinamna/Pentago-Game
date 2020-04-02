public class Disc {
    /*
    id represents the state of Disc
    if its 0 it means its empty
    if its 1 it means it belongs to player 1
    if its 2 it means it belongs to player 2
     */
    private int id;
    public Disc(int id){
        this.id=id;
    }
    public Disc(){
        id=0;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
