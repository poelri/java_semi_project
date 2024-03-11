package semi02.project.school;

import semi02.project.rain.Basic;
import semi02.project.rain.bus;
import semi02.project.rain.subway;

public class PublicTransit {
    private static PublicTransit instance;

    private PublicTransit() {
    }

    public static synchronized PublicTransit getInstance() {
        if (instance == null) {
            instance = new PublicTransit();
        }
        return instance;
    }

    public int calculateLatePercentage(Student student, RainFallAmount rainfall) {
        int busLatePercentage = bus.getInstance().calculateLatePercentage(rainfall.getRainfallPercentage());
        int subwayLatePercentage = subway.getInstance().calculateLatePercentage(rainfall.getRainfallPercentage());


        // 학생의 버스와 지하철 이용 시 추가 지각 확률을 가져옵니다.
        //int busLatePercentage = student.getBusLatePercentage();
        //int subwayLatePercentage = student.getSubwayLatePercentage();

        // 각 교통수단에 따른 추가 지각 확률을 합산하여 반환합니다.
        return busLatePercentage + subwayLatePercentage;
    }
}