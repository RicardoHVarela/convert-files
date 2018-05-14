package convertFiles.convertFiles;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final String FILE_NAME = "/Users/base22/Documents/docs/cnh/Projects/Translations/Translations_Thaiv2.xlsx";
	private static String sheet_adminScreens = "Administration Screens";
	private static String sheet_myProfile = "My Profile";
	private static String sheet_DPLogin = "DPLogin";
	private static String sheet_Theme = "Theme";
//	private static String[] output_columns = {"Internal Name","Thai"};
	
    public static void main( String[] args )
    {
        FileConverter.excel2Text(FILE_NAME, sheet_adminScreens);
      
    }
}