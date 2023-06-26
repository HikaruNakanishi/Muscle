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
			System.out.println("�܂��́A�x���`�v���X�̌��E���L������m�낤�I");
			System.out.println("1���b�v�グ�Ă݂悤�B�グ�ꂽ��A" + MIN_PLATE_VALUE + "kg�ǉ����ďグ�Ď����̌��E��m�낤�I�I");

			do {
				isAct = false;
				System.out.println("�x���`�v���X���L������X�^�[�g���܂����H");
				str = br.readLine();
				startValue = Integer.parseInt(str);

				if ( startValue < 20 ) {
					System.out.println("�x���`�v���X�̓o�[�x����20kg������A�x���`�v���X�͏o���Ȃ��B���߂�ˁB");
					System.out.println("����Ƀ_���x���������ă_���x���v���X�����悤�I");
					return;
				}
				if ( startValue % MIN_PLATE_VALUE != 0 ) {
					System.out.println("�x���`�v���X��" + MIN_PLATE_VALUE + "kg�̔{������Ȃ��ƃv���[�g���Ȃ��̂�");
					isAct = true;
				}
			} while (isAct) ;
			System.out.println("�x���`�v���X" + startValue + "kg����X�^�[�g���܂��B");

			isAct = inputYesOrNo( isr, br, startValue);

			double maxTryVlaue = startValue + MIN_PLATE_VALUE;
			double maxVlaue = isAct ? startValue : 0;
	        while (isAct) {
				System.out.println("�ł́A����" + maxTryVlaue + "kg���グ�Ă݂悤�I");
				if(inputYesOrNo( isr, br, maxTryVlaue)) {
					maxVlaue = maxTryVlaue;
					maxTryVlaue += MIN_PLATE_VALUE;
				} else {
					isAct = false;
				}
	        } 
				System.out.println(maxVlaue);


			if( maxVlaue == 0) {
				System.out.println("�ŏ��݂͂�ȁA�~�W���R�݂����Ȃ��̂���I���ꂩ��撣�낤�I�I");
				return;
			}

			double tryValue = calcTryValue(maxVlaue, 0);
			System.out.println("�x���`�v���X" + maxVlaue + "kg��MAX�ł����I�i�C�X�I���������E�𒴂��悤");
			System.out.println("���E�L��������M���M��5���b�v�グ�邱�Ƃ��o����L�����������v�Z���܂����B");
			System.out.println("���̂��Ȃ��́A" + tryValue + "kg��5rep�グ�邱�Ƃ��o���܂��B");
			System.out.println("���āA���̃��j���[�́A" + tryValue + "kg��5���b�v5�Z�b�g���悤�I�I");

        } catch (NumberFormatException e){
    		System.out.println("�����A��������");
	    }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean inputYesOrNo(InputStreamReader isr, BufferedReader br, double maxTryVlaue){
    	String ans = null;
        try {
	        Boolean isFool = false;
	        do {
				System.out.println("�x���`�v���X" + maxTryVlaue + "kg�͎����オ��܂������H");
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

	public static double calcTryValue(double maxVlaue, int MODE){
		// 5��z��i����񐔕ύX����@�\��ǉ����邩������Ȃ�����ϐ��ɂ��Ă���B�j
		int time = 5;
		// MODE 0 �� �x���`�v���X�̏ꍇ�W��:40
		// MODE 1 �� �f�b�h���t�g/�X�N���b�g�̏ꍇ�W��:33.3
		double COEFFICIENT = ( MODE == 0 ) ? 40 : 33.3;
		double result = Math.floor(COEFFICIENT * maxVlaue / (COEFFICIENT + time));

		return Math.floor((result / MIN_PLATE_VALUE)) * MIN_PLATE_VALUE;
	}
}
