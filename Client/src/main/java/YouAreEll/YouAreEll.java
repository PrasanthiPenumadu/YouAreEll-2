package YouAreEll;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.*;
import models.Id;
import models.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class YouAreEll {

    private MessageController msgCtrl;
    private IdController idCtrl;

    public YouAreEll (MessageController m, IdController j) {
        // used j because i seems awkward
        this.msgCtrl = m;
        this.idCtrl = j;
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(new MessageController(), new IdController());
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonpayload = "";
        try {
            Id id = new Id();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return MakeURLCall("/ids", "GET", "");
    }

    public String postuser_id(String[] commands) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonpayload = "";
        try {
            Id id = new Id();
            id.setName(commands[1]);
            id.setGithubId(commands[2]);
            jsonpayload = mapper.writeValueAsString(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return MakeURLCall("/ids", "POST", jsonpayload);
    }
    public String put_id(String[] commands) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonpayload = "";
        try {
            Id id = new Id();
            id.setUserid(commands[1]);
            id.setName(commands[2]);
            id.setGithubId(commands[3]);
          //  id.getGithub();//GithubId(commands[2]);
            jsonpayload = mapper.writeValueAsString(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return MakeURLCall("/ids", "PUT", jsonpayload);
    }

    public String get_messages() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonpayload = "";
        try {
            Message message = new Message();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return MakeURLCall("/messages", "GET", "");
    }
    public String post_Messages(String[] commands) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonpayload = "";
        try {
            Message message = new Message();
            message.setFromId(commands[1]);
            message.setToid(commands[4]);
            message.setMessage(commands[2]);
            jsonpayload = mapper.writeValueAsString(message);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return MakeURLCall("/ids/PrasanthiPenumadu/messages", "POST", jsonpayload);
    }

    public String MakeURLCall(String mainurl, String method, String jpayload) {
        StringBuilder jsonresponse = new StringBuilder();
        try {

            URL url = new URL("http://zipcode.rocks:8085" + mainurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            if (method == "POST"){
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
           writer.write(jpayload);
           writer.close();}
                if(method=="PUT"){
                    OutputStreamWriter writer=new OutputStreamWriter(connection.getOutputStream());
                    writer. write(jpayload);
                    writer.flush();
                    writer.close();
                }
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String jsoninputline ;
            while ((jsoninputline = bufferedReader.readLine()) != null){
                jsonresponse.append(jsoninputline);
                System.out.println(jsoninputline);
            }
            bufferedReader.close();
            connection.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonresponse.toString();
    }
}
