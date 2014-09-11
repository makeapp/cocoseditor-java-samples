package org.ccj.game.doodle;

/**
 *  * Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */

import org.ccj.Application;
import org.ccj.Director;
import org.ccj.GLView;
import org.ccj.Logger;
import org.ccj.base.FileUtils;
import org.ccj.editor.cce.NodeReader;

/**
 * author: touchsnow
 * -
 * -Game Engine:Cocos2d-Java
 * -
 * -Game Develop Tool:CocosEditor
 * -
 * -Doc Links
 * http://www.cocoseditor.com/ (Office Website)
 * http://blog.makeapp.co/ (Office Blog)
 * http://blog.csdn.net/touchsnow (csdn Blog)
 * https://github.com/makeapp      (github)
 * -
 * -Support
 * E-Mail:  zuowen@makeapp.co
 * QQ    :  232361142
 */
public class Main {

    public static final int DESIGN_WIDTH = 720;
    public static final int DESIGN_HEIGHT = 1280;

    public static void mainScene() {
        String paths[] = {
                ""
        };
        for (String path : paths) {
            FileUtils.getInstance().addSearchPath(path);
        }
        Director director = Director.getInstance();
        director.setDisplayStats(true);

        director.getOpenGLView().setDesignResolutionSize(DESIGN_WIDTH, DESIGN_HEIGHT, GLView.POLICY_EXACT_FIT);

        director.runWithScene(NodeReader.create().readScene("layouts/loading.cce"));
    }

    public static void main(String[] args) {
        int w = DESIGN_WIDTH / 2;
        int h = DESIGN_HEIGHT / 2;

        if (args != null && args.length >= 2) {
            w = Integer.parseInt(args[0]);
            h = Integer.parseInt(args[1]);
        }

        final int width = w;
        final int height = h;

        Application app = new Application() {
            public boolean applicationDidFinishLaunching() {
                if (OS_WINDOWS == getTargetPlatform()
                        || OS_ANDROID == getTargetPlatform()
                        || OS_MAC == getTargetPlatform()) {
                    GLView eglView = GLView.create("CocosPlayer");
                    eglView.setFrameSize(width, height);
                    Logger.log("width  " + width + " height " + height);
                    Director.getInstance().setOpenGLView(eglView);
                }
                Main.mainScene();
                return true;
            }
        };
        app.run();
    }
}
