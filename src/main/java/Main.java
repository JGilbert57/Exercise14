//Johnny Gilbert 5/1/2019
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;



import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 111618 on 5/1/2019.
 */
public class Main {
    public static void main(String [] Args){
        simpleDeserialize();
        simpleSerialize();
    }
    public static void simpleDeserialize(){
        String jsonPerson1 = "{\"body\":\"Walk the dog\",\"done\":false,\"id\":0,\"priority\":3,\"title\":\"dog\"}";
        String jsonPerson2 = "{\"body\":\"Pay the bills\",\"done\":false,\"id\":1,\"priority\":1,\"title\":\"bills\"}";
        JsonParser parser = new JsonParser();
        JsonElement test = parser.parse(jsonPerson1);
        JsonElement test2 = parser.parse(jsonPerson2);
        Gson gson = new Gson();
        Json person1 = gson.fromJson(jsonPerson1,Json.class);
        Json person2 = gson.fromJson(jsonPerson2,Json.class);
        System.out.println(person1.toString() + " this is the converted Json to a java object");
        System.out.println(person2.toString() + " this is the converted Json to a java object");
    }
    public static void simpleSerialize(){
        Json jsonPerson1 =  new Json("Walk the dog",false,0,3,"dog");
        Json jsonPerson2 = new Json("Pay the bills",false,1,1,"bills");
        ArrayList <Json> list = new ArrayList<>();
        list.add(jsonPerson1);
        list.add(jsonPerson2);
        Gson gson = new Gson();
        System.out.println();
        try {
            FileWriter writer = new FileWriter("serialize.json");
            gson.toJson(list,writer);
            //gson.toJson(jsonPerson2,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
class Json {
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public Json(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Json{" +
                "body='" + body + '\'' +
                ", done=" + done +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}

