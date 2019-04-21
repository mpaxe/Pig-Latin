
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinTranslator {
	
	String translate(String frase){
		Pattern pat1 = Pattern.compile("^(a.*|e.*|i.*|o.*|u.*|xr.*|yt.*)");
		Matcher mat1;
		String[] arr = frase.split(" ");
		List<String> list = Arrays.asList(arr);
		String result = "";
		for(int i = 0; i < list.size(); i++) {
			mat1 = pat1.matcher(list.get(i));
			if(mat1.matches()) {
				result += list.get(i)+"ay";
			}else  {
				if(list.get(i).startsWith("squ") || list.get(i).startsWith("thr") || list.get(i).startsWith("sch")) {
					String aux = "";
					aux = list.get(i).substring(0, 3);
					frase = list.get(i).substring(3);
					frase += aux + "ay";
					result = result.trim() +" "+frase;
					
				}else if(list.get(i).startsWith("ch") || list.get(i).startsWith("qu") || list.get(i).startsWith("th")|| list.get(i).startsWith("rh")) {
					String aux = "";
					aux = list.get(i).substring(0, 2);
					frase = list.get(i).substring(2);
					frase += aux + "ay";
					result = result +" "+frase;
				}else {
					String aux = "";
					aux = list.get(i).substring(0, 1);
					frase = list.get(i).substring(1);
					frase += aux + "ay";
					result = result +" "+frase;
				}
			}
		}
		return result.trim();
	}
}
