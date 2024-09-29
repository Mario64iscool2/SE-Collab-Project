package data;
public interface DataStorageSystem{

	
	Iterable<Integer> read(InputSource inputSource);
	
	void writeTo(OutputSource outputSource);
	
	WriteResult appendSingleResult(OutputSource outputSource, String result);


}
