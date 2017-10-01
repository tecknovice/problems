package detector;

import com.detectlanguage.Result;

public class MyResult extends Result {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+"language:"+this.language+",isReliable:"+this.isReliable+",confidence:"+this.confidence+"]";
	}

	
}
