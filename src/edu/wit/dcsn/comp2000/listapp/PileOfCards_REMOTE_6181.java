public class PileOfCards
//List of card objects privately
//shuffle method
//get method for index of certain values
{
    
    public int topCard = 0;                // keeps track of the array index corresponding to the top of the deck
    
    public int gettopCard(){
        return topCard;
    }

    // Constructor - creates a new Card object to place at each
    //  position in the array
    public void Pile()
    {
        int k = 0;
        for (int j = 0; j <= 4; j++) {      // go through all suits
            for (int i = 2; i <= 14; i++) { // for each suit, go through all ranks
                theCards[k] = new Card(j, i);
                k++;
            }
        }
    }
    public void addCard(Card c){   
        if (numCardsInHand < cardsInHand.length) {
            cardsInHand[numCardsInHand] = c;
            numCardsInHand++;  // we do this so that next time draw() is called, we get the next card
        } else {
            System.out.println("Hey, there are no more cards in this deck!");
        }
}
    public void removeCard(int index){
        //seaerches through the hand array and turn the index to null if in array
        for (int i = 0; i < cardsInHand.length;i++){
            
                 cardsInHand[index] = null;
                
     
}

    // Shuffles the deck by rearranging the Card objects in the array.
    public void shuffle()
    {
        for (int j = 0; j < 52; j++) {  // repeat 52 times...
            // go through the array of cards, and swap each card with
            //  another, randomly chosen card
            for (int i = 0; i < theCards.length; i++) {
                int randomIndex = (int)(theCards.length*Math.random());
                
                // swap the Card objects at indices i and randomIndex
                Card temp = theCards[i];
                theCards[i] = theCards[randomIndex];
                theCards[randomIndex] = temp;
            }
        }
    }

    // Returns the Card object at the top of the deck, or null if the deck
    //  has been exhausted.

    // toString method -- just goes through the whole deck and adds each
    //  individual card to the returned string
    public String toString()
    {
        String r = "";
        for (int i = 0; i < theCards.length; i++) {
            r += theCards[i] + "\n";
        }
        return r;
    }
    
    public static void main(String[] args)
    {
        PileOfCards d = new PileOfCards();
        System.out.println(d);
        d.shuffle();
        System.out.println();
        System.out.println(d);
        
        for (int i = 0; i < 52;  i++) {
            System.out.println("Draw returned: " + d.draw());
        }
        System.out.println(d.draw());
    }
}
