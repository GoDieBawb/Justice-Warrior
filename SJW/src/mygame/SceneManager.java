/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 *
 * @author Bawb
 */
public class SceneManager extends AbstractAppState {
    
    private SimpleApplication app;
    private AppStateManager   stateManager;
    
    public SceneManager(Application app) {
        this.app     = (SimpleApplication) app;
        stateManager = app.getStateManager();
    }
    
    private void createGround() {
    
        Box box          = new Box(1,1,1);
        Geometry cube1   = new Geometry("Geometry", box);
        Geometry cube2   = new Geometry("Geometry", box);
        Node     ground1 = new Node("Ground One");
        Node     ground2 = new Node("Ground Two");
        ground1.attachChild(cube1);
        ground1.attachChild(cube2);
        
    }
    
    @Override
    public void update(float tpf) {
    
    }
    
}
