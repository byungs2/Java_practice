package drugstore.info.model;

import java.io.File;
import java.util.List;

import drugstore.info.dto.DrugStoreData;
import drugstore.info.dto.FileIO;

public class DrugStoreModelDB {
		
	private static DrugStoreModelDB instance = new DrugStoreModelDB();
	private FileIO fileIO = FileIO.getInstance();
	private List<DrugStoreData> dataList = fileIO.readData();
	
	private DrugStoreModelDB() {}
		

	//fileIO.writeData(file, content); //���������� content�� ����ó�������ؼ� DB���� ���Ϸ� ������. + ����ó��	
	
	public static DrugStoreModelDB getInstance() {
		return instance;
	}
	
	public List<DrugStoreData> getdataList(){
		return dataList;
	}

	public void insertNewDrugStore(DrugStoreData newStore) {
	      //dataList.add(newStore);
	      File file = new File("data.txt");
	      //�߿���   ���̾౹   031-733-2006   ��⵵ ������ �߿��� �����380���� 13 (������)   2020-03-04   77
	      fileIO.writeData(file, "\n"+newStore.getStoreRegion()+"\t"
	                         +newStore.getStoreName()+"\t"
	                         +newStore.getStoreNumber()+"\t"
	                         +newStore.getStoreAddr()+"\t"
	                         +newStore.getStoreMaskNumber()); //���������� content�� ����ó�������ؼ� DB���� ���Ϸ� ������. +
	   		
	}
}
