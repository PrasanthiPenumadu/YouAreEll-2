package models;

import java.util.UUID;

/*
 * POJO for an Id object
 */
public class Id {
private String userid ;
private String name;
private String github;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithub() {
        return github;
    }

    public void setGithubId(String githubId) {
        this.github = githubId;
    }
    @Override
    public String toString  (){
        String result = //"UnderARock Id has been succesfully created " + "\n" +
                "Id: "+ this.getUserid() +
                "\n" + "User name : " + this.getName() + "\n" + "Github Id : " + this.getGithub();
        return result;
    }



}