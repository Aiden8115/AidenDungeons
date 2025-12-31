package com.aiden.dungeons.screen;

import com.aiden.dungeons.button.AbstractButton;
import com.aiden.dungeons.button.QuitButton;
import com.aiden.dungeons.button.StartButton;
import com.aiden.dungeons.util.DungeonsLabel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TitleScreen extends AbstractScreen {
    public DungeonsLabel gameTitle;
    public AbstractButton startButton;
    public AbstractButton quitButton;

    public TitleScreen(Pane pane) {
        super(pane);
    }

    @Override
    public void load(Pane pane) {
        // Game title
        this.gameTitle = DungeonsLabel.Builder.create()
                .value("Aiden Dungeons")
                .size(50)
                .textFill(Color.BLACK)
                .build(pane);
        StackPane.setAlignment(this.gameTitle, Pos.TOP_CENTER);
        this.gameTitle.setTranslateY(100);
        this.gameTitle.setBackground(Background.fill(Color.LIME));

        // Start button
        this.startButton = new StartButton(pane, this);
        this.quitButton = new QuitButton(pane, this);
    }

    @Override
    public void tick(ActionEvent event, Pane pane) {
    }

    @Override
    public void close(Pane pane) {
        super.close(pane);
        this.gameTitle.remove();
        this.startButton.label.remove();
    }
}
