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
			//这是节目管理系统的主界面
			System.out.println("------学生管理系统------");
			System.out.println(" 1.根据节目号查看该节目信息");
			System.out.println(" 2.查看所有节目信息");
			System.out.println(" 3.增加节目");
			System.out.println(" 4.删除节目");
			System.out.println(" 5.修改节目");
			System.out.println(" 6.退出");
			Scanner sc =new Scanner(System.in);
			System.out.println("请输入序号选择相应的功能：");
			String stufunction = sc.nextLine();
			switch (stufunction) {
			case "1":
				//根据节目号查看该节目信息
				System.out.println("请输入要查询的节目号");
				String pid = sc.nextLine();
				pr = sd.findProgramByPid(pid);
				System.out.println(pr.getPid() + " " + pr.getPname());
				System.out.println();
				break;
				
			case "2":
				//查看所有节目信息
				Vector<Program> v = sd.findAllProgram();
				for(Program i : v)
					System.out.println(i.getPid() + " " + i.getPname());
				System.out.println();
				break;
				
			case "3":
				//增加节目
				System.out.println("请输入节目号");
				String pid1 = sc.nextLine();
				
				System.out.println("请输入节目名");
				String pname = sc.nextLine();
				
//				System.out.println("请输入表演者");
//				String performer = sc.nextLine();
				
//				pr.setPerformer(performer);
				pr.setPid(pid1);
				pr.setPname(pname);
				
				sd.insertInfoToProgram(pr);
				System.out.println("节目添加成功！");
				System.out.println();
				break;
				
			case "4":
				//删除节目
				System.out.println("请输入要删除的节目号");
				String pid2 = sc.nextLine();
				
				pr.setPid(pid2);
				sd.deletePro(pid2);
				System.out.println("节目删除成功！");
				System.out.println();
				break;
				
			case "5":
				//修改节目
				System.out.println("请输入要修改的节目号");
				String pid3 = sc.nextLine();
				
				System.out.println("请输入新节目名");
				String pname3 = sc.nextLine();
				
//				System.out.println("请输入新表演者");
//				String performer3 = sc.nextLine();
				
				pr.setPid(pid3);
				pr.setPname(pname3);
//				pr.setPerformer(performer3);
				
				sd.updateStu(pr);
				System.out.println("节目信息修改成功！");
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
