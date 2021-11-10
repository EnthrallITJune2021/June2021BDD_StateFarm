package utils;

public class TestClass {

	public static void main(String[] args) {
		ExcelReader reader = new ExcelReader(System.getProperty("user.dir") + ReadProperties.instanceOFProp().getExcelPath(), ReadProperties.instanceOFProp().getSheetName());
		System.out.println(reader.dataTable()[0][0]);
	}
}
