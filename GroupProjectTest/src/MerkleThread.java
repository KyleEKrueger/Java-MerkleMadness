import java.util.ArrayList;

public class MerkleThread implements Runnable {

    public String threadName;

    // holds all the grabbed words
    public static volatile ArrayList<String> lstWords;

    private int iMerkleTreeInputs = 4;


    public void run(){

        Util oUtil = new Util();
        lstWords= new ArrayList<>();
        while (true){
            oUtil.sleepRandomTime(threadName);
            String sNewWord = MerkleManager.grabWord();
            if (sNewWord != null){
                System.out.println(sNewWord);
                lstWords.add(sNewWord);
                if (lstWords.size() == iMerkleTreeInputs)
                    MerkleManager.sMerkleRoot = oUtil.getMerkleRoot(lstWords);

            }
        }
//        System.out.println(String.format("%s: has started", threadName));
    }
}
