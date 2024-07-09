package com.scm;

import com.scm.Model.*;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Board board = Board.getInstance(100);
        ObstacleFactory.createSnakes(board, Arrays.asList(new int[][]{{16, 6}, {48, 26}, {49, 11}, {56, 53}, {62, 19}, {64, 60}, {87, 24}, {93, 73}, {95, 75}, {98, 78}}));
        ObstacleFactory.createLadders(board, Arrays.asList(new int[][]{{1, 38}, {4, 14}, {9, 31}, {21, 42}, {28, 84}, {36, 44}, {51, 67}, {71, 91}, {80, 100}}));

        Game game = new Game();
        Player player1 = new Player("Ravi");
        Player player2 = new Player("Snehasis");

        game.addPlayer(player1);
        game.addPlayer(player2);

        DiceStrategy diceStrategy = new NormalDice();
        while(true){
            Player currentPlayer = game.getCurrentPlayer();
            int diceRoll = diceStrategy.rollDice();
            Command moveCommand = new MoveCommand(currentPlayer,diceRoll,board);
            moveCommand.execute();

            game.notifyPlayers(currentPlayer+" rolled a "+diceRoll+" and moved to "+currentPlayer.getPosition());
            if(currentPlayer.getPosition()==board.getSize()){
                game.notifyPlayers(currentPlayer.getName()+" wins!");
                break;
            }

            game.nextTurn();
        }
    }
}