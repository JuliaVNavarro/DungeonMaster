import java.awt.Point;

/** Representation of the Hero */
public class Hero extends Entity implements Magical {
  /* Represents the active map */
  private Map map = new Map();

  /* Represents the location of hero */
  private Point loc = map.findStart(); 

  /* Represents the hero's level */
  private int level = 1;

  /** Constructs hero with a name
  *   @param n    hero's name
  */
  public Hero (String n){
    super(n, 25); // sets max HP to 25
  }
  
  /** String representation of a Hero object
  * @return string representation of hero's hp, level, and map
  */
  @Override
  public String toString(){
    return super.toString() + "\n" + "\nLevel: " + level + "\n" + map.mapToString(loc); 
  }
  
  /** Level up the hero and load the next map
  */
  public void levelUp(){ 
    level += 1;
    if (level % 3 == 0) {
      map.loadMap(3);
    } else {
      map.loadMap(level % 3);
    }
  }

  /** Moves hero's position up one position
  * @return character at new location 
  */
  public char goNorth(){
    loc.translate(-1, 0);
    // checking for out of bounds 
    if ((loc.getX() >= 0 && loc.getX() <=4) && (loc.getY() >= 0 && loc.getY() <=4)) {
      map.reveal(loc);
      char value = map.getCharAtLoc(loc);
      map.removeCharAtLoc(loc);
      return value;
    } else {
      // if out of bounds, back to original position 
      loc.translate(1, 0);
      return 'x';
    }
  }

  /** Moves hero's position down one position
  * @return character at new location 
  */
  public char goSouth(){
    loc.translate(1, 0);
    // checking for out of bounds 
    if ((loc.getX() >= 0 && loc.getX() <=4) && (loc.getY() >= 0 && loc.getY() <=4)) {
      map.reveal(loc);
      char value = map.getCharAtLoc(loc);
      map.removeCharAtLoc(loc);
      return value;
    } else {
      // if out of bounds, back to original position 
      loc.translate(-1, 0);
      return 'x';
    }
  }

  /** Moves hero's position right one position
  * @return character at new location 
  */
  public char goEast(){
    loc.translate(0, 1);
    // checking for out of bounds 
    if ((loc.getX() >= 0 && loc.getX() <=4) && (loc.getY() >= 0 && loc.getY() <=4)) {
      map.reveal(loc);
      char value = map.getCharAtLoc(loc);
      map.removeCharAtLoc(loc);
      return value;
    } else {
      // if out of bounds, back to original position 
      loc.translate(0, -1);
      return 'x';
    }
  }

  /** Moves hero's position left one position
  * @return character at new location 
  */
  public char goWest(){
    loc.translate(0, -1);
    // checking for out of bounds 
    if ((loc.getX() >= 0 && loc.getX() <=4) && (loc.getY() >= 0 && loc.getY() <=4)) {
      map.reveal(loc);
      char value = map.getCharAtLoc(loc);
      map.removeCharAtLoc(loc);
      return value;
    } else {
      // if out of bounds, back to original position 
      loc.translate(0, 1);
      return 'x';
    }
  }

  public Point getLoc(){
    return(loc);
  }
    
  
  /* Hero will attack using a physical attack, which will cause a random amount of damage.
   * @param e the enemy's information that is being attacked
   * @return a string representation of the attack that had occurred and the damage done*/
  @Override
  public String attack(Entity e) {
	  int dmg = (int)(Math.random() * 3) + 1;
	  e.takeDamage(dmg);
    return "\n" + super.getName() + " attacks " + e.getName() + " for " + dmg + " damage.";
  }
  
  /* Hero will attack using a magic missile, which will cause a random amount of damage.
   * @param e the enemy's information that is being attacked
   * @return a string representation of the attack that had occurred and the damage done*/
  @Override
  public String magicMissile(Entity e) {
	  int dmg = (int)(Math.random() * 5) + 1;
	  e.takeDamage(dmg);
    return "\n" + super.getName() + " shoots " + e.getName() + " with a Magic Missile for " + dmg + " damage.";
  }
  
  /* Hero will attack using a fireball, which will cause a random amount of damage.
   * @param e the enemy's information that is being attacked
   * @return a string representation of the attack that had occurred and the damage done*/
  @Override
  public String fireball(Entity e) {
	  int dmg = (int)(Math.random() * 5) + 1;
	  e.takeDamage(dmg);
    return "\n" + super.getName() + " burns " + e.getName() + " with a Fireball for " + dmg + " damage.";
  }
  
  /* Hero will attack using a thunderclap, which will cause a random amount of damage.
   * @param e the enemy's information that is being attacked
   * @return a string representation of the attack that had occurred and the damage done*/
  @Override
  public String thunderclap(Entity e) {
	  int dmg = (int)(Math.random() * 5) + 1;
	  e.takeDamage(dmg);
    return "\n" + super.getName() + " zaps " + e.getName() + " with Thunderclap for " + dmg + " damage.";
  }
}
