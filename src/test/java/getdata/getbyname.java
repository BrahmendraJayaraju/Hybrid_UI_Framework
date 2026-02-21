package getdata;

public class getbyname {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String data = Exceldata.getdata("./Data/input.xlsx", "Sheet1", 1, 1);

		System.out.print(data);

		int rows = Exceldata.getrowcount("./Data/input.xlsx", "Sheet1");

		System.out.print(rows);

		int cells = Exceldata.getcellcount("./Data/input.xlsx", "Sheet1", 1);

		System.out.print(cells);

	}

}
