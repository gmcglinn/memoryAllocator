package algorithms;
import java.io.IOException;
import java.io.FileWriter;
import memory.*;
import processes.*;

public class worstFit {
    /*
     * Allocating to largest available free portion so leftover
     * space will maybe be useable.
     */
    public worstFit(memory[] mem, process[] procStack){
        try{
            FileWriter myWriter = new FileWriter("src\\outputs\\WFoutput.data");

            String lastLine = "-";
            memory[] tempMem = mem;


            //bubble sort to get largest to smallest
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
                    if(a.getSize() <= tempMem[i].getSize()){
                        int tempNewStart = tempMem[i].getStart() + a.getSize();
                        myWriter.write(tempMem[i].getStart() + " " + tempNewStart + " " + a.getID()+"\n");
                        tempMem[i].setStart(tempNewStart);
                        i = tempMem.length+1;
                        miss = false;
                    }
                    //re-sort available memory with another bubble sort
                    for(int x = 0;x < tempMem.length;x++){
                        for(int j = 1; j < tempMem.length;j++){
                            if(tempMem[j-1].getSize() < tempMem[j].getSize()){
                                memory temp = tempMem[j-1];
                                tempMem[j-1] = tempMem[j];
                                tempMem[j] = temp;
                            }
                        }
                    }
                }
                if(miss == true){
                    lastLine = lastLine + a.getID() + ",";
                }
            

            }
            if(lastLine == "-"){
                lastLine = "-0" + ",";
            }
            myWriter.write(lastLine.substring(0, lastLine.length() - 1));

            myWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        

    }
}