import akka.actor.ActorRef;

/**
 * Created by curtis on 11/9/15.
 */
public class Configure {
    private ActorRef collectionActor;
    private String fileName;

    public Configure(ActorRef collectionActor, String fileName) {
        this.collectionActor = collectionActor;
        this.fileName = fileName;
    }

    public ActorRef getCollectionActor() {
        return collectionActor;
    }

    public String getFileName() {
        return  fileName;
    }
}
