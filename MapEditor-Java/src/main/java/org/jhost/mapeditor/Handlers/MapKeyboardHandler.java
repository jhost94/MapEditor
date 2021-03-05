package org.jhost.mapeditor.Handlers;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.jhost.mapeditor.grid.Canvas;
import org.jhost.mapeditor.grid.Cursor;
import org.jhost.mapeditor.grid.Direction;

public class MapKeyboardHandler implements KeyboardHandler {

    /** ADDITIONAL KEYS*/
    public static final int TAB = 9;

    /** KEYBOARD */
    private Keyboard keyboard;

    /** Keys */
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent left;
    private KeyboardEvent right;

    private KeyboardEvent space;
    private KeyboardEvent spaceX;

    private KeyboardEvent s;
    private KeyboardEvent l;
    private KeyboardEvent c;
    private KeyboardEvent x;

    private KeyboardEvent tab;

    /**Cursor*/
    private Cursor cursor;

    private Canvas canvas;

    public MapKeyboardHandler(Canvas canvas){
        init(canvas);
    }

    private void init(Canvas canvas){
        this.canvas = canvas;
        this.keyboard = new Keyboard(this);
        initKeys();
        setKeys();
        setKeyboardEventType();
        setKeyboardListeners();
    }

    private void initKeys(){
        this.up = new KeyboardEvent();
        this.down = new KeyboardEvent();
        this.left = new KeyboardEvent();
        this.right = new KeyboardEvent();

        this.space = new KeyboardEvent();
        this.spaceX = new KeyboardEvent();

        this.s = new KeyboardEvent();
        this.l = new KeyboardEvent();
        this.c = new KeyboardEvent();
        this.x = new KeyboardEvent();

        this.tab = new KeyboardEvent();
    }

    private void setKeys(){
        this.up.setKey(KeyboardEvent.KEY_UP);
        this.down.setKey(KeyboardEvent.KEY_DOWN);
        this.left.setKey(KeyboardEvent.KEY_LEFT);
        this.right.setKey(KeyboardEvent.KEY_RIGHT);

        this.space.setKey(KeyboardEvent.KEY_SPACE);
        this.spaceX.setKey(KeyboardEvent.KEY_SPACE);

        this.s.setKey(KeyboardEvent.KEY_S);
        this.l.setKey(KeyboardEvent.KEY_L);
        this.c.setKey(KeyboardEvent.KEY_C);
        this.x.setKey(KeyboardEvent.KEY_X);

        //this.tab.setKey(TAB);
        this.tab.setKey(KeyboardEvent.KEY_Z);
    }

    private void setKeyboardEventType(){
        /**PRESSED*/
        this.up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.l.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.c.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.x.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        this.tab.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        /**RELEASED*/
        this.spaceX.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
    }

    private void setKeyboardListeners(){
        this.keyboard.addEventListener(up);
        this.keyboard.addEventListener(down);
        this.keyboard.addEventListener(left);
        this.keyboard.addEventListener(right);

        this.keyboard.addEventListener(space);
        this.keyboard.addEventListener(spaceX);

        this.keyboard.addEventListener(s);
        this.keyboard.addEventListener(l);
        this.keyboard.addEventListener(c);
        this.keyboard.addEventListener(x);

        this.keyboard.addEventListener(tab);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //TO BE FIXED
        System.out.printf("key pressed: " + keyboardEvent.getKey());

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
                cursor.setDirection(Direction.UP);
                cursor.move();
                break;
            case KeyboardEvent.KEY_DOWN:
                cursor.setDirection(Direction.DOWN);
                cursor.move();
                break;
            case KeyboardEvent.KEY_LEFT:
                cursor.setDirection(Direction.LEFT);
                cursor.move();
                break;
            case KeyboardEvent.KEY_RIGHT:
                cursor.setDirection(Direction.RIGHT);
                cursor.move();
                break;
            case KeyboardEvent.KEY_SPACE:
                canvas.setPainting(true);
                break;
            case KeyboardEvent.KEY_S:
                canvas.save();
                break;
            case KeyboardEvent.KEY_L:
                canvas.load();
                break;
            case KeyboardEvent.KEY_C:
                canvas.clear();
                break;
            case KeyboardEvent.KEY_X:
                System.exit(0);
                break;
            case KeyboardEvent.KEY_Z:
                cursor.rotateColor();
                canvas.getMenu().changeColor(cursor.getColorToPaint());
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            canvas.setPainting(false);
        }
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
