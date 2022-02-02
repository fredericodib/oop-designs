import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<>();
        generateDeck();
    }

    public void generateDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Face face : Card.Face.values()) {
                cards.add(new Card(suit, face));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawn() {
        return cards.removeFirst();
    }
}
