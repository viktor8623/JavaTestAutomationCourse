package pvt.home.task3;

public class CommandLineParamsRevers {

	public static void main(String[] args) {
		for(int i = args.length; i > 0; i--) {
			System.out.println("Argument " + (i - 1) + " = " + args[i - 1]);
		}
	}
}
