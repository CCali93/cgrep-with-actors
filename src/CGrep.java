import static akka.actor.Actors.* ;
import java.util.* ;
import akka.actor.* ;

/**
 * Created by curtis on 11/9/15.
 */
public class CGrep {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("ERROR! Must provide a regex pattern and at least 1 file");
            System.exit(1);
        } else {
            int numFiles = args.length - 1;
            String regex = args[0];

            ActorRef[] scanActors = new ActorRef[numFiles];
            for(int i = 0; i < scanActors.length; i++) {
                scanActors[i] = actorOf(new UntypedActorFactory() {
                    @Override
                    public Actor create() {
                        return new ScanActor();
                    }
                });
            }

            ActorRef collectionActor = actorOf(CollectionActor.class);

            for(ActorRef scanActor : scanActors) {
                scanActor.start();
            }

            collectionActor.start();

            collectionActor.tell(new FileCount(numFiles));

            for(int i = 1, j = 0; i < args.length; i++, j++) {
                scanActors[j].tell(new Configure(collectionActor, regex, args[i]));
            }
        }
    }
}
