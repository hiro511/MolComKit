
public class CollisionCounter {
	private static CollisionCounter collisionCounter = new CollisionCounter();;
	private int count = 0;
	
	private CollisionCounter() {
	}
	
	public static CollisionCounter getInstance() {
		return collisionCounter;
	}
	
	public void up(){
		count++;
	}
	
	public int getCount() {
		return count;
	}

}
