package com.shitgames.flappyshit.sprites;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;


/**
 * Created by Hovsep on 2/16/2018.
 */

public class Tubes implements Disposable {

    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

    private final Array<Tube> tubes;
    private final Camera camera;

    public Tubes(Camera camera) {
        this.camera = camera;
        tubes = new Array<Tube>();
        for (int i = 0; i <= TUBE_COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }
    }

    public void reposition() {
        for (int i = 0; i < tubes.size; i++) {
            final Tube tube = tubes.get(i);
            if (camera.position.x - camera.viewportWidth / 2 >
                    tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
                tube.reposition(tube.getPosTopTube().x + (Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT);
            }
        }
    }

    public boolean collides(Rectangle rectangle) {
        for (Tube tube : tubes) {
            if (tube.collides(rectangle)) {
                return true;
            }
        }
        return false;
    }

    public void draw(SpriteBatch spriteBatch) {
        for (Tube tube : tubes) {
            tube.draw(spriteBatch);
        }
    }

    @Override
    public void dispose() {
        for (Tube tube : tubes) {
            tube.dispose();
        }
    }
}
