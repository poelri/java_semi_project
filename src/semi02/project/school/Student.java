package semi02.project.school;

public class Student {
    private int id;
    private String name;
    private String area;
    private int baseLatePercentage;
    private boolean lunchBox;
    private int busLatePercentage;    // 버스 이용 시 추가 지각 확률
    private int subwayLatePercentage; // 지하철 이용 시 추가 지각 확률

    public Student(int id, String name, String area, int baseLatePercentage, boolean lunchBox) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.baseLatePercentage = baseLatePercentage;
        this.lunchBox = lunchBox;
    }

    // 버스 이용 시 추가 지각 확률 설정
    public void setBusLatePercentage(int busLatePercentage) {
        this.busLatePercentage = busLatePercentage;
    }

    // 지하철 이용 시 추가 지각 확률 설정
    public void setSubwayLatePercentage(int subwayLatePercentage) {
        this.subwayLatePercentage = subwayLatePercentage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public int getBaseLatePercentage() {
        return baseLatePercentage;
    }

    public boolean hasLunchBox() {
        return lunchBox;
    }

    public int getBusLatePercentage() {
        return busLatePercentage;
    }

    public int getSubwayLatePercentage() {
        return subwayLatePercentage;
    }
}
