package semi02.project.application;

import semi02.project.rain.Basic;
import semi02.project.school.RainFallAmount;

import semi02.project.school.Student;
import semi02.project.rain.bus;
import semi02.project.rain.subway;
import semi02.project.school.report.TradinnesReport;

import java.util.Scanner;

public class StudentInfoApplication {
    public static void main(String[] args) {


        Student student1 = new Student(121212, "김영광", "서울", 50, false);
        Student student2 = new Student(121213, "도라에몽", "천안", 0, false);
        Student student3 = new Student(121214, "작은정민", "부천", 0, true);
        Student student4 = new Student(121215, "큰정민", "서울", 30, true);

        Student[] students = {student1, student2, student3, student4};

        Scanner scanner = new Scanner(System.in);
        System.out.println("오늘의 강수량을 입력하세요: ");
        int rainfallPercentage = scanner.nextInt();

        RainFallAmount rainfall = new RainFallAmount(rainfallPercentage);

        System.out.println("지각 보고서를 계산 중입니다...\n");

        for (Student student : students) {
            Basic transportation;
            if (student.getArea().equals("서울")) {
                transportation = subway.getInstance();
            } else {
                transportation = bus.getInstance();
            }
            TradinnesReport.report(student, rainfall);
            System.out.println();
        }
    }
}
