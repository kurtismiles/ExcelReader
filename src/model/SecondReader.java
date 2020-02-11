package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//@author Kurtis Miles

public class SecondReader {

    int participantCount;

    Cell currentCell;
    Row currentRow;
    boolean proceed;

    int arrayCount;

    Object[] secondData;

    SecondSheetData[] secondList;

    public SecondReader() {

    }

    public SecondReader(int inf_participantCount) {
        try {

            FileInputStream fis = new FileInputStream(new File("C:\\Users\\Kurtis\\Desktop\\Bre Spreadsheet.xlsx"));
            //creating workbook instance that refers to .xls file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            //creating a Sheet object to retrieve the object  
            XSSFSheet sheet = wb.getSheetAt(2);

            participantCount = inf_participantCount;
            //evaluating cell type   
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

            Iterator<Row> rowIterator = sheet.iterator();

            secondData = new Object[participantCount];

            for (int j = 0; j < participantCount; ++j) {

                System.out.println("Participant number " + j);

                secondList = new SecondSheetData[23];

                arrayCount = 0;

                for (int i = 0; i < 34; ++i) {

                    if (arrayCount == 23) {
                        break;
                    }
                              
                    currentRow = rowIterator.next();

                    Iterator<Cell> cellIterator = currentRow.iterator();
                    
                    SecondSheetData a = new SecondSheetData();
                    boolean proceed = false;

                    int cellCount = 4;

                    while (cellIterator.hasNext() && cellCount > 0) {

                        try {

                            currentCell = cellIterator.next();

                            String check = (currentCell.getAddress()).toString();

                            String read = currentCell.getStringCellValue();

                            if (read.contains("P1")) {

                                --i;
                                currentRow = rowIterator.next();
                                cellIterator = currentRow.iterator();
                                cellCount = 4;
                                continue;

                            }

                            if (read.contains("Word Bank")) {

                                --i;
                                --i;
                                currentRow = rowIterator.next();
                                currentRow = rowIterator.next();
                                cellIterator = currentRow.iterator();

                                cellCount = 4;
                                continue;

                            }

                            if (check.contains("C")) {
                                --cellCount;
                                continue;

                            } else if (check.contains("B")) {

                                String c;

                                if (read.contains("driving")) {
                                    c = "Driving";
                                    a.setSound(c);
                                } else if (read.contains("pouring")) {
                                    c = "Pouring";
                                    a.setSound(c);
                                } else if (read.contains("phone ringing")) {
                                    c = "Phone";
                                    a.setSound(c);
                                } else if (read.contains("pickup receiver")) {
                                    c = "Picking up receiver";
                                    a.setSound(c);
                                } else if (read.contains("dial tone")) {
                                    c = "Dial Tone";
                                    a.setSound(c);
                                } else if (read.contains("dialing")) {
                                    c = "Dialing";
                                    a.setSound(c);
                                } else if (read.contains("stirring")) {
                                    c = "Stirring";
                                    a.setSound(c);
                                } else if (read.contains("doorbell")) {
                                    c = "Doorbell";
                                    a.setSound(c);
                                } else if (read.contains("barking")) {
                                    c = "Barking";
                                    a.setSound(c);
                                } else if (read.contains("trotting")) {
                                    c = "Trotting";
                                    a.setSound(c);
                                } else if (read.contains("door closing")) {
                                    c = "Door Closing";
                                    a.setSound(c);
                                } else if (read.contains("tires screeching")) {
                                    c = "Tires Screeching";
                                    a.setSound(c);
                                } else if (read.contains("sipping")) {
                                    c = "Sipping";
                                    a.setSound(c);
                                } else if (read.contains("seagulls")) {
                                    c = "Seagulls";
                                    a.setSound(c);
                                } else if (read.contains("fog horn")) {
                                    c = "Fog Horn";
                                    a.setSound(c);
                                } else if (read.contains("waves")) {
                                    c = "Waves";
                                    a.setSound(c);
                                } else if (read.contains("sigh")) {
                                    c = "Sigh";
                                    a.setSound(c);
                                } else if (read.contains("honking")) {
                                    c = "Honking";
                                    a.setSound(c);
                                } else if (read.contains("crashing")) {
                                    c = "Crashing";
                                    a.setSound(c);
                                } else if (read.contains("tea kettle")) {
                                    c = "Tea Kettle";
                                    a.setSound(c);
                                } else if (read.contains("snoring")) {
                                    c = "Snoring";
                                    a.setSound(c);
                                } else if (read.contains("rooster")) {
                                    c = "Rooster";
                                    a.setSound(c);
                                } else if (read.contains("alarm ringing")) {
                                    c = "Alarm Ringing";
                                    a.setSound(c);
                                } else if (read.contains("busy signal")) {
                                    c = "Busy Signal";
                                    a.setSound(c);
                                }

                            } else if (check.contains("D")) {

                                if (read.equals("incorrect")) {
                                    Boolean c = false;

                                    a.setStatus(c);
                                }
                                if (read.equals("correct")) {
                                    Boolean c = true;

                                    a.setStatus(c);
                                }

                            }

                            --cellCount;
                        } catch (IllegalStateException f) {
                        }
                    }

                    if (!(a.getStatus() == null) && !(a.getSound() == "N/A")) {
                        
                        System.out.println("SecondReader: " + a.getStatus());
                        proceed = true;
                    }

                    if (proceed == true) {

                        Array.set(secondList, arrayCount, a);

                        ++arrayCount;

                    }

                }

                if (arrayCount == 23){
                Array.set(secondData, j, secondList);
                }
                
                else if (arrayCount == 0){
                Array.set(secondData, j, null);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Object[] getSecondData() {

        return secondData;
    }

}
