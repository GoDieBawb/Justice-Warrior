/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.scene.Node;

/**
 *
 * @author Bawb
 */
public class Player extends Node {
    
    private SimpleApplication app;
    private Node              model;
    private boolean           left;
    private boolean           right;
    
    public Player(SimpleApplication app) {
        this.app = app;
        loadModel();
    }
    
    private void loadModel() {
        model = (Node) app.getAssetManager().loadModel("Models/Player/Triggerella.j3o");
        attachChild(model);
        model.getChild("Legs").addControl(new LegControl());
        model.getChild("Arms").addControl(new ArmControl());
    }
    
    public Node getModel() {
        return model;
    }
    
    public void setLeft(boolean newVal) {
        left = newVal;
    }
    
    public void setRight(boolean newVal) {
        right = newVal;
    }
    
    public boolean getLeft() {
        return left;
    }
    
    public boolean getRight() {
        return right;
    }
    
}
