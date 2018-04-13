package cs2410.assn7.ui.controller;

import cs2410.assn7.logic.Difficulty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class GameStartController extends Controller
{
    @FXML
    private ComboBox<Difficulty> difficultyComboBox;

    @Override
    protected void initController()
    {
        difficultyComboBox.getItems().addAll(Difficulty.values());
        difficultyComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void onStartButtonClicked()
    {
        MainController mainController = ((MainController)parentController);
        mainController.resetGame();
        mainController.getGame().setDifficulty(difficultyComboBox.getSelectionModel().getSelectedItem());
        mainController.getGame().nextTurn();
        stage.close();
    }

    @FXML
    private void onCancelButtonClicked()
    {
        stage.close();
    }
}
