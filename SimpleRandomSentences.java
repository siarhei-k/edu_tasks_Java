/***
 *Rules:
 * <sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]
 * <simple_sentence> ::= <noun_phrase> <verb_phrase>
 * <noun_phrase> ::= <proper_noun> |
 * <determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]
 * <verb_phrase> ::= <intransitive_verb> |
 * <transitive_verb> <noun_phrase> |
 * is <adjective> |
 ***/

public class SimpleRandomSentences {
    static final String[] conjunction = { " and", " or", " but", " because" };
    static final String[] proper_noun = { " Fred", " Jane", " Richard Nixon", " Miss America" };
    static final String[] common_noun = { " man", " woman", " fish", " elephant", " unicorn" };
    static final String[] determiner = { " a", " the", " every", " some" };
    static final String[] adjective = { " big", " tiny", " pretty", " bald" };
    static final String[] intransitive_verb = { " runs", " jumps", " talks", " sleeps" };
    static final String[] transitive_verb = { " loves", " hates", " sees", " konws", " looks for", " finds" };

    // take a random item from strings
    static void randomItem(String[] listOfStrings) {
        int pickedItem = (int) (Math.random() * listOfStrings.length);
        System.out.print(listOfStrings[pickedItem]);
    }

    // printing text with 5 Random Simple Sentences
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            randomSentence();
            System.out.print(".");
            System.out.println("");
        }
    }

    // <sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]
    static void randomSentence() {
        randomSimpleSentence(); // calls randomSimpleSentence
        if (Math.random() > 0.4) { // 60% chance of having [ <conjunction> <sentence> ]
            randomItem(conjunction);
            randomSentence(); // recursion
        }
    }

    // <simple_sentence> ::= <noun_phrase> <verb_phrase>
    static void randomSimpleSentence() {
        randomNounPhrase(); // calls randomNounPhrase
        randomVerbPhrase(); // calls randomVerbPhrase
    }

    /***
     * <noun_phrase> ::= <proper_noun> | determiner> [ <adjective> ] <common_noun> [
     * who <verb_phrase> ]
     ***/
    static void randomNounPhrase() {
        if (Math.random() > 0.5) { // 50% chance of having proper_noun
            randomItem(proper_noun);
        } else {
            randomItem(determiner);
            randomItem(adjective);
            randomItem(common_noun);
            if (Math.random() > 0.5) { // 50% chance of having verb phrase
                System.out.print(" who");
                randomVerbPhrase(); // calls randomVerbPhrase
            }
        }
    }

    /***
     * <verb_phrase> ::= <intransitive_verb> | <transitive_verb> <noun_phrase> | is
     * <adjective> | believes that <simple_sentence>
     ***/
    static void randomVerbPhrase() {
        int choice = ((int) (Math.random() * 4) + 1);
        switch (choice) {
            case 1:
                randomItem(intransitive_verb);
                break;
            case 2:
                randomItem(transitive_verb);
                randomNounPhrase(); // calls randomNounPhrase
                break;
            case 3:
                System.out.print(" is");
                randomItem(adjective);
                break;
            default:
                System.out.print(" believes that");
                randomSimpleSentence(); // calls randomSimpleSentence
        }
    }
}
