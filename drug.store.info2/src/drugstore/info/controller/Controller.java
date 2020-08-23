package drugstore.info.controller;

import org.apache.log4j.Logger;

import drugstore.info.dto.DrugStoreData;
import drugstore.info.exception.DuplExcept;
import drugstore.info.exception.NotExcept;
import drugstore.info.service.DrugStoreService;
import drugstore.info.view.EndView;
import drugstore.info.view.FailView;

public class Controller {
	Logger log = Logger.getRootLogger();
	private static Controller instance = new Controller();
	private DrugStoreService service = DrugStoreService.getInstance();

	public static Controller getInstance() {
		return instance;
	}

	public void search(String string, int i) {
		if (string != null) {
			if (service.getDrugStore(string) != null) {
				EndView.storeView(service.getDrugStoreList(string, i));
			} else {
				log.debug("Unmatched String Input");
				EndView.messageView("입력한 지명과 일치하는 정보가 없습니다.");
			}
		} else {
			log.debug("Null Error!!");
			EndView.messageView("잘못된 입력입니다.");
		}
	}

	public void insert(DrugStoreData newStore) {
		if(newStore != null) {
			try {
				service.insertDrugStore(newStore);
				EndView.messageView("새로운 약국 등록 성공!");
			} catch (DuplExcept d) {
				FailView.failMessageView(d.getMessage());
			}
		}else {
			EndView.messageView("잘못된 입력입니다");
		}
	

	}
	//upDate 수정 필요;;
	public void upDate(String string, int i) {
		if (string != null && i != 0) {
			try{
				service.upDate(string, i);
				EndView.messageView("수정 성공!");
			}catch(NotExcept n) {
				FailView.failMessageView(n.getMessage());
			}
		} else {
			EndView.messageView("잘못된 입력입니다");
		}
	}

	public void delete(String string) {
		if (string != null) {
			try {

				service.deleteStore(string);
				log.trace("Complete Delete!");
				EndView.messageView("삭제 성공");

			} catch (NotExcept n) {
				FailView.failMessageView(n.getMessage());
			}
		} else {
			log.debug("Null Error!!");
			EndView.messageView("잘못된 입력입니다.");

		}
	}
}
