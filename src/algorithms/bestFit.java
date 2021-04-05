package algorithms;
import java.io.IOException;
import java.io.FileWriter;
import memory.*;
import processes.*;

public class bestFit {

    /*
     * Allocating the smallest free partition which meets the 
     * requirement of the requesting process
     */
    public bestFit(memory[] mem, process[] procStack){

        String lastLine = "-";
        memory[] tempMem = mem;


        //bubble sort to get smallest to largest
        for(int i = 0;i < tempMem.length-2;i++){
            for(int j = 0; j < tempMem.length-2;j++){
                if(tempMem[j].getSize() > tempMem[j+1].getSize()){
                    memory temp = tempMem[j];
                    tempMem[j] = tempMem[j + 1];
                    tempMem[j+1] = temp;
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
        


          //Experimental file writer method, probably make this into its own
          //thing and input filename and an array
        try{
            FileWriter myWriter = new FileWriter("src\\outputs\\BFoutput.data");
            myWriter.write("line1\n");
            myWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        

    }


}
