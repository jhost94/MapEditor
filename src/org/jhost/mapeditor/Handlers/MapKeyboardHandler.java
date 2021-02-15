package org.jhost.mapeditor.Handlers;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MapKeyboardHandler implements KeyboardHandler {

    private Keyboard keyboard;

    /** Keys */
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent left;
    private KeyboardEvent right;


    public MapKeyboardHandler(){
        init();
    }

    private void init(){
        this.keyboard = new Keyboard(this);
        initKeys();
        setKeys();
        setKeyboardListeners();
    }

    private void initKeys(){
        this.up = new KeyboardEvent();
        this.down = new KeyboardEvent();
        this.left = new KeyboardEvent();
        this.right = new KeyboardEvent();
    }

    private void setKeys(){
        this.up.setKey(KeyboardEvent.KEY_UP);
        this.down.setKey(KeyboardEvent.KEY_DOWN);
        this.left.setKey(KeyboardEvent.KEY_LEFT);
        this.right.setKey(KeyboardEvent.KEY_RIGHT);
    }

    private void setKeyboardListeners(){
        this.keyboard.addEventListener(this.up);
        this.keyboard.addEventListener(this.down);
        this.keyboard.addEventListener(this.left);
        this.keyboard.addEventListener(this.right);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
