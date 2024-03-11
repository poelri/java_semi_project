package studentInfo.project.school;

import java.util.ArrayList;

public class Student {
    //학번, 이름, 필수과목, 점수리스트
    protected int studentId;
    protected String studentName;
    protected Subject majorSubject; // 필수과목
    protected ArrayList<Score> scoreList = new ArrayList<>(); // 학생 한 명은 여러개의 점수를 가진다.

    public Student(int studentId, String studentName, Subject majorSubject) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.majorSubject = majorSubject;
//        majorSubject.register(this); // 학생을 필수과목에 등록
    }
    public void addSubjectScore(Score score) {
        //점수를 추가해준다
        scoreList.add(score);
    }
    //getter, setter


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Subject getMajorSubject() {
        return majorSubject;
    }

    public void setMajorSubject(Subject majorSubject) {
        this.majorSubject = majorSubject;
    }

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
