package cs2410.assn7.ui.controller;

import cs2410.assn7.logic.Colors;
import cs2410.assn7.logic.Game;
import cs2410.assn7.ui.handler.ButtonHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainController extends Controller
{
    @FXML private Rectangle rect;
    @FXML private Rectangle rect2;
    @FXML private Rectangle rect3;
    @FXML private Rectangle rect4;
    @FXML private Label gameStatusLabel;
    private Game game;
    private ButtonHandler buttonHandler;

    public void showColors(ArrayList<Colors> colors)
    {
        gameStatusLabel.setText("Turns: "+ game.getCurrentRound());
        game.setCurrentRound(game.getCurrentRound() +1);
        buttonHandler.clearColor();
        game.setComputerPhase(true);

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(Colors currentColor : colors)
                {
                    try
                    {
                        //otherwise same color wouldn't even appear
                        Thread.sleep(250);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    buttonHandler.showColor(currentColor);
                    try
                    {
                        Thread.sleep(game.getDifficulty().getSleepTime());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    buttonHandler.clearColor();
                }
                game.setComputerPhase(false);
            }
        });
        thread.start();
    }

    public void showLostDialog()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Better luck next time!");
        alert.setContentText("Lost");
        alert.show();
    }

    public void resetGame()
    {
        game = new Game(this);
    }

    public Rectangle getRect1()
    {
        return rect;
    }

    public Rectangle getRect2()
    {
        return rect2;
    }

    public Rectangle getRect3()
    {
        return rect3;
    }

    public Rectangle getRect4()
    {
        return rect4;
    }

    public ButtonHandler getButtonHandler()
    {
        return buttonHandler;
    }

    @Override
    protected void initController()
    {
        buttonHandler = new ButtonHandler(this);
    }

    @FXML
    private void onAboutItemClicked()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("© Max Wittig 2017");
        alert.setTitle("Credits");
        alert.show();
    }

    @FXML
    private void blueButtonClicked()
    {
        if(game != null)
            game.addColor(Colors.BLUE);
    }
    @FXML
    private void rectClicked()
    {
        System.out.println("Hey it worked!!!");
        if(game != null)
            game.addColor(Colors.BLUE);
    }

    @FXML
    private void rect2Clicked()
    {
        if(game!= null)
            game.addColor(Colors.RED);
    }

    @FXML
    private void rect3Clicked()
    {
        if(game!=null)
            game.addColor(Colors.YELLOW);
    }

    @FXML
    private void rect4Clicked()
    {
        if(game!=null)
            game.addColor(Colors.GREEN);
    }

    @FXML
    private void onNewGameMenuItemClicked()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("cs2410/assn7/ui/fxml/game_start_controller.fxml"));
            Parent root = (Parent) loader.load();

            Scene scene = new Scene(root);
            Stage gameStartStage = new Stage();
            gameStartStage.setTitle("New Game");
            gameStartStage.setScene(scene);
            gameStartStage.initModality(Modality.APPLICATION_MODAL);
            gameStartStage.initOwner(stage.getOwner());
            ((GameStartController) loader.getController()).init(gameStartStage, this);
            gameStartStage.showAndWait();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Game getGame()
    {
        return game;
    }
}