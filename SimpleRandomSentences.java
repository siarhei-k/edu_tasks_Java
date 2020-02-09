public class SimpleRandomSentences {
    static final String[] conjunction = { " and", " or", " but", " because" };
    static final String[] proper_noun = { " Fred", " Jane", " Richard Nixon", " Miss America" };
    static final String[] common_noun = { " man", " woman", " fish", " elephant", " unicorn" };
    static final String[] determiner = { " a", " the", " every", " some" };
    static final String[] adjective = { " big", " tiny", " pretty", " bald" };
    static final String[] intransitive_verb = { " runs", " jumps", " talks", " sleeps" };
    static final String[] transitive_verb = { " loves", " hates", " sees", " konws", " looks for", " finds" };

    // picking a random item from an array of strings above.
    static void randomItem(String[] listOfStrings) {
        int pickingItem = (int) (Math.random() * listOfStrings.length);
        System.out.print(listOfStrings[pickingItem]);
    }

    public static void main(String[] args) {
        System.out.println("Be welcome! This program will print 10 random phrases...\n\n");
        System.out.println("********************************");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i);
            randomSentence();
            System.out.println(".\n");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("********************************");
        System.out.println("Bye!! See you in the next forum!");
    }

    // <sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]
    static void randomSentence() {
        randomSimpleSentence(); // calls randomSimpleSentence method
        if (Math.random() > 0.4) { // 60% chance of having [ <conjunction> <sentence> ]
            randomItem(conjunction);
            randomSentence(); // recursivity calling itself
        }
    }

    // <simple_sentence> ::= <noun_phrase> <verb_phrase>
    static void randomSimpleSentence() {
        randomNounPhrase(); // calls randomNounPhrase method
        randomVerbPhrase(); // calls randomVerbPhrase method
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
                randomVerbPhrase(); // calls randomVerbPhrase method
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
                randomNounPhrase(); // calls randomNounPhrase method
                break;
            case 3:
                System.out.print(" is");
                randomItem(adjective);
                break;
            default:
                System.out.print(" believes that");
                randomSimpleSentence(); // calls randomSimpleSentence method
        }
    }
}
