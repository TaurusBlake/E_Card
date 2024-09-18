package e_Card_Game;

import java.util.ArrayList;
import java.util.Collections;

public class Card_Deck {
	ArrayList<Card> deck;
	Card_Deck(){
		startGame();
	}
	
	public void startGame() {
		buildDeck();
        ArrayList<Card> kingHand = setKingHand();
        ArrayList<Card> slaveHand = setSlaveHand();
        System.out.println("king:"+kingHand);
        System.out.println("slave:"+slaveHand);
	}
	
	//製作牌庫
	public void buildDeck() {
		deck = new ArrayList<Card>();
		String[] type = {"king","citizen","slave","back"};
		for (String i : type) {
			deck.add(new Card(i));
		}
		System.out.println("buildDeck:"+deck);
	}
	//設置king牌組
	public ArrayList<Card> setKingHand(){
		ArrayList<Card> kingHand = new ArrayList<>();
		kingHand.add(new Card("king"));
		for(int i=0; i < 4 ; i++) {
			kingHand.add(new Card("citizen"));
		}
		Collections.shuffle(kingHand);//Collection.shuffle方法，可以將陣列中的數值隨機打亂
		return kingHand;	
	}
	//設置slave牌組
	public ArrayList<Card> setSlaveHand(){
		ArrayList<Card> slaveHand = new ArrayList<>();
		slaveHand.add(new Card("slave"));
		for (int i = 0 ;i < 4 ; i++) {
			slaveHand.add(new Card("citizen"));
		}
		Collections.shuffle(slaveHand);
		return slaveHand;
	}
	
	//設計卡片規則
	class Card implements Comparable<Card>{
		String type;
		
		Card(String type){
			this.type=type;
		}
		public String toString() {
			return type;
		}
		@Override
		//compareTo為Comparable<Card>介面的方法
		//可以比較this(當前卡片)與other(另一張卡片)，透過回傳值比較兩張的大小
		public int compareTo(Card other) {
		    if (this.type.equals("king") && other.type.equals("citizen")) {
		        return 1; // king > citizen
		    } else if (this.type.equals("citizen") && other.type.equals("king")) {
		        return -1; // citizen < king
		    } else if (this.type.equals("citizen") && other.type.equals("citizen")) {
		        return 0; // citizen = citizen
		    } else if (this.type.equals("citizen") && other.type.equals("slave")) {
		        return 1; // citizen > slave
		    } else if (this.type.equals("slave") && other.type.equals("citizen")) {
		        return -1; // slave < citizen
		    } else if (this.type.equals("king") && other.type.equals("slave")) {
		        return -1; // king < slave
		    } else if (this.type.equals("slave") && other.type.equals("king")) {
		        return 1; // slave > king
		    } else {
		        return 0; // default case
		    }
		}

	}
	
	
}
