package org.ccj.game.doodle;


import org.ccj.Director;
import org.ccj.Scheduler;
import org.ccj.base.Ref;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.MoveTo;
import org.ccj.d2.action.RepeatForever;
import org.ccj.d2.action.Sequence;
import org.ccj.editor.cce.Action;
import org.ccj.editor.cce.Bind;
import org.ccj.editor.cce.NodeController;
import org.ccj.editor.cce.NodeReader;
import org.ccj.math.Vec2;

public class LoadingController extends NodeController {

    @Bind()
    public Sprite doodleSprite;
    @Bind()
    public Sprite loadingSprite;

    public boolean isLoadingFinish = false;

    @Override
    public void onEnter() {
        super.onEnter();

        //涂鸦怪物跳跃动画
        Vec2 dsPos = doodleSprite.getPosition();
        doodleSprite.runAction(RepeatForever.create(Sequence.create(
                MoveTo.create(0.5f, new Vec2(dsPos.getX(), dsPos.getY() + 150)),
                MoveTo.create(0.4f, new Vec2(dsPos.getX(), dsPos.getY()))
        )));


        //loading 3s后删除
        loadingSprite.runAction(NodeReader.create().readAnimation("animates/loadingAnimate.cce"));
        owner.scheduleOnce(new Scheduler.SchedulerCallback() {
            @Override
            public void onUpdate(float delta) {
                super.onUpdate(delta);
                if (loadingSprite != null) {
                    loadingSprite.removeFromParent();
                    isLoadingFinish = true;
                }
            }
        }, 3);
    }

    @Override
    public void onExit() {
        super.onExit();
    }

    @Bind("playBtn")
    @Action(Action.ActionType.WidgetTouchUp)
    public void onPlayClicked(Ref ref) {
        if (isLoadingFinish) {
            Director.getInstance().replaceScene(NodeReader.create().readScene("layouts/main.cce"));
        }
    }
}
