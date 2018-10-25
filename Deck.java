import java.util.ArrayList;
import java.util.Random;
//import Card.Suit;

public class Deck {
	private ArrayList<Card> usedCard= new ArrayList<Card>();
	public int nUsed;
	private ArrayList<Card> cards;
	Random ran = new Random();
	///////////////////////////////
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		
		for(int deckcount=1;deckcount<=nDeck;deckcount++) {
			
			for(int i=1;i<=4;i++) {
				for(int j=1;j<=13;j++) {
					Card card=new Card(i,j);
					cards.add(card);
					}
			}
          
		}
    }
	public void shuffle() {
		
		//int R =usedCard.size();//set random size by cards num
		for(int i=0;i<=51;i++) {
			Card handcard = cards.get(i);
			cards.remove(i);
			
			//select a space to insert card
			int r = ran.nextInt(51);
			cards.add(r,handcard);
			
			//reset nUsed count and usedCard array
			
			nUsed = 0;
			usedCard.clear();
		}
		
		
	}
	public Card getOneCard() {
		if (nUsed==52)
		{
			shuffle();
		}
		int O =cards.size();
		int rnd_out= ran.nextInt(O);
		Card getcard = cards.get(rnd_out);
		usedCard.add(getcard);
		nUsed++;
		return getcard;
		
	}
	public ArrayList<Card> getAllCards() {
		return cards;
	}
}