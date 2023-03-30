package StuInfoManagementSys;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.println("欢迎来到学生管理系统");
        Scanner sc = new Scanner(System.in);
        ArrayList<User> list = new ArrayList<>();
        
        while(true){
            System.out.println("请选择操作1登录 2注册 3忘记密码");
            String option = sc.next();
            switch(option){
                case"1" -> Login(list);
                case"2" -> Register(list);
                case"3" -> ForgetPassword(list);
                default -> System.out.print("请重新选择，");
            }
        }
    }    
    
    
    public static void Login(ArrayList<User> list){
        System.out.println("请输入用户名");
        Scanner sc = new Scanner(System.in);
        String UserName = sc.next();
        if(!contains(list, UserName)){
            System.out.println("用户名未注册，请先注册");
            return;
        }
        System.out.println("请输入密码");
        String Password = sc.next();
        
        while(true){
            String code = VerifyCode();
            System.out.println("请输入验证码：" + code);
            String code2 = sc.next();
            if(!code.equalsIgnoreCase(code2)){
                System.out.println("验证码输入错误");
                continue;
            }
            break;
        }

        int count = 0;
        while(true){
            int index = getIndex(list, UserName);
            if(!(UserName.equals(list.get(index).getUserName())&&Password.equals(list.get(index).getPassword()))){
                if(count==2)
                    return;
                System.out.println("用户名或密码错误,请重新输入用户名和密码，你还有"+(2-count)+"次机会");
                UserName = sc.next();
                System.out.println("请输入密码");
                Password = sc.next();
                count++;
                continue;
            }
            break;
        }

        System.out.println("登陆成功");

        TheSystem.MainSystem();
    }

    public static void Register(ArrayList<User> list){
        User u = new User();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入用户名");
            String UserName = sc.next();
            int length = UserName.length();
            int count = 0;
            if(!(length >= 3 && length <= 15)){
                System.out.println("用户名长度必须在3~15位之间");
                continue;
            }
            for(int i = 0; i<length;i++){
                char ch = UserName.charAt(i);
                if((ch >= 'a' && ch <='z')||(ch >= 'A' && ch <= 'Z')){
                    count++;
                }
            }
            if(count==0){
                System.out.println("用户名不能是纯数字");
                continue;
            }
            u.setUserName(UserName);
            break;
        }

        while(true){
            System.out.println("请输入密码");
            String password1 = sc.next();
            System.out.println("请再次输入密码");
            String password2 = sc.next();
            if(password1.equals(password2))
                u.setPassword(password1);
            else{
                System.out.print("两次输入的密码不一致,");
                continue;
            }
            break;
        }

        while(true){
            int count1 = 0; int count2 = 0;
            System.out.println("请输入身份证号");
            String UserID = sc.next();
            if(UserID.length()!=18||(UserID.startsWith("0"))){
                System.out.println("格式不合法");
                continue;
            }
            for(int i = 0;i<UserID.length()-1;i++){
                char digit = UserID.charAt(i);
                char last_digit = UserID.charAt(UserID.length()-1);
                if(!(digit>='0'&&digit<='9')){
                    count1++;
                }
                if(!((last_digit>='0'&&last_digit<='9')||last_digit=='x'||last_digit=='X'))
                    count2++;
                if(count1!=0||count2!=0){
                    System.out.println("格式不合法");
                    continue;
                }
            }
            u.setUserID(UserID);
            break;            
        }

        while(true){
            int count = 0;
            System.out.println("请输入手机号");
            String PhoneNumber = sc.next();
            if(PhoneNumber.length()!=11||PhoneNumber.startsWith("0")){
                System.out.println("手机号格式不合法");
                continue;
            }
            for (int i = 0; i < PhoneNumber.length(); i++) {
                char digit = PhoneNumber.charAt(i);
                if(!(digit>='0'&&digit<='9')){
                    count++;
                }
                if(count!=0){
                    System.out.println("手机号格式不合法");
                    continue;
                }
            }
            u.setPhoneNumber(PhoneNumber);
            break;
        }
        list.add(u);
        System.out.println("注册成功");
    }

    public static void ForgetPassword(ArrayList<User> list){
        System.out.println("请输入要找回账号的用户名");
        Scanner sc = new Scanner(System.in);
        String UserName = sc.next();
        if(!contains(list, UserName)){
            System.out.println("未注册");
            return;
        }
        System.out.println("请输入身份证号");
        String UserID = sc.next();
        System.out.println("请输入手机号码");
        String PhoneNumber = sc.next();

        int index = getIndex(list, UserName);
        if(!(UserID.equals(list.get(index).getUserID()) && PhoneNumber.equals(list.get(index).getPhoneNumber()))){
            System.out.println("账号信息不匹配，更改失败");
            return;
        }
        System.out.println("请输入新密码");
        String NewPassword = sc.next();
        list.get(index).setPassword(NewPassword);
        System.out.println("更改成功");
    }

    public static boolean contains(ArrayList<User> list, String key){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUserName().equals((key)))
                return true;
        }
        return false;
    }

    public static int getIndex(ArrayList<User> list, String key){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUserName().equals((key)))
                return i;
        }
        return -1;
    }

    public static String VerifyCode(){
        Random r = new Random();
        char[] letters = new char[52];
        char[] result1 = new char[5];
        String result2;
        int j = 0;
        
        for(int i=0; i<52; i++){
            letters[i] = (char)((int)'a'+ j);
            letters[i+1] = (char)((int)'A'+ j);
            i++; 
            j++;
        }
    
        for(int i=0;i<4;i++){
            result1[i]=letters[r.nextInt(52)];
        }

        result1[4] = (char)(r.nextInt(10)+48);
        
        for(int i=0;i<5;i++){
            int num = r.nextInt(5);
            char temp = result1[i];
            result1[i] = result1[num];
            result1[num] = temp;
        }
        
        result2 = new String(result1);
        return result2;
    }
}


