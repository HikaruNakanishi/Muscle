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
            System.out.println("�x���`�v���X���L������X�^�[�g���܂����H");
            str = br.readLine();
		
            startValue = Integer.parseInt(str);
            
            System.out.println("�x���`�v���X" + startValue + "kg����X�^�[�g���܂��B");
            System.out.println("�x���`�v���X" + startValue + "kg�͎����オ��܂������H");
		inputYesOrNo( isr, br);

		double addValue = 2.5;
		double tryValue = startValue + addValue;
		double maxVlaue = 0;
		Boolean isAct = true;
	        do {
	              System.out.println("�ł́A����" + tryValue + "kg���グ�Ă݂悤�I");
	            	System.out.println("�x���`�v���X" + tryValue + "kg�͎����オ��܂������H");
			if(inputYesOrNo( isr, br)) {
				maxVlaue = tryValue;
				tryValue += addValue;
			} else {
				isAct = false;
			}
	        } while (isAct);

            	System.out.println("�x���`�v���X" + maxVlaue + "kg��MAX�ł����I�i�C�X�I�����͌��E�𒴂��悤");

        } catch (NumberFormatException e){
    		System.out.println("�����A��������");
	    }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean inputYesOrNo(InputStreamReader isr, BufferedReader br){
	
    	String ans = null;
        try {
	        Boolean isFool = false;
	        do {
                System.out.println("�����オ�����ꍇ�uy�v");
                System.out.println("�����オ�����ꍇ�un�v");
                System.out.println("����͂��Ă�");
	            ans = br.readLine();
	            if (ans.equals("y") || ans.equals("n")){
	                isFool = false;
	            } else {
	                System.out.println("�uy�v���un�v���");
	                isFool = true;
			}
	        } while (isFool);
	    }catch (IOException e) {
            e.printStackTrace();
        }
    	return (ans.equals("y")) ?  true : false;
    }
}
