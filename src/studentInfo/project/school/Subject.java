package studentInfo.project.school;

import studentInfo.project.utils.Define;

import java.util.ArrayList;

public class Subject {
    //과목명, 과목코드, 필수과목인지 일반과목인지
    protected String subjectName;
    protected int subjectId;
    protected int gradeType;
    protected ArrayList<Student> studentList = new ArrayList<>(); // 과목에 등록한 학생 리스트

    public Subject(String subjectName, int subjectId) {
        this.subjectName = subjectName;
        this.subjectId = subjectId;
        this.gradeType = Define.AB_TYPE; // 학점 평가 정책 : 기본으로 일반과목 산출 방식 사용
    }

    // 수강신청
    public void register(Student student) {
        //학생이 과목을 수강신청.
        //과목별로 성적 처리
        studentList.add(student);
    }

    //getter, setter

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getGradeType() {
        return gradeType;
    }

    public void setGradeType(int gradeType) {
        this.gradeType = gradeType;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
