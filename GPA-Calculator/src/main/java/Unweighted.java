import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
public class Unweighted extends Calculator{
    private static DecimalFormat df = new DecimalFormat("0.00");


    public static String unweighted(List<Integer>Credits,List<String>Grades) {
        df.setRoundingMode(RoundingMode.UP);



        double gpa = 0;
        int ncredit = 0;

        for (int x = 0; x < Grades.size(); x++) {
            String classGrade = Grades.get(x);
            int credit = Credits.get(x);
            ncredit +=credit;
            if ("A".equals(classGrade) || "A+".equals(classGrade)) {
                gpa += (4 * credit);
            }
            if ("A-".equals(classGrade)) {
                gpa += (3.7 * credit);
            }
            if ("B".equals(classGrade)) {
                gpa += (3 * credit);
            }
            if ("B-".equals(classGrade)) {
                gpa += (2.7 * credit);
            }
            if ("B+".equals(classGrade)) {
                gpa += (3.3 * credit);
            }
            if ("C".equals(classGrade)) {
                gpa += (2 * credit);
            }
            if ("C+".equals(classGrade)) {
                gpa += (2.3 * credit);
            }
            if ("C-".equals(classGrade)) {
                gpa += (1.7 * credit);
            }
            if ("D".equals(classGrade)) {
                gpa += (1 * credit);
            }
            if ("D+".equals(classGrade)) {
                gpa += (1.3 * credit);
            }
            if ("D-".equals(classGrade)) {
                gpa += (0.7 * credit);
            }
            if ("F".equals(classGrade)) {
                gpa += 0;
            }
        }
        double calculatedGpa = gpa / ncredit;
       return df.format(calculatedGpa);
    }

}





