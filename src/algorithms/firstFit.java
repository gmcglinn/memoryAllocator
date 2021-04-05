package algorithms;
import memory.*;
import processes.*;

public class firstFit {
    /*
     * allocate the first free partition or hole large 
     * enough which can accommodate the process
     */
    public firstFit(memory[] mem, process[] procStack){
        String lastLine = "-";
        memory[] tempMem = mem;

        for(process a : procStack){
            boolean miss = true;
            for(int i = 0; i < tempMem.length;i++){
                if(a.getSize() <= tempMem[i].getSize() && !tempMem[i].isFull()){
                    tempMem[i].toggleState();
                    tempMem[i].setEnd(a.getSize()+tempMem[i].getStart());
                    i = tempMem.length+1;
                    miss = false;
                }
                
            }
            if(miss == true){
                lastLine = lastLine + a.getID() + ",";
            }
        

        }
        if(lastLine == "-"){
            lastLine = "-0" + ",";
        }
        lastLine = lastLine.substring(0, lastLine.length() - 1);

        System.out.println(lastLine);
        for(memory a : tempMem){
            System.out.println("Memory Slot #"+ a.ID() + " Size: " + a.getSize() + " Begins: " + a.getStart() + " End: "+ a.getEnd() + " Is Full? " + a.isFull());
          }
    }
}
