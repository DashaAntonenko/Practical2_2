import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class Practical9 {
    public static void main(String[] args) {
//        System.out.println("Practical 2.2, Antonenko Darya, RIBO-04-22");
//        System.out.println("Start program!");
//        String server = "https://www.mirea.ru/";
//        HTTPRunnable httpRunnable = new HTTPRunnable(server, null);
//        Thread th = new Thread(httpRunnable);
//        th.start();
//        try{
//            th.join();
//        }catch(InterruptedException ex){
//
//        }finally{
//            try{
//                FileWriter fw = new FileWriter("C:\Java\resp.html");
//                fw.write(httpRunnable.getResponseBody());
//                fw.close();
//                System.out.println("Success save response from server:" + server);
//            }catch (IOException ex) {
//                System.out.println("Error response saving: " + ex.getMessage());
//            }
//        }
//    }
        System.out.println("Practical 2.2, Antonenko Darya, RIBO-04-22");
        System.out.println("Start program!");
        String server = "https://android-for-students.ru/";
        String serverPath = "/materials/practical/hello.php";
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Antonenko");
        map.put("group", "RIBO-04-22");
        HTTPRunnable httpRunnable = new HTTPRunnable(server + serverPath, map);
        Thread th = new Thread(httpRunnable);
        th.start();
        try{
            th.join();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }finally{
            JSONObject jsonObject = new JSONObject(httpRunnable.getResponseBody());
            int result = jsonObject.getInt("result_code");
            System.out.println("Result: " + result);
            System.out.println("Type: " + jsonObject.getString("message_type"));
            System.out.println("Text: " + jsonObject.getString("message_text"));
            switch (result) {
                case 1:
                    JSONArray jsonArray = jsonObject.getJSONArray("task_list");
                    System.out.println("Task list:");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        System.out.println((i + 1) + ") " + jsonArray.get(i));
                    }
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
    }
}