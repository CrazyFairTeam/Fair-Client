package minigames.drawing;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import lombok.Getter;

public class CorrectSymbols {

    private static final String [] PATHS = {"/CorrectSymbols/Fragile.png","/CorrectSymbols/Cold.png","/CorrectSymbols/Warm.png","/CorrectSymbols/Danger.png"};
    private static final int HEIGHT = 150;
    private static final int WIDTH = 150;

    @Getter
    private Rectangle[] correctSymbols;

    public CorrectSymbols() {
        correctSymbols = new Rectangle[4];
        for (int i = 0; i < correctSymbols.length; ++i) {
            correctSymbols[i] = new Rectangle();
            correctSymbols[i].setFill(new ImagePattern(new Image(PATHS[i])));
            correctSymbols[i].setLayoutY(i * HEIGHT);
            correctSymbols[i].setHeight(HEIGHT);
            correctSymbols[i].setWidth(WIDTH);
        }
    }
}
