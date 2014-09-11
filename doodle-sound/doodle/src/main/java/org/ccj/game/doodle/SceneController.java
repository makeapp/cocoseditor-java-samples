package org.ccj.game.doodle;

import org.ccj.Director;
import org.ccj.Event;
import org.ccj.Touch;
import org.ccj.audio.AudioEngine;
import org.ccj.base.Ref;
import org.ccj.d2.Label;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.MoveTo;
import org.ccj.d2.action.ScaleTo;
import org.ccj.d2.action.Sequence;
import org.ccj.editor.cce.Action;
import org.ccj.editor.cce.Bind;
import org.ccj.editor.cce.NodeController;
import org.ccj.math.Vec2;
import org.ccj.particle.ParticleSystemQuad;

/**
 */
public class SceneController extends NodeController {

    @Bind()
    public Label scoreLabel;
    @Bind()
    public Sprite monsterSprite;

    public float totalScore = 0;

    public void createParticle(String name, Vec2 vec2) {
        ParticleSystemQuad particle = ParticleSystemQuad.create("particles/" + name + ".plist");
        particle.setPosition(vec2);
        particle.setTotalParticles(1000);
        owner.addChild(particle);
    }

    public void moveMonster(Vec2 vec2) {
        monsterSprite.runAction(MoveTo.create(0.5f, vec2));
    }

    @Override
    public void onEnter() {
        super.onEnter();
        setTouchEnabled(true);
        setTouchMode(Touch.MODE_ONE_BY_ONE);

        this.createParticle("lv01", new Vec2(360, 400));

        AudioEngine.getInstance().playBackgroundMusic("sounds/bgmusic.mp3", true);
    }

    @Override
    public void onExit() {
        super.onExit();
    }

    @Override
    public void onUpdate(float delta) {
        super.onUpdate(delta);
        totalScore += delta;
        scoreLabel.setString((int) totalScore + "");
    }

    @Override
    public boolean onTouchBegan(Touch touch, Event event) {
        Vec2 pos = touch.getLocation();
        this.moveMonster(pos);

        return true;
    }

    @Override
    public void onTouchMoved(Touch touch, Event event) {
        super.onTouchMoved(touch, event);
    }

    @Override
    public void onTouchEnded(Touch touch, Event event) {
        super.onTouchEnded(touch, event);
    }
}
