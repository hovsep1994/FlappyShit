package com.shitgames.flappyshit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shitgames.flappyshit.States.GameStateManager;
import com.shitgames.flappyshit.States.MenuState;

public class FlappyShit extends ApplicationAdapter {

    public static final String TITLE = "Flappy shit";

    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    private GameStateManager gsm;
    private SpriteBatch batch;

    @Override
    public void create() {
        gsm = new GameStateManager();
        batch = new SpriteBatch();
        gsm.push(new MenuState(gsm));
        Gdx.gl.glClearColor(1, 0, 0, 1);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }

    @Override
    public void dispose() {
        batch.dispose();

    }
}
