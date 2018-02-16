package com.shitgames.flappyshit.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.shitgames.flappyshit.animation.Animation;

/**
 * Created by Hovsep on 2/15/2018.
 */

public class AnimatedShit {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private final Texture texture;
    private final Vector3 position;
    private final Vector3 velocity;
    private final Rectangle bounds;
    private final Animation animation;
    private final Sound sound;

    public AnimatedShit(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("birdanimation.png");
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());
        animation = new Animation(new TextureRegion(texture), 3, 0.5f);
        sound = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float dt) {
        animation.update(dt);
        if (position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);
        velocity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);
    }

    public void jump() {
        sound.play(0.5f);
        velocity.y = 250;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(animation.getCurrentFrame(), position.x, position.y);
    }
}
