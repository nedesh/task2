package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Filter {
    public static List<Data> waterCount(List<Data> counts) {
        List<Data> result = new ArrayList<>();
        int maxWaterCount = 0;
        for (Data count : counts) {
            int waterCount = count.getWaterCount();
            if (waterCount > maxWaterCount) {
                maxWaterCount = waterCount;
                result.clear();
                result.add(count);
            } else if (waterCount == maxWaterCount) {
                result.add(count);
            }
        }
        return result;

    }

    public static List<Data> gasCount1(List<Data> counts) {
        List<Data> result = new ArrayList<>();
        int maxGasCount1 = 0;
        for (Data count : counts) {
            int GasCount1 = count.getGasCount1();
            if (GasCount1 > maxGasCount1) {
                maxGasCount1 = GasCount1;
                result.clear();
                result.add(count);
            } else if (GasCount1 == maxGasCount1) {
                result.add(count);
            }
        }
        return result;
    }

    public static List<Data> gasCount2(List<Data> counts) {
        List<Data> result = new ArrayList<>();
        int maxGasCount2 = 0;
        for (Data count : counts) {
            int GasCount2 = count.getGasCount2();
            if (GasCount2 > maxGasCount2) {
                maxGasCount2 = GasCount2;
                result.clear();
                result.add(count);
            } else if (GasCount2 == maxGasCount2) {
                result.add(count);
            }
        }
        return result;
    }

    public static List<Data> electroCount1(List<Data> counts) {
        List<Data> result = new ArrayList<>();
        int maxElectroCount1 = 0;
        for (Data count : counts) {
            int electroCount1 = count.getElectroCount1();
            if (electroCount1 > maxElectroCount1) {
                maxElectroCount1 = electroCount1;
                result.clear();
                result.add(count);
            } else if (electroCount1 == maxElectroCount1) {
                result.add(count);
            }
        }
        return result;
    }

    public static List<Data> electroCount2(List<Data> counts) {
        List<Data> result = new ArrayList<>();
        int maxElectroCount2 = 0;
        for (Data count : counts) {
            int electroCount2 = count.getElectroCount2();
            if (electroCount2 > maxElectroCount2) {
                maxElectroCount2 = electroCount2;
                result.clear();
                result.add(count);
            } else if (electroCount2 == maxElectroCount2) {
                result.add(count);
            }
        }
        return result;
    }

    //    public static List<Data> excessMetricsElectro(List<Data> counts) {
//        List<Data> result = new ArrayList<>();
//        int electroCount = 0;
//        for (Data count : counts) {
//            int electroCount1 = count.getElectroCount1();
//            int electroCount2 = count.getElectroCount2();
//            Predicate<Integer> isPositive = x -> electroCount1 < electroCount2;
//            if (isPositive.test(electroCount1)) {
//                electroCount = electroCount1;
//                result.add(count);
//            }
//        }
//        return result;
//    }
//    public static List<Data> excessMetricsGas(List<Data> counts) {
//        List<Data> result = new ArrayList<>();
//        int gasCount = 0;
//        for (Data count : counts) {
//            int gasCount1 = count.getGasCount1();
//            int gasCount2 = count.getGasCount2();
//            Predicate<Integer> isPositive = x -> gasCount1 < gasCount2;
//            if (isPositive.test(gasCount1)) {
//                gasCount = gasCount1;
//                result.add(count);
//            }
//        }
//        return counts;
//    }
    public static void getExcessMetricsGas(List<Data> counts) {
        Stream<Data> stream = counts.stream();
        stream.filter(s -> s.getGasCount1() < s.getGasCount2())
                .forEach(s -> System.out.println("Превышает показатели газа: " + s.getName() + " на " + (s.getGasCount2() - s.getGasCount1())));
    }

    public static void getExcessMetricsElectro(List<Data> counts) {
        Stream<Data> stream = counts.stream();
        stream.filter(s -> s.getElectroCount1() < s.getElectroCount2())
                .forEach(s -> System.out.println("Превышает показатели электричества: " + s.getName() + " на " + (s.getElectroCount2() - s.getElectroCount1())));
    }
}
