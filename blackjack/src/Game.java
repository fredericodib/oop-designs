import java.util.List;

public class Game {
    private final Dealer dealer;
    private List<Player> players;
    private final Deck deck;

    public Game(Dealer dealer, List<Player> players, Deck deck) {
        this.dealer = dealer;
        this.players = players;
        this.deck = deck;
    }

    public void start() {
        deck.shuffle();
        drawnInitialCards();
        printTableCards();
        players.forEach(this::playerTurn);
        printDealerCards();
    }

    private void drawnInitialCards() {
        dealer.drawnCard(deck.drawn());
        dealer.drawnCard(deck.drawn());

        for (var player : players) {
            player.drawnCard(deck.drawn());
            player.drawnCard(deck.drawn());
        }
    }

    private void printTableCards() {
        System.out.println("----");
        System.out.println("Dealer card is " + dealer.getHand().get(0));
        System.out.println();

        players.forEach(player -> {
            player.getHand().forEach(card -> {
                System.out.println(player.getName() + " card is " + card);
            });
            System.out.println(player.getName() + " points is " + player.showPoints());
            System.out.println();
        });
    }

    private void playerTurn(Player player) {
        System.out.println("\n----");
        System.out.println("Turn of " + player.getName());
        while (player.showPoints() < 17) {
            Card card = deck.drawn();
            player.drawnCard(card);
            System.out.println(player.getName() + " drawn " + card);
            System.out.println(player.getName() + " points is " + player.showPoints());
        }
        if (player.showPoints() > 21) {
            System.out.println(player.getName() + " lost");
        }
    }

    private void printDealerCards() {
        System.out.println("\n----");
        dealer.getHand().forEach(card -> {
            System.out.println(dealer.getName() + " card is " + card);
        });
        System.out.println(dealer.getName() + " points is " + dealer.showPoints());
        System.out.println();
    }
}
