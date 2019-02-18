
import javax.swing.JOptionPane;

public class RPS
{
	public static void main(String[] args)
	{
		int com;
		String userPick = "";
		String comPick = "";
		String message = "";
		int gameCount = 1;
		int userWins = 0;
		int comWins = 0;
		int tieGames = 0;
		final int NUM_GAMES = 10;

		// While loop controls the overall game structure
		while(gameCount <= NUM_GAMES)
		{

		// Computer randomly chooses a number between 1 and 3
			com = 1 + (int)(Math.random() * 3);

			// reset the strings each time a new round is played
			userPick = "";
			message = "";

			// Validate the player data, allowing for some misspellings, loop the dialog prompt if the user doe not give a valid selection
			while(!userPick.equalsIgnoreCase("rock") && !userPick.equalsIgnoreCase("paper") && !userPick.equalsIgnoreCase("scissors"))
			{
				userPick = JOptionPane.showInputDialog(null, "Please type one of the following: \nRock \nPaper \nScissors");
				
				userPick = userPick.toLowerCase();

				// now we have what the user typed checked if the first to characters are correct, assign the proper selection from there
				if(userPick.startsWith("ro"))
				{
					userPick = "rock";
				}
				else
				{
					if(userPick.startsWith("pa"))
					{
						userPick = "paper";
					}
					else
					{
						if(userPick.startsWith("sc"))
						{
							userPick = "scissors";
						}
						else
						{
							JOptionPane.showMessageDialog(null, "INVALID SELECTION");
						}
					}
				}
			}

			// Decision process for the computer which assigns a string with the item name to the numeric choices
			//Computer's string
			if(com == 1)
			{
				comPick = "ROCK";
			}
			else
			{
				if(com == 2)
				{
					comPick = "PAPER";
				}
				else
				{
					comPick = "Scissors";
				}
			}

			// Game mechanics
			if(userPick.equalsIgnoreCase(comPick))
			{
				tieGames++;
				message = "We have a tie!";
			}
			else // what if it's not a tie
			{
				if(userPick.equalsIgnoreCase("rock"))
				{
					if(comPick.equalsIgnoreCase("paper"))
					{
						// computer wins
						comWins++;
						message = "Computer wins!";
					}
					else
					{
						// player wins
						userWins++;
						message = "You win!";
					}
				}
				// What if the player didn't pick rock?
				else
				{
					if(userPick.equalsIgnoreCase("paper"))
					{
						if(comPick.equalsIgnoreCase("scissors"))
						{
							// computer wins
							comWins++;
							message = "Computer wins!";
						}
						else
						{
							// player wins
							userWins++;
							message = "You win!";
						}
					}
					else
					{
						if(comPick.equalsIgnoreCase("rock"))
						{
							// computer wins
							comWins++;
							message = "Computer wins!";
						}
						else
						{
							// player wins
							userWins++;
							message = "You win!";
						}
					}
				}
			}

			// We have everything we need, this is the output
			JOptionPane.showMessageDialog(null, "You selected " + userPick + " \nComputer selected " + comPick + "\nOutcome: " + message);

			// Increment the gameCount variable by 1
			gameCount++;
		}
		// All rounds are done, display a final score summary
		JOptionPane.showMessageDialog(null, "Score after " + NUM_GAMES + " games. \nUser wins: " + userWins + "\nComputer wins: " + comWins + "\nTie games: " + tieGames);
	}
}