package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//@author Kurtis Miles

public class FirstReader {

    int participantCount;
    int rowStart;

    Cell currentCell;
    Row currentRow;

    Row writerRow;
    Cell writerCell;

    Boolean barking, driving, tires, honking, crashing, phone, pickup, busy,
            dialtone, dialing, doorbell, tea, pour, stir, sip, sign, trot, door,
            seagull, fog, wave, snore, rooster;

    Object[] secondData;

    boolean secondDataNull;

    Object[] firstDataType1;
    Object[] firstDataType2;
    Object[] firstDataType3;
    Object[] firstDataType4;

    FirstSheetData[] description1;
    FirstSheetData[] description2;
    FirstSheetData[] description3;
    FirstSheetData[] description4;

    public FirstReader(int inf_participantCount, Object[] inf_secondData) throws IOException {

        try {

            File src = new File("C:\\Users\\Kurtis\\Desktop\\Bre Spreadsheet.xlsx");

            FileInputStream fis = new FileInputStream(src);
            //creating workbook instance that refers to .xls file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            //creating a Sheet object to retrieve the object  
            XSSFSheet sheet = wb.getSheetAt(1);

            participantCount = inf_participantCount;

            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

            Iterator<Row> rowIterator = sheet.iterator();

            secondData = inf_secondData;

            firstDataType1 = new Object[participantCount];
            firstDataType2 = new Object[participantCount];
            firstDataType3 = new Object[participantCount];
            firstDataType4 = new Object[participantCount];

            int dataCount = 0;

            for (int j = 0; j < participantCount; ++j) {

                System.out.println("Participant number " + j);
                rowStart = (j * 105);

                secondDataNull = false;
                readDataStatus(j);

                description1 = new FirstSheetData[24];
                description2 = new FirstSheetData[24];
                description3 = new FirstSheetData[24];
                description4 = new FirstSheetData[24];

                int arrayCount1 = 0;
                int arrayCount2 = 0;
                int arrayCount3 = 0;
                int arrayCount4 = 0;

                for (int i = 0; i < 101; ++i) {

                    currentRow = rowIterator.next();

                    if (secondDataNull == true) {
                        System.out.println("null data" + i);

                        description1 = null;
                        description2 = null;
                        description3 = null;
                        description4 = null;

                        continue;
                    }

                    if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {

                        System.out.println("Loop " + i);
                        continue;
                    }

                    //Fixes a weird bug that happens at j = 30 and i == 5
                    //Row Iterator is one behind where it needs to be
                    //FIND OUT WHAT CAUSES THIS!
                    if (i == 5 && j == 30) {
                        currentRow = rowIterator.next();
                    }

                    writerCell = currentRow.createCell(15);

                    Iterator<Cell> cellIterator = currentRow.iterator();

                    FirstSheetData a = new FirstSheetData();

                    while (cellIterator.hasNext()) {

                        currentCell = cellIterator.next();

                        String check = (currentCell.getAddress()).toString();

                        if (check.contains("B")) {

                            String b = currentCell.getStringCellValue();

                            String c;

                            if (b.equals("The sound of 'driving' (car)")) {
                                c = "Driving";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (driving == true) {
                                    a.setStatus(true);
                                } else if (driving == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("pouring")) {
                                c = "Pouring";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (pour == true) {
                                    a.setStatus(true);
                                } else if (pour == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("phone ringing")) {
                                c = "Phone";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (phone == true) {
                                    a.setStatus(true);
                                } else if (phone == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("picking up receiver")) {
                                c = "Picking up receiver";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (pickup == true) {
                                    a.setStatus(true);
                                } else if (pickup == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.equals("The sound of 'dial tone' (telephone)")) {
                                c = "Dial Tone";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (dialtone == true) {
                                    a.setStatus(true);
                                } else if (dialtone == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("dialing")) {
                                c = "Dialing";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (dialing == true) {
                                    a.setStatus(true);
                                } else if (dialing == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("stirring")) {
                                c = "Stirring";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (stir == true) {
                                    a.setStatus(true);
                                } else if (stir == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("doorbell")) {
                                c = "Doorbell";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (doorbell == true) {
                                    a.setStatus(true);
                                } else if (doorbell == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("barking")) {
                                c = "Barking";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (barking == true) {
                                    a.setStatus(true);
                                } else if (barking == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("trotting")) {
                                c = "Trotting";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (trot == true) {
                                    a.setStatus(true);
                                } else if (trot == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("door closing")) {
                                c = "Door Closing";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (door == true) {
                                    a.setStatus(true);
                                } else if (door == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("tires screeching")) {
                                c = "Tires Screeching";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (tires == true) {
                                    a.setStatus(true);
                                } else if (tires == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("sipping")) {
                                c = "Sipping";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (sip == true) {
                                    a.setStatus(true);
                                } else if (sip == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("seagulls")) {
                                c = "Seagulls";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (seagull == true) {
                                    a.setStatus(true);
                                } else if (seagull == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("fog horn")) {
                                c = "Fog Horn";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (fog == true) {
                                    a.setStatus(true);
                                } else if (fog == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("waves")) {
                                c = "Waves";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (wave == true) {
                                    a.setStatus(true);
                                } else if (wave == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("sigh")) {
                                c = "Sigh";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (sign == true) {
                                    a.setStatus(true);
                                } else if (sign == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("honking")) {
                                c = "Honking";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (honking == true) {
                                    a.setStatus(true);
                                } else if (honking == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("crashing")) {
                                c = "Crashing";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (crashing == true) {
                                    a.setStatus(true);
                                } else if (crashing == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("tea kettle")) {
                                c = "Tea Kettle";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (tea == true) {
                                    a.setStatus(true);
                                } else if (tea == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("snoring")) {
                                c = "Snoring";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (snore == true) {
                                    a.setStatus(true);
                                } else if (snore == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("rooster")) {
                                c = "Rooster";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (rooster == true) {
                                    a.setStatus(true);
                                } else if (rooster == false) {
                                    a.setStatus(false);
                                }

                            } else if (b.contains("The sound of 'busy signal' (telephone)")) {
                                c = "Busy Signal";
                                a.setSound(c);
                                System.out.println("One before rooster is " + (i - 1));
                                if (busy == true) {
                                    a.setStatus(true);
                                } else if (busy == false) {
                                    a.setStatus(false);
                                }
                            }

                        }

                        if (check.contains("C")) {

                            String b = currentCell.getStringCellValue();

                            String c;

                            if (b.contains("familiar")) {
                                c = "Familiar";
                                a.setDescription(c);
                            } else if (b.contains("pleasant")) {
                                c = "Pleasant";
                                a.setDescription(c);
                            } else if (b.contains("complex")) {
                                c = "Complex";
                                a.setDescription(c);
                            } else if (b.contains("imagine")) {
                                c = "Imagine";
                                a.setDescription(c);
                            }

                        }

                        if (check.contains("E")) {

                            try {
                                int d = (int) currentCell.getNumericCellValue();

                                a.setScore(d);

                            } catch (IllegalStateException f) {
                            }
                        }

                    }

                    if ((a.getCoefficient() != "N/A") && (a.getStatus() != null)) {
                        a.calculateCoefficient();
                        sheet.getRow(currentRow.getRowNum()).createCell(15)
                                .setCellValue(a.getCoefficient());

                    }

                    if (a.getDescription().contains("Familiar") && arrayCount1 < 24) {
                        Array.set(description1, arrayCount1, a);
                        System.out.println("idk1");
                        ++arrayCount1;
                    } else if (a.getDescription().contains("Pleasant") && arrayCount2 < 24) {
                        Array.set(description2, arrayCount2, a);
                        System.out.println("idk2");
                        ++arrayCount2;
                    } else if (a.getDescription().contains("Complex") && arrayCount3 < 24) {
                        Array.set(description3, arrayCount3, a);
                        System.out.println("idk3");
                        ++arrayCount3;
                    } else if (a.getDescription().contains("Imagine") && arrayCount4 < 24) {
                        Array.set(description4, arrayCount4, a);
                        System.out.println("idk4");
                        ++arrayCount4;

                    }

                }

                Array.set(firstDataType1, dataCount, description1);
                Array.set(firstDataType2, dataCount, description2);
                Array.set(firstDataType3, dataCount, description3);
                Array.set(firstDataType4, dataCount, description4);
                ++dataCount;

            }

            FileOutputStream fos = new FileOutputStream(src);

            wb.write(fos);

            wb.close();
            fis.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readDataStatus(int inf_loopIteration) {

        int loopIteration = inf_loopIteration;
        System.out.println(loopIteration);

        try {
            Object[] takeSecondData;
            takeSecondData = (Object[]) Array.get(secondData, loopIteration);

            if (takeSecondData == null) {
                System.out.println("loopIteration null: " + loopIteration);
                secondDataNull = true;
            }

            if (takeSecondData != null) {
                SecondSheetData[] secondDataList = (SecondSheetData[]) takeSecondData;

                SecondSheetData object1 = (SecondSheetData) Array.get(secondDataList, 0);
                SecondSheetData object2 = (SecondSheetData) Array.get(secondDataList, 1);
                SecondSheetData object3 = (SecondSheetData) Array.get(secondDataList, 2);
                SecondSheetData object4 = (SecondSheetData) Array.get(secondDataList, 3);
                SecondSheetData object5 = (SecondSheetData) Array.get(secondDataList, 4);
                SecondSheetData object6 = (SecondSheetData) Array.get(secondDataList, 5);
                SecondSheetData object7 = (SecondSheetData) Array.get(secondDataList, 6);
                SecondSheetData object8 = (SecondSheetData) Array.get(secondDataList, 7);
                SecondSheetData object9 = (SecondSheetData) Array.get(secondDataList, 8);
                SecondSheetData object10 = (SecondSheetData) Array.get(secondDataList, 9);
                SecondSheetData object11 = (SecondSheetData) Array.get(secondDataList, 10);
                SecondSheetData object12 = (SecondSheetData) Array.get(secondDataList, 11);
                SecondSheetData object13 = (SecondSheetData) Array.get(secondDataList, 12);
                SecondSheetData object14 = (SecondSheetData) Array.get(secondDataList, 13);
                SecondSheetData object15 = (SecondSheetData) Array.get(secondDataList, 14);
                SecondSheetData object16 = (SecondSheetData) Array.get(secondDataList, 15);
                SecondSheetData object17 = (SecondSheetData) Array.get(secondDataList, 16);
                SecondSheetData object18 = (SecondSheetData) Array.get(secondDataList, 17);
                SecondSheetData object19 = (SecondSheetData) Array.get(secondDataList, 18);
                SecondSheetData object20 = (SecondSheetData) Array.get(secondDataList, 19);
                SecondSheetData object21 = (SecondSheetData) Array.get(secondDataList, 20);
                SecondSheetData object22 = (SecondSheetData) Array.get(secondDataList, 21);
                SecondSheetData object23 = (SecondSheetData) Array.get(secondDataList, 22);

                barking = object1.getStatus();
                driving = object2.getStatus();
                tires = object3.getStatus();
                honking = object4.getStatus();
                crashing = object5.getStatus();
                phone = object6.getStatus();
                pickup = object7.getStatus();
                dialtone = object8.getStatus();
                dialing = object9.getStatus();
                busy = object10.getStatus();
                doorbell = object11.getStatus();
                tea = object12.getStatus();
                pour = object13.getStatus();
                stir = object14.getStatus();
                sip = object15.getStatus();
                sign = object16.getStatus();
                trot = object17.getStatus();
                door = object18.getStatus();
                seagull = object19.getStatus();
                fog = object20.getStatus();
                wave = object21.getStatus();
                snore = object22.getStatus();
                rooster = object23.getStatus();

            }

        } catch (NullPointerException p) {
        }
    }

    public Object[] returnDataArray(int inf_attribute) {

        int attribute = inf_attribute;

        if (attribute == 1) {
            return firstDataType1;
        } else if (attribute == 2) {
            return firstDataType2;
        } else if (attribute == 3) {
            return firstDataType3;
        } else if (attribute == 4) {
            return firstDataType4;
        } else {
            return null;
        }
    }

}
