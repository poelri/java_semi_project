package semi02.project.school.report;

import semi02.project.rain.subway;
import semi02.project.school.Student;
import semi02.project.school.PublicTransit;
import semi02.project.school.RainFallAmount;
import semi02.project.rain.Basic;
import semi02.project.utils.Define;

public class TradinnesReport {
    public static void report(Student student, RainFallAmount rainfall) {
        PublicTransit publicTransit = PublicTransit.getInstance();
        int baseLatePercentage = student.getBaseLatePercentage();
        int additionalLatePercentage = publicTransit.calculateLatePercentage(student, rainfall);


        // 기본 지각 확률과 추가 지각 확률을 백분율로 합산
        int totalLatePercentage = baseLatePercentage + additionalLatePercentage;

        // 합산 결과가 100%를 초과하는 경우 100%로 고정
        if (totalLatePercentage > Define.MAX_PERCENTAGE) {
            totalLatePercentage = Define.MAX_PERCENTAGE;
        }
        System.out.println("학생 ID : " +student.getId());
        System.out.println("거주지 : " +student.getArea());
        System.out.println("학생 이름: " + student.getName());
        System.out.println("기본 지각 확률: " + baseLatePercentage + "%");
        System.out.println("강수량: " + rainfall.getRainfallPercentage() + "%");

        System.out.println("강수량 고려 후 지각 확률: " + totalLatePercentage + "%");

        // 모범생 여부 출력
        //if 여기에 강수량이 70% 이상이아니면 아래 실행
        if (totalLatePercentage <= Define.THRESHOLD_PERCENTAGE) {
            if (student.hasLunchBox()) {
                System.out.println("학생은 모범생이고 도시락을 가지고 다니고 있습니다.");
            } else {
                System.out.println("학생은 모범생이지만 도시락을 가져오지 않고 있습니다.");
            }
        } else {
            if (student.hasLunchBox()) {
                System.out.println("학생은 모범생이 아니지만 도시락을 챙겨오고 있습니다.");
            } else {
                System.out.println("학생은 모범생이 아니며, 도시락도 가져오지 않고 있습니다.");
            }
        }
        //else 비가 오지게 많이 와서 도시락 생략~
    }
}
