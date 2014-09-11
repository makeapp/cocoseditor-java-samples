package org.ccj.game.doodle;

import org.ccj.Director;
import org.ccj.base.Ref;
import org.ccj.d2.Label;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.ScaleTo;
import org.ccj.d2.action.Sequence;
import org.ccj.editor.cce.Action;
import org.ccj.editor.cce.Bind;
import org.ccj.editor.cce.NodeController;

/**
 */
public class SceneController extends NodeController {

    @Bind()
    public Label scoreLabel;

    public float totalScore = 0;

    @Override
    public void onEnter() {
        super.onEnter();

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

}
