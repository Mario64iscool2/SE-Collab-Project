package checkstyles;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class Checkstyles {

	public static void main(String[] args) {
		if (args != null) {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

				File inputFile = new File(args[0]);
				Document doc = docBuilder.parse(inputFile);

				NodeList list = doc.getElementsByTagName("file");
				String curFile;
				NodeList detailList;

				int line, col;
				String sev, msg, src;

				System.out.println("");
				System.out.println("| Severity | File | Error |");
				System.out.println("| --- | ---  | :---   |");
				for (int i = 0; i < list.getLength(); i++) {
					curFile = ((Element) list.item(i)).getAttribute("name").split("/./")[1];
					// If the file has any checkstyles entries
					if (list.item(i).hasChildNodes()) {
						detailList = list.item(i).getChildNodes();
						for (int j = 0; j < detailList.getLength(); j++) {
							if (detailList.item(j).hasAttributes()) {
								// We are in an error node or similar.
								line = Integer.parseInt(((Element) detailList.item(j)).getAttribute("line"));
								col = Integer.parseInt(((Element) detailList.item(j)).getAttribute("column"));
								sev = ((Element) detailList.item(j)).getAttribute("severity");
								msg = ((Element) detailList.item(j)).getAttribute("message");
								src = ((Element) detailList.item(j)).getAttribute("source").split(
										"\\.")[((Element) detailList.item(j)).getAttribute("source").split("\\.").length
												- 1];
								System.out.println(String.format("| %s | %s | [%d,%d] %s <%s> |", sev, curFile, line,
										col, msg, src));
							}
						}
					} else {
						System.out.println("|    | " + ((Element) list.item(i)).getAttribute("name").split("/./")[1] + " | No errors found.");
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}