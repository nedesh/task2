package main.java;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Data> dataList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("data.csv"))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split("\\|");

                int id = Integer.parseInt(array[0]);
                String name = array[1];
                int waterCount = Integer.parseInt(array[2]);
                int gasCount1 = Integer.parseInt(array[3]);
                int gasCount2 = Integer.parseInt(array[4]);
                int electroCount1 = Integer.parseInt(array[5]);
                int electroCount2 = Integer.parseInt(array[6]);

                dataList.add(new Data(id, name, waterCount, gasCount1, gasCount2, electroCount1, electroCount2));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        Comparator<Data> maxWater = Comparator.comparingInt(Data::getWaterCount);
//        System.out.println(dataList.stream().max(maxWater));

        List<Data> waterCount = Filter.waterCount(dataList);
        for (Data data : waterCount) {
            System.out.printf("Больше всего воды потребляет: %s - %s\n", data.getName(), data.getWaterCount());
        }
        List<Data> gasCount1 = Filter.gasCount1(dataList);
        for (Data data : gasCount1) {
            System.out.printf("Больше всего газа потребляет: %s - %s\n", data.getName(), data.getGasCount1());
        }
        List<Data> electroCount1 = Filter.electroCount1(dataList);
        for (Data data : electroCount1) {
            System.out.printf("Больше всего электричества потребляет: %s - %s\n", data.getName(), data.getElectroCount1());
        }

//        List<Data> gas = Filter.excessMetricsGas(dataList);
//        for (Data data : gas) {
//            System.out.printf("Превышает показатели газа: %s на %s\n", data.getName(), data.getGasCount2() - data.getGasCount1());
//        }
//        List<Data> electro = Filter.excessMetricsElectro(dataList);
//        for (Data data : electro) {
//            System.out.printf("Превышает показатели электричества: %s на %s\n", data.getName(), data.getElectroCount2() - data.getElectroCount1());
//        }

        System.out.println();
        Filter.getExcessMetricsGas(dataList);
        System.out.println();
        Filter.getExcessMetricsElectro(dataList);
    }
}
