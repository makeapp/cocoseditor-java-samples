package org.ccj.game.doodle;

import org.ccj.Director;
import org.ccj.Event;
import org.ccj.Logger;
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
import org.ccj.editor.cce.NodeReader;
import org.ccj.math.Vec2;
import org.ccj.particle.ParticleSystemQuad;
import org.ccj.ui.Button;

/**
 */
public class SceneController extends NodeController {

    public float totalScore = 0;
    @Bind()
    public Label scoreLabel;
    @Bind()
    public Sprite monsterSprite;
    @Bind("pausedBtn")
    public Button pausedBtn;

    @Bind("pausedBtn")
    @Action(Action.ActionType.WidgetTouchUp)
    public void onPausedClicked(Ref ref) {
        Logger.log("paused");

//        setTouchEnabled(false);
//        pausedBtn.setTouchEnabled(false);
//        NodeReader.create().showNode(owner, "layouts/pause.cce");
//        Director.getInstance().pause();
    }


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

        if (pausedBtn.getBoundingBox().containsPoint(pos)) {
            return false;
        }

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
