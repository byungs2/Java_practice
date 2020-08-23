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
		

	//fileIO.writeData(file, content); //서빗스에서 content에 로직처리까지해서 DB에서 파일로 내보냄. + 예외처리	
	
	public static DrugStoreModelDB getInstance() {
		return instance;
	}
	
	public List<DrugStoreData> getdataList(){
		return dataList;
	}

	public void insertNewDrugStore(DrugStoreData newStore) {
	      //dataList.add(newStore);
	      File file = new File("data.txt");
	      //중원구   세미약국   031-733-2006   경기도 성남시 중원구 희망로380번길 13 (상대원동)   2020-03-04   77
	      fileIO.writeData(file, "\n"+newStore.getStoreRegion()+"\t"
	                         +newStore.getStoreName()+"\t"
	                         +newStore.getStoreNumber()+"\t"
	                         +newStore.getStoreAddr()+"\t"
	                         +newStore.getStoreMaskNumber()); //서빗스에서 content에 로직처리까지해서 DB에서 파일로 내보냄. +
	   		
	}
}
