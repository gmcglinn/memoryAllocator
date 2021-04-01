package memory;


public class memSlot {
    private int startAdd;
    private int endAdd;
    private int size;
    private boolean state;

    /**
    * Memory slots to insert into memory (start address, end address)
    */
    public memSlot(int start, int end){
        this.startAdd = start;
        this.endAdd = end;
        this.size = end - start;
        this.state = false;
    }

    public int getStart(){
        return this.startAdd;
    }
    public int getEnd(){
        return this.endAdd;
    }
    public int getSize(){
        return this.size;
    }
    public boolean isFull(){
        return this.state;
    }
    /**
    * Fill or empty the memory slot state
    */
    public void toggleState(){
        this.state = !this.state;
    }
}
