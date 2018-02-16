package com.shitgames.flappyshit.sprites;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Hovsep on 2/16/2018.
 */

public class Ground implements Disposable {

    private static final int GROUND_Y_OFFSET = -50;

    private final Texture texture;
    private final Vector2 position1, position2;
    private final Camera camera;

    public Ground(Camera camera) {
        this.camera = camera;
        texture = new Texture("ground.png");
        position1 = new Vector2(camera.position.x - camera.viewportWidth / 2, GROUND_Y_OFFSET);
        position2 = new Vector2(camera.position.x - camera.viewportWidth / 2 + texture.getWidth(), GROUND_Y_OFFSET);
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, position1.x, position1.y);
        spriteBatch.draw(texture, position2.x, position2.y);
    }

    public void reposition() {
        if (camera.position.x - (camera.viewportWidth / 2) > position1.x + texture.getWidth()) {
            position1.add(texture.getWidth(), 0);
        }
        if (camera.position.x - (camera.viewportWidth / 2) > position2.x + texture.getWidth()) {
            position2.add(texture.getWidth(), 0);
        }
    }

    public boolean collides(Rectangle player) {
        return player.y < position1.y - GROUND_Y_OFFSET || player.y < position2.y - GROUND_Y_OFFSET;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
