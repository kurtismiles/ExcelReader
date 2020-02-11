
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import model.FirstReader;
import model.FirstSheetData;
import model.SecondReader;
import model.SecondSheetData;
import model.Writer;

//@author Kurtis Miles

public class app {
     

    public static void main(String[] args) throws IOException {
            
        int participantCount = 58;
        
        
        SecondReader readSecond = new SecondReader(participantCount);
        
        /*
        try{
            Object[] takeSecond;
            takeSecond = readSecond.getSecondData();
            
            for (int i = 0; i < 58; ++i){
            
                System.out.println("Participant: " + i);
                Object[] readSecondData;
                readSecondData = (Object[]) Array.get(takeSecond, i);
                
                if (readSecondData == null){
                System.out.println("Data null");
                }
                
                if (readSecondData != null){
                System.out.println("Data NOT null");
                
                }
            
            }
           
        } catch (NullPointerException f){System.out.println("NULL!!");}
        */
        
        FirstReader readFirst = new FirstReader(participantCount, readSecond.getSecondData());
        
                try{
            int dataType = 2;
            System.out.println("Woof!");
            Object[] takeFirst;
            takeFirst = (Object[]) readFirst.returnDataArray(dataType);
            
        for (int i = 0; i < 58; ++i){
        
            Object[] readFirstData;
            System.out.println("Woof! 1");
            readFirstData = (Object[]) Array.get(takeFirst, i);
            
            FirstSheetData[] firstDataList = (FirstSheetData[]) readFirstData;
            
            System.out.println("Participant Number" + i);
            
            if (firstDataList == null){System.out.println("Different NULL");continue;}
            
            
            for (int j = 0; j <24; ++j){
                

            FirstSheetData object1 = (FirstSheetData) Array.get(firstDataList, j);
            
            String barking = object1.getDescription();
            String woofing = object1.getSound();
            System.out.println(woofing);
            
             
            }
        
        }
        } catch (NullPointerException f){System.out.println("NULL!!");}
        
         
        
        for (int i = 1; i < 5; ++i){
            
            Writer writeMe = new Writer(participantCount, i, readFirst.returnDataArray(i));
            
            
    
        }
        
         

        
        }
        
    }
    

