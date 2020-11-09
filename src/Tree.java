import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Tree {

    char node; //qui est notre noeud père
    Tree nextChar,nextWord; //sous arbre gauche ainsi que le sous arbre de droite

    // Dans notre modelisation , on compte a mettre dans notre sous arbre gauche le caractere suivant du mot.
    // Cependant on tient a mettre dans notre sous arbre droite le mot suivant du dictionnaire.

    //constructeur pour initialser un noeud
    Tree (char node ){
        this.node = node;
    }

    //constructeur pour initialiser nos sous-arbre
    Tree (char node , Tree nextChar, Tree nextWord ){
        this.node = node ;
        this.nextChar = nextChar;
        this.nextWord = nextWord;
    }

    //tout nos mots terminent par "dot"
    final static char dot = '.';

    //la methode getchar retourne le i-eme caractere du string "s"
    static char getChar(String s, int i) {
        return i < s.length() ? s.charAt(i) : dot ;
    }

    //cette methode cree notre dictionnaire a partir d'un fichier .
    //on ulilise bufferedReader qui lit notre fichier ligne par ligne.
    static Tree createdicoTOfic(BufferedReader in) {
        Tree r = null ;
        String line ;
        try {
            while ((line = in.readLine()) != null) { // Idiome !
                r = add(r, line) ;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage()) ;
            System.exit(2) ;
        }
        //on teste si nos mots so,t bien inseres
        System.out.println(r.node);
        System.out.println(r.nextChar.node);
        System.out.println(r.nextWord.node);
        return r ;
    }
    // ceci permet d'ajouter le premier caractere
    static Tree add(Tree t, String s) { return add(t, s, 0) ; }
    //permet d'ajouter n'importe quel caractere du mot
    //la methode est simple , si le premier caractere est egale a dot , cela veut dire que cest un sous mot du mot
    //commencant par dot , sonon cest un autre mot.
    static Tree add(Tree t, String s, int i) {// Attention! t peut être vide
        char c = getChar(s, i) ;
        if (c == dot) {
            if (t != null && t.node == dot) { // Déjà là.
                return t ;
            } else { // Ajouter effectivement le mot vide.
                return new Tree(dot, null, t) ;
            }
        } else {
            return addInList(t, c, s, i+1) ;
        }} //
  private static Tree addInList(Tree t, char c, String s, int i) {
        if (t == null || c < t.node) { // Ajouter devant
            return new Tree(c, add(null, s, i), t) ;
        } else if (c == t.node) { //  sous-dictionnaire
            return new Tree(c, add(t.nextChar, s, i), t.nextWord) ;
        } else { //  ajouter plus loin
            return new Tree(t.node, t.nextChar, addInList(t.nextWord, c, s, i)) ;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader in
                = new BufferedReader(new FileReader("/home/momo/IdeaProjects/tp2/resources/dico.txt"));
        Tree r = createdicoTOfic(in);



    }



}
