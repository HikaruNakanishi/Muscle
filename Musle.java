import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
 
public class Musle {

	public static double MIN_PLATE_VALUE = 2.5;
    
	public static void main(String[] args) {
 
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
	    double startValue = 0;
        String str = null;
 		Boolean isAct = false;

        try {
			System.out.println("まずは、ベンチプレスの限界何キロ数を知ろう！");
			System.out.println("1レップ上げてみよう。上げれたら、" + MIN_PLATE_VALUE + "kg追加して上げて自分の限界を知ろう！！");

			do {
				isAct = false;
				System.out.println("ベンチプレス何キロからスタートしますか？");
				str = br.readLine();
				startValue = Integer.parseInt(str);

				if ( startValue < 20 ) {
					System.out.println("ベンチプレスはバーベルが20kgだから、ベンチプレスは出来ない。ごめんね。");
					System.out.println("代わりにダンベルを持ってダンベルプレスをしよう！");
					return;
				}
				if ( startValue % MIN_PLATE_VALUE != 0 ) {
					System.out.println("ベンチプレスは" + MIN_PLATE_VALUE + "kgの倍数じゃないとプレートがないのさ");
					isAct = true;
				}
			} while (isAct) ;
			System.out.println("ベンチプレス" + startValue + "kgからスタートします。");

			isAct = inputYesOrNo( isr, br, startValue);

			double maxTryVlaue = startValue + MIN_PLATE_VALUE;
			double maxVlaue = isAct ? startValue : 0;
	        while (isAct) {
				System.out.println("では、次は" + maxTryVlaue + "kgを上げてみよう！");
				if(inputYesOrNo( isr, br, maxTryVlaue)) {
					maxVlaue = maxTryVlaue;
					maxTryVlaue += MIN_PLATE_VALUE;
				} else {
					isAct = false;
				}
	        } 
				System.out.println(maxVlaue);


			if( maxVlaue == 0) {
				System.out.println("最初はみんな、ミジンコみたいなものだよ！これから頑張ろう！！");
				return;
			}

			double tryValue = calcTryValue(maxVlaue, 0);
			System.out.println("ベンチプレス" + maxVlaue + "kgがMAXでした！ナイス！明日も限界を超えよう");
			System.out.println("限界キロ数からギリギリ5レップ上げることが出来るキロ数を自動計算しました。");
			System.out.println("今のあなたは、" + tryValue + "kgを5rep上げることが出来ます。");
			System.out.println("さて、次のメニューは、" + tryValue + "kgを5レップ5セットしよう！！");

        } catch (NumberFormatException e){
    		System.out.println("ちっ、文字列やんけ");
	    }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean inputYesOrNo(InputStreamReader isr, BufferedReader br, double maxTryVlaue){
    	String ans = null;
        try {
	        Boolean isFool = false;
	        do {
				System.out.println("ベンチプレス" + maxTryVlaue + "kgは持ち上がりましたか？");
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

	public static double calcTryValue(double maxVlaue, int MODE){
		// 5回想定（今後回数変更する機能を追加するかもしれないから変数にしている。）
		int time = 5;
		// MODE 0 → ベンチプレスの場合係数:40
		// MODE 1 → デッドリフト/スクワットの場合係数:33.3
		double COEFFICIENT = ( MODE == 0 ) ? 40 : 33.3;
		double result = Math.floor(COEFFICIENT * maxVlaue / (COEFFICIENT + time));

		return Math.floor((result / MIN_PLATE_VALUE)) * MIN_PLATE_VALUE;
	}
}
