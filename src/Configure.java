import akka.actor.ActorRef;

/**
 * Created by curtis on 11/9/15.
 */
public class Configure {
    private ActorRef collectionActor;
    private String fileName, regex;

    public Configure(ActorRef collectionActor, String regex, String fileName) {
        this.collectionActor = collectionActor;
        this.regex = regex;
        this.fileName = fileName;
    }

    public ActorRef getCollectionActor() {
        return collectionActor;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getRegularExpression() {
        return this.regex;
    }
}
