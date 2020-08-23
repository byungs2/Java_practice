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
				EndView.messageView("�Է��� ����� ��ġ�ϴ� ������ �����ϴ�.");
			}
		} else {
			log.debug("Null Error!!");
			EndView.messageView("�߸��� �Է��Դϴ�.");
		}
	}

	public void insert(DrugStoreData newStore) {
		if(newStore != null) {
			try {
				service.insertDrugStore(newStore);
				EndView.messageView("���ο� �౹ ��� ����!");
			} catch (DuplExcept d) {
				FailView.failMessageView(d.getMessage());
			}
		}else {
			EndView.messageView("�߸��� �Է��Դϴ�");
		}
	

	}
	//upDate ���� �ʿ�;;
	public void upDate(String string, int i) {
		if (string != null && i != 0) {
			try{
				service.upDate(string, i);
				EndView.messageView("���� ����!");
			}catch(NotExcept n) {
				FailView.failMessageView(n.getMessage());
			}
		} else {
			EndView.messageView("�߸��� �Է��Դϴ�");
		}
	}

	public void delete(String string) {
		if (string != null) {
			try {

				service.deleteStore(string);
				log.trace("Complete Delete!");
				EndView.messageView("���� ����");

			} catch (NotExcept n) {
				FailView.failMessageView(n.getMessage());
			}
		} else {
			log.debug("Null Error!!");
			EndView.messageView("�߸��� �Է��Դϴ�.");

		}
	}
}
