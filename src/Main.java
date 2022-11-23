import java.util.Scanner;

public class Main {
	
	public static Game startGame() {
		System.out.println("******************* Pedra, Papel e Tesoura! *******************\n");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe o seu nome: ");
		String playerName = scan.next().toUpperCase();
		
		Player user = new Player(playerName);
		Player IA = new Player("IA");
		
		System.out.print("\n" + playerName + ", informe quantos rounds você quer jogar: ");
		int rounds = scan.nextInt()+1;
		
		return new Game(user, IA, rounds);
		
	}

	public static void main(String[] args) {
		Game game = startGame();
		game.toPlay();
		game.showFinalResult();
	}
}
