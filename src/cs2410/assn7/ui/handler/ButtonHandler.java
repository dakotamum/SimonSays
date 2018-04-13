package cs2410.assn7.ui.handler;

import cs2410.assn7.logic.Colors;
import cs2410.assn7.ui.controller.MainController;
import javafx.scene.paint.Color;

public class ButtonHandler
{
    private MainController mainController;

    public ButtonHandler(MainController mainController)
    {
        this.mainController = mainController;
    }

    public void showColor(Colors color)
    {
        switch (color)
        {
            case BLUE:
                mainController.getRect1().setFill(Color.LIGHTBLUE);
                break;
            case RED:
                mainController.getRect2().setFill(Color.RED);
                break;
            case YELLOW:
                mainController.getRect3().setFill(Color.YELLOW);
                break;
            case GREEN:
                mainController.getRect4().setFill(Color.GREEN);
                break;
            default:
                break;
        }
    }

    public void clearColor()
    {
        mainController.getRect1().setFill(Color.BLUE);
        mainController.getRect2().setFill(Color.DARKRED);
        mainController.getRect3().setFill(Color.YELLOWGREEN);
        mainController.getRect4().setFill(Color.DARKGREEN);
    }
}