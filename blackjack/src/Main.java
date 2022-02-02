import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Dealer dealer = new Dealer();
        Game game = new Game(dealer, List.of(player1, player2), deck);
        game.start();

    }
}
