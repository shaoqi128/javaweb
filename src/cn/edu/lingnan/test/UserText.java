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
			//���ǽ�Ŀ����ϵͳ��������
			System.out.println("------��Ŀ����ϵͳ------");
			System.out.println(" 1.�����û���������鿴���û��Ƿ����");
			System.out.println(" 2.�鿴�����û���Ϣ");
			System.out.println(" 3.�����û�");
			System.out.println(" 4.ɾ���û�");
			System.out.println(" 5.�޸��û�");
			System.out.println(" 6.�˳�");
			Scanner sc =new Scanner(System.in);
			System.out.println("���������ѡ����Ӧ�Ĺ��ܣ�");
			String stufunction = sc.nextLine();
			switch (stufunction) {
//			case "1":
//				//���û�������������û�
//				System.out.println("�������û���");
//				String _name = sc.nextLine();
//				System.out.println("����������");
//				String _password = sc.nextLine();
//				ur = sd.findUserByNameAndPassword(_name,_password);
//				System.out.println(ur.getUid() + " " + ur.getUname() + " " + ur.getPassword() + " " + ur.getSuperuser());
//				System.out.println();
//				break;
				
			case "2":
				//�鿴�����û���Ϣ
				Vector<User> v = sd.findAllUser();
				for(User i : v)
					System.out.println(i.getUid() + " " + i.getUname() + " " + i.getPassword() + " " + i.getSuperuser());
				System.out.println();
				break;
				
			case "3":
				//���ӽ�Ŀ
				System.out.println("�������û�ID");
				String uid1 = sc.nextLine();
				
				System.out.println("�������û���");
				String uname = sc.nextLine();
				
				System.out.println("����������");
				String password = sc.nextLine();
				
				System.out.println("������Ȩ��");
				int superuser = sc.nextInt();
				
				ur.setUid(uid1);
				ur.setUname(uname);
				ur.setPassword(password);
				ur.setSuperuser(superuser);

				
				sd.insertInfoToUser(ur);
				System.out.println("�û���ӳɹ���");
				System.out.println();
				break;
				
			case "4":
				//ɾ���û�
				System.out.println("������Ҫɾ�����û���");
				String uid2 = sc.nextLine();
				
				ur.setUid(uid2);
				sd.deleteUser(uid2);
				System.out.println("�û�ɾ���ɹ���");
				System.out.println();
				break;
				
			case "5":
				//�޸��û���Ϣ
				System.out.println("������Ҫ�޸ĵ��û�ID");
				String uid3 = sc.nextLine();
				
				System.out.println("���������û���");
				String uname3 = sc.nextLine();
				
				System.out.println("������������");
				String password3 = sc.nextLine();
				
				System.out.println("��������Ȩ��");
				int superuser3 = sc.nextInt();
				
				ur.setUid(uid3);
				ur.setUname(uname3);
				ur.setPassword(password3);
				ur.setSuperuser(superuser3);

				sd.updateUser(ur);
				System.out.println("�û���Ϣ�޸ĳɹ���");
				System.out.println();
				break;
				
			case "6":
				//�˳�
			default:
				System.out.println("лл���ʹ��.");
				System.exit(0);//�˳�JVM
				break;
			}
		}

	}
}


