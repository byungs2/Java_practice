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
			System.out.println("ã���ô� ������ ����ũ ��� ������ �౹�� �����ϴ�.");
		}

	}

	public static void messageView(String string) {
		System.out.println(string);
	}
}
