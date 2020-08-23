package controller;

import model.TeamDAO;
import modelDTO.TeamScore;
import view.EndView;

public class Controller {
	private static TeamDAO homerun = TeamDAO.getInstance();
	public static String firTeam;
	public static String secTeam;
	
	public static String firWinTeam;
	public static String secWinTeam;
	public static String thirdWinTeam;
	public static String fourthWinTeam;

	public static String firFinalTeam;
	public static String secFinalTeam;

	public static String winnerTeam;
	
	//참가 팀 소개
	public static void selectAll() {
		EndView.printAllTeams(homerun.selectAll());
	}
	
	//참가 팀 목록 수정
	public static String updateTeam(String team, String newName) {
		return homerun.update(team, newName);
	}
	
	//새로운 팀 저장
	public static void insertTeam(TeamScore newTeam) {
		homerun.insert(newTeam);
	}
	
	//플레이오프 진출 못한팀 삭제
	public static String deleteTeam(String team) {
		return homerun.delete(team);
	}
	
	//플레이오프 참가 팀 지정
	public static void getRandomTeam() {
	      firTeam = homerun.RandomTeam();
	      TeamDAO.removeList(firTeam);
	      secTeam = homerun.RandomTeam();
	      TeamDAO.removeList(secTeam);
	   }
	
	//경기당 팀 총점
	public static int totalScore() {
		return homerun.totalNum();
	}

	public static void changeList() {
		homerun.changeList();
		
	}
	
	public static void versusTeam() {
	    System.out.println(firTeam+" vs "+secTeam);
	}
	
	//총점 계산
	public static void getTotalNum() {
	      homerun.totalNum();
	}
	
	//1회당 팀 점수
	public static void getRandomNum() {
	      homerun.randomNum();
	}
	
	//총점 및 승리팀
	public static void getWinner() {
	      if (TeamDAO.firtotalnum > TeamDAO.sectotalnum) {
	         winnerTeam = firTeam;
	      }else {
	         winnerTeam = secTeam;
	      }
	      System.out.println(winnerTeam+" 승");
	      TeamDAO.firtotalnum = 0;
	      TeamDAO.sectotalnum = 0;
	   }
	
	///무승부에 관한 경우 
	//8강 1경기 승리팀
	public static void getFirWinner() {
	      firWinTeam = winnerTeam;
	      System.out.println(firWinTeam +" 4강 진출!");
	}
	//8강 2경기 승리팀
	public static void getSecWinner() {
	      secWinTeam = winnerTeam;
	      System.out.println(secWinTeam +" 4강 진출!");
	}
	//8강 3경기 승리팀
	public static void getThirdWinner() {
	      thirdWinTeam = winnerTeam;
	      System.out.println(thirdWinTeam +" 4강 진출!");
	}
	//8강 4경기 승리팀
	public static void getfourthWinner() {
	      fourthWinTeam = winnerTeam;
	      System.out.println(fourthWinTeam +" 4강 진출!");
	}
	//4강 1경기 승리팀
	public static void getFirFinalTeam() {
	      firFinalTeam = winnerTeam;
	      System.out.println(firFinalTeam +" 한국시리즈 진출!");
	}
	//4강 2경기 승리팀   
	public static void getSecFinalTeam() {
	      secFinalTeam = winnerTeam;
	      System.out.println(secFinalTeam +" 한국시리즈 진출!");
	}

}
