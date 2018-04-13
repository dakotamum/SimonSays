package cs2410.assn7.main;

import cs2410.assn7.ui.controller.MainController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application
{

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("cs2410/assn7/ui/fxml/main_controller.fxml"));
            Parent root = (Parent) loader.load();

            Scene scene = new Scene(root);

            ((MainController) loader.getController()).init(primaryStage, null);

            primaryStage.setTitle("ColorRemember");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);

            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
            {
                @Override
                public void handle(WindowEvent event)
                {
                    System.exit(0);
                }
            });

            primaryStage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
