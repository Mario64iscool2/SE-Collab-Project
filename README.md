# Software Engineering Collaborative Project

## Chosen Computation
Calculate the first prime number greater than the input.
## Design Diagram
<picture>
  <source media="(prefers-color-scheme: dark)" srcset="https://github.com/Mario64iscool2/SE-Collab-Project/blob/next-prime/Systems%20Diagram%20(Dark).png">
  <img alt="Shows the system design diagram." src="https://github.com/Mario64iscool2/SE-Collab-Project/blob/next-prime/Systems%20Diagram%20(Light).png">
</picture>

## Classpath management
1. Navigate to your project directory
2. Run `.\gradlew eclipse` to update .classpath and .project
3. Add both to your .gitignore

# Code Standards:
We have a very short list of expectations for code around here.
## Code should be self-documenting.
1. Function names, parameters, and any local variables should aim to be self-explanatory without being too verbose.
2. Make Javadoc comments for methods (Type `/**`+<kbd>Enter</kbd> and Eclipse will auto-insert the formatting.)
> [!IMPORTANT]
> For the sake of readable code, please hit <kbd>Ctrl</kbd> + <kbd>Shift</kbd> + <kbd>F</kbd> in Eclipse before saving a file. It reformats the file in a Checkstyles-friendly way.
> If Checkstyles still declines your commit, check the reason: Click into the Action, under Checkstyles, click into Print Results in the main column.
## Code must compile before attempting to make a Pull Request.
- It should never be the case that code cannot compile when trying to make a Pull-Request, as that strictly violates any semblance of quality.
- Try to run the code locally. If it doesn't want to run, debug it.
  - Eclipse is very good about why errors happen.
  - See the Problems tab on the bottom of the main window (If using the default layout).
> [!CAUTION]
> Do not add more than a single top-level object per file. Gradle will be angry.
> The file name has the same name as the class.
> - `ClassA.java → ClassA`
> This is Case-Sensitive

# Examples of Minimum Quality Standards:
Fibonacci.java
```java
/**
 * @author cameron
 * Handles generating the nth Fibonacci number
 */
public class Fibonacci {

	public static void main(String[] args) {
		int nthFib = Integer.parseInt(args[0]);
		System.out.println(new Fibonacci().findNthFib(nthFib));
	}

	/**
	 * Generates the nth Fibonacci number given an index.
	 * @param nthFib The index of the Fibonacci number to generate.
	 * @return an integer containing the nth Fibonacci number.
	 */
	private int findNthFib(int nthFib) {
		int currentFib = 1;
		int prevFib = 0;
		for (int i = 0; i < nthFib; i++) {
			int nextFib = currentFib + prevFib;
			prevFib = currentFib;
			currentFib = nextFib;
		}
		return currentFib;
	}
}

```
[Checkstyles.java](https://github.com/Mario64iscool2/SE-Collab-Project/blob/main/src/checkstyles/Checkstyles.java) (Could use some more javadoc comments)
```java
package checkstyles;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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
						System.out.println("|    | " + ((Element) list.item(i)).getAttribute("name").split("/./")[1]
								+ " | No errors found.");
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
```
