package com.shitgames.flappyshit.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shitgames.flappyshit.FlappyShit;
import com.shitgames.flappyshit.sprites.AnimatedShit;
import com.shitgames.flappyshit.sprites.Ground;
import com.shitgames.flappyshit.sprites.Tubes;

/**
 * Created by Hovsep on 2/15/2018.
 */

public class PlayState extends State {

    private AnimatedShit shit;
    private Texture bg;
    private Ground ground;
    private Tubes tubes;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("bg.png");
        shit = new AnimatedShit(55, 100);
        camera.setToOrtho(false, FlappyShit.WIDTH / 2, FlappyShit.HEIGHT / 2);
        ground = new Ground(camera);
        tubes = new Tubes(camera);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            shit.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        shit.update(dt);
        camera.position.x = shit.getPosition().x + 80;
        ground.reposition();
        tubes.reposition();
        if (tubes.collides(shit.getBounds())) {
            gsm.set(new PlayState(gsm));
        }
        if (ground.collides(shit.getBounds())) {
            gsm.set(new PlayState(gsm));
        }
        camera.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bg, camera.position.x - (camera.viewportWidth / 2), 0);
        shit.draw(spriteBatch);
        ground.draw(spriteBatch);
        tubes.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        shit.dispose();
        ground.dispose();
        tubes.dispose();
    }
}
