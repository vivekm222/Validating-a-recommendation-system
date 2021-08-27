import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weighted extends Calculator{

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static List<Double> converter(List<Map<String, String>> classes) {
        String temp;
        Map<String, String> grade;
        List<Double> grades = new ArrayList<>();
        for (int i = 0; i < classes.size(); i++) {
            grade = classes.get(i);
            if (grade.containsKey("ap")) {
                temp = grade.get("ap");
                temp.toUpperCase();
                if (temp.equals("A+") || temp.equals("A")) {
                    grades.add(5.0);
                } else if (temp.equals("A-")) {
                    grades.add(4.7);
                } else if (temp.equals("B+")) {
                    grades.add(4.3);
                } else if (temp.equals("B")) {
                    grades.add(4.0);
                } else if (temp.equals("B-")) {
                    grades.add(3.7);
                } else if (temp.equals("C+")) {
                    grades.add(3.3);
                } else if (temp.equals("C")) {
                    grades.add(3.0);
                } else if (temp.equals("C-")) {
                    grades.add(2.7);
                } else if (temp.equals("D+")) {
                    grades.add(2.3);
                } else if (temp.equals("D")) {
                    grades.add(2.0);
                } else if (temp.equals("D-")) {
                    grades.add(1.7);
                } else if (temp.equals("F")) {
                    grades.add(0.0);
                } else {
                    System.out.println("Invalid Grade Input");
                }
            } else if (grade.containsKey("honors")) {
                temp = grade.get("honors");
                temp.toUpperCase();
                if (temp.equals("A+") || temp.equals("A")) {
                    grades.add(4.5);
                } else if (temp.equals("A-")) {
                    grades.add(4.17);
                } else if (temp.equals("B+")) {
                    grades.add(3.83);
                } else if (temp.equals("B")) {
                    grades.add(3.5);
                } else if (temp.equals("B-")) {
                    grades.add(3.17);
                } else if (temp.equals("C+")) {
                    grades.add(2.83);
                } else if (temp.equals("C")) {
                    grades.add(2.5);
                } else if (temp.equals("C-")) {
                    grades.add(2.17);
                } else if (temp.equals("D+")) {
                    grades.add(1.83);
                } else if (temp.equals("D")) {
                    grades.add(1.5);
                } else if (temp.equals("D-")) {
                    grades.add(1.17);
                } else if (temp.equals("F")) {
                    grades.add(0.0);
                } else {
                    System.out.println("Invalid Grade Input");
                }
            }else{
                temp = grade.get("");
                temp.toUpperCase();
                if (temp.equals("A+") || temp.equals("A")) {
                        grades.add(4.0);
                    } else if (temp.equals("A-")) {
                        grades.add(3.7);
                    } else if (temp.equals("B+")) {
                        grades.add(3.3);
                    } else if (temp.equals("B")) {
                        grades.add(3.0);
                    } else if (temp.equals("B-")) {
                        grades.add(2.7);
                    } else if (temp.equals("C+")) {
                        grades.add(2.3);
                    } else if (temp.equals("C")) {
                        grades.add(2.0);
                    } else if (temp.equals("C-")) {
                        grades.add(1.7);
                    } else if (temp.equals("D+")) {
                        grades.add(1.3);
                    } else if (temp.equals("D")) {
                        grades.add(1.0);
                    } else if (temp.equals("D-")) {
                        grades.add(0.7);
                    } else if (temp.equals("F")) {
                        grades.add(0.0);
                    } else {
                        System.out.println("Invalid Grade Input");
                    }
                }
            }
        return grades;
    }

    public static String calculation(List<Double> grades, List<Integer> credits){
        df.setRoundingMode(RoundingMode.UP);
        Double avgGPA = 0.0;
        Integer totalCredits = 0;
        int counter = 0;
        if(grades.size() != credits.size()){
            System.out.println("Input Error: amount of credits entered does not match amount of classes entered.");
        }else {
            while(counter < grades.size() && counter < credits.size()){
                avgGPA += grades.get(counter) * credits.get(counter);
                totalCredits += credits.get(counter);
                counter++;
            }
            avgGPA /= totalCredits;
        }
        return df.format(avgGPA);
    }
}
