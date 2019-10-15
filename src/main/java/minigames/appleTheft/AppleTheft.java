package minigames.appleTheft;

import core.Playable;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import lombok.Getter;

public class AppleTheft implements Playable {

    private static final int WINDOWWIDTH = 1125;
    private static final int WINDOWHEIGHT = 800;

    private Group layout;
    private Scene scene;
    private Garden garden;
    @Getter
    private static Stage window = new Stage();

    public AppleTheft() {
        layout = new Group();
        scene = new Scene(layout, WINDOWWIDTH, WINDOWHEIGHT);
        garden = new Garden();
    }

    @Override
    public void play() {
        for (Rectangle[] R: garden.getGarden()){
            for (Rectangle R2: R){
                layout.getChildren().add(R2);
            }
        }
        scene.setOnKeyPressed(new Mover());
        window.setScene(scene);
        window.show();
    }

    private class Mover implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case UP:
                    garden.moveUp();
                    break;
                case DOWN:
                    garden.moveDown();
                    break;
                case LEFT:
                    garden.moveLeft();
                    break;
                case RIGHT:
                    garden.moveRight();
                    break;
            }
            showInfoWhenGameEnded();
        }
    }

    private void showInfoWhenGameEnded() {
        if(garden.getConnect().isGameEnded()) {
            window.hide();
            if(garden.getConnect().isWon()) {
                new InformationWindow("Ви виграли!").display();
            }
            else {
                new InformationWindow("Ви програли(").display();
            }
        }
    }
}
