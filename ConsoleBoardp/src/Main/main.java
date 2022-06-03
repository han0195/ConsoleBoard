package Main;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


sfsdfsef
public class main {

	static Scanner scanner = new Scanner(System.in);
	static String yourId;
	static String yourPw;

	public static void main(String[] args){
		try {
			Controller.�Խù����();
			Controller.ȸ�����();
			Controller.�������();
			Controller.�������();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			scanner = new Scanner(System.in);
			try {
				
					�׸�();

					// �޴�
					���θ޴�();

				
			} catch (Exception e) {
				System.err.println("����ε� �Է� �ٶ�");
			}
		}
		
		

		
	}

	public static void �α��θ޴�(String id) throws IOException {
		while (true) {
			//////////////////////////////////////////// �α�����
//////////////////////////////////////////////�α�����
			for (int i = 0; i < Controller.ī�װ�.length; i++) {
				ArrayList<Board> �α�� = Controller.�α��(Controller.ī�װ�[i]); // �� ī�װ� �α�� ��������
				System.out
						.println("---------------------ī�װ�: " + Controller.ī�װ�[i] + "-----------------------------");
				System.out.println("����\t\t����\t\t�۹�ȣ\t\t��õ��");
				for (int j = 0; j < �α��.size(); j++) {
					if (�α��.size() != 0) {
						String ���� = "";
						for (int s = 0; s < �α��.get(j).getContent().length(); s++) {
							���� += �α��.get(j).getContent().charAt(s);
							if (s == 9) {
								break;
							}
						}
						String ���� = "";
						for (int s = 0; s < �α��.get(j).getTitle().length(); s++) {
							���� += �α��.get(j).getTitle().charAt(s);
							if (s == 9) {
								break;
							}
						}
						System.out.println(String.format("%-15s", ����)+ String.format("%-15s", ����)
								+ �α��.get(j).getIndex() + "\t\t" + �α��.get(j).getGood());

					}
					if (j == 4) {
						break;
					}
				}

			}
			///////////////////////////////////////////////////

			System.out.println("-------------");
			System.out.println("|1.ī�װ� ����|");
			System.out.println("-------------");
			System.out.println();
			System.out.println("--------");
			System.out.println("|2.���̹�|");
			System.out.println("--------");
			System.out.println();
			System.out.println("------------------");
			System.out.println("|3.���� ������|");
			System.out.println("------------------");
			System.out.println();
			System.out.println("-----------");
			System.out.println("|4.����Ȯ��|");
			System.out.println("-----------");
			System.out.println();
			System.out.println("----------");
			System.out.println("|5.�α׾ƿ�|");
			System.out.println("----------");
			System.out.println();

			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.println("\t\t\t");
			System.out.print("��ȣ: ");
			int ch = scanner.nextInt();
			if (ch == 1) {
				ī�װ��޴�(id);
			} else if (ch == 2) {
				���̹�޴�(id);
			} else if (ch == 3) { // ���� ������
				System.out.println("�޴� ��� id: ");
				String receiveid = scanner.next();
				scanner.nextLine();
				System.out.println("����: ");
				String con = scanner.nextLine();

				boolean pass = Controller.����������(receiveid, id, con);
				if (pass) {
					System.out.println("����");
				} else {
					System.out.println("����");
				}
			} else if (ch == 4) { // ����Ȯ��
				for (Acount temp : Controller.acountlist) {
					if (temp.getId().equals(id)) {
						for (����Ŭ���� temp2 : temp.get����()) {
							System.out.println("--------------------------------------------");
							System.out.print("��ȣ : " + temp2.get��ȣ() + "\t");
							System.out.print("������� : " + temp2.get�޴»��() + "\t");
							System.out.print("�޴»�� : " + temp2.get�������() + "\n");
							System.out.print("���� : " + temp2.get����() + "\n");
							System.out.println("--------------------------------------------");
						}
					}
				}
			} else if (ch == 5) { // �α׾ƿ�
				scanner = new Scanner(System.in);
				try {
					�׸�();
					���θ޴�();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("���õ� ��ȣ �Է� �ٶ�");
			}
		}
	}

	public static void ī�װ��޴�(String id) {
		for(int i = 0; i < Controller.ī�װ�.length; i++) {
			System.out.print(i+". "+Controller.ī�װ�[i]+" ");
		}
		int ī�װ����� = scanner.nextInt();
		while (true) {
			System.out.println("*** " + Controller.ī�װ�[ī�װ�����] + " ***");
			// ���
			System.out.println("����\t\t����\t\t�ۼ���\t��ȣ");
			ArrayList<String> templist = new ArrayList<>();
			boolean block = true;
			for (Acount temp2 : Controller.acountlist) {
				for (�������� temp : Controller.��������list) {
					if (temp2.getId().equals(id) && temp.getIndex().equals(id)) {
						templist.add(temp.getTarget());
					}
				}
			}
			if (templist.isEmpty())// ���������� ����ִٸ�
				block = false; // �������� ���� �⺻���� true������
			if (block) {// �����������ִٸ� ���

				for (Board temp : Controller.boardlist) {
					// ���� �ִ� 10���ڱ��� ���
					String ���� = ""; 
					for (int s = 0; s < temp.getContent().length(); s++) {
						���� += temp.getContent().charAt(s);
						if (s == 9) {
							break;
						} 
						
					}
					// ���� �ִ� 10���ڱ��� ���
					String ���� = "";
					for (int s = 0; s < temp.getTitle().length(); s++) {
						���� += temp.getTitle().charAt(s);
						if (s == 9) {
							break;
						}
						
					} 
					if (temp.getCategory().equals(Controller.ī�װ�[ī�װ�����])) { // ī�װ� �����͸�
						if (templist.contains(temp.getWriter())) {				   // ���ܸ���Ʈ�� �ۼ��� ���ٸ�
							System.out.println("���ܵ� ������ ��");
						} else {
							System.out.println(String.format("%-15s", ���� ) + "\t" + String.format("%-15s", ���� ) + "\t" + temp.getWriter()
									+ "\t" + temp.getIndex());
						}
					}

				}

			} else { // ���������� ������
				for (Board temp : Controller.boardlist) {
					String ���� = "";
					for (int s = 0; s < temp.getContent().length(); s++) {
						���� += temp.getContent().charAt(s);
						if (s == 9) {
							break;
						}
						
					}
					String ���� = "";
					for (int s = 0; s < temp.getTitle().length(); s++) {
						���� += temp.getTitle().charAt(s);
						if (s == 9) {
							break;
						}
						
					}
					if (temp.getCategory().equals(Controller.ī�װ�[ī�װ�����])) {
						System.out.println(String.format("%-15s", ���� ) + "\t" + String.format("%-15s", ���� ) + "\t" + temp.getWriter()
						+ "\t" + temp.getIndex());
					}
				}
			}

			templist.clear();
			System.out.println("------------"); // ���м�
			try {
				ī�װ�����(id, ī�װ�����);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // while end

	} // ī�װ� ���� end

	public static void �׸�() {
		System.out.println(
				" -------------------------------------------------------------------------------------------        ");
		System.out.println(
				"/                 *          *          *        **********      ***********               |        ");
		System.out.println(
				"|                *          *          *         *                    *                    |        ");
		System.out.println(
				"|               *          *          *          *                    *                    |        ");
		System.out.println(
				"|              *          *          *           **********           *        6 6 6       |        ");
		System.out.println(
				"|             * * *      * * *      * * *        *                    *                    |        ");
		System.out.println(
				"|             *     *    *     *    *     *      *                    *       �������θ�Ʈ     |        ");
		System.out.println(
				"|             *     *    *     *    *     *      *                    *                    |        ");
		System.out.println(
				"|               * *        * *        * *        **********           *        Ŀ�´�Ƽ      /         ");
		System.out.println(
				"-------------------------------------------------------------------------------------------          ");
		System.out.println("\\    /\\          \\    /\\          \\    /\\");
		System.out.println(" )  ( ')          )  ( ')          )  ( ')");
		System.out.println("(  /  )          (  /  )          (  /  )");
		System.out.println(" \\(__)|           \\(__)|           \\(__)|");

	}

	public static void ���θ޴�() throws IOException {
		while (true) {
			System.out.println("---------");
			System.out.println("|1.ȸ������|");
			System.out.println("---------");
			System.out.println("");

			System.out.println("--------");
			System.out.println("|2.�α���|");
			System.out.println("--------");
			System.out.println("");

			System.out.println("------------");
			System.out.println("|3.���̵� ã��|");
			System.out.println("------------");
			System.out.println("");

			System.out.println("-------------");
			System.out.println("|4.��й�ȣ ã��|");
			System.out.println("-------------");

			System.out.println("���Ͻô� �޴��� ��ȣ�� �Է��ϼ���,,,,,,,,,,,@@@,,");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.print("��ȣ : ");
			int ch = scanner.nextInt();
			if (ch == 1) {
				ȸ������();
			} // ȸ������
			else if (ch == 2) {
				�α���();
			} // �α���
			else if (ch == 3) {
				���̵�ã��();
			} // ���̵� ã��
			else if (ch == 4) {
				��й�ȣã��();
			} // ��й�ȣ ã�� �޼ҵ�
			else {
				System.out.println("���õ� ��ȣ �Է� �ٶ�");
			}
		}

	}

	public static void ȸ������() throws IOException {
		System.out.println("----------------ȸ������ ������----------------");
		System.out.println("(���̵�� 1~6���ڸ� �����ϸ�, �ѱ�,����,Ư�����ڴ� ����� �� �����ϴ�.)");
		scanner.nextLine();
		System.out.print("���̵� �Է� : ");
		String id = scanner.nextLine();
		int idresult = Controller.ȸ�����Ծ��̵�(id);
		if (idresult == 1)
			System.out.println("���̵� �ѱ�,����,Ư�����ڴ� �� �� �����ϴ�.");
		else if (idresult == 2)
			System.out.println("���̵��� ���̴� 1~6���ڸ� �����մϴ�.");
		else if (idresult == 3)
			System.out.println("�ߺ��� ���̵��Դϴ�.");
		else if (idresult == 4) {
			System.out.println("(��й�ȣ�� 4~12���ڸ� �����մϴ�.)");
			System.out.print("��й�ȣ �Է� : ");
			String pw = scanner.nextLine();
			System.out.print("��й�ȣ Ȯ�� : ");
			String pwcheck = scanner.nextLine();
			int pwresult = Controller.ȸ�����Ժ�й�ȣ(pw, pwcheck);
			if (pwresult == 1)
				System.out.println("��й�ȣ�� ������ ���Ե� �� �����ϴ�.");
			else if (pwresult == 2)
				System.out.println("��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�.");
			else if (pwresult == 3) {
				System.out.print("�̸� �Է� : ");
				String name = scanner.next();
				System.out.print("�̸��� �Է� : ");
				String email = scanner.next();
				System.out.print("��ȭ��ȣ �Է� : ");
				String phone = scanner.next();
				boolean result = Controller.ȸ������(id, pw, pwcheck, name, email, phone);

				if (result)
					System.out.println("ȸ�����Կ� �����Ͽ����ϴ�.");
				else
					System.out.println("�ش� ��ȭ��ȣ�� ���̻� ������ �Ұ����մϴ�.");
			}
			else if(pwresult==4) {
				System.out.println("��й�ȣ�� ���̴� 4~12���ڸ� �����մϴ�.");
			}
		}

	}

	public static void �α���() throws IOException {

		String id = null;
		String pw = null;
		System.out.print("���̵� �Է� : ");
		id = scanner.next();
		System.out.print("��й�ȣ �Է� : ");
		pw = scanner.next();
		int result = Controller.�α���(id, pw);
		if (result == 1) {
			System.out.println(id + "�� ȯ���մϴ�.");
			System.out.println();
			�α��θ޴�(id);
		} else if (result == 2) {
			System.out.println("���Ե� ���̵� �����ϴ�.");
		} else if (result == 3) {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}

	public static void ���̵�ã��() {
		System.out.print("�̸� �Է� : ");
		String name = scanner.next();
		System.out.print("��ȭ��ȣ �Է� : ");
		String phone = scanner.next();
		System.out.print("�̸��� �Է� : ");
		String email = scanner.next();
		String result = Controller.���̵�ã��(name, phone, email);
		if (result.equals("1")) {
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		} else {
			System.out.println("ȸ������ ���̵�� \"" + result + "\" �Դϴ�.");
		}
	}

	public static void ��й�ȣã��() {
		System.out.print("���̵� �Է� : ");
		String id = scanner.next();
		System.out.print("��ȭ��ȣ �Է� : ");
		String phone = scanner.next();
		System.out.print("�̸��� �Է� : ");
		String email = scanner.next();

		String result = Controller.��й�ȣã��(id, phone, email);
		if (result.equals("1")) {
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		} else {
			System.out.println("ȸ������ ��й�ȣ�� \"" + result + "\" �Դϴ�.");
		}
	}

	public static void ī�װ�����(String id, int ī�װ�����) throws IOException {
		System.out.println("1.�۾��� 2.�ۺ��� 3.�˻� 4.���������� 5.���������� 6.�ڷΰ���");
		int �ൿ���� = scanner.nextInt();// �����Է¹ޱ�
		if (�ൿ���� == 1) {
			System.out.println("����: ");
			String title = scanner.next(); // ���� �Է¹ޱ�
			System.out.println("����: ");
			String content = scanner.next();// ���� �Է¹ޱ�
			boolean pass = Controller.�۾���(id, title, content, Controller.ī�װ�[ī�װ�����]);
			if (pass) { // ������
				System.out.println("���ۼ�����");
			} else { // ���н�
				System.out.println("���ۼ�����");
			}
		} else if (�ൿ���� == 2) { // �ۺ���
			�ۺ���(id, ī�װ�����);
		} else if (�ൿ���� == 3) { // �˻�
			System.out.println("���� �˻� : ");
			String serch = scanner.next();

			ArrayList<Board> result = Controller.�˻�(serch);

			System.out.println("---------------------�˻� ���---------------------------");
			for (Board temp : result) {
				System.out.println(temp.getTitle() + "\t" + temp.getContent() + "\t" + temp.getIndex());
			}
			System.out.println("-------------------------------------------------------");

		} else if (�ൿ���� == 4) { // ����������

		} else if (�ൿ���� == 5) { // ����������

		} else if (�ൿ���� == 6) { // �ڷΰ���
			�α��θ޴�(id);
		} else {
			System.out.println("�˼����� �ൿ");
		}
	}

	public static void �ۺ���(String id, int ī�װ�����) throws IOException {
		System.out.println("�۹�ȣ�Է�: ");
		int index = scanner.nextInt();
		boolean pass = Controller.�ۻ󼼺���(id, index);
		if (pass) { // ��ã�� ������
			while (true) {
				for (Board temp : Controller.boardlist) {
					if (temp.getIndex() == index) {
						System.out.println("�ۼ���: " + temp.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd | hh:mm")) + "\n");
						System.out.println(
								"��ȣ: " + temp.getIndex() + " ����: " + temp.getTitle() + " ī�װ�: " + temp.getCategory() +"\n");
						System.out.println("����: " + temp.getContent());
						System.out.println(
								"��õ��: " + temp.getGood() + " ����: " + temp.getBad() + " �Ű��: " + temp.getReport());
						System.out.println("----���â-----------------------------------------------------------");

						if (temp.getReplylist() == null) {

						} else {
							int �ε��� = 0;
							for (Reply temp2 : temp.getReplylist()) {
								System.out.println(�ε��� + " ����: " + temp2.getContent());
								�ε���++;
							} // ��� ��� end
						} // ��� ��� if�� end
						break;
					}
				} // ��� for�� end

				System.out.println("1.���� 2.���� 3.��۴ޱ� 4.��ۼ��� 5.��ۻ��� 6.�Ű��ϱ� 7.�ڷΰ��� 8.��õ 9.����");
				int ���� = scanner.nextInt();
				////////////////////////////// �� ����
				////////////////////////////// //////////////////////////////////////////////////
				if (���� == 1) {
					boolean result = Controller.�ۼ������̵�üũ(id, index);
					if (result) {
						System.out.print("��й�ȣ �Է� : ");
						String pw = scanner.next();
						boolean result2 = Controller.�ۼ�����й�ȣüũ(id, pw, index);
						if (result2) {
							System.out.print("������ ���� �Է� : ");
							scanner.nextLine();
							String title = scanner.nextLine();
							System.out.print("������ ���� �Է� : ");
							String content = scanner.nextLine();
							Controller.�ۼ���(index, title, content);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						}
					} else
						System.out.println("������ �ۼ��� �۸� ������ �����մϴ�.");
					//////////////////////////////////// �� ����
					//////////////////////////////////// ////////////////////////////////////////
				} else if (���� == 2) {
					boolean result = Controller.�ۼ������̵�üũ(id, index);
					if (result) {
						System.out.print("��й�ȣ �Է� : ");
						String pw = scanner.next();
						boolean result2 = Controller.�ۼ�����й�ȣüũ(id, pw, index);
						if (result2) {
							Controller.�ۻ���(id, pw, index);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
							break;
						} else
							System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");

					} else
						System.out.println("������ �ۼ��� �۸� ������ �����մϴ�.");
					/////////////////////////////////// ��� �ޱ�
					/////////////////////////////////// /////////////////////////////////////////
				} else if (���� == 3) {
					System.out.println("����: ");
					scanner.nextLine();
					String con = scanner.nextLine();
					Controller.����ۼ�(con, index, id);
					/////////////////////////////////// ��� ����
					/////////////////////////////////// ///////////////////////////////////////////
				} else if (���� == 4) {
					System.out.println("�����Ҵ���ε���: ");
					int ����ε��� = scanner.nextInt();
					System.out.println("�����ҳ���: ");
					String ��ۼ��� = scanner.next();
					boolean pass2 = Controller.��ۼ���(index, ����ε���, ��ۼ���, id);
					if (pass2) {
						System.out.println("��ۼ��� ����");
					} else {
						System.out.println("��ۼ��� ����");
					}
					///////////////////////////////////// ��ۻ���//////////////////////////////////////////////////
				} else if (���� == 5) {
					System.out.println("�����Ҵ���ε���: ");
					int ����ε��� = scanner.nextInt();
					boolean pass2 = Controller.��ۻ���(index, ����ε���, id);
					if (pass2)
						System.out.println("��ۻ��� ����");
					else
						System.out.println("��ۻ��� ����");
				} else if (���� == 6) { // �Ű�
					System.out.println("�Ű��� ������ �ڵ����� ���ܵ˴ϴ�. ���� �Ű��Ͻðڽ��ϱ�?");
					System.out.println("1.�Ű��ϱ� 2.���");
					int ch = scanner.nextInt();
					if (ch == 1) {
						boolean result = Controller.�Ű�(id, index);
						if (result) {
							System.out.println("\t\t\t�Ű� �Ϸ�Ǿ����ϴ�.");
							ī�װ�����(id, ī�װ�����);
						} else
							System.out.println("�ڽ��� ���̵�� �Ű� �Ұ����մϴ�.");

					} else if (ch == 2) {

					}

				} else if (���� == 7) {
					break;
				} // �ڷΰ���
				else if (���� == 8) {
					Controller.��õ����(true, index, id);
				} else if (���� == 9) {
					Controller.��õ����(false, index, id);
				} else
					System.out.println("�˼����� �ൿ");
			} // while end

		} // ��ã�� ���� if ��¹� end
		else {// ã�� ���н�
			System.out.println("�ش���� ã�����߽��ϴ�");
		}
	}

	public static void ���̹�޴�(String id) throws IOException {
		System.out.println("1.����Ʈ���� 2.����Ʈ��ŷ 3. ����ã�� 4.�ڷΰ���");
		int ch = scanner.nextInt();
		if (ch == 1) { // ����Ʈ����
			String[] result = Controller.����(id);
			if (result[0].equals("[ ]")) {
				System.out.println("\t\t\t���� ����Ʈ�� �����ؼ� ������ �� �����ϴ�.");
			} else {
				System.out.print("\t\t\t");
				for (int i = 0; i < result.length; i++) {
					System.out.print(result[i]);
				}
				int result2 = Controller.���ǰ��(result, id);

				if (result2 == 1)
					System.out.println("\n1�� 1000����Ʈ ��÷");
				else if (result2 == 2)
					System.out.println("\n2�� 300����Ʈ ��÷");
				else if (result2 == 3)
					System.out.println("\n3�� 100����Ʈ ��÷");
				else if (result2 == 4)
					System.out.println("\n4�� 10����Ʈ ��÷");
				else if (result2 == 5)
					System.out.println("\n��");
			}
			���̹�޴�(id);
		}

		else if (ch == 2) {
			ArrayList<Acount> ranking = Controller.����Ʈ��ŷ();
			int i = 1;
			System.out.println("���\t���̵�\t����Ʈ");
			for (Acount temp : ranking) {
				System.out.println(i + "��\t" + temp.getId() + "\t" + temp.getPoint());
				if(i == 4) {
					break;
				}
				i++;
			}
			���̹�޴�(id);

		} else if (ch == 3) {
			// 1.������ �ʱ�ȭ
			while (true) { // ���α׷�����
				int �������ε��� = 0;
				for (String temp : Controller.������) { // ���� for ��������
					if (temp != "[��]") {
						Controller.������[�������ε���] = "[��]";
					} // "[��]" �ʱ�ȭ
					�������ε���++; // �����ε���
				}
				System.out.println("���� ã�� 1�� 3ȸ 30��");
				System.out.println("1.�̱� 2.�ڷΰ���");
				int ch2 = scanner.nextInt(); // �����Է¹ޱ�
				if (ch2 == 1) {// �̱� ����
					boolean pass = true; // �� pass üũ
					for (Acount temp : Controller.acountlist) { // ȸ��������
						if (temp.getId().equals(id)) { // id ��ġ�ϸ�
							if (temp.getPoint() < 30) { // �� üũ
								System.out.println("������");
								pass = false; // ������� ����ġ ��Ȱ
							}
						}
					}
					if (pass) {// ���� �ִٸ�
						int ��ȸ = 3;
						int[] ��� = Controller.����ã����Ӽ���(); // ��÷��ȣ �ʱ�ȭ
						for (int j = 0; j < 3; j++, ��ȸ--) { // 3�� ������
							// ������ ���
							for (int i = 0; i < Controller.������.length; i++) {
								System.out.print(Controller.������[i]);
								if (i % 5 == 4) {
									System.out.println();
								} // �ٹٲ�
							}
							System.out.println("������ȸ: " + ��ȸ + " | �ε�������: ");
							int ���� = scanner.nextInt(); // �ε����ޱ�
							boolean pass2 = false;
							if(���� > 14) {
								while(true) {
									System.out.println("0~14������ �ٽ��Է�"); ���� = scanner.nextInt();
									if(����>=0 && ���� < 15) {
										break;
									}
								}
								
							}
							int ��÷���� = Controller.����ã��(����, id, ���); // ����ã�� �޼ҵ� ȣ��
							if (��ȸ == 0) {
								break;
							} // ���ӳ���ȸ�� ������
							if (��÷���� == 1) {
								System.out.println("1�� ��÷");
								Controller.ȸ������ó��(id);
							} else if (��÷���� == 2) {
								System.out.println("2�� ��÷");
								Controller.ȸ������ó��(id);
							} else if (��÷���� == 3) {
								System.out.println("3�� ��÷");
								Controller.ȸ������ó��(id);
							} else if (��÷���� == -1) {
								System.out.println("��");
							}
						}
						// ������ ���
						for (int i = 0; i < Controller.������.length; i++) {
							System.out.print(Controller.������[i]);
							if (i % 5 == 4) {
								System.out.println();
							} // �ٹٲ�
						}
						System.out.println("��������");
					} else {
						System.out.println("������");
					}
				} else if (ch2 == 2) { // �ڷΰ���
					break;
				} else {
					System.out.println("�˼����� ����");
				}
			}
		}

		else if (ch == 4) {
			�α��θ޴�(id);
		} else {
			System.out.println("\t\t\t���õ� ��ȣ �Է� �ٶ�");
			���̹�޴�(id);
		}

	}

}
