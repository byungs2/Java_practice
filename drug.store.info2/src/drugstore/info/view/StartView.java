package drugstore.info.view;


import drugstore.info.controller.Controller;
import drugstore.info.dto.DrugStoreData;
public class StartView {
	
	public static void main(String[] args) {
		Controller controller = Controller.getInstance();
		
		//�˻�( ���̸� , ����ũ ����)
		System.out.println("\n����� ����ũ ������ �౹ �˻�");
		controller.search("���̵�", 70);
		//����ó��
		//1. ������ ���� ��
		System.out.println("\n������ ������ ���� ó��");
		controller.search("���̻ڵ�", 50);
		//2. ������ �ִ� ��쿡 ����ũ ������ ���� ���
		System.out.println("\n������ ������ ����ũ ������ ���� ��");
		controller.search("���̵�", 250);
		//3. null�� �Է�
		System.out.println("\n null�� �Է� ���� ��");
		controller.search(null, 0);
		
		
		//���� ���� 
		DrugStoreData newstore = new DrugStoreData("���ϱ�","���̻ھ౹","010-2067-9386","���ϱ� �Ⱦϵ� 1�� 17 ��ž (�Ⱦϵ�,��ž ���̻� Ÿ��)",34);
		DrugStoreData newstore3 = new DrugStoreData("�д籸",	"����� �౹","031-712-7300","��⵵ ������ �д籸 ������ 68, 403-1ȣ (���̵�, �д�������)",12);
		controller.search("���̻ڵ�",1);
		controller.delete("���̻ھ౹");
		controller.insert(newstore);
		System.out.println("\n���� �� �˻�");
		controller.search("���̻ڵ�",1);
		controller.search("�Ⱦϵ�", 1);
		//����ó��
		//1. �ߺ� ����
		System.out.println("\n�ߺ� ���� �׽�Ʈ");
		controller.insert(newstore3);
		//2. null�� �Է�
		System.out.println("\n null �Է� �׽�Ʈ");
		controller.insert(null);

		
		//������Ʈ (��������� ������ �ε��� ����)
		System.out.println("\n���� �õ�");
		controller.upDate("���ľ౹", 50);
		System.out.println("\n���� �� �˻� �õ�");
		controller.search("���ľ౹",1);
		//����ó��
		//1. null�� �Է�
		System.out.println("\nNull �Է� �� ���� �õ�");
		controller.upDate(null, 3);
		//2. �������� �ʴ� �౹ ���� �õ�
		System.out.println("\n�������� �ʴ� �౹ ���� �õ�");
		controller.upDate("�ݴ��Ǿ౹", 25);
		
		
		
		//���� (�ι�° �ε����� �˻��ؼ� ��ü ����)
		System.out.println("\n�˻� �� ����");
		controller.delete("��������౹");
		
		//���� �� �˻�
		System.out.println("\n���� �� �˻�");
		controller.search("���̵�", 70);
		
		//����ó��
		//1. null ���� ���
		System.out.println("\n null �Է½� ���");
		controller.delete(null);
		//2. �������� �ʴ� �౹ ���� �õ�
		System.out.println("\n �������� �ʴ� �౹ ���� �õ�");
		controller.delete("���̻� �౹");
		
		
	}
}
