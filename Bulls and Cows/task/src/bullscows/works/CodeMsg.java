package bullscows.works;

public class CodeMsg {
    public static String prepareCodeMsg(int secretCodeSize, int charRange){
        StringBuilder asterisksBuilder = new StringBuilder();
        for (int i = 0; i < secretCodeSize; i++) {
            asterisksBuilder.append("*");
        }
        String asterisksStr = String.join("", asterisksBuilder.toString());

        //---------------------------------------------------------------------//

        String numberCharRange;

        if (charRange == 10) {
            numberCharRange = "(0-9)";
        } else if (charRange < 10) {
            numberCharRange = "(0-" + charRange + ")";
        } else {
            int range = charRange - 10;
            char lastLetter = "abcdefghijklmnopqrstuvwxyz".charAt(range - 1);
            numberCharRange = " (0-9, a-" + lastLetter + ").";
        }
        return "The secret is prepared: " + asterisksStr.concat(numberCharRange);
    }
}
