package bullscows;
import java.util.Scanner;
import bullscows.works.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int turn = 1;
        String attemptIn = new String();

        System.out.println("Input the length of the secret code:");
        int codeLength = 0;
        try {
            codeLength = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error: invalid input: " + e.getMessage());
            System.exit(0);
        }
        if (codeLength > 36 || codeLength == 0) {
            System.out.println("Error: the secret code's length must be less than or equal 36 digits, (0-9, a-z).");
            System.exit(0);
        }
        scan.nextLine();


        System.out.println("Input the number of possible symbols in the code:");
        int charRange = 0;
        try {
            charRange = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error: the number of possible unique symbols in the code is 36, (0-9, a-z): " + e.getMessage());
            System.exit(0);
        }
        if (charRange > 36 || charRange == 0 || charRange < codeLength) {
            System.out.printf("Error: It's not possible to generate a code with a length of %d with %d unique symbols.\n", codeLength, charRange);
            System.exit(0);
        }
        scan.nextLine();


        String secretCode = RandomList.makeRandomList(codeLength, charRange);
        boolean flag = false;

        System.out.println("Okay, let's start a game!");
        System.out.println(CodeMsg.prepareCodeMsg(codeLength, charRange));

        while (!flag) {
            System.out.printf("Turn %d:\n", turn);
            attemptIn = scan.nextLine();
            flag = Grader.grader(attemptIn, secretCode);

            turn++;
        }
    }
}
