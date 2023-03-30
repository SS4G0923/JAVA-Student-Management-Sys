
public class Student {
    
    private String id;
    private String name;
    private int age;
    private String adress;

    public Student(){

    }

    public Student(String id,String name,int age,String adress){
        this.id = id;
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getAdress(){
        return adress;
    }

    public void setAdress(String adress){
        this.adress = adress;
    }

    public void MainSystem() {
    }
}
