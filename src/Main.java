import java.util.Arrays;
import java.util.Set;

public class Main {
    static Set<String> dictionary;
    public static void main(String[] args) {
        dictionary= new FileHandler().getValidWords();
        System.out.println(findValidWords("aaahed"));
    }
    static boolean isValid(String tmp){
        return dictionary.contains(tmp.toLowerCase());
    }
    static String findValidWords(String tmp){
        String[] words = new String[tmp.length() + 1];
        Arrays.fill(words, "");
        for (int i = 1; i < tmp.length()+1; i++) {
            words[i] = findWordsTheIndexIsFinished(words, tmp , i);
        }
        return words[tmp.length()];

    }
    static String findWordsTheIndexIsFinished(String[] words ,String input , int index){
        String word = "";
        String ans = "";
        for (int i = index-1 ; i >= 0 ; i--) {
            word = input.substring(i , index);
            if (isValid(word)){
                if (i == 0){
                    ans = word;
                }else if(!words[i].equals("")){
                    ans = word +" "+words[i];
                }
            }
        }
        return ans;
    }
}
