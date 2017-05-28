package ch05ex22;

public class Ch05ex22 {
	public enum Bills {TEN, TWENTY, FIFTY, ONE_HUNDRED, TWO_HUNDRED, FIVE_HUNDRED};
	Bills b;
    public static void main(String[] args) {
    	System.out.println("Values: ");
        for(Bills b: Bills.values()){
        	switch(b){
            case TEN: System.out.println("10"); break;
            case TWENTY: System.out.println("20"); break;
            case FIFTY: System.out.println("50"); break;
            case ONE_HUNDRED: System.out.println("100"); break;
            case TWO_HUNDRED: System.out.println("200"); break;
            case FIVE_HUNDRED: System.out.println("500"); break;
            default: break;
        	}
        }
    }
}

/* Output:
Values: 
10
20
50
100
200
500
*/