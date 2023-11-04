package bullscows.works;

public class Grader {
    public static boolean grader(String attempt, String sC){
        int bulls = 0;
        int cows = 0;
        boolean flag = false;

        for (int i = 0; i < sC.length(); i++) {
            if (attempt.charAt(i) == sC.charAt(i)) {
                bulls++;
            } else if (attempt.charAt(i) != sC.charAt(i) &&
                    sC.contains(attempt.substring(i, i + 1))) {
                cows++;
            }
        }
        if (bulls == sC.length()) {
            System.out.printf("Grade: %d bulls\n", bulls);
            System.out.println("Congratulations! You guessed the secret code.");
            flag = true;

        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s)\n", bulls, cows);
        }
        return flag;
    }
}
