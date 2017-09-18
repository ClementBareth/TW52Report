package entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("name")
public class Name {

    @Id
    private String objId;

    private String name;

    public Name(){

    }

    public Name(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
