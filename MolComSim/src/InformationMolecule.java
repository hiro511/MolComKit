//package MComSim.InformationMolecule;

import java.io.*;
import java.util.*;

public class InformationMolecule extends Molecule{

	private NanoMachine source;
	private int msgId;
	private ArrayList<NanoMachine> destinations;

	public void move() {
		setPosition(getMovementController().getNextPosition(this, getSimulation()));
		if(reachedDestination() != null)
		{
			reachedDestination().receiveMolecule(this);
		}
	}

	private NanoMachine reachedDestination() {
		for(NanoMachine dest : destinations){
			if(haveOverlap(dest)){
				return dest;
			}
		}
		return null;
	}

	public InformationMolecule(MovementController mc, Position psn, double r, MolComSim sim, NanoMachine src, int msgNum, MoleculeMovementType molMvType) {
		super(mc, psn, r, sim, molMvType);
		this.source = src;
		this.msgId = msgNum; 
		this.destinations = sim.getReceivers();
	}

	private boolean haveOverlap(NanoMachine dest) {
		return getPosition().getDistance(dest.getPosition()) < getRadius() + dest.getRadius();
	}

}
