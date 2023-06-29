import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        Map<String, Integer> text = new HashMap<>();
        for (String word: str){
            if(text.containsKey(word)){
                int count=text.get(word);
                text.put(word,count+1);
            }else {
                text.put(word,1);
            }
        }
        for(Map.Entry<String,Integer> entry:text.entrySet()){
            System.out.printf("'%s' occurs %d times\n",entry.getKey(), entry.getValue());        }
    }
}