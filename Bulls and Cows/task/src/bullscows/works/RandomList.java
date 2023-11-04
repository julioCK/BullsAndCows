package bullscows.works;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomList {
    public static String makeRandomList(int secretCodeSize, int charRange){

        List<String> availableCharacters = new ArrayList<>();
        for (char ch : "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            availableCharacters.add(String.valueOf(ch));
        }

        List<String> characterList = new ArrayList<>(charRange);
        for(int i = 0; i < charRange; i++) {
            characterList.add(String.valueOf(availableCharacters.get(i)));
        }
        Collections.shuffle(characterList);

        String[] secretCodeArr = new String[secretCodeSize];

        for (int i = 0; i < secretCodeSize; i++) {
            secretCodeArr[i] = characterList.get(i);
        }

        return String.join("", secretCodeArr);
    }
}
