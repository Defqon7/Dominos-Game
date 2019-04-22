
package dominos;



/**
 *
 * @author Braden Hanna
 */
public class Dominos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        startGame();
        
    }
    public static void startGame(){
        CTable table = new CTable();
        CDominoes domino = new CDominoes();
        CRandom random = new CRandom();
        CPlayer player = new CPlayer();
        //create starting hand and pile of available pieces
        domino.createPieces();
        //int to hold either a 0 or 1 - check to see who goes first
        int goesFirst;
        goesFirst = random.goesFirst();
        if(goesFirst == 0){
            System.out.println("Player One Goes First: ");
        }
        else{
            System.out.println("Player Two Goes First");
        }
        System.out.println("Player Ones Hand:");
        System.out.println(player.getPlayerOnesHand());
        System.out.println("Player Twos Hand");
        System.out.println(player.getPlayerTwosHand());
        player.firstTurn(goesFirst);
        System.out.println("1st move");
        System.out.println(table.getTable());
        
        for(int i =0; i <12; i++){
            
            //nested ifs for whos turn it is
            if(goesFirst == 1){
                if(player.playerOneCanPlay()){
                    System.out.println("Player Ones Move");
                    player.playerOneTurn();
                    
                    System.out.println(table.getTable());
                    
                }
                else{
                    System.out.println("Player One Cannot Move");
                    if(domino.getAvailablePieces().size() >0){
                            player.playerOneAnotherTile();
                            player.playerOneTurn();
                        }
                    System.out.println(table.getTable());
                }
                    
            
                if(player.playerTwoCanPlay()){
                    System.out.println("Player Twos Move");
                    player.playerTwoTurn();
                    
                    System.out.println(table.getTable());
                }
                else{
                    System.out.println("Player Two Cannot Move");
                    if(domino.getAvailablePieces().size() >0){
                            player.playerTwoAnotherTile();
                            player.playerTwoTurn();
                        }
                    System.out.println(table.getTable());
                }
                    
                    
                
            }
            if(goesFirst == 0){
                if(player.playerTwoCanPlay()){
                    System.out.println("Player Twos Move");
                    player.playerTwoTurn();
                    
                    System.out.println(table.getTable());
                }
                else{
                    System.out.println("Player Two Cannot Move");
                    if(domino.getAvailablePieces().size() >0){
                            player.playerTwoAnotherTile();
                            player.playerTwoTurn();
                        }
                    System.out.println(table.getTable());
                    }
                  
                    
                if(player.playerOneCanPlay()){
                    System.out.println("Player Ones Move");
                    player.playerOneTurn();
                    
                    System.out.println(table.getTable());
                }
                else{
                    System.out.println("Player One Cannot Move");
                    if(domino.getAvailablePieces().size() >0){
                            player.playerOneAnotherTile();
                            player.playerOneTurn();
                        }
                    System.out.println(table.getTable());
                    }
                  
                
                    
                
                
            }
            
            
        }
        System.out.println("Game Over");
        System.out.println("Player One's Hand: " + player.getPlayerOnesHand());
        System.out.println("Player Two's Hand: " + player.getPlayerTwosHand());
        if (player.getPlayerOnesHand().size() < player.getPlayerTwosHand().size()){
            System.out.println("Player One Wins!");
        }
        else{
            System.out.println("Player Two Wins!");
        }
        }
   
    
    
}
