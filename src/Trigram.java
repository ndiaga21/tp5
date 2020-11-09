import java.util.ArrayList;
import java.util.HashMap;

public class Trigram  {
    static  HashMap<String, ArrayList<String>> trigram = new HashMap<>();
    public static HashMap<String, ArrayList<String>> trigram(String word){
        String local =  "<".concat(word).concat(">");
        for (int i = 0; i < local.length()-2; i++) {
            createHashMapTrigram(local.substring(i, i+3), word);
        }
        return trigram;

    }

    private static void createHashMapTrigram(String tri, String word) {
        ArrayList<String> list= new ArrayList<>();
        list.add(word);
        if (trigram.containsKey(tri)){
            trigram.get(tri).add(word);
        }else {
            trigram.put(tri,list);
        }


    }
    public static void main(String[] args) {
        trigram("savoir");
        trigram("savond");
        trigram("savant");
        System.out.println(trigram);
    }
}