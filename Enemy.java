/* Enemy.java represents an enemy with no magical abilities, which the hero will encounter. 
 * It extends from the abstract Entity.java*/
public class Enemy extends Entity {
	/** Constructs enemy with a name and max hp
  *   @param n    enemy's name
  *   @param mHp  enemy's max HP
  */
	public Enemy(String n, int mHp) {
		super(n, mHp); // calls superclass constructor from Entity.java
	}

	/* String representation of the physical attack that the 
	 * enemy would do to the hero with a random damage
	 * @param the hero's information that is being attacked, using the entity 
	 * method, .takeDamage()
   * @return string representation of attack & damage */
	@Override
	public String attack(Entity e) {
		int rand = (int)(Math.random() * 3) + 1; // generate random number
		e.takeDamage(rand); // hero takes random amount of damage
    return super.getName() + " attacks " + e.getName() + " for " + rand + " damage.";
	}
}
