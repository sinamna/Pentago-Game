public class Disc {
    /*
    id represents the state of Disc
    if its 0 it means its empty
    if its 1 it means it belongs to player 1
    if its 2 it means it belongs to player 2
     */
    private int id;

    /**
     * creating disc with id given
     * @param id
     */
    public Disc(int id){
        this.id=id;
    }

    /**
     * creating new empty disc constructor
     *
     */
    public Disc(){
        id=0;
    }

    /**
     *
     * @return returns disc id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id id to be set to disc
     */
    public void setId(int id) {
        this.id = id;
    }
}
