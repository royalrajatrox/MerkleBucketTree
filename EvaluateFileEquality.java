package MainPackage;



public class EvaluateFileEquality<type> {// GENERICS REQUIREMENT
	private boolean isEqual;
	private String message = "";

	// constructor: Sets variables mt1 and mt2 and runs the determineEquality
	// function
	public EvaluateFileEquality(MerkleTree<type> mt1, MerkleTree<type> mt2) {
		isEqual = determineEquality(mt1, mt2);
	}

	// determine whether two merkle trees are equal or not be comparing hashes
	private boolean determineEquality(MerkleTree<type> mt1, MerkleTree<type> mt2) {
		boolean checking = false;
		String diff1 = null;
		String diff2 = null;
		if (mt1.getMerkleTree().equals(mt2.getMerkleTree()))
		{
			checking = true;
			diff1=mt1.getMerkleTree().get(0);
		}
		else {
			checking = false;
			diff1 = mt1.getMerkleTree().get(0);
			diff2 = mt2.getMerkleTree().get(0);
		}
		if (checking) {
			message = "Both files are the same. Merkle Tree is: "+ diff1;
			return true;
		}
//			if(mt1.getMerkleTree().get(0).equals(mt2.getMerkleTree().get(0))) {
//				message = "Both files are the same";
//				return true;
//			}
		else {
			message = "Files are different: \tFile1: " + diff1 + "\tVS. \tFile2: " + diff2;
			return false;
		}
	}


	// return the result of the isEqual function
	public boolean getEquality() {
		return isEqual;
	}

	public String getMessage() {
		return message;
	}
}
