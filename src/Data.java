public class Data {
    private int id;
    private String name;
    private Integer waterCount;
    private Integer gasCount1;
    private Integer gasCount2;
    private Integer electroCount1;
    private Integer electroCount2;

    public Data(int id, String name, int waterCount, int gasCount1, int gasCount2, int electroCount1, int electroCount2) {
        this.id = id;
        this.name = name;
        this.waterCount = waterCount;
        this.gasCount1 = gasCount1;
        this.gasCount2 = gasCount2;
        this.electroCount1 = electroCount1;
        this.electroCount2 = electroCount2;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getWaterCount() {
        return waterCount;
    }

    public Integer getGasCount1() {
        return gasCount1;
    }

    public Integer getGasCount2() {
        return gasCount2;
    }

    public Integer getElectroCount1() {
        return electroCount1;
    }

    public Integer getElectroCount2() {
        return electroCount2;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", waterCount=" + waterCount +
                ", gasCount1=" + gasCount1 +
                ", gasCount2=" + gasCount2 +
                ", electroCount1=" + electroCount1 +
                ", electroCount2=" + electroCount2 +
                '}';
    }
}
