package cn.edu.lingnan.test;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.User;

public class UserText {

	public static void main(String[] args) {
		UserDAO sd = new UserDAO();
		User  ur = new User();
		while(true) {
			//这是节目管理系统的主界面
			System.out.println("------节目管理系统------");
			System.out.println(" 1.根据用户名和密码查看该用户是否存在");
			System.out.println(" 2.查看所有用户信息");
			System.out.println(" 3.增加用户");
			System.out.println(" 4.删除用户");
			System.out.println(" 5.修改用户");
			System.out.println(" 6.退出");
			Scanner sc =new Scanner(System.in);
			System.out.println("请输入序号选择相应的功能：");
			String stufunction = sc.nextLine();
			switch (stufunction) {
//			case "1":
//				//按用户名和密码查找用户
//				System.out.println("请输入用户名");
//				String _name = sc.nextLine();
//				System.out.println("请输入密码");
//				String _password = sc.nextLine();
//				ur = sd.findUserByNameAndPassword(_name,_password);
//				System.out.println(ur.getUid() + " " + ur.getUname() + " " + ur.getPassword() + " " + ur.getSuperuser());
//				System.out.println();
//				break;
				
			case "2":
				//查看所有用户信息
				Vector<User> v = sd.findAllUser();
				for(User i : v)
					System.out.println(i.getUid() + " " + i.getUname() + " " + i.getPassword() + " " + i.getSuperuser());
				System.out.println();
				break;
				
			case "3":
				//增加节目
				System.out.println("请输入用户ID");
				String uid1 = sc.nextLine();
				
				System.out.println("请输入用户名");
				String uname = sc.nextLine();
				
				System.out.println("请输入密码");
				String password = sc.nextLine();
				
				System.out.println("请输入权限");
				int superuser = sc.nextInt();
				
				ur.setUid(uid1);
				ur.setUname(uname);
				ur.setPassword(password);
				ur.setSuperuser(superuser);

				
				sd.insertInfoToUser(ur);
				System.out.println("用户添加成功！");
				System.out.println();
				break;
				
			case "4":
				//删除用户
				System.out.println("请输入要删除的用户号");
				String uid2 = sc.nextLine();
				
				ur.setUid(uid2);
				sd.deleteUser(uid2);
				System.out.println("用户删除成功！");
				System.out.println();
				break;
				
			case "5":
				//修改用户信息
				System.out.println("请输入要修改的用户ID");
				String uid3 = sc.nextLine();
				
				System.out.println("请输入新用户名");
				String uname3 = sc.nextLine();
				
				System.out.println("请输入新密码");
				String password3 = sc.nextLine();
				
				System.out.println("请输入新权限");
				int superuser3 = sc.nextInt();
				
				ur.setUid(uid3);
				ur.setUname(uname3);
				ur.setPassword(password3);
				ur.setSuperuser(superuser3);

				sd.updateUser(ur);
				System.out.println("用户信息修改成功！");
				System.out.println();
				break;
				
			case "6":
				//退出
			default:
				System.out.println("谢谢你的使用.");
				System.exit(0);//退出JVM
				break;
			}
		}

	}
}


