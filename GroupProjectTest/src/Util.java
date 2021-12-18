import javax.swing.*;
import java.util.ArrayList;
import java.security.SecureRandom;
import javax.swing.JOptionPane;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Util {
    public String getMerkleRoot(ArrayList<String> lstItems){
        MerkleNode oNode1 = new MerkleNode();
        MerkleNode oNode2 = new MerkleNode();
        MerkleNode oNode3 = new MerkleNode();
        MerkleNode oNode4 = new MerkleNode();
        MerkleNode oNode5 = new MerkleNode();
        MerkleNode oNode6 = new MerkleNode();
        MerkleNode oNode7 = new MerkleNode();
        //Fill our leaf nodes
        oNode1.sHash = generateHash(lstItems.get(0));
        oNode2.sHash = generateHash(lstItems.get(1));
        oNode3.sHash = generateHash(lstItems.get(2));
        oNode4.sHash = generateHash(lstItems.get(3));
        //Build the tree to get Merkle Root
        populateMerkleNode(oNode5,oNode1,oNode2);
        populateMerkleNode(oNode6,oNode3,oNode4);
        populateMerkleNode(oNode7,oNode5,oNode6);
        //Merkle Root Return
        return oNode7.sHash;



    }
    private void populateMerkleNode(MerkleNode oNode, MerkleNode oLeftNode,MerkleNode oRightNode){
        oNode.oLeft = oLeftNode;
        oNode.oRight = oRightNode;
        oNode.sHash = generateHash(oLeftNode.sHash+oRightNode.sHash);

    }
    public void sleepRandomTime(String sThreadName){

        // Gets random number between 0 and 5 and then adds 3, meaning between 3 and 8 now.
        int iSleepTime = new SecureRandom().nextInt(5) + 3;

        System.out.println(sThreadName + " sleeping for " + iSleepTime + " seconds.");
        sleep(iSleepTime);
    }
    public void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch(Exception ex){
            //do nothing
        }
    }
    public String promptUser(String question){
        String response;
        JOptionPane oQuestion = new JOptionPane();
        response = oQuestion.showInputDialog(question);
        return response;
    }
    public synchronized String generateHash(String sOriginal){

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(
                    sOriginal.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < btEncodedhash.length; i++) {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch(Exception ex){

            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }

}
