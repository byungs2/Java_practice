package view;

import controller.Controller;
import modelDTO.TeamScore;

public class StartView {
	public static void main(String[] args) {
		
		//참가 팀 목록 수정 (Update)
		System.out.println("\n*** KBO팀 목록 업데이트 (팀 목록 수정 전) ***");
		Controller.selectAll();
		System.out.println("\n*** KBO팀 목록 업데이트 (팀 목록 수정 후) ***");
		System.out.println(Controller.updateTeam("LG 트윈스", "롯데 자이언츠"));
		Controller.selectAll();
		
		//플레이오프 진출 못한 팀 삭제(Delete)
		System.out.println("\n*** 플레이오프 진출 탈락 팀 (팀 삭제)***");
		System.out.println(Controller.deleteTeam("롯데 자이언츠"));
		
		//새로운 팀 추가 (Create)
		System.out.println("\n*** KBO팀 소개 (새로운 팀 추가 전) ***");
		Controller.selectAll();
		System.out.println("\n*** KBO팀 소개 (새로운 팀 추가 후) ***");
		Controller.insertTeam(new TeamScore("LG 트윈스"));
		Controller.insertTeam(new TeamScore("KT 위즈"));
		Controller.insertTeam(new TeamScore("삼성 라이온즈"));
		Controller.selectAll();
		
		//경기 시작 (Read)
		  System.out.println("\n*** 2020 KBO 플레이오프 개막 뿜뿜뿜뿜  ***");
	      System.out.println("\n*** 8강 1경기 ***");
	      Controller.changeList();
	      Controller.getRandomTeam();

	      System.out.print(Controller.firTeam);//1팀
	      System.out.print(" vs ");
	      System.out.println(Controller.secTeam);
	      
	      Controller.getRandomNum();
	      Controller.getWinner();
	      Controller.getFirWinner();


	      System.out.println(" -----------------------------------------");
	      

	      System.out.println("\n*** 8강 2경기 ***");
	      Controller.getRandomTeam();

	      System.out.print(Controller.firTeam);//1팀
	      System.out.print(" vs ");
	      System.out.println(Controller.secTeam);
	      
	      Controller.getRandomNum();
	      Controller.getWinner();
	      Controller.getSecWinner();


	      System.out.println(" -----------------------------------------");
	      
	      System.out.println("\n*** 8강 3경기 ***");
	      Controller.getRandomTeam();

	      System.out.print(Controller.firTeam);//1팀
	      System.out.print(" vs ");
	      System.out.println(Controller.secTeam);
	      
	      Controller.getRandomNum();
	      Controller.getWinner();
	      Controller.getThirdWinner();

	      System.out.println("-----------------------------------------");
	      
	      System.out.println("\n*** 8강 4경기 ***");
	      Controller.getRandomTeam();

	      System.out.print(Controller.firTeam);//1팀
	      System.out.print(" vs ");
	      System.out.println(Controller.secTeam);
	      
	      Controller.getRandomNum();
	      Controller.getWinner();
	      Controller.getfourthWinner();


	      System.out.println(" -----------------------------------------");
	      
	      System.out.println("\n*** 4강 1경기 ***");
	      Controller.firTeam = Controller.firWinTeam;
	      Controller.secTeam = Controller.secWinTeam;
	      Controller.versusTeam();
	
	      Controller.getRandomNum();
	      Controller.getTotalNum();
	      Controller.getWinner();
	      Controller.getFirFinalTeam();

	      System.out.println("-----------------------------------------");

	      System.out.println("\n*** 4강 2경기 ***");
	      Controller.firTeam = Controller.thirdWinTeam;
	      Controller.secTeam = Controller.fourthWinTeam;
	      Controller.versusTeam();

	      Controller.getRandomNum();
	      Controller.getTotalNum();
	      Controller.getWinner();
	      Controller.getSecFinalTeam();

	      System.out.println("-----------------------------------------");

	      System.out.println("\n*** !!한국 시리즈 결승전!! ***");
	      Controller.firTeam = Controller.firFinalTeam;
	      Controller.secTeam = Controller.secFinalTeam;
	      Controller.versusTeam();

	      Controller.getRandomNum();
	      Controller.getTotalNum();
	      System.out.println("\n~~~ 한국시리즈  우승팀 ~~~");

			System.out.println("\n~~~ 두 구 두 구 ~~~");

			System.out.println("\n!!! 뿜 뿜 뿜 뿜 !!!");

	      Controller.getWinner();
	      
	   }

		
	}

