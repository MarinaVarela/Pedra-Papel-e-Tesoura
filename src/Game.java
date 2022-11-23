import java.util.Random;
import java.util.Scanner;

public record Game(
	Player user,
	Player IA,
	int rounds
	) {
	
	public void toPlay () {
	System.out.println("\nSeja bem-vinde, " + user.getName() + "!\n");
	
	for(int i = 1; i < rounds; i++){
		int choiceUser = choiceUser();
	if (choiceUser < 1 || choiceUser > 3) {
		System.out.println("\nJogada inválida! As opções são 1, 2 ou 3.");
		System.out.println("\tPonto para " + IA.getName() + "\n");
		IA.incrementScore();
		continue;
	}
	
	int choiceIA = choiceIA();
	System.out.println("\nA escolha de IA foi: " + choiceIA);
	System.out.println(choiceUser + "x" + choiceIA + "\n");
	
	int result = choiceUser - choiceIA;
	winnerRound(result);
	
	}
}
		
	
	// Placar final
	
	public void showFinalResult() {
		System.out.println("\n*******************************************************\n");
		
		Integer finalScoreUser = user.getScore();
		Integer finalScoreIA = IA.getScore();
		
		System.out.println("\n\tPLACAR FINAL: " + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getName());
		
		if(finalScoreUser == finalScoreIA) {
			System.out.println("\t\tEmpate!");
		} else {
			String finalWinner = (finalScoreIA > finalScoreUser) ? IA.getName() : user.getName();
			System.out.println("\t\tVENCEDOR = " + finalWinner.toUpperCase());
		}

		System.out.println("\n*******************************************************\n");

	}

	// Vencedor do Round
	
	private void winnerRound(int result) {
		String winnerRound;
		if(result == 0) {
			winnerRound = "Empate!";
		} else {
			if (result == - 1 || result == 2) {
				IA().incrementScore();
				winnerRound = IA().getName();
			} else {
				user.incrementScore();
				winnerRound = user.getName();
			}
		}
		
		System.out.println("\n\tVencedor do round: " + winnerRound + "\n");
	}
	
	// Escolha da IA
	
	private int choiceIA() {
		Random random = new Random();
		return random.nextInt(3) + 1;
	}
	
	// Escolha do usuário
	
	private int choiceUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1 - Pedra");
		System.out.println("2 - Papel");
		System.out.println("3 - Tesoura");

		System.out.println("\nInforme sua jogada: ");
		return scan.nextInt();
	}
	
}
