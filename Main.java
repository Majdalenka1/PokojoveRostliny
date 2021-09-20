package com.engeto.plant;
import java.time.LocalDate;

public class Main {

    private static final String INPUT_FILE = "kvetiny.txt";
    private static final String OUTPUT_FILE = "vystup.txt";
    public static void main(String[] agrs){
        PlantList list = new PlantList();
        try{
            list.importPlantsFromFile(INPUT_FILE);
        }catch (PlantException e){
            System.out.println(e.getLocalizedMessage());
        }
        for (int i = 0; i < list.size();i++){
            System.out.println(list.getPlant(i).getWateringInfo());
        }
        list.addPlant(new Plant("Lilie v obývaku"));
        list.addPlant(new Plant("Fialka v kuchyni", 3,LocalDate.now()));
        list.removePlant(2);

        try{
            list.exportToFile(OUTPUT_FILE);
        }catch(PlantException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
