package memory;


public class memory {
    private int startAdd;
    private int endAdd;
    private int size;
    private boolean state;
    private int slotID;

    /**
    * Memory slots to insert into memory (start address, end address)
    */
    public memory(int start, int end, int slotID){
        this.startAdd = start;
        this.endAdd = end;
        this.size = end - start;
        this.state = false;
        this.slotID = slotID;
    }

    public int getStart(){
        return this.startAdd;
    }
    public int getEnd(){
        return this.endAdd;
    }
    public void setEnd(int i){
        this.endAdd = i;
    }
    public int getSize(){
        return this.size;
    }
    public boolean isFull(){
        return this.state;
    }
    public int ID(){
        return this.slotID;
    }
    /**
    * Fill or empty the memory slot state
    */
    public void toggleState(){
        this.state = !this.state;
    }
}
