//package MComSim.MoleculeCreator;

import java.io.*;
import java.util.*;

public class MoleculeCreator {

	private ArrayList<MoleculeParams> molParams;
	private MolComSim simulation;
	private NanoMachine source;
	private Position position;

	public void createMolecules() {
		/*create molecules using molecule params, basing the type to be created on moleculeParam.getMoleculeType() with mol.position = position and mol.source = source
		set msgId using source.getCurrentMsgId().  The molecules need to be given a movement controller based on the getMolecule().getMoleculeMovementType().
		If this is none, then install null movement controller.  If this is passive, then install DiffusiveRandomMovementController.  If this is active we need to check if there are
		any microtubules close enough to the starting position, and, if there are, install the onMicrotubuleMovementController.  If not, install the random movement one.

		We need to install the appropriate collision handler into the movement controller as well.  This is based on whether or not we want to handle collisions at all (should be a parameter, 
			just use null collision handler if no), whether or not we are on a tubule (should auto-derail if get collision), whether or not we want decomposing collsions (params file), etc.  
	sim.addMolecules(the molecules created);*/
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public MoleculeCreator(ArrayList<MoleculeParams> mParams, MolComSim sim) {
		this.molParams = mParams;
		this.simulation = sim;
	}

	public MoleculeCreator(ArrayList<MoleculeParams> mParams, MolComSim sim, NanoMachine src) {
		this.molParams = mParams;
		this.simulation = sim;
		this.source = src;
		this.position = src.getPosition();
	}

}
