/**
 *  Molecule class represents a generic molecule
 *  in the molecular communication simulation
 *  Contains information necessary for moving
 *  the molecule through the medium
 *
 */

public abstract class Molecule {

	private Position position;
	private int radius;
	private int numSequence;
	private MovementController movementController;
	protected MolComSim simulation;
	private MoleculeMovementType moleculeMovementType;
	//Id of the message a molecule carries - null for noise molecules
	protected Integer msgId;

	protected Molecule(MovementController mc, Position psn, MolComSim sim, MoleculeMovementType molMvType) {
		this.movementController = mc;
		this.position = psn;
		this.simulation = sim;
		this.moleculeMovementType = molMvType; 
	}
	
	protected Molecule(Position psn, MolComSim sim, MoleculeMovementType molMvType) {
		this.movementController = null;
		this.position = psn;
		this.simulation = sim;
		this.moleculeMovementType = molMvType;
	}
	
	protected Molecule(Position psn, int radius, int numSeq, MolComSim sim, MoleculeMovementType molMvType) {
		this(psn, sim, molMvType);
		this.radius = radius;
		this.numSequence = numSeq;
	}
	
	//Moves the molecule as defined by its movementController
	public abstract void move();

	public Position getPosition() {
		return position;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public int getNumSequence() {
		return numSequence;
	}

	public void setMovementController(MovementController mc) {
		this.movementController = mc;
	}

	public MolComSim getSimulation() {
		return simulation;
	}

	public MovementController getMovementController() {
		return movementController;
	}
	
	protected void setPosition(Position p) {
		this.position = p;
	}

	public MoleculeMovementType getMoleculeMovementType() {
		return moleculeMovementType;
	}
	
	public Integer getMsgId(){
		return this.msgId;
	}

}
