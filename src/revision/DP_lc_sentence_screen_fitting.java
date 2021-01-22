package revision;
//https://leetcode.com/problems/sentence-screen-fitting/
public class DP_lc_sentence_screen_fitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int iterator = 0;
        int len = s.length();

        for (int i = 0; i < rows; ++i) {
            iterator += cols;
            if (s.charAt(iterator % len) == ' ') {
                iterator++;
            } else {
                while(iterator > 0 && s.charAt((iterator - 1) % len) != ' ') {
                    --iterator;
                }
            }
        }
        return iterator / len;
    }

    public int wordsTyping2x(String[] sentence, int rows, int cols) {
        int c = 0;
        int i = 0;
        int j = 0;

        for (String word: sentence) {
            if (word.length() > cols) {
                return 0;
            }
        }

        outer: while (i < rows) {
            int tempI = i;
            int tempJ = j;
            for (int k = 0; k < sentence.length; ++k) {
                if (tempJ + sentence[k].length() > cols) {
                    tempJ = 0;
                    tempI++;
                }
                if (tempI == rows) {
                    break outer;
                }
                tempJ = tempJ + sentence[k].length() + 1;
            }
            c++;
            i = tempI;
            j = tempJ;
        }

        return c;
    }
}
