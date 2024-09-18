package e_Card_Game;

import java.util.ArrayList;

public class Character {
    private String role;//king或slave
    private ArrayList<Card_Deck.Card> hand;
    private int coins;
    private int bet;

    public Character(String role, int initialCoins) {
        this.role = role;
        this.coins = initialCoins;
        this.hand = new ArrayList<>();
    }
 
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Card_Deck.Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card_Deck.Card> hand) {
        this.hand = hand;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int dollor) {
        this.coins += dollor;
    }

    public void subtractCoins(int dollor) {
        this.coins -= dollor;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    @Override
    public String toString() {
        return role + " [Coins: " + coins + ", Hand: " + hand + "]";
    }
}