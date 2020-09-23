package serializer;

import java.util.*;

public interface Serializer{
	
	
	abstract <T> String toStringJson(T objectModel);
	abstract Object Json2Object(String stringJson);
	abstract <T> List<T> getAll();
	
}
