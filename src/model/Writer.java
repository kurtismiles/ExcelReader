package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//@author Kurtis Miles

public class Writer {

    int participantCount;
    XSSFSheet sheet;
    XSSFWorkbook wb;

    File src;

    Cell currentCell;
    Row currentRow;

    int rowStart;
    int dataDescription;

    Object[] dataArray;

    FirstSheetData[] firstData;

    public Writer() {
    }

    public Writer(int inf_participantCount, int inf_attributeNum, Object[] inf_dataArray) {

        try {

            src = new File("C:\\Users\\Kurtis\\Desktop\\Bre Spreadsheet.xlsx");
            FileInputStream fis = new FileInputStream(src);
            //creating workbook instance that refers to .xls file  
            wb = new XSSFWorkbook(fis);
            //creating a Sheet object to retrieve the object  
            sheet = wb.getSheetAt(3);

            participantCount = inf_participantCount;
            dataDescription = inf_attributeNum;

            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            Iterator<Row> rowIterator = sheet.iterator();

            rowStart = ((dataDescription * participantCount) - participantCount);

            if (dataDescription > 1) {
                rowStart = rowStart + (6 * dataDescription) - 6;
            }

            if (dataDescription == 1){
            for (int i = 0; i < 1000; ++i){
                
                Row rowCreator = sheet.createRow(i);
            }
            }
            
            paintVerticalText();
            paintHorizontalText();
            
            int rowCount = rowStart;
            
            Row row = sheet.getRow(rowStart++);
            row = sheet.getRow(rowStart++);
            row = sheet.getRow(rowStart++);
            
            
            dataArray = inf_dataArray;
            
            
            for (int i = 0; i < participantCount; ++i) {

                firstData = (FirstSheetData[]) Array.get(dataArray, i);
                
                if (firstData == null){
                    continue;
                }
                
                int jCount = 0;
                
                System.out.println("Participant Count is " + i);
                for (int j = 0; j < 23; ++j) {
                    
                    if (j == 1){
                        
                        sheet.getRow(row.getRowNum()).createCell(j + 1)
                        .setCellValue("N/A");
                        
                        continue;}
                    
                    FirstSheetData object1 = (FirstSheetData) Array.get(firstData, jCount);
                    
                    String coefficient = object1.getCoefficient();
                    
                    sheet.getRow(row.getRowNum()).createCell(j + 1)
                        .setCellValue(coefficient);
                    
                    
                    System.out.println("Object is " + object1.getSound());
                    System.out.println("jCount is " + jCount);
                    ++jCount;
                    
                          
                }
                
                row = sheet.getRow(rowStart++);

            }
            
            FileOutputStream fos = new FileOutputStream(src);

            wb.write(fos);

            fos.close();
            
            wb.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException c){}

    }

    public void paintVerticalText() throws FileNotFoundException, IOException {

        int rowCount = rowStart;

        for (int j = 0; j < participantCount + 2; ++j) {

            Row row = sheet.getRow(rowCount++);
            
            try{
            
            if (j == 0) {
                if (dataDescription == 1) {
                    sheet.getRow(row.getRowNum()).createCell(0)
                            .setCellValue("Familiar");
                } else if (dataDescription == 2) {
                    sheet.getRow(row.getRowNum()).createCell(0)
                            .setCellValue("Pleasant");
                } else if (dataDescription == 3) {
                    sheet.getRow(row.getRowNum()).createCell(0)
                            .setCellValue("Complex");
                } else if (dataDescription == 4) {
                    sheet.getRow(row.getRowNum()).createCell(0)
                            .setCellValue("Imagine");
                }
            } else if (j == 1) {
                sheet.getRow(row.getRowNum()).createCell(0)
                        .setCellValue("Subject");
            } else {
                sheet.getRow(row.getRowNum()).createCell(0)
                        .setCellValue(j - 1);
            }
            } catch (NullPointerException e){}
        }

        FileOutputStream fos = new FileOutputStream(src);

        wb.write(fos);

        fos.close();

    }

    public void paintHorizontalText() throws FileNotFoundException, IOException {

        int rowCount = rowStart;

        Row row = sheet.getRow(rowCount++);
        
        try{
        
        for (int j = 1; j < 25; ++j) {

            if (j == 1) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("driving");
            } else if (j == 2) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("yawning (imagine did not have yawning question, but there was an alarm ringing question?)");
            } else if (j == 3) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("pouring");
            } else if (j == 4) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("phone");
            } else if (j == 5) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("picking up receiver");
            } else if (j == 6) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("dial tone");
            } else if (j == 7) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("dialing");
            } else if (j == 8) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("stirring");
            } else if (j == 9) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("doorbell");
            } else if (j == 10) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("barking");
            } else if (j == 11) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("trotting");
            } else if (j == 12) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("door closing");
            } else if (j == 13) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("tires screeching");
            } else if (j == 14) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("sipping");
            } else if (j == 15) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("seagulls");
            } else if (j == 16) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("fog horn");
            } else if (j == 17) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("waves");
            } else if (j == 18) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("sigh");
            } else if (j == 19) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("honking");
            } else if (j == 20) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("seagulls");
            } else if (j == 21) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("crashing");
            } else if (j == 22) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("tea");
            } else if (j == 23) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("snoring");
            } else if (j == 24) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("rooster");
            }
        }

        row = sheet.getRow(rowCount);

        for (int j = 1; j < 25; ++j) {

            if (j == 1) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.1");
            } else if (j == 2) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.10");
            } else if (j == 3) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.11");
            } else if (j == 4) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.12");
            } else if (j == 5) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.13");
            } else if (j == 6) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.14");
            } else if (j == 7) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.15");
            } else if (j == 8) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.16");
            } else if (j == 9) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.17");
            } else if (j == 10) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.18");
            } else if (j == 11) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.19");
            } else if (j == 12) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.2");
            } else if (j == 13) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.20");
            } else if (j == 14) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.21");
            } else if (j == 15) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.22");
            } else if (j == 16) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.23");
            } else if (j == 17) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.24");
            } else if (j == 18) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.3");
            } else if (j == 19) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.4");
            } else if (j == 20) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.5");
            } else if (j == 21) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.6");
            } else if (j == 22) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.7");
            } else if (j == 23) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.8");
            } else if (j == 24) {
                sheet.getRow(row.getRowNum()).createCell(j)
                        .setCellValue("Q2.9");
            }

        }
        } catch(NullPointerException e){}

        FileOutputStream fos = new FileOutputStream(src);

        wb.write(fos);

        fos.close();

    }
}
