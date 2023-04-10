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

        Filter.waterCount(dataList);
        Filter.gasCount1(dataList);
        Filter.electroCount1(dataList);

//        Filter.exceedsGas(dataList);
//        Filter.exceedsElectro(dataList);

        System.out.println();
        Filter.streamGas(dataList);
        System.out.println();
        Filter.streamElectro(dataList);
    }
}
