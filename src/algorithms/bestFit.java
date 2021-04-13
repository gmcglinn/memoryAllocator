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
        try{
            FileWriter myWriter = new FileWriter("src\\outputs\\BFoutput.data");

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
                    if(a.getSize() <= tempMem[i].getSize()){
                        int tempNewStart = tempMem[i].getStart() + a.getSize();
                        myWriter.write(tempMem[i].getStart() + " " + tempNewStart + " " + a.getID()+"\n");
                        tempMem[i].setStart(tempNewStart);
                        i = tempMem.length+1;
                        miss = false;
                    }
                    //re-sort available memory with another bubble sort
                    for(int x = 0;x < tempMem.length-2;x++){
                        for(int j = 0; j < tempMem.length-2;j++){
                            if(tempMem[j].getSize() > tempMem[j+1].getSize()){
                                memory temp = tempMem[j];
                                tempMem[j] = tempMem[j + 1];
                                tempMem[j+1] = temp;
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
