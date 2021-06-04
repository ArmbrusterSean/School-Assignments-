import java.util.Random;

public class Threading {
    static int player[] = new int[1000];
    static int computer[] = new int[1000];

    static class UserThread implements Runnable {

        
        public void run() {
            System.out.println("Player started rolling dice.");
            Random random = new Random();
            for (int i = 0; i < 1000; i++) {
                player[i] = random.nextInt(6) + 1;
                System.out.println("Player dice roll : " + player[i]);
            }
            System.out.println("Player stopped rolling dice.");
        }
    }

    static class ComputerThread implements Runnable {

      
        public void run() {
            System.out.println("Computer starts rolling dice.");
            Random random = new Random();
            for (int i = 0; i < 1000; i++) {
                computer[i] = random.nextInt(6) + 1;
                System.out.println("Computer dice roll : " + computer[i]);
            }
            System.out.println("Computer stopped rolling dice.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread computerRoll = new Thread(new ComputerThread());
        Thread yourTurnToRoll = new Thread(new UserThread());
        computerRoll.start();
        yourTurnToRoll.start();
        computerRoll.join();
        yourTurnToRoll.join();
        int computerWins = 0, playerWins = 0, ties = 0;
        for (int i = 0; i < 1000; i++) {
            if (computer[i] > player[i])
                computerWins++;
            else if (computer[i] <player[i])
                playerWins++;
            else
                ties++;
        }
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Ties: " + ties);
    }
}