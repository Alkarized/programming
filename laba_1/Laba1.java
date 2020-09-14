import java.lang.*;
import java.util.*;

public class Laba1{
	public static void main(String[] args) {
		long[] d = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24};
		float[] x = new float[19];
		for(float a: x){
			a = (float)(-11.0 + Math.random()*14);	
		}
		float[][] dd = new float[11][19];
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < 19; j++){
				if(d[i]==12){
					dd[i][j] = (float)Math.pow((0.5f)/((float)(Math.PI - 1/4*(Math.sin(x[j]-1)))),Math.pow(Math.E,Math.cos(x[j])));
				} else if(d[i] == 4 && d[i] == 6 && d[i] == 8 && d[i] == 18 && d[i] == 20){
					dd[i][j] = (float)Math.asin(Math.sin(Math.atan(1/(Math.pow(Math.E,Math.abs(x[j]))))));
				} else{
					dd[i][j] = (float)Math.pow((3/4f/(1 - Math.cos(Math.asin(1/2*((x[j]-4)/14))))),2);
				}
			}
		}
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < 19; j++)
				System.out.print(dd[i][j] + " ");
			System.out.println();
		}

	}
}