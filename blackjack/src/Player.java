import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Card> hand;
    private Integer points;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        points = 0;
    }

    public Integer showPoints() {
        return points;
    }

    public void drawnCard(Card card) {
        points += card.getFace().getValue();
        hand.add(card);
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }
}
