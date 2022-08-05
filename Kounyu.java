import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kounyu {
	public static void kounyu() throws Exception {


		/********* Creating an object to call method of class DbCon **********/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int sum1 = Money.sum;

		while(true) {

			System.out.println("商品番号選択で購入出来ます。\n商品番号選択してください。");

			int water = DbCon.pdr.get(0).id;
			int coke = DbCon.pdr.get(1).id;
			int fanta = DbCon.pdr.get(2).id;
			int yog = DbCon.pdr.get(3).id;
			int mon = DbCon.pdr.get(4).id;

			while (true) {
				String str = br.readLine();
				char res = str.charAt(0);

				if (res == '1' && water > 0 && sum1 >= 110) {
					System.out.println(DbCon.pdr.get(0).goods + "を購入しました。\n");
					DbCon.Henkyaku(DbCon.pdr.get(0).id);
					System.out.println("\n       【商品一覧表】\n");
					DbCon.zaiko(DbCon.pdr.get(0).id);
					DbCon.Uriage(DbCon.pdr.get(0).id);
					DbCon.mn();
					DbCon.UPMN();
					//DbCon.Lt();
					break;

				} else if (res == '2' && coke > 0 && sum1 >= 120) {
					System.out.println(DbCon.pdr.get(1).goods + "を購入しました。\n");
					DbCon.Henkyaku(DbCon.pdr.get(1).id);
					System.out.println("\n       【商品一覧表】\n");
					DbCon.zaiko(DbCon.pdr.get(1).id);
					DbCon.Uriage(DbCon.pdr.get(1).id);
					DbCon.mn();
					DbCon.UPMN();
					break;

				} else if (res == '3' && fanta > 0 && sum1 >= 130) {
					System.out.println(DbCon.pdr.get(2).goods + "を購入しました。\n");
					System.out.println("\n       【商品一覧表】\n");
					DbCon.zaiko(DbCon.pdr.get(2).id);
					DbCon.Henkyaku(DbCon.pdr.get(2).id);
					DbCon.Uriage(DbCon.pdr.get(2).id);
					DbCon.mn();
					DbCon.UPMN();
					break;

				} else if (res == '4' && yog > 0 && sum1 >= 140) {
					System.out.println(DbCon.pdr.get(3).goods + "を購入しました。\n");
					System.out.println("\n       【商品一覧表】\n");
					DbCon.zaiko(DbCon.pdr.get(3).id);
					DbCon.Henkyaku(DbCon.pdr.get(3).id);
					DbCon.Uriage(DbCon.pdr.get(3).id);
					DbCon.mn();
					DbCon.UPMN();
					break;

				} else if (res == '5' && mon > 0 && sum1 >= 150) {
					System.out.println(DbCon.pdr.get(4).goods + "を購入しました。\n");

					/******* Calling DbCon.zaiko method from DbCon Class *******/
					DbCon.Henkyaku(DbCon.pdr.get(4).id);
					System.out.println("\n       【商品一覧表】\n");
					DbCon.zaiko(DbCon.pdr.get(4).id);
					DbCon.Uriage(DbCon.pdr.get(4).id);
					DbCon.mn();
					DbCon.UPMN();
					break;

				} else {
					System.out.println("在庫切れか、入力誤りです。\n再度入力してください。");
					continue;
				}

			}
			System.out.println("\n続けて購入しますか？(y/n)");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

			String str = br1.readLine();
			String res = str.intern();

			if (res != "y" && res != "Y" && res != "n" && res != "N") {

				System.out.println("入力誤りです。\n再度入力してください。\n");


				/******* Calling kounyu() method from kounyu Class *******/

			}

			else if (res == "y" || res == "Y") {
				Money.money();
				break;
			}
			else if(res == "n" || res == "N"){
				System.out.println("ご利用ありがとうございます。");
				System.out.println("またお願いします。");
				DbCon.Lt();
				break;
			}
			else {
				break;
			}
		}

	}
}