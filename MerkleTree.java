package MainPackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;




public class MerkleTree<type> {

    private ArrayList<String> hashList;


    @SuppressWarnings("unchecked") // This is used to suppress warnings that arise when cloning ArrayLists
    // constructor: Will take in a data set and construct the corresponding merkle
    // tree

    public MerkleTree(ArrayList<String> dataList) throws NoSuchAlgorithmException {

        Node root=generateTree(dataList);
        hashList=output(root);





    }

    public static ArrayList<String> output(Node root) throws NoSuchAlgorithmException{
        ArrayList<String> hs=new ArrayList<String>();

        if ((root.getLeft() == null && root.getRight() == null)) {
            hs.add( root.getHash());
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                hs.add(node.getHash());
            } else {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }

            if (node != null && node.getLeft() != null) {
                queue.add(node.getLeft());
            }

            if (node != null && node.getRight() != null) {
                queue.add(node.getRight());
            }

        }
        return hs;

    }
    public static Node generateTree(ArrayList<String> dataList) throws NoSuchAlgorithmException {
        ArrayList<Node> childNodes = new ArrayList<>();

        for (String message : dataList) {
            childNodes.add(new Node(null, null, hashFunction(message)));
        }

        return buildTree(childNodes);
    }

    private static Node buildTree(ArrayList<Node> children) throws NoSuchAlgorithmException {
        ArrayList<Node> parents = new ArrayList<>();

        while (children.size() != 1) {
            int index = 0, length = children.size();
            while (index < length) {
                Node leftChild = children.get(index);
                Node rightChild = null;

                if ((index + 1) < length) {
                    rightChild = children.get(index + 1);
                } else {
                    rightChild = new Node(null, null, leftChild.getHash());
                }

                String parentHash = hashFunction(leftChild.getHash() + rightChild.getHash());
                parents.add(new Node(leftChild, rightChild, parentHash));
                index += 2;
            }
            children = parents;
            parents = new ArrayList<>();
        }
        return children.get(0);
    }

    // This function uses MessageDigest in the Java security library to hash input
    // strings
    public static String hashFunction(String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(data.getBytes());



        byte[] digest = messageDigest.digest();
        System.out.println("Digest: "+ digest);
//
        //Converting the byte array in to HexString format
        StringBuffer hexString = new StringBuffer();

        for (int i = 0;i<digest.length;i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        System.out.println("Hex format : " + hexString.toString());
//	      System.out.println("String hash : "+ String.valueOf(sascii(hexString.toString(),100)));
//	      System.out.println("String fold hash : "+ String.valueOf(sfold(hexString.toString(),100)));
        return hexString.toString();
    }
//	}

//	private static int sfold(String s, int M) {
//		  long sum = 0, mul = 1;
//		  for (int i = 0; i < s.length(); i++) {
//		    mul = (i % 4 == 0) ? 1 : mul * 256;
//		    sum += s.charAt(i) * mul;
//		  }
//		  return (int)(Math.abs(sum) % M);
//	}
//
//	private static int sascii(String x, int M) {
//	     char ch[];
//	     ch = x.toCharArray();
//	     int xlength = x.length();
//
//	     int i, sum;
//	     for (sum=0, i=0; i < x.length(); i++)
//	       sum += ch[i];
//	     return sum % M;
//	   }

    public ArrayList<String> getMerkleTree() {
        return hashList;
    }

}




