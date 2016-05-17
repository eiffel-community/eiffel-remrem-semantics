import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LibraryTest {

    @Test public void testSomeLibraryMethod() {
        Library library = new Library();
        JsonObject msgNodes = new JsonObject();
        msgNodes.addProperty("domainId", "my domain");
        Map<String, String> eventParams = new HashMap<>();
        eventParams.put("type", "EiffelActivityQueuedEvent");
        String msg = library.generateMsg(null,msgNodes,eventParams);
        System.out.println(msg);
    }
}
