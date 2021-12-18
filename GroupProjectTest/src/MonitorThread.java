public class MonitorThread implements Runnable {

    public String threadName;

    public void run() {
        Util oUtil = new Util();    // ?? Not mentioned in the lab description
        while (true){
            if (MerkleManager.sMerkleRoot != null){
                if (MerkleManager.sMerkleRoot.equals(MerkleManager.expMerkleRoot)){
                    System.out.println(String.format("You win: %s", MerkleManager.sMerkleRoot));
                } else {
                    System.out.println("Merkle Root does not match: you lost");
                }
                System.exit(0);

            } else
                if (MerkleManager.iStrikes == 3){
                    System.out.println("3 strikes: you lost!");
                    System.exit(0);
            }
                oUtil.sleep(1);

                //	After the if-else statement, then call sleep on util object and sleep for 1 second.
                // (if you don’t do this, the endless loop never allows updates on that thread to see MerkleManager’s changing values.)

        }
    }
}
