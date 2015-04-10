/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author Bawb
 */
public class ArmControl extends AbstractControl {

    private boolean  left;
    private Node     rightArm;
    private Node     leftArm;
    
    @Override
    public void setSpatial(Spatial spatial) {
    
        leftArm  = (Node) ((Node)spatial).getChild("LeftArm");
        rightArm = (Node) ((Node)spatial).getChild("RightArm");
        
    }
    
    private void run(float tpf) {
        
        if (leftArm.getLocalRotation().getZ() < -.90f) {
            left = true;
        }
        
        else if(leftArm.getLocalRotation().getZ() > 0f) {
            left = false;
        }
        
        if(left) {

            leftArm.rotate(0, 0, 6f*tpf);
            rightArm.rotate(0, 0, -6f*tpf);
            
        }
        
        else {
        
            leftArm.rotate(0, 0, -6f*tpf);
            rightArm.rotate(0, 0, 6f*tpf);
        
        }
        
    } 
    
    @Override
    protected void controlUpdate(float tpf) {
        run(tpf);
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
    
}
