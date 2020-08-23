package model;

import java.util.ArrayList;
import java.util.Random;

import modelDTO.TeamScore;

public class TeamDAO {
	private static TeamScore[] kboTeam;
	   private static TeamDAO instance = new TeamDAO(); // singleton design pattern
	   public static ArrayList<String> list = new ArrayList<>();
	   //리스트에 직접 TeamScore 타입 변수 입력
	// 배열에 저장된 데이터 개수와 index 구분을 위한 변수
	   public static int count = 5;
	   public static int ranNum;
	   public static int firtotalnum;
	   public static int sectotalnum;
	   public static int firTeam;
	   public static int secTeam;
	   static int [] firscore = new int[9];
	   static int [] secscore = new int[9];

	private TeamDAO() {}
	
	public static TeamDAO getInstance() {
		return instance;
	}
	
	 // byte code가 메모리에 로딩시 단 한번만 실행 보장
	   // 개발자가 명시적으로 호출 불가능 왜? 이름이 없다
	   static {
	      kboTeam = new TeamScore[] { new TeamScore("한화 이글스"),
							            new TeamScore("기아 타이거스"),
							            new TeamScore("NC 다이노스"),
							            new TeamScore("SK 와이번스"),
							            new TeamScore("두산 베어스"),
							            new TeamScore("LG 트윈스"),null,null};
	   }

	
	//팀 배열에 저장
	public void insert(TeamScore v) {
		kboTeam[count++] = v;
	}
	
	// 팀명으로 배열 데이터 삭제
	   public String delete(String team) {
	      for (int i = 0; i < kboTeam.length; i++) {
	         if (kboTeam[i].getTeam().equals(team)) {// id1과 id2 비교 -> true -> 삭제 -> 메소드 종료되버림
	            kboTeam[i] = null;
	            return team + " 플레이오프 탈락";
	         }
	      }
	      return "삭제하고자 하는 team이 없네용"; // if블록 즉 return 실행이 안되었을 때만 실행되는 line
	   }

	   // 팀명 바꾸기 (기존팀명team, 바꿀팀명newName)
	   public String update(String team, String newName) {
	      for (int i = 0; i < kboTeam.length; i++) {
	         if (kboTeam[i].getTeam().equals(team)) {
	            kboTeam[i].setTeam(newName);
	            return team + " 에서" + newName + "(으)로 변경 성공!";
	         }
	      }
	      return "기존에 존재하지 않는 팀이라 못바꿔요ㅠ";
	   }

	   // 배열 모두 반환
	   public TeamScore[] selectAll() {
	      return kboTeam;
	   }

	   public void changeList() {
	      for(int i=0; i<kboTeam.length; i++) {
	         list.add(kboTeam[i].getTeam());
	      }
	      System.out.println();
	      
	   }
	   
	   public String RandomTeam() {
	      Random random = new Random();
	      ranNum = random.nextInt(count);
	      return list.get(ranNum);
//	      list.remove(ranNum);
//	      System.out.println("삭제! "+list);
//	      count--;
	   }
	   public static void removeList(String team) {
	      list.remove(ranNum);
	      count--;
	   }
	   //점수가 3점을 넘기는 경우 
	   public void randomNum() {
	      Random random = new Random();

	      for(int i=0; i<9; i++) {
	         firscore[i] = random.nextInt(3);
	         secscore[i] = random.nextInt(3);
	         firtotalnum += firscore[i];
	         sectotalnum += secscore[i];
	         System.out.println("<"+(i+1)+"회> "+firscore[i]+"  :  "+secscore[i]);
	      }
	   }
	   
	   public int totalNum() {
	      System.out.println("--- 총점 ---");
	      
	      System.out.println(firtotalnum+"  :  "+sectotalnum);
	      if(firtotalnum > sectotalnum) {
	         return firtotalnum;
	      }
	      return sectotalnum;
	   }
	   
}
