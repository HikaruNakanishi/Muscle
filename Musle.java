import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Musle {
 
    public static void main(String[] args) {
 
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
	    int startValue = 0;
        String str = null;
 
        try {
            System.out.println("ベンチプレス何キロからスタートしますか？");
            str = br.readLine();
		
            startValue = Integer.parseInt(str);
            
            System.out.println("ベンチプレス" + startValue + "kgからスタートします。");
            System.out.println("ベンチプレス" + startValue + "kgは持ち上がりましたか？");
		inputYesOrNo( isr, br);

		double addValue = 2.5;
		double tryValue = startValue + addValue;
		double maxVlaue = 0;
		Boolean isAct = true;
	        do {
	              System.out.println("では、次は" + tryValue + "kgを上げてみよう！");
	            	System.out.println("ベンチプレス" + tryValue + "kgは持ち上がりましたか？");
			if(inputYesOrNo( isr, br)) {
				maxVlaue = tryValue;
				tryValue += addValue;
			} else {
				isAct = false;
			}
	        } while (isAct);

            	System.out.println("ベンチプレス" + maxVlaue + "kgがMAXでした！ナイス！明日は限界を超えよう");

        } catch (NumberFormatException e){
    		System.out.println("ちっ、文字列やんけ");
	    }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean inputYesOrNo(InputStreamReader isr, BufferedReader br){
	
    	String ans = null;
        try {
	        Boolean isFool = false;
	        do {
                System.out.println("持ち上がった場合「y」");
                System.out.println("持ち上がった場合「n」");
                System.out.println("を入力してね");
	            ans = br.readLine();
	            if (ans.equals("y") || ans.equals("n")){
	                isFool = false;
	            } else {
	                System.out.println("「y」か「n」やて");
	                isFool = true;
			}
	        } while (isFool);
	    }catch (IOException e) {
            e.printStackTrace();
        }
    	return (ans.equals("y")) ?  true : false;
    }
}
