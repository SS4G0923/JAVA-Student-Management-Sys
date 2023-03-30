
import java.util.ArrayList;
import java.util.Scanner;

public class TheSystem {
    public static void MainSystem() {
        System.out.println("-------------欢迎来到学生管理系统----------------");
        System.out.println("1: 添加学生");
        System.out.println("2: 删除学生");
        System.out.println("3: 修改学生");
        System.out.println("4: 查询学生");
        System.out.println("5: 退出");

        Scanner sc = new Scanner(System.in);
        
        ArrayList <Student> list = new ArrayList<>();
        
        while(true){   
            System.out.println("请输入您的选择:");
            String option = sc.next();
            switch(option){
            case "1" -> AddStudent(list);
            case "2" -> DeleteStudent(list);
            case "3" -> ChangeStudent(list);
            case "4" -> QueryStudent(list);
            case "5" -> System.exit(0);
            default  -> System.out.print("请重新输入,");
            }
        }
    }

    public static void AddStudent(ArrayList<Student> list){
        Student stu = new Student();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入学生ID");
            String id = sc.next();
            if(!contains(list, id)){
                stu.setId(id);
                break;
            }else{
                System.out.println("学生ID重复, 请重新添加");
            }
        }
        System.out.println("请输入学生姓名");
        String name = sc.next();
        stu.setName(name);

        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        stu.setAge(age);

        System.out.println("请输入家庭住址");
        String adress = sc.next();
        stu.setAdress(adress);

        list.add(stu);
        System.out.println("添加成功");

        return;
    }


    public static void DeleteStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生ID");
        String id = sc.next();
        
        if(contains(list,id)){
            list.remove(getIndex(list, id));
            System.out.println("删除成功");
        }else{
            System.out.println("你输入的ID不存在");
        }

        return;
    }

    public static void QueryStudent(ArrayList<Student> list){
        System.out.println("id\t"+"姓名\t"+"\t"+"年龄\t"+"家庭住址\t");
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).getId() +"\t"+ list.get(i).getName() +"\t"+ list.get(i).getAge() +"\t"+ list.get(i).getAdress());
        }
    }

    public static void ChangeStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生ID");
        String id = sc.next();

        if(!contains(list, id)){
            System.out.println("你输入的ID不存在");
            return;
        }

        int index = getIndex(list, id);
        System.out.println("请输入新的姓名");
        list.get(index).setName(sc.next());
        System.out.println("请输入新的年龄");
        list.get(index).setAge(sc.nextInt());
        System.out.println("请输入新的家庭住址");
        list.get(index).setAdress(sc.next());

        System.out.println("修改成功");

        return;

    }

    public static boolean contains(ArrayList<Student> list, String key){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals((key)))
                return true;
        }
        return false;
    }

    public static int getIndex(ArrayList<Student> list, String key){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals((key)))
                return i;
        }
        return -1;
    }
}
