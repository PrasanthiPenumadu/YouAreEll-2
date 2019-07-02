package models;

/* 
 * POJO for an Message object
 */
public class Message {
    private String message;
    private String fromid;
    private String toid;
    private String sequence;
    private String timestamp;

    public Message(){}
//    public Message (String message, String fromId, String toId) {
//        this.fromId=fromId;
//        this.message=message;
//        this.toId=toId;
//    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromId(String fromId) {
        this.fromid = fromId;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toId) {
        this.toid = toId;
    }
    @Override
    public  String toString(){
      String result="sequence: "+this.getSequence()+"\n"+
              "timestamp: "+this.getTimestamp()+"\n"+
                "fromid: "+this.getFromid()+"\n"+
                "toid: "+this.getToid()+"\n"+
                "message: "+this.getMessage() ;
      return result;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}