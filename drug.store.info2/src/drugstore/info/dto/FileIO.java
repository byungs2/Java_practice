package drugstore.info.dto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileIO {

	private static FileIO instance = new FileIO();

	private FileIO() {
	}

	public List<DrugStoreData> readData() {
		File file = new File("data.txt");

		List<String> lines;
		String[] dataAry = null;
		List<DrugStoreData> dataList = new ArrayList<>();

		try {
			lines = instance.readFile(file);
			for (int i = 1; i < lines.size(); i++) {// i = 1 -> ī�װ��� ����.
				dataAry = ((String) lines.get(i)).split("\t");
				DrugStoreData data = new DrugStoreData(dataAry[0], // �ñ���
						dataAry[1], // �౹��
						dataAry[2], // ��ȭ��ȣ
						dataAry[3], // �ּ�
						Integer.parseInt(dataAry[4]) // ����ũ ���� ��
				);
				dataList.add(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;
	}

	public int writeData(File file, String content) {
		try {
			instance.writeFile(file, content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void updataData(File file, DrugStoreData updateStore) {

		List<String> lines;
		String[] dataAry = null;
		List<DrugStoreData> dataList = new ArrayList<>();

		try {
			lines = instance.readFile(file);
			for (int i = 1; i < lines.size(); i++) {// i = 1 -> ī�װ��� ����.
				dataAry = ((String) lines.get(i)).split("\t");
				if (dataAry[1].equals(updateStore.getStoreName())) {

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> readFile(File file) throws IOException {
		return FileUtils.readLines(file, "MS949");
	}

	public void writeFile(File file, String content) throws IOException {
		FileUtils.writeStringToFile(file, content, true);
	}

	public static FileIO getInstance() {
		return instance;
	}

}