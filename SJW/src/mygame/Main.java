package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        stateManager.attach(new PlayerManager(this));
        stateManager.attach(new SceneManager(this));
        InteractionManager im = new InteractionManager(this);
        flyCam.setEnabled(false);
        flyCam.setMoveSpeed(15);
        cam.setLocation(new Vector3f(-0.15173124f, 4.480524f, 7.5511436f));
        cam.lookAtDirection(new Vector3f(0.015364283f, -0.18160264f, -0.98325205f), new Vector3f(0,1,0));
    }

    @Override
    public void simpleUpdate(float tpf) {
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
