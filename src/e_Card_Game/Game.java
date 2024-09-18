package e_Card_Game;

import java.util.Collections;
import java.util.Scanner;

public class Game {
    private Character player;
    private Character npc;
    private Card_Deck cardDeck;
    private int round;

    public Game() {
        cardDeck = new Card_Deck();
        round = 1;
    }
    
    public Character getPlayer() {
        return player;
    }
    public Character getNpc() {
        return npc;
    }
    public int getRound() {
        return round;
    }
    
    public void nextRound() {
        round++;
    }
    
    public void start() {
        Scanner scanner = new Scanner(System.in);

        // 玩家選擇角色
        System.out.print("Choose your role (King/Slave): ");
        String playerRole = scanner.nextLine();
        String npcRole = playerRole.equalsIgnoreCase("King") ? "Slave" : "King";

        player = new Character(playerRole, 15);
        npc = new Character(npcRole, 15);

        while (round <= 12 && player.getCoins() > 0 && npc.getCoins() > 0) {
            System.out.println("Round " + round);
            System.out.println(player);
            System.out.println(npc);

            // 玩家下注
            System.out.print("Enter your bet: ");
            int playerBet = scanner.nextInt();
            if(playerBet <=0) {
            	System.out.println("輸入金幣不能小於等於0，請重新輸入");
            	System.out.println();
            	continue;
            }else if(playerBet > player.getCoins()) {
            	System.out.print("輸入金幣不能大於持有金幣，請重新輸入");
            	System.out.println();
            	continue;
            	
            }
            player.setBet(playerBet);
            player.subtractCoins(playerBet);
            System.out.println("玩家下注:"+playerBet);

            
            // NPC 隨機下注
            int npcBet = (int) (Math.random() * npc.getCoins()+1);
            npc.setBet(npcBet);
            npc.subtractCoins(npcBet);
            System.out.println("npc下注:"+npcBet);

            // 分配手牌
            if (player.getRole().equalsIgnoreCase("King")) {
                player.setHand(cardDeck.setKingHand());
                npc.setHand(cardDeck.setSlaveHand());
            } else {
                player.setHand(cardDeck.setSlaveHand());
                npc.setHand(cardDeck.setKingHand());
            }

            // 進行出牌與比較
            boolean roundOver = false;
            int playerCardIndex = 0;
            int npcCardIndex = 0;

            while (!roundOver) {
            	System.out.println(player.getHand());
                System.out.println("Choose a card to play (0-4): ");
                playerCardIndex = scanner.nextInt();
                Card_Deck.Card playerCard = player.getHand().get(playerCardIndex);

                npcCardIndex = (int) (Math.random() * npc.getHand().size());
                Card_Deck.Card npcCard = npc.getHand().get(npcCardIndex);

                // 比較卡牌
                int result = playerCard.compareTo(npcCard);

                if (result > 0) {
                    System.out.println("Player wins the round!");
                    if (player.getRole().equalsIgnoreCase("King")) {
                        player.addCoins(playerBet * 2);
                    } else {
                        player.addCoins(playerBet * 5);
                    }
                    roundOver = true;
                } else if (result < 0) {
                    System.out.println("NPC wins the round!");
                    if (npc.getRole().equalsIgnoreCase("King")) {
                        npc.addCoins(npcBet * 2);
                    } else {
                        npc.addCoins(npcBet * 5);
                    }
                    roundOver = true;
                } else {
                    System.out.println("It's a tie! Continue playing.");
                }

                player.getHand().remove(playerCardIndex);
                Collections.shuffle(player.getHand());
                npc.getHand().remove(npcCardIndex);
                Collections.shuffle(npc.getHand());
            }

            round++;
            if (round % 3 - 1 == 0) {
                // 交換角色
                String tempRole = player.getRole();
                player.setRole(npc.getRole());
                npc.setRole(tempRole);
            }

            System.out.println();
        }

        // 最終結果
        if (player.getCoins() <= 0) {
            System.out.println("Player has no more coins. NPC wins!");
        } else if (npc.getCoins() <= 0) {
            System.out.println("NPC has no more coins. Player wins!");
        } else {
            System.out.println("Game over! Final results:");
            System.out.println(player);
            System.out.println(npc);
            if (player.getCoins() > npc.getCoins()) {
                System.out.println("Player wins!");
            } else {
                System.out.println("NPC wins!");
            }
        }

        scanner.close();
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}