package com.company;

import java.util.*;

public class EquationGenerator {

    public EquationGenerator() {

    }

    private static String signGenerator() {
        Random rand = new Random();
        String sign;
        switch(rand.nextInt(3)) {
            case 0:
                sign = "+";
                break;
            case 1:
                sign = "-";
                break;
            case 2:
                sign = "*";
                break;
            default:
                sign = "error";
        }
        return sign;
    }

    private static int[] numberGenerator(String sign) {
        Random rand = new Random();
        int[] result = new int[2];
        if (sign == "+" || sign == "-") {
            result[0] = rand.nextInt(100) + 1;
            result[1] = rand.nextInt(100) + 1;
        } else if (sign == "*") {
            result[0] = rand.nextInt(10) + 1;
            result[1] = rand.nextInt(10) + 1;
        }
        return result;
    }

    private static Integer getScore(String sign, int[] numbers) {
        Integer score = 0;
        switch(sign) {
            case "+":
                score = numbers[0] + numbers[1];
                break;
            case "-":
                score = numbers[0] - numbers[1];
                break;
            case "*":
                score = numbers[0] * numbers[1];
                break;
            default:
                score = 0;
        }
        return score;
    }

    private static Integer[] generateResults(String sign, int[] numbers) {
        Integer score = getScore(sign, numbers);

        Integer[] res = new Integer[4];
        res[0] = score;
        Random rand = new Random();
        for (int i = 1; i < 4; i++) {
            int numb = rand.nextInt(10) + (score - 5);
            if (!Arrays.asList(res).contains(numb)) {
                res[i] = numb;
            } else {
                i--;
            }
        }

        List<Integer> resList = Arrays.asList(res);

        Collections.shuffle(resList);

        res = resList.toArray(res);
        return res;
    }

    public static HashMap<String, String> generateEquation() {
        String sign = signGenerator();
        int[] numbers = numberGenerator(sign);
        String equation = numbers[0] + " " + sign + " " + numbers[1] + " = ?";
        HashMap<String, String> result = new HashMap<String, String>();
        Integer[] results = generateResults(sign, numbers);
        String score = getScore(sign, numbers).toString();
        result.put("equation", equation);
        result.put("result1", results[0].toString());
        result.put("result2", results[1].toString());
        result.put("result3", results[2].toString());
        result.put("result4", results[3].toString());
        result.put("score", score.toString());
        return result;
    }

}
