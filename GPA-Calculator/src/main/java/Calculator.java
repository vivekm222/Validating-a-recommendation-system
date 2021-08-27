import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    public static void main(String[]args){
        List<Map<String, String>> grades1 = new ArrayList<>();

        List<Double> check;
        Map<String, String> a = new HashMap<>();
        a.put("", "A");
        Map<String, String> b = new HashMap<>();
        b.put("", "A+");
        Map<String, String> c = new HashMap<>();
        c.put("", "A-");
        Map<String, String> d = new HashMap<>();
        d.put("", "B+");
        Map<String, String> e = new HashMap<>();
        e.put("", "B");
        grades1.add(a);
        grades1.add(b);
        grades1.add(c);
        grades1.add(d);
        grades1.add(e);

        List<Integer>credits = new ArrayList<>();
        credits.add(3);
        credits.add(4);
        credits.add(3);
        credits.add(4);
        credits.add(3);

        List<String>grades= new ArrayList<>();
        grades.add("A");
        grades.add("A+");
        grades.add("A-");
        grades.add("B+");
        grades.add("B");

        String unw = Unweighted.unweighted(credits,grades);

        check = Weighted.converter(grades1);

        String avgGPA = Weighted.calculation(check, credits);

        System.out.println(unw);
        System.out.println(avgGPA);

    }

}