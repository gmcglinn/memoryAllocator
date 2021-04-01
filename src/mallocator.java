import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import memory.memory;


public class mallocator {


    public static void main(String[] args){
        
        memory memSet = null;
        int processes[] = null;

        try {
            Scanner fileReader = new Scanner(new File("src/inputs/Minput.data"));
            while (fileReader.hasNextLine()) {
                memSet = new memory(Integer.parseInt(fileReader.nextLine()));
                for(int j = 0; j < memSet.getSize();j++){
                    String tempLine[] = fileReader.nextLine().split(" ");
                    int[] temp2 = new int[2];
                    for(int i =0 ;i < 2;i++){
                        temp2[i]= Integer.parseInt(tempLine[i]);
                    }
                    memSet.createSlot(j, temp2[0], temp2[1]);
                }
            }
            fileReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          try {
            Scanner fileReader = new Scanner(new File("src/inputs/Pinput.data"));
            while (fileReader.hasNextLine()) {
                processes = new int[Integer.parseInt(fileReader.nextLine())];
                for(int j = 0; j < processes.length;j++){
                    String tempLine[] = fileReader.nextLine().split(" ");
                    int[] temp2 = new int[2];
                    for(int i =0 ;i < 2;i++){
                        temp2[i]= Integer.parseInt(tempLine[i]);
                    }
                    processes[j] = temp2[1];
                }
            }
            fileReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }


          memSet.checkSum();


        
    }
}
