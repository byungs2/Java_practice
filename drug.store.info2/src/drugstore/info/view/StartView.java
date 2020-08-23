package drugstore.info.view;


import drugstore.info.controller.Controller;
import drugstore.info.dto.DrugStoreData;
public class StartView {
	
	public static void main(String[] args) {
		Controller controller = Controller.getInstance();
		
		//검색( 동이름 , 마스크 개수)
		System.out.println("\n지명과 마스크 개수로 약국 검색");
		controller.search("구미동", 70);
		//예외처리
		//1. 지명이 없을 때
		System.out.println("\n지명이 없을때 예외 처리");
		controller.search("빠이쁘동", 50);
		//2. 지명이 있는 경우에 마스크 수량이 없는 경우
		System.out.println("\n지명은 있지만 마스크 수량이 없을 때");
		controller.search("구미동", 250);
		//3. null값 입력
		System.out.println("\n null값 입력 했을 때");
		controller.search(null, 0);
		
		
		//새로 저장 
		DrugStoreData newstore = new DrugStoreData("성북구","파이쁘약국","010-2067-9386","성북구 안암동 1가 17 옥탑 (안암동,옥탑 파이쁘 타워)",34);
		DrugStoreData newstore3 = new DrugStoreData("분당구",	"가까운 약국","031-712-7300","경기도 성남시 분당구 돌마로 68, 403-1호 (구미동, 분당프라자)",12);
		controller.search("빠이쁘동",1);
		controller.delete("파이쁘약국");
		controller.insert(newstore);
		System.out.println("\n저장 후 검색");
		controller.search("빠이쁘동",1);
		controller.search("안암동", 1);
		//예외처리
		//1. 중복 저장
		System.out.println("\n중복 저장 테스트");
		controller.insert(newstore3);
		//2. null값 입력
		System.out.println("\n null 입력 테스트");
		controller.insert(null);

		
		//업데이트 (멤버변수의 마지막 인덱스 수정)
		System.out.println("\n수정 시도");
		controller.upDate("알파약국", 50);
		System.out.println("\n수정 후 검색 시도");
		controller.search("알파약국",1);
		//예외처리
		//1. null값 입력
		System.out.println("\nNull 입력 후 수정 시도");
		controller.upDate(null, 3);
		//2. 존재하지 않는 약국 수정 시도
		System.out.println("\n존재하지 않는 약국 수정 시도");
		controller.upDate("금단의약국", 25);
		
		
		
		//삭제 (두번째 인덱스로 검색해서 전체 삭제)
		System.out.println("\n검색 후 삭제");
		controller.delete("토지공사약국");
		
		//삭제 후 검색
		System.out.println("\n삭제 후 검색");
		controller.search("구미동", 70);
		
		//예외처리
		//1. null 값의 경우
		System.out.println("\n null 입력시 출력");
		controller.delete(null);
		//2. 존재하지 않는 약국 삭제 시도
		System.out.println("\n 존재하지 않는 약국 삭제 시도");
		controller.delete("빠이쁘 약국");
		
		
	}
}
