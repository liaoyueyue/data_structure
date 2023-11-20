import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-11-20
 * Time: 0:17
 */
class Card {
    public int rank;
    public String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " " + suit;
    }
}
public class CardDemo {
    public static final String[] suits = {"♥", "♠", "♣", "♦"}; // 红桃， 黑桃， 梅花， 方片

    public List<Card> buyDeskCard() {
        List<Card> cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                Card card = new Card(i, suits[j]);
                cards.add(card);
            }
        }
        return cards;
    }

    public void shuffle(List<Card> cards) {
        Random random = new Random();
        for (int i = cards.size()-1; i > 0; i--) {
            int index = random.nextInt(i);
            swap(cards, index, i);
        }
    }

    public void initCard(List<Card> cards) {
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();

        List<List<Card>> hands = new ArrayList<>();
        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);

        // 三个人每人5张牌
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                hands.get(j).add(cards.remove(0));
            }
        }

        System.out.println("hand1 = " + hand1);
        System.out.println("hand2 = " + hand2);
        System.out.println("hand3 = " + hand3);
        System.out.println("发牌后");
        System.out.println("cards = " + cards);
        System.out.println("cards.size() = " + cards.size());
    }

    public static void main(String[] args) {
        CardDemo cardDemo = new CardDemo();
        List<Card> cards = cardDemo.buyDeskCard();
        System.out.println("初始化套牌");
        System.out.println(cards);
        cardDemo.shuffle(cards);
        System.out.println("洗牌");
        System.out.println("cards = " + cards);
        System.out.println("cards.size() = " + cards.size());
        System.out.println("发牌");
        cardDemo.initCard(cards);
    }
}
