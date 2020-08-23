package drugstore.info.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import drugstore.info.dto.DrugStoreData;
import drugstore.info.exception.DuplExcept;
import drugstore.info.exception.NotExcept;
import drugstore.info.model.DrugStoreModelDB;

public class DrugStoreService {
	Logger log = Logger.getRootLogger();
	private static DrugStoreService service = new DrugStoreService();
	DrugStoreModelDB drugStoreDB = DrugStoreModelDB.getInstance();

	public static DrugStoreService getInstance() {
		return service;
	}

	public DrugStoreData getDrugStore(String string) {
		List<DrugStoreData> datalist = drugStoreDB.getdataList();
		for (int i1 = 0; i1 < datalist.size(); i1++) {
			if (datalist.get(i1).getStoreAddr().contains(string) || datalist.get(i1).getStoreName().contains(string)) {
				return datalist.get(i1);
			}
		}
		return null;
	}

	public List<DrugStoreData> getDrugStoreList(String string, int i) {
		List<DrugStoreData> datalist = drugStoreDB.getdataList();
		List<DrugStoreData> returnlist = new ArrayList<DrugStoreData>();
		int cnt = 0;
		for (int i1 = 0; i1 < datalist.size(); i1++) {
			if (datalist.get(i1).getStoreAddr().contains(string) && datalist.get(i1).getStoreMaskNumber() >= i) {
				returnlist.add(datalist.get(i1));
				cnt++;
			}
		}
		if (cnt == 0) {
			return null;
		}else{
			return returnlist;
		}
	}
//	public void inserDrugStore(DrugStoreData newStore) {
//		drugStoreData.insertNewDrugStore(newStore);
//	}

	public void deleteStore(String string) throws NotExcept {
		if (getDrugStore(string) == null) {
			throw new NotExcept("�����Ϸ��� �౹�� �������� �ʽ��ϴ�");
		} else {
			List<DrugStoreData> datalist = drugStoreDB.getdataList();
			for (int i1 = 0; i1 < datalist.size(); i1++) {
				if (datalist.get(i1).getStoreName().equals(string)) {
					datalist.remove(i1);
				}

			}
		}
	}

	public void insertDrugStore(DrugStoreData newStore) throws DuplExcept {
		if(getDrugStore(newStore.getStoreName()) != null){
			throw new DuplExcept("�ߺ��� �౹�� ������ �� �����ϴ�");
		}else {
			drugStoreDB.insertNewDrugStore(newStore);
		}
	}

	public void upDate(String string, int i) throws NotExcept {
		if(getDrugStore(string) == null) {
			throw new NotExcept("�����ϰ��� �ϴ� �౹�� ������ �������� �ʽ��ϴ�.");
		}else {
			getDrugStore(string).setStoreMaskNumber(i);
		}
	}
}
