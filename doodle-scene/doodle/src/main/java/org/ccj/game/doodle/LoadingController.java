package org.ccj.game.doodle;


import org.ccj.Director;
import org.ccj.base.Ref;
import org.ccj.editor.cce.Action;
import org.ccj.editor.cce.Bind;
import org.ccj.editor.cce.NodeController;
import org.ccj.editor.cce.NodeReader;

public class LoadingController extends NodeController {

    @Override
    public void onEnter() {
        super.onEnter();
    }

    @Override
    public void onExit() {
        super.onExit();
    }

    @Bind("playBtn")
    @Action(Action.ActionType.WidgetTouchUp)
    public void onPlayClicked(Ref ref) {
        Director.getInstance().replaceScene(NodeReader.create().readScene("layouts/main.cce"));
    }
}
