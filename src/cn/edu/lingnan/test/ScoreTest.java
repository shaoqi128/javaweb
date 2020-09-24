package cn.edu.lingnan.test;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dao.ProgramDAO;
import cn.edu.lingnan.dto.Program;

public class ScoreTest {

	public static void main(String[] args) {
		ProgramDAO sd = new ProgramDAO();
		Program  pr = new Program();
		//System.out.println(sd.deleteStu("s01"));	
		while(true) {
			//���ǽ�Ŀ����ϵͳ��������
			System.out.println("------ѧ������ϵͳ------");
			System.out.println(" 1.���ݽ�Ŀ�Ų鿴�ý�Ŀ��Ϣ");
			System.out.println(" 2.�鿴���н�Ŀ��Ϣ");
			System.out.println(" 3.���ӽ�Ŀ");
			System.out.println(" 4.ɾ����Ŀ");
			System.out.println(" 5.�޸Ľ�Ŀ");
			System.out.println(" 6.�˳�");
			Scanner sc =new Scanner(System.in);
			System.out.println("���������ѡ����Ӧ�Ĺ��ܣ�");
			String stufunction = sc.nextLine();
			switch (stufunction) {
			case "1":
				//���ݽ�Ŀ�Ų鿴�ý�Ŀ��Ϣ
				System.out.println("������Ҫ��ѯ�Ľ�Ŀ��");
				String pid = sc.nextLine();
				pr = sd.findProgramByPid(pid);
				System.out.println(pr.getPid() + " " + pr.getPname());
				System.out.println();
				break;
				
			case "2":
				//�鿴���н�Ŀ��Ϣ
				Vector<Program> v = sd.findAllProgram();
				for(Program i : v)
					System.out.println(i.getPid() + " " + i.getPname());
				System.out.println();
				break;
				
			case "3":
				//���ӽ�Ŀ
				System.out.println("�������Ŀ��");
				String pid1 = sc.nextLine();
				
				System.out.println("�������Ŀ��");
				String pname = sc.nextLine();
				
//				System.out.println("�����������");
//				String performer = sc.nextLine();
				
//				pr.setPerformer(performer);
				pr.setPid(pid1);
				pr.setPname(pname);
				
				sd.insertInfoToProgram(pr);
				System.out.println("��Ŀ��ӳɹ���");
				System.out.println();
				break;
				
			case "4":
				//ɾ����Ŀ
				System.out.println("������Ҫɾ���Ľ�Ŀ��");
				String pid2 = sc.nextLine();
				
				pr.setPid(pid2);
				sd.deletePro(pid2);
				System.out.println("��Ŀɾ���ɹ���");
				System.out.println();
				break;
				
			case "5":
				//�޸Ľ�Ŀ
				System.out.println("������Ҫ�޸ĵĽ�Ŀ��");
				String pid3 = sc.nextLine();
				
				System.out.println("�������½�Ŀ��");
				String pname3 = sc.nextLine();
				
//				System.out.println("�������±�����");
//				String performer3 = sc.nextLine();
				
				pr.setPid(pid3);
				pr.setPname(pname3);
//				pr.setPerformer(performer3);
				
				sd.updateStu(pr);
				System.out.println("��Ŀ��Ϣ�޸ĳɹ���");
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
