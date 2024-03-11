package studentInfo.project.application;

import studentInfo.project.school.School;
import studentInfo.project.school.Score;
import studentInfo.project.school.Student;
import studentInfo.project.school.Subject;
import studentInfo.project.school.report.GenerateGradeReport;
import studentInfo.project.utils.Define;


public class StudentInfoApplication {
School goodSchool = School.getInstance(); // 학교 생성
Subject Korean; // 국어 과목
Subject math; // 수학 과목
    GenerateGradeReport gradeReport =new GenerateGradeReport();

    public static void main(String[] args){
        StudentInfoApplication app = new StudentInfoApplication();

        app.createSubject(); // 과목 개설 , 과목 학교에 등록
        app.createStudent();

        // 성적 결과 생성해서 출력
        String report = app.gradeReport.getReport();
        System.out.println(report);
    }

    // 과목생성
    public void createSubject(){
        Korean = new Subject("국어", Define.KOREA);
        math = new Subject("수학", Define.MATH);

        // 학교에 과목 등록
        goodSchool.addSubject(Korean);
        goodSchool.addSubject(math);
    }

    // 학생 생성
    public void createStudent(){
        Student student1 = new Student(181213,"이지은", Korean);
        Student student2 = new Student(181518,"장원영", math);
        Student student3 = new Student(171230,"원빈", Korean);
        Student student4 = new Student(171255,"하니", Korean);
        Student student5 = new Student(171590,"정성찬", math);

        // 학교에 등록
        goodSchool.addStudent(student1);
        goodSchool.addStudent(student2);
        goodSchool.addStudent(student3);
        goodSchool.addStudent(student4);
        goodSchool.addStudent(student5);

        // 수강신청
        Korean.register(student1);
        Korean.register(student2);
        Korean.register(student3);
        Korean.register(student4);
        Korean.register(student5);

        math.register(student1);
        math.register(student2);
        math.register(student3);
        math.register(student4);
        math.register(student5);


        // 학생의 과목별 점수 추가
        addScoreForStudent(student1, Korean, 95);
        addScoreForStudent(student1, math, 56);

        addScoreForStudent(student2, Korean, 95);
        addScoreForStudent(student2, math, 98);

        addScoreForStudent(student3, Korean, 100);
        addScoreForStudent(student3, math, 88);

        addScoreForStudent(student4, Korean, 89);
        addScoreForStudent(student4, math, 95);

        addScoreForStudent(student5, Korean, 83);
        addScoreForStudent(student5, math, 56);

    }

    // 학생별로 과목별(수학, 국어) 점수 추가
    public void addScoreForStudent(Student student, Subject subject, int point ){
        Score score = new Score(student.getStudentId(), subject, point);
        student.addSubjectScore(score);

    }
}
