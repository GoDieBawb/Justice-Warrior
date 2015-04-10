package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;

/**
 *
 * @author Bawb
 */
public class PlayerManager extends AbstractAppState {
    
    private SimpleApplication app;
    private Player            player;
    
    public PlayerManager(SimpleApplication app) {
        this.app = app;
        createPlayer();
        app.getRootNode().attachChild(player);
        player.scale(.5f);
        player.setLocalTranslation(0,3f,-3);
    }
    
    private void createPlayer() {
    
        player = new Player(app);
        
    }
    
    public Player getPlayer() {
        return player;
    }
    
}
