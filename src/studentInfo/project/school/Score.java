package studentInfo.project.school;

public class Score {
    //학번, 과목, 점수
    protected int studentId;
    protected Subject subject;
    protected int point;

    public Score(int studentId, Subject subject, int point) {
        this.studentId = studentId;
        this.subject = subject;
        this.point = point;
    }

    @Override
    public String toString() {
        //어느 학생의 어느 과목의 점수가 몇점이다.
        //필수과목인지 아닌지 어떻게 체크할까? scoreList에 있는 순? 모두가 들어가있는데?
        return this.studentId + " | " + subject.getSubjectName() + "\t | " + this.point + ":";
        // "학번: " + this.studentId + ", " + subject.getSubjectName() + ": " + point;"
    }
    //getter, setter

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
