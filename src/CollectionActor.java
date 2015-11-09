import akka.actor.*;

import java.util.Iterator;

import akka.actor.Actors;

/**
 * Created by curtis on 11/9/15.
 */
public class CollectionActor extends UntypedActor {
    private int numberOfFiles;
    private int filesReceived = 0;

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Found) {
            Found found = (Found) message;
            this.filesReceived++;

            Iterator<String> matchingLines = found.getIterator();

            System.out.printf("Matching lines for %s: \n", found.getFileName());

            while(matchingLines.hasNext()) {
                String matchingLine = matchingLines.next();
                System.out.println(matchingLine);
            }

            //Once all messages have been received
            if(this.filesReceived == this.numberOfFiles) {
                Actors.registry().shutdownAll();
            }
        } else if (message instanceof FileCount) {
            FileCount fileCount = (FileCount) message;
            this.numberOfFiles = fileCount.getNumberOfFiles();
        }
    }
}
