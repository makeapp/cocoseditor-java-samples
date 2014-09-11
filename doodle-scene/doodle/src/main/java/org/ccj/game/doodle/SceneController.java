package org.ccj.game.doodle;

import org.ccj.Director;
import org.ccj.base.Ref;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.ScaleTo;
import org.ccj.d2.action.Sequence;
import org.ccj.editor.cce.Action;
import org.ccj.editor.cce.Bind;
import org.ccj.editor.cce.NodeController;

/**
 */
public class SceneController extends NodeController {

//    @Bind()
//   public Sprite bgSprite;

    @Override
    public void onEnter() {
        super.onEnter();
//        bgSprite.runAction(Sequence.create(ScaleTo.create(0.5f, 0.3f), ScaleTo.create(0.5f, 1f)));
    }

    @Override
    public void onExit() {
        super.onExit();
    }

    @Override
    public void onUpdate(float delta) {
        super.onUpdate(delta);
    }

    @Bind("closeButton")
    @Action(Action.ActionType.WidgetTouchUp)
    public void onCloseClicked(Ref ref) {
        Director.getInstance().end();
    }
}
