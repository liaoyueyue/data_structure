import java.util.Comparator;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-28
 * Time: 1:22
 */
class Card implements Comparable{
    int rank; // 数值
    String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    @Override
    public int compareTo(Object o) {
        return this.rank - ((Card) o).rank;
    }
}

class RankComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.rank - o2.rank;
    }
}
public class TestComparator {
    public static void main(String[] args) {
        Card card1 = new Card(2, "♣");
        Card card2 = new Card(1, "♣");
        System.out.println("card1 == card2 : " + String.valueOf(card1 == card2));
        System.out.println("card1.equals(card2) = " + card1.equals(card2));
        System.out.println("card1.compareTo(card2) = " + card1.compareTo(card2));
        RankComparator rankComparator = new RankComparator();
        System.out.println("rankComparator.compare(card1, card2) = " + rankComparator.compare(card1, card2));

    }


}
