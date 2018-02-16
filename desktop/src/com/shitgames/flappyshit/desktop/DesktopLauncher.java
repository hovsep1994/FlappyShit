package com.shitgames.flappyshit.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.shitgames.flappyshit.FlappyShit;

public class DesktopLauncher {
    public static void main(String[] arg) {
        final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = FlappyShit.WIDTH;
        config.height = FlappyShit.HEIGHT;
        config.title = FlappyShit.TITLE;
        new LwjglApplication(new FlappyShit(), config);
    }
}
