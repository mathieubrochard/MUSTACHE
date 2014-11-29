package mustache;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;

public class Mustache
{
	private float x;
	private float y;
	private int   width;
	private int   height;
	private Animation[] animations = new Animation[8];
	private boolean moving;
	private int direction;
	private double speed;
	
	public Mustache(int w, int h) {
		this.width  = w;
		this.height = h;
	}
	
	public void init()
	{
		this.moving = false;
		this.direction = 0;
				
		this.speed = 0.2;
		
		x = this.width/2 - 90;
		y = this.height/2 - 90;
		
		try
		{
			SpriteSheet spriteSheet = new SpriteSheet("res/sprites/mustache.jpg", 179, 180);
			this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
	        this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
	        this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
	        this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
	        this.animations[4] = loadAnimation(spriteSheet, 1, 2, 0);
	        this.animations[5] = loadAnimation(spriteSheet, 1, 2, 1);
	        this.animations[6] = loadAnimation(spriteSheet, 1, 2, 2);
	        this.animations[7] = loadAnimation(spriteSheet, 1, 2, 3);
		}
		
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
	
	public void deplacer(char dir, int delta)
	{
		
	}
	
	public void update(GameContainer gc, int delta)
	{
		Input key = gc.getInput();
		
		int mouseX = key.getMouseX();
		int mouseY = key.getMouseY();
		
		if(mouseY < y) y -= speed * delta;
		if(mouseY > y) y += speed * delta;
		if(mouseX > x) x += speed * delta;
		if(mouseX < x) x -= speed * delta;
		
	}
	
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }
	
	public Animation[] getAnimation() {
		return this.animations;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public boolean getMoving() {
		return this.moving;
	}
}
