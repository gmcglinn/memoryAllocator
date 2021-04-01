package memory;

public class memory {
    private memSlot[] slots;

    /**
    * Memory instance (slots)
    */
    public memory(int totalSlots){ 
        this.slots = new memSlot[totalSlots];
    }
    
    /**
    * Define characteristics of memory slot.
    * SlotNum is index
    */
    public void createSlot(int slotNum, int start, int stop){
        this.slots[slotNum] = new memSlot(start, stop);
    }
    public int getSize(){
        return this.slots.length;
    }


    public void checkSum(){

        for(memSlot a : this.slots){
            System.out.println("Memory Start: "+a.getStart()+" Memory End:"+a.getEnd()+" Size: "+a.getSize()+" Full?: "+a.isFull());
        }

    }
}
