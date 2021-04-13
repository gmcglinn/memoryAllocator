package algorithms;
import java.io.IOException;
import java.io.FileWriter;
import memory.*;
import processes.*;

public class firstFit {
    /*
     * allocate the first free partition or hole large 
     * enough which can accommodate the process
     */
    public firstFit(memory[] mem, process[] procStack){


        try{
            FileWriter myWriter = new FileWriter("src\\outputs\\FFoutput.data");

            String lastLine = "-";
            memory[] tempMem = mem;

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
