/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.asset.TextureKey;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.Quaternion;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.texture.Texture;

/**
 *
 * @author Bawb
 */
public class InteractionManager implements ActionListener {
    
  
  public InputManager      inputManager;
  private Player           player;
  public boolean           left = false, right = false, click = false;
  private Texture          tex1, tex2, tex3, tex4;
  private Material         skin;
  
  public InteractionManager(Application app) {
      
     this.inputManager = app.getInputManager();
     player            = app.getStateManager().getState(PlayerManager.class).getPlayer(); 
     
     TextureKey key    = new TextureKey("Models/Player/Dress.png", false);
             tex1      = app.getAssetManager().loadTexture(key);
             
     TextureKey key1   = new TextureKey("Models/Player/Head.png", true);
             tex2      = app.getAssetManager().loadTexture(key1);
          
     TextureKey key3    = new TextureKey("Models/Player/Dress.png", true);
             tex3      = app.getAssetManager().loadTexture(key3);
             
     TextureKey key4   = new TextureKey("Models/Player/Head.png", false);
             tex4      = app.getAssetManager().loadTexture(key4);
             
     TextureKey key5   = new TextureKey("Models/Player/Skin.png", false);
     Texture tex5      = app.getAssetManager().loadTexture(key5);
     
     skin              = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
     skin.setTexture("ColorMap", tex5);
     
     Geometry head = (Geometry) ((Node)player.getModel().getChild("Body")).getChild("Head");
     Geometry body = (Geometry) ((Node)player.getModel().getChild("Body")).getChild("Body");

     body.getMaterial().setTexture("ColorMap", tex1);
     head.getMaterial().setTexture("ColorMap", tex2);
     
     player.getModel().getChild("Arms").setMaterial(skin);
     player.getModel().getChild("Legs").setMaterial(skin);
     
     setUpKeys();
     
  }

    

  private void setUpKeys() {
  
      inputManager.addMapping("Left",  new KeyTrigger(KeyInput.KEY_A));
      inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
      inputManager.addMapping("Click", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
      inputManager.addListener(this, "Left");
      inputManager.addListener(this, "Right");
      inputManager.addListener(this, "Click");
  
  }
    
  @Override
  public void onAction(String binding, boolean isPressed, float tpf) {
  
      if (binding.equals("Click")) {
          click = isPressed;
      }
      
      else  if (binding.equals("Left")) {
          
          
          if(isPressed) {
              
            Geometry head = (Geometry) ((Node)player.getModel().getChild("Body")).getChild("Head");
            Geometry body = (Geometry) ((Node)player.getModel().getChild("Body")).getChild("Body");
            
            body.getMaterial().setTexture("ColorMap", tex3);
            
            head.getMaterial().setTexture("ColorMap", tex4);
            head.setLocalTranslation(0,2f,0);
            
            player.getModel().setLocalRotation(new Quaternion(0,.9f,0,0f));
          
          }
          
          player.setLeft(isPressed);
          
      }
      
      else if (binding.equals("Right")) {
          
          if(isPressed) {
              
            Geometry head = (Geometry) ((Node)player.getModel().getChild("Body")).getChild("Head");
            Geometry body = (Geometry) ((Node)player.getModel().getChild("Body")).getChild("Body");

            body.getMaterial().setTexture("ColorMap", tex1);
            head.getMaterial().setTexture("ColorMap", tex2);
          
            head.setLocalTranslation(0,1.6f,0);
          
            player.getModel().setLocalRotation(new Quaternion(0,0,0,1));
            
          }
          
          player.setRight(isPressed);
          
      }
      
  }
    
}
