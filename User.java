package StuInfoManagementSys;

public class User {
    private String UserName;
    private String Password;
    private String UserID;
    private String PhoneNumber;

    public User(){

    }

    public User(String UserNme, String Password,String UserID, String PhoneNumber){
        this.UserName = UserNme;
        this.Password = Password;
        this.UserID = UserID;
        this.PhoneNumber = PhoneNumber;
    }

    public String getUserName(){
        return UserName;
    }

    public String getPassword(){
        return Password;
    }

    public String getUserID(){
        return UserID;
    }

    public String getPhoneNumber(){
        return PhoneNumber;
    }

    public void setUserName(String UserName){
        this.UserName = UserName;
    }

    public void setPassword(String Password){
        this.Password = Password;
    }

    public void setUserID(String UserID){
        this.UserID = UserID;
    }

    public void setPhoneNumber(String PhoneNumber){
        this.PhoneNumber = PhoneNumber;
    }


}
