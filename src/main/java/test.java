import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.Name;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;


import java.util.Iterator;
import java.util.List;

public class test {

    public static void main( String args[] ) {

        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        final Morphia morphia = new Morphia();
        morphia.mapPackage("entity");
        Datastore datastore = morphia.createDatastore(mongo, "REPORTS");
        datastore.ensureIndexes();

        MongoDatabase database = mongo.getDatabase("REPORTS");

        MongoCollection<Document> reports = database.getCollection("movie");

        DB db = datastore.getDB();
        DBCollection col = db.getCollection("name");
        DBCursor i = col.find();
        final Query<Name> query = datastore.createQuery(Name.class);
        final List<Name> employees = query.asList();
        while(i.hasNext()){
            DBObject obj = i.next();
            obj.get("name");
            System.out.println(obj.get("name"));
        }

    }
}