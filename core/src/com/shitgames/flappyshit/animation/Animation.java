package com.shitgames.flappyshit.animation;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


/**
 * Created by Hovsep on 2/16/2018.
 */

public class Animation {

    private final Array<TextureRegion> frames;
    private final float frameCyclingTime;

    private int currentFrameNumber;
    private float currentFrameTime;

    public Animation(TextureRegion textureRegion, int frameCount, float cyclingTime) {
        frames = new Array<TextureRegion>();
        int frameWidth = textureRegion.getRegionWidth() / frameCount;
        for (int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(textureRegion, frameWidth * i, 0, frameWidth, textureRegion.getRegionHeight()));
        }
        frameCyclingTime = cyclingTime / frameCount;
        currentFrameNumber = 0;
        currentFrameTime = 0;
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > frameCyclingTime) {
            currentFrameNumber++;
            currentFrameTime = 0;
        }
        if (currentFrameNumber >= frames.size) {
            currentFrameNumber = 0;
        }
    }

    public TextureRegion getCurrentFrame() {
        return frames.get(currentFrameNumber);
    }

}
