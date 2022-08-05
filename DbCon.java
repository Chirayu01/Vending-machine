import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DbCon {

	
	//static int oturi = 0;
//Making array list of product class, uriage,and coin class
	static List<Products> pdr = new ArrayList<Products>();
	static List<Uriage> ur = new ArrayList<Uriage>();
	static List<Coin> cn = new ArrayList<Coin>();
	
	
//Connecting database and fetching data from PhpAdmin

	public static void fetchdata() throws Exception {

		
		/*************** Selection of Table name goods from DB *****************/

		String sql = "select * from goods";//Selecting goods and excute them

		try {
			Statement st = Connector.connect().createStatement();
			ResultSet rs = st.executeQuery(sql);

			pdr.clear();
			while (rs.next()) {
				
				pdr.add(new Products(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));//Try if not throw

				System.out.println("商品番号 = " + rs.getInt(1) + "\t" + " " + "商品名 = " + rs.getString(2) + "\n" + "在庫数 = "//Fetch data from data base and insert them as mentioned
						+ rs.getInt(4) + "個" + "\t" + " " + "価格 = " + rs.getInt(3) + "円" + "\n");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/******* Method To update DATA of table goods *************/

	public static void zaiko(int i) throws Exception {

		int a = 0;
		if (i == 1) {
			a = pdr.get(i-1).getStock();//i=is zaiko from database and after 購入　the stock will be -1
		} else if (i == 2) {
			a = pdr.get(i-1).getStock();//same
		} else if (i == 3) {
			a = pdr.get(i-1).getStock();
		} else if (i == 4) {
			a = pdr.get(i-1).getStock();
		} else if (i == 5) {
			a = pdr.get(i-1).getStock();
		}

		/********** updating table goods stock ****************/

		String sql = "UPDATE `goods` SET `stock`= " + (a - 1) + " WHERE id = " + i;

		try {
			Statement st = Connector.connect().createStatement();
			int rs = st.executeUpdate(sql);

			/********* Calling fetchdata method of DbCon class ***********/
			fetchdata();

			//Connector.cnx.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/******************** Method to import table price ********************/
	public static void moneydata() throws Exception {
		
		/********** importing data from table price *****************/
		String sql = "select * from price";

		try {
			Statement st = Connector.connect().createStatement();
			ResultSet rs = st.executeQuery(sql);

			cn.clear();
			while (rs.next()) {
				
				cn.add(new Coin(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
				

				System.out.println("\n番号 = " + rs.getInt(1) + "\n" + "お金 = " + rs.getInt(2) + "円" + "\n在庫 = "//For coinstatic List<Coin> cn = new ArrayList<Coin>();
						+ rs.getInt(3) + "枚" + "\n");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
     public static void moneydata1() throws Exception {
		
		/********** importing data from table price *****************/
		String sql = "select * from price";

		try {
			Statement st = Connector.connect().createStatement();
			ResultSet rs = st.executeQuery(sql);

			cn.clear();
			while (rs.next()) {
				
				cn.add(new Coin(rs.getInt(1), rs.getInt(2), rs.getInt(3)));//static List<Coin> cn = new ArrayList<Coin>(); Imported data from Coin(cn)

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void Uriage(int i) throws Exception {
		
		// String sql = "select * from sales";
		DbCon.Sales();

		int sum = cn.get(0).getMoney();
		int sum1 = cn.get(1).getMoney();
		int sum2 = cn.get(2).getMoney();
		int sum3 = cn.get(3).getMoney();
		int sum4 = cn.get(4).getMoney();

		int a = 0, b = 0, c = 0, d = 0, e = 0;
		if (i == 1) {
			a = 110;
			String sql1 = "UPDATE `sales` SET `amount`= " + (sum + a) + " WHERE id = 1";
			try {
				Statement st1 = Connector.connect().createStatement();
				st1.executeUpdate(sql1);
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		} else if (i == 2) {
			b = 120;
			String sql2 = "UPDATE `sales` SET `amount`= " + (sum1 + b) + " WHERE id = 2";
			try {
				Statement st2 = Connector.connect().createStatement();
				st2.executeUpdate(sql2);
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		} else if (i == 3) {
			c = 130;
			String sql3 = "UPDATE `sales` SET `amount`= " + (sum2 + c) + " WHERE id = 3";
			try {
				Statement st3 = Connector.connect().createStatement();
				st3.executeUpdate(sql3);
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		} else if (i == 4) {
			d = 140;
			String sql4 = "UPDATE `sales` SET `amount`= " + (sum3 + d) + " WHERE id = 4";
			try {
				Statement st4 = Connector.connect().createStatement();
				st4.executeUpdate(sql4);
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		} else if (i == 5) {
			e = 150;
			String sql5 = "UPDATE `sales` SET `amount`= " + (sum4 + e) + " WHERE id = 5";
			try {
				Statement st5 = Connector.connect().createStatement();
				st5.executeUpdate(sql5);
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
		}
		//Connector.cnx.close();

	}

	public static void Saleslist() {
		int sum = 0;
		for (int i = 0; i < cn.size(); i++) {
			System.out.println("\n商品番号 = " + cn.get(i).getId() + "\n売上 = " + cn.get(i).getMoney() + "円");
			sum += cn.get(i).getMoney();
		}
		System.out.println("\n売上合計 = " + sum + "円\n");
	}

	public static void Sales() throws Exception {

		/********** importing data from table price *****************/
		String sql = "select * from sales";

		try {
			Statement st = Connector.connect().createStatement();
			ResultSet rs = st.executeQuery(sql);

			ur.clear();
			while (rs.next()) {
				ur.add(new Uriage(rs.getInt(1), rs.getInt(2)));

				// System.out.println("\n商品番号 = " + rs.getInt(1) + "\n売上 = " + rs.getInt(2) +
				// "円");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void UUreset() throws Exception {
		while (true) {
			System.out.println("売上リセットしますか？");
			BufferedReader reset = new BufferedReader(new InputStreamReader(System.in));
			String str8 = reset.readLine();
			String change = str8.intern();
			if (change == "yes") {
				DbCon.Ureset();
				break;
			} else if (change == "no") {
				break;
			} else {
				System.out.println("正しいパスワード入力してください。\n");
				continue;
			}
		}
	}

	public static void Ureset() throws Exception {

		String sql1 = "UPDATE `sales` SET `amount`= " + 0 + " WHERE id = " + 1;
		String sql2 = "UPDATE `sales` SET `amount`= " + 0 + " WHERE id = " + 2;
		String sql3 = "UPDATE `sales` SET `amount`= " + 0 + " WHERE id = " + 3;
		String sql4 = "UPDATE `sales` SET `amount`= " + 0 + " WHERE id = " + 4;
		String sql5 = "UPDATE `sales` SET `amount`= " + 0 + " WHERE id = " + 5;

		try {
			Statement st1 = Connector.connect().createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = Connector.connect().createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = Connector.connect().createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = Connector.connect().createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = Connector.connect().createStatement();
			st5.executeUpdate(sql5);

			//Connector.cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

		System.out.println("売上リセットされました。");
		DbCon.Sales();

	}

	/*** Creating Henkyaku Method ***/
	static int oturi = 0;
	public static void Henkyaku(int i) throws Exception {//お釣り返却
		
		int sum1 = Money.sum;
		moneydata1();

		while (true) {
			if (i == 1) {
				oturi = (sum1 - pdr.get(i-1).getPrice());///get(i-1) = i is the ID number IF i=1,then from data base (1-1)=0,data be impotred
				System.out.println("お釣り = " + oturi + "円\n");//Total Inserted Money- Product money=oturi
				break;

			} else if (i == 2) {
				oturi = sum1 - pdr.get(i-1).getPrice();
				System.out.println("お釣り = " + oturi + "円\n");
				break;

			} else if (i == 3) {
				oturi = sum1 - pdr.get(i-1).getPrice();
				System.out.println("お釣り = " + oturi + "円\n");
				break;

			} else if (i == 4) {
				oturi = sum1 - pdr.get(i-1).getPrice();
				System.out.println("お釣り = " + oturi + "円\n");
				break;

			} else if (i == 5) {
				oturi = sum1 - pdr.get(i-1).getPrice();
				System.out.println("お釣り = " + oturi + "円\n");
				// DbCon.UPMN();
				break;

			}

		}

	}

	public static void UpdateM() throws Exception {//Coin の在庫Update Money
		int a, b, c, d, e;
		int i, j, k, l, m;
		i = Kanri.id6;
		j = Kanri.id7;
		k = Kanri.id8;
		l = Kanri.id9;
		m = Kanri.id10;

		Connector.connect().createStatement();

		a = cn.get(0).stock;

		b = cn.get(1).stock;

		c = cn.get(2).stock;

		d = cn.get(3).stock;

		e = cn.get(4).stock;

		String sql1 = "UPDATE `price` SET `stock`= " + (a + i) + " WHERE id = " + cn.get(0).id;
		String sql2 = "UPDATE `price` SET `stock`= " + (b + j) + " WHERE id = " + cn.get(1).id;
		String sql3 = "UPDATE `price` SET `stock`= " + (c + k) + " WHERE id = " + cn.get(2).id;
		String sql4 = "UPDATE `price` SET `stock`= " + (d + l) + " WHERE id = " + cn.get(3).id;
		String sql5 = "UPDATE `price` SET `stock`= " + (e + m) + " WHERE id = " + cn.get(4).id;
		try {
			Statement st1 = Connector.connect().createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = Connector.connect().createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = Connector.connect().createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = Connector.connect().createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = Connector.connect().createStatement();
			st5.executeUpdate(sql5);

			DbCon.moneydata();
			//Connector.cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}

	public static void UpdateS() throws Exception {//Update Stock商品在庫
		int a, b, c, d, e;
		int i, j, k, l, m;
		i = Kanri.id1;
		j = Kanri.id2;
		k = Kanri.id3;
		l = Kanri.id4;
		m = Kanri.id5;

		Connector.connect().createStatement();

		a = pdr.get(0).stock;

		b = pdr.get(1).stock;

		c = pdr.get(2).stock;

		d = pdr.get(3).stock;

		e = pdr.get(4).stock;

		String sql1 = "UPDATE `goods` SET `stock`= " + (a + i) + " WHERE id = " + pdr.get(0).id;
		String sql2 = "UPDATE `goods` SET `stock`= " + (b + j) + " WHERE id = " + pdr.get(1).id;
		String sql3 = "UPDATE `goods` SET `stock`= " + (c + k) + " WHERE id = " + pdr.get(2).id;
		String sql4 = "UPDATE `goods` SET `stock`= " + (d + l) + " WHERE id = " +  pdr.get(3).id;
		String sql5 = "UPDATE `goods` SET `stock`= " + (e + m) + " WHERE id = " +  pdr.get(4).id;
		try {
			Statement st1 = Connector.connect().createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = Connector.connect().createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = Connector.connect().createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = Connector.connect().createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = Connector.connect().createStatement();
			st5.executeUpdate(sql5);

			DbCon.fetchdata();
		//	Connector.cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}

	public static void Withdrawm() throws Exception {
		int a, b, c, d, e;
		int i, j, k, l, m;
		i = Kanri.id11;
		j = Kanri.id12;
		k = Kanri.id13;
		l = Kanri.id14;
		m = Kanri.id15;

		Connector.connect().createStatement();

		a = cn.get(0).stock;

		b = cn.get(1).stock;

		c = cn.get(2).stock;

		d = cn.get(3).stock;

		e = cn.get(4).stock;

		String sql1 = "UPDATE `price` SET `stock`= " + (a - i) + " WHERE id = " + cn.get(0).id;
		String sql2 = "UPDATE `price` SET `stock`= " + (b - j) + " WHERE id = " + cn.get(1).id;
		String sql3 = "UPDATE `price` SET `stock`= " + (c - k) + " WHERE id = " + cn.get(2).id;
		String sql4 = "UPDATE `price` SET `stock`= " + (d - l) + " WHERE id = " + cn.get(3).id;
		String sql5 = "UPDATE `price` SET `stock`= " + (e - m) + " WHERE id = " + cn.get(4).id;
		try {
			Statement st1 = Connector.connect().createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = Connector.connect().createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = Connector.connect().createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = Connector.connect().createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = Connector.connect().createStatement();
			st5.executeUpdate(sql5);

			DbCon.moneydata();
			//Connector.cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}

	public static void Withdraws() throws Exception {
		int a, b, c, d, e;
		int i, j, k, l, m;
		i = Kanri.id16;
		j = Kanri.id17;
		k = Kanri.id18;
		l = Kanri.id19;
		m = Kanri.id20;

		Connector.connect().createStatement();

		a = pdr.get(0).stock;

		b = pdr.get(1).stock;

		c = pdr.get(2).stock;

		d = pdr.get(3).stock;

		e = pdr.get(4).stock;

		String sql1 = "UPDATE `goods` SET `stock`= " + (a - i) + " WHERE id = " + pdr.get(0).id;
		String sql2 = "UPDATE `goods` SET `stock`= " + (b - j) + " WHERE id = " + pdr.get(1).id;
		String sql3 = "UPDATE `goods` SET `stock`= " + (c - k) + " WHERE id = " + pdr.get(2).id;
		String sql4 = "UPDATE `goods` SET `stock`= " + (d - l) + " WHERE id = " + pdr.get(3).id;
		String sql5 = "UPDATE `goods` SET `stock`= " + (e - m) + " WHERE id = " + pdr.get(4).id;
		try {
			Statement st1 = Connector.connect().createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = Connector.connect().createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = Connector.connect().createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = Connector.connect().createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = Connector.connect().createStatement();
			st5.executeUpdate(sql5);

			DbCon.fetchdata();
		//	Connector.cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}

	public static void UPMN() throws InstantiationException, SQLException {

		Connector.connect().createStatement();
		String sql = "select * from price";

		try {
			Statement st = Connector.connect().createStatement();
			ResultSet rs = st.executeQuery(sql);

			cn.clear();
			while (rs.next()) {
				cn.add(new Coin(rs.getInt(1), rs.getInt(2),rs.getInt(3)));
			}

			} catch (SQLException e2) {

				e2.printStackTrace();
			}



		int a, b, c, d, e;
		String sql1 = null, sql2 = null, sql3 = null, sql4 = null, sql5 = null;


		a = cn.get(0).stock;

		b = cn.get(1).stock;

		c = cn.get(2).stock;

		d = cn.get(3).stock;

		e = cn.get(4).stock;
		
		try {

			while (true) {
				if (oturi / 1000 >= 1) {
					sql1 = "UPDATE `price` SET `stock`= " + (a - (oturi / 1000)) + " WHERE id = 1";
					oturi -= (oturi / 1000)*1000;
					Statement st1 = Connector.connect().createStatement();
					st1.executeUpdate(sql1);
					continue;
				} else if (oturi / 500 >= 1) {
					sql2 = "UPDATE `price` SET `stock`= " + (b - (oturi / 500)) + " WHERE id = 2";
					oturi -= (oturi / 500)*500;
					Statement st2 = Connector.connect().createStatement();
					st2.executeUpdate(sql2);
					continue;
				} else if (oturi / 100 >= 1) {
					sql3 = "UPDATE `price` SET `stock`= " + (c - (oturi / 100)) + " WHERE id = 3";
					oturi -= (oturi / 100)*100;
					Statement st3 = Connector.connect().createStatement();
					st3.executeUpdate(sql3);
					continue;
				} else if (oturi / 50 >= 1) {
					sql4 = "UPDATE `price` SET `stock`= " + (d - (oturi / 50)) + " WHERE id = 4";
					oturi -= (oturi / 50)*50;
					Statement st4 = Connector.connect().createStatement();
					st4.executeUpdate(sql4);
					continue;
				} else if (oturi / 10 >= 1) {
					sql5 = "UPDATE `price` SET `stock`= " + (e - (oturi / 10)) + " WHERE id = 5";
					oturi -= (oturi / 10)*10;
					Statement st5 = Connector.connect().createStatement();
					st5.executeUpdate(sql5);
				} else {
					break;
				}

			//	Connector.cnx.close();
			}
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}


	public static void mn() throws Exception {
		Connector.connect().createStatement();
		String sql = "select * from price";

		try {
			Statement st = Connector.connect().createStatement();
			ResultSet rs = st.executeQuery(sql);

			cn.clear();
			while (rs.next()) {
				cn.add(new Coin(rs.getInt(1), rs.getInt(2),rs.getInt(3)));

			}

			int a, b, c, d, e;

			a = cn.get(0).stock;

			b = cn.get(1).stock;

			c = cn.get(2).stock;

			d = cn.get(3).stock;

			e = cn.get(4).stock;

			String sql1 = "UPDATE `price` SET `stock`= " + (Money.sum1[0] + a) + " WHERE id = 1";
			String sql2 = "UPDATE `price` SET `stock`= " + (Money.sum1[1] + b) + " WHERE id = 2";
			String sql3 = "UPDATE `price` SET `stock`= " + (Money.sum1[2] + c) + " WHERE id = 3";
			String sql4 = "UPDATE `price` SET `stock`= " + (Money.sum1[3] + d) + " WHERE id = 4";
			String sql5 = "UPDATE `price` SET `stock`= " + (Money.sum1[4] + e) + " WHERE id = 5";
			Statement st1 = Connector.connect().createStatement();
			st1.executeUpdate(sql1);

			Statement st2 = Connector.connect().createStatement();
			st2.executeUpdate(sql2);

			Statement st3 = Connector.connect().createStatement();
			st3.executeUpdate(sql3);

			Statement st4 = Connector.connect().createStatement();
			st4.executeUpdate(sql4);

			Statement st5 = Connector.connect().createStatement();
			st5.executeUpdate(sql5);

			//Connector.cnx.close();
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	}
	public static void Lt() throws Exception {
		
		int lottery = (int)(Math.random()*50);
		
		Scanner Lt = new Scanner(System.in);
		
		System.out.println("********抽選番号を1-100まで選んでください********");
		
		int guess = Lt.nextInt();
		
	
		
		int LotteryDigit1 = lottery/10;
		int LotteryDigital2 = lottery % 10;
		int guessDigit1 = guess/10;
		int guessDigit2 = guess % 10;
		
		if(guess == lottery)
		{
			System.out.println("********おめでとうございます\n 当たりです********");
			
		}
		else 
			System.out.println("*******はずれです。********");
		
		
			}
		 
		
}

