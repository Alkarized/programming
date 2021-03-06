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
        /*int[] max = new int[19];
        for(int j = 0; j < 19; j++){
            for(int i = 0; i < 11; i++){
                if (max[j] < dd[i][j])
                    max[j] = (int)dd[i][j];
            }
        }*/
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 19; j++){
                /*for(int l = 0; l < String.valueOf(max[j]).length() - String.valueOf((int)dd[i][j]).length(); l++)
                    System.out.print(" ");*/
                System.out.printf("%10.3f",dd[i][j]);
                System.out.printf(" ");
                    //System.out.print(String.format("|%10.3f|",dd[i][j]));
            
            }
            System.out.printf(System.lineSeparator());
        }

    }
}

/*import static java.lang.Math.*;


public class Laba1{
	public static void main(String[] args) {
		long[] d = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24};
		float[] x = new float[19];
		for(int i = 0; i < 19; i++){
			x[i] = (float)(-11.0 + random()*14);	
		}
		double[][] dd = new double[11][19];
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < 19; j++){
				if(d[i]==12){
					dd[i][j] = pow((0.5d)/((PI - 0.25d*(sin(x[j]-1)))),pow(E,cos(x[j])));
				} else if(d[i] == 4 || d[i] == 6 || d[i] == 8 || d[i] == 18 || d[i] == 20){
					dd[i][j] = asin(sin(atan(1/(pow(E,abs(x[j]))))));
				} else{
					dd[i][j] = pow((0.75d/(1 - cos(asin(((x[j]-4)/28))))),2);
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
}*/