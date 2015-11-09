import akka.actor.* ;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by curtis on 11/9/15.
 */
public class ScanActor extends UntypedActor {
    private Scanner inputScanner;

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Configure) {
            Configure configMessage = (Configure) message;

            if (configMessage.getFileName() != null) {
                this.inputScanner = new Scanner(new File(configMessage.getFileName()));
            } else {
                this.inputScanner = new Scanner(System.in);
            }

            List<String> matchingLines = new ArrayList<String>();

            while(this.inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();

                //TODO: match the REGEX with the line
            }
        }
    }
}
