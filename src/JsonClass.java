import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonClass {

    public void basicJson(){
        JsonElement jsonElement = JsonParser.parseString("{ \"key\":\"value\" }");
        System.out.println(jsonElement.toString());
    }

    public void makingJson(){
        JsonObject jsonObj = new JsonObject();

        //Property1
        jsonObj.addProperty("name", "rosy");

        //Property2
        jsonObj.addProperty("age", 27);

        //Property3
        jsonObj.addProperty("married", false);

        //Property4
        JsonArray jsonArr = new JsonArray();
        jsonArr.add("tennis");
        jsonArr.add("soccer");
        jsonObj.add("hobby", jsonArr);

        //Property5
        JsonObject jsonObj2 = new JsonObject();
        jsonObj2.addProperty("1st", "done");
        jsonObj2.addProperty("2nd", "expected");
        jsonObj2.add("3rd", null);
        jsonObj.add("vaccine", jsonObj2);

        //Property6
        JsonArray jsonArr2 = new JsonArray();
        jsonObj2 = new JsonObject();
        jsonObj2.addProperty("name", "park");
        jsonObj2.addProperty("age", 10);
        jsonArr2.add(jsonObj2);
        jsonObj.add("children", jsonArr2);

        //Property7
        jsonObj.add("address", null);

        try(Writer writer = new FileWriter("example.json")){
            Gson gson = new GsonBuilder().serializeNulls().create();
            gson.toJson(jsonObj, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readingJson() throws FileNotFoundException {
        String filePath = "example.json";

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filePath));
        JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);
        System.out.println(jsonObj);

        String name = jsonObj.get("name").getAsString();
        int age = jsonObj.get("age").getAsInt();
        System.out.println("name " +  name);
        System.out.println("age " + age);

        JsonArray jsonArray = jsonObj.get("hobby").getAsJsonArray();
        String hobby1 = jsonArray.get(0).getAsString();
        String hobby2 = jsonArray.get(1).getAsString();
        System.out.println("hobbies " + hobby1 + "," + hobby2 );

        JsonObject jsonObject = jsonObj.get("vaccine").getAsJsonObject();
        String first = jsonObject.get("1st").getAsString();
        String second = jsonObject.get("2nd").getAsString();
        System.out.println("vaccine " + first + "," + second);

        JsonArray jsonArray2 = jsonObj.get("children").getAsJsonArray();
        JsonObject jsonObj2 = jsonArray2.get(0).getAsJsonObject();
        String childName = jsonObj2.get("name").getAsString();
        int childAge = jsonObj2.get("age").getAsInt();
        System.out.println("childName : " + childName);
        System.out.println("childAge : " + childAge);
    }

    public void checkingTypeJson() throws IOException {
        String filePath = "example.json";
        Path jsonFilePath = Paths.get(filePath);

        String wholeData = new String(Files.readAllBytes(jsonFilePath));
        System.out.println(wholeData);

        Gson gson = new Gson();
        JsonObject jsonObj = gson.fromJson(wholeData, JsonObject.class);

        for (String key : jsonObj.keySet()) {
            System.out.print("Key : "+key+" / Value Type : ");

            JsonElement je = jsonObj.get(key);

            if (je.isJsonPrimitive()) {
                if (je.getAsJsonPrimitive().isString()) {
                    System.out.println("String");
                }
                else if (je.getAsJsonPrimitive().isNumber())
                {
                    System.out.println("Number");
                }
                else if (je.getAsJsonPrimitive().isBoolean()) {
                    System.out.println("Boolean");
                }
                else if (je.getAsJsonPrimitive().isJsonNull()) {
                    System.out.println("null");
                }
            }
            else if (je.isJsonArray()) {
                System.out.println("Array");
            }
            else if (je.isJsonObject()) {
                System.out.println("Object");
            }
            else if (je.isJsonNull()) {
                System.out.println("null");
            }
        }

    }


}
