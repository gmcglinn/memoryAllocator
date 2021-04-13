package memory;


public class memory {
    private int startAdd;
    private int endAdd;
    private boolean state;
    private int slotID;
    private String processes;

    /**
    * Memory slots to insert into memory (start address, end address)
    */
    public memory(int start, int end, int slotID){
        this.startAdd = start;
        this.endAdd = end;
        this.state = false;
        this.slotID = slotID;
        this.processes = "";
    }

    public int getStart(){
        return this.startAdd;
    }
    public int getEnd(){
        return this.endAdd;
    }
    public void setStart(int i){
        this.startAdd = i;
    }
    public int getSize(){
        return this.endAdd - this.startAdd;
    }
    public boolean isFull(){
        return this.state;
    }
    public int ID(){
        return this.slotID;
    }

    public void addProcess(String a){
        this.processes = this.processes + "\n" + a;
    }




    /**
    * Fill or empty the memory slot state
    */
    public void toggleState(){
        this.state = !this.state;
    }
}
