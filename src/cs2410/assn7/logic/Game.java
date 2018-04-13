package cs2410.assn7.logic;

import cs2410.assn7.ui.controller.MainController;

import java.util.ArrayList;

public class Game
{
    private Difficulty difficulty;
    private boolean computerPhase = false;
    private ArrayList<Colors> computerColors;
    private ArrayList<Colors> playerColors;

    private MainController mainController;
    private int currentRound = 1;

    public Game(MainController mainController)
    {
        this.mainController = mainController;
        computerColors = new ArrayList<>();
        playerColors = new ArrayList<>();
        difficulty = Difficulty.EASY;
    }

    public void addColor(Colors color)
    {
        if(computerPhase)
            return;

        playerColors.add(color);

        if(playerColors.get(playerColors.size()-1) != computerColors.get(playerColors.size()-1))
        {
            mainController.showLostDialog();
            mainController.resetGame();
        }

        System.out.println(playerColors);
        System.out.println(computerColors);
        System.out.println(playerColors.equals(computerColors));

        if(playerColors.equals(computerColors))
        {
            nextTurn();
            playerColors.clear();
        }
    }

    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    public void nextTurn()
    {
        computerColors.add(Colors.getRandom());
        mainController.showColors(computerColors);
    }

    public void setComputerPhase(boolean computerPhase)
    {
        this.computerPhase = computerPhase;
    }

    public Difficulty getDifficulty()
    {
        return difficulty;
    }

    public int getCurrentRound()
    {
        return currentRound;
    }

    public void setCurrentRound(int currentRound)
    {
        this.currentRound = currentRound;
    }
}