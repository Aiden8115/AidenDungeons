package com.aiden.dungeons.entity;

import com.aiden.dungeons.entity.renderer.EntityRenderer;
import com.aiden.dungeons.util.Vec2d;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public abstract class Entity {
    public Vec2d pos;
    public Vec2d velocity;
    public EntityRenderer entityRenderer;
    public boolean isLiving;

    public Entity(EntityRenderer renderer) {
        this.pos = new Vec2d();
        this.velocity = new Vec2d();
        this.entityRenderer = renderer;
        this.getEntityRenderer().setEntity(this);
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.01),
                actionEvent -> {
                    if (this.isLiving) this.tick(actionEvent);
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void tick(ActionEvent actionEvent) {
        this.move();
    }

    public void move() {
        this.pos = this.pos.add(this.velocity.getX(), this.velocity.getY());
    }

    public Vec2d getEntityPos() {
        return this.pos;
    }

    public Vec2d getVelocity() {
        return this.velocity;
    }

    public EntityRenderer getEntityRenderer() {
        return this.entityRenderer;
    }
}
