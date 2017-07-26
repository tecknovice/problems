import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Derivative {
    public static void main(String[] args) {
        BufferedReader lineReader = null;
        try {
            lineReader = new BufferedReader(new FileReader(".\\input.txt"));
            String lineText = null;
            lineText = lineReader.readLine();
            int T = Integer.parseInt(lineText);
            String poli;
            int x;
            Map<Integer, Integer> map,derivativeMap ;
            //lap qua tung test case
            for (int i = 1; i <= T; i++) {
                lineText = lineReader.readLine();
                poli = lineText;
                lineText = lineReader.readLine();
                x = Integer.parseInt(lineText);
                map = polynomial(poli);
//                System.out.println(map.toString());
//                System.out.println(x);
                derivativeMap=derivative(map);
//                System.out.println(derivativeMap.toString());
                Double slope = getSlope(derivativeMap, x);
                System.out.println(slope.intValue());
            }
            lineReader.close();
        } catch (Exception ex) {
            Logger.getLogger(Derivative.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lineReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Derivative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static Map<Integer, Integer> polynomial(String poli) {
        Map<Integer, Integer> map = new HashMap<>();
        int sign = 0;
        if (poli.charAt(0) == '-') {
            sign = -1;
            poli = poli.substring(1);
        }
        String[] parts = poli.split(" ");

        //phan tich da thuc
        for (String part : parts) {
            //tim dau + -
            if (part.length() == 1) {
                if (part.equals("+")) {
                    sign = 1;
                    continue;
                }
                if (part.equals("-")) {
                    sign = -1;
                    continue;
                }

            }
            int coef = 0;
            int power = 0;
            String[] s1 = part.split("\\*");
            if (s1.length == 1) {
                coef = 1;
                String end = s1[0];
                String[] s2 = end.split("\\^");
                String end1 = s2[0];
                if (s2.length == 1) {
                    if (end1.equalsIgnoreCase("x")) {
                        power = 1;
                    } else {
                        coef = Integer.parseInt(end1);
                        power = 0;
                    }
                } else {
                    power = Integer.parseInt(s2[1]);
                }
            } else {
                String c = s1[0];
                String end = s1[1];
                coef = Integer.parseInt(c);
                String[] s2 = end.split("\\^");
                String end1 = s2[0];
                if (s2.length == 1) {
                    if (end1.equalsIgnoreCase("x")) {
                        power = 1;
                    } else {

                    }
                } else {
                    power = Integer.parseInt(s2[1]);
                }
            }
            if (sign == 0) {
                map.put(power, coef);
            } else {
                coef = coef * sign;
                map.put(power, coef);
            }
            sign = 0;
        }

        return map;
    }
    public static Map<Integer, Integer> derivative(Map<Integer, Integer> poliMap) {
        Map<Integer, Integer> derivativeMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> part : poliMap.entrySet()) {
            Integer power = part.getKey();
            Integer coef = part.getValue();
            if (power.intValue() == 0) {
                continue;
            }
            Integer newpower = power - 1;
            Integer newCoef = coef * power;
            derivativeMap.put(newpower, newCoef);
        }
        return derivativeMap;
    }
    public static Double getSlope(Map<Integer,Integer> derivativeMap,int x){
        if(derivativeMap.size()==0)return 0D;
        Double slope=0D;
        for (Map.Entry<Integer, Integer> part : derivativeMap.entrySet()) {
            Integer power = part.getKey();
            Integer coef = part.getValue();
            slope+=coef*Math.pow(x, power);
        }
        return slope;
    }
}
