import java.util.Scanner;

public class MerkleManager {

    public static volatile String userIn;
    public static String sMerkleRoot;
    public static String nullRoot = null;
    public static int iStrikes = 0;

    public void manage() {

        MerkleThread oMerkleThread = new MerkleThread();
        oMerkleThread.threadName = "Merkle Thread";
        Thread oThread1 = new Thread(oMerkleThread);
        oMerkleThread.run();                              //Fix start

        RogueThread oRogueThread = new RogueThread();
        oRogueThread.threadName = "Rogue Thread";
        Thread oThread2 = new Thread(oRogueThread);
        oRogueThread.run();

        MonitorThread oMonitorThread = new MonitorThread();
        oMonitorThread.threadName = "Monitor Thread";
        Thread oThread3 = new Thread(oMonitorThread);
        oMonitorThread.run();

        while(true){

            Scanner Scan = new Scanner(System.in);
            System.out.print("Please enter a word");
            String userInput = Scan.next();
            break;

        }
    }

        public static synchronized String grabWord() {

            String temp = userIn;
            userIn = null;
            return temp;

        }
    }
