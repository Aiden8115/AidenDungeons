package com.aiden.dungeons.entity.renderer;

import com.aiden.dungeons.entity.Entity;
import javafx.scene.layout.Pane;

public class EntityRenderer {
    public Pane pane;
    public String imagePath;
    public Entity entity;

    public EntityRenderer(Pane pane, String imagePath) {
        this.pane = pane;
        this.imagePath = imagePath;
    }



    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return this.entity;
    }
}
