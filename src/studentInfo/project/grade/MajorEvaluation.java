package studentInfo.project.grade;

public class MajorEvaluation implements GradeEvaluation{
    @Override
    public String getGrade(int point) {
        //필수과목일때
        if(point > 100) return "잘못된 입력값입니다.";
        else if(point >= 95) return "S";
        else if (point >= 90) return "A";
        else if (point >= 80) return "B";
        else if (point >= 70) return "C";
        else if (point >= 60) return "D";
        else return "F";
    }
}
