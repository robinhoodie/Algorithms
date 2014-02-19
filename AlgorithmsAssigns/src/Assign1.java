
public class Assign1 {

    private static void intervals(Integer[] A){
        Integer Y = 0;
        Integer assignToX1 = 0;
        Integer assignToX2 = 0;
        Integer hit = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = i; j < A.length; j++){
                Integer X = 0;
                hit++;
                for(int k = 0; k < j; k++){
                    X = X + A[k];
                    assignToX1++;
                    for(int h = k; h < i; h++){
                        X = X * A[h];
                        assignToX2++;
                    }
                }
                Y = Y + X;
            }
        }
        System.out.println("Actual: " + (hit + assignToX1 + assignToX2));
    }
    
    private static Integer[] randArray(Integer n){
        Integer[] array = new Integer[n];
        
        for(int i = 0; i < array.length; i++){
            array[i] = (int) Math.round(Math.random()*10);
        }
        
        return array;
    }
    
    public static void main(String[] args){
        
    	for(int i=1; i <= 10; i++){
    		System.out.println("Array size: " + i);
    		System.out.println("Expected: " + (calcExpected(i)));
    		intervals(randArray(i));    		
    	}
        
        
    }

	private static double calcExpected(int n) {
		double i = n*1.0;
		double partA = ((i*i*i)-i);
		partA = partA/3;
		double partB = ((i*i*i*i)+(2*i*i*i)-(i*i)-(2*i));
		partB = partB/24;
		double partHit = ((i*i)+i);
		partHit = partHit/2;
		System.out.println("X <- 0 :" + partHit);
		System.out.println("X <- X + A[k] :" + partA);
		System.out.println("X <- X + A[h] :" + partB);
		
		double expect = partA + partB + partHit;
		
		double expectB = ((i*i*i*i)/24) + ((5*i*i*i)/12) + ((11*i*i)/24) + (i/12);
		int expectation = (int) Math.round(expectB);
		if(expectation == expect){
			return expectation;
		}
		return 0.0;
	}

	
}
