/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author Bawb
 */
public class LegControl extends AbstractControl {

    private boolean  left;
    private Geometry rightLeg;
    private Geometry leftLeg;
    
    @Override
    public void setSpatial(Spatial spatial) {
    
        leftLeg  = (Geometry) ((Node)spatial).getChild("LeftLeg");
        rightLeg = (Geometry) ((Node)spatial).getChild("RightLeg");
        
    }
    
    private void run(float tpf) {
        
        if (leftLeg.getLocalTranslation().x < -.35f) {
            left = true;
        }
        
        else if(leftLeg.getLocalTranslation().x > .35f) {
            left = false;
        }
        
        if(left) {

            leftLeg.move(2.75f*tpf,0,0);
            rightLeg.move(-2.75f*tpf,0,0);
            
        }
        
        else {
        
            leftLeg.move(-2.75f*tpf,0,0);
            rightLeg.move(2.75f*tpf,0,0);
        
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
