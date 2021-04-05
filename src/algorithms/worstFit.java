package algorithms;
import memory.*;
import processes.*;

public class worstFit {
    /*
     * Allocating to largest available free portion so leftover
     * space will maybe be useable.
     */
    public worstFit(memory[] mem, process[] procStack){

        String lastLine = "-";
        memory[] tempMem = mem;


        //bubble sort to get smallest to largest
        for(int i = 0;i < tempMem.length;i++){
            for(int j = 1; j < tempMem.length;j++){
                if(tempMem[j-1].getSize() < tempMem[j].getSize()){
                    memory temp = tempMem[j-1];
                    tempMem[j-1] = tempMem[j];
                    tempMem[j] = temp;
                }
            }
        }

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
