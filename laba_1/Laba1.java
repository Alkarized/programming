import java.lang.*;

public class Laba1{
	public static void main(String[] args) {
		long[] d = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24};
		float[] x = new float[19];
		for(int i = 0; i < 19; i++){
			x[i] = (float)(-11.0 + Math.random()*14);	
		}
		double[][] dd = new double[11][19];
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < 19; j++){
				if(d[i]==12){
					dd[i][j] = Math.pow((0.5d)/((Math.PI - 0.25d*(Math.sin(x[j]-1)))),Math.pow(Math.E,Math.cos(x[j])));
				} else if(d[i] == 4 || d[i] == 6 || d[i] == 8 || d[i] == 18 || d[i] == 20){
					dd[i][j] = Math.asin(Math.sin(Math.atan(1/(Math.pow(Math.E,Math.abs(x[j]))))));
				} else{
					dd[i][j] = Math.pow((0.75d/(1 - Math.cos(Math.asin(((x[j]-4)/28))))),2);
				}
			}
		}
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < 19; j++){
				System.out.printf("%.3f",dd[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}
}