package getdata;

public class getbyname {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String data = ExceldataFramework.getdata("./Data/input.xlsx", "Sheet1", 1, 1);

		System.out.print(data);

		int rows = ExceldataFramework.getrowcount("./Data/input.xlsx", "Sheet1");

		System.out.print(rows);

		int cells = ExceldataFramework.getcellcount("./Data/input.xlsx", "Sheet1", 1);

		System.out.print(cells);

	}

}
