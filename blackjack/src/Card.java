import lombok.Getter;

@Getter
public class Card {
    private final Suit suit;
    private final Face face;

    public Card(Suit suit, Face face) {
        this.face = face;
        this.suit = suit;
    }

    public enum Suit {
        HEARTS, DIAMONDS, SPADES, CLUBS
    }

    public enum Face {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
        EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
        private final Integer value;

        Face(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
}
