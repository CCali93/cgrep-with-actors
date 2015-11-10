import akka.actor.* ;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by curtis on 11/9/15.
 */
public class ScanActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Configure) {
            Configure configMessage = (Configure) message;

            Scanner inputScanner;

            if (configMessage.getFileName() != null) {
                inputScanner = new Scanner(new File(configMessage.getFileName()));
            } else {
                inputScanner = new Scanner(System.in);
            }

            List<String> matchingLines = new ArrayList<String>();

            while(inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();

                //TODO: match the REGEX with the line
            }
        }
    }
}
