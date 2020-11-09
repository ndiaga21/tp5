import java.util.Arrays;

public class Levenshtein {

    public static int distance(String str1, String str2) {
        long debut = System.nanoTime();
        int[][] tab = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    tab[i][j] = j;
                } else if (j == 0) {
                    tab[i][j] = i;
                } else {
                    tab[i][j] = min(tab[i - 1][j - 1] + cout(str1.charAt(i - 1), str2.charAt(j - 1)),
                            tab[i - 1][j] + 1, tab[i][j - 1] + 1);
                }
            }
        }
       System.out.println(System.nanoTime() - debut);
        return tab[str1.length()][str2.length()];
    }

    private static int cout(char charAt, char charAt1) {
        if (charAt == charAt1)
            return 0;
        else return 1;
    }
    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        System.out.println( distance("abracabra","baradaca"));

    }
}
