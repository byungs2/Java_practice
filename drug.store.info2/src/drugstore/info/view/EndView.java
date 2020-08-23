package drugstore.info.view;

import java.util.List;

import org.apache.log4j.Logger;

import drugstore.info.dto.DrugStoreData;

public class EndView {
	Logger log = Logger.getRootLogger();
	public static void storeView(List<DrugStoreData> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}else{
			System.out.println("찾으시는 수량의 마스크 재고를 보유한 약국이 없습니다.");
		}

	}

	public static void messageView(String string) {
		System.out.println(string);
	}
}
