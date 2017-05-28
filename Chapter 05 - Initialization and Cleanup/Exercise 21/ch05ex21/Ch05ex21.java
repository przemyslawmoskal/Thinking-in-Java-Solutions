package ch05ex21;

public class Ch05ex21 {
	public enum Bills {TEN, TWENTY, FIFTY, ONE_HUNDRED, TWO_HUNDRED, FIVE_HUNDRED};
    public static void main(String[] args) {
        for(Bills b: Bills.values()){
            System.out.println(b + " is at the following position in the enum: " + b.ordinal());
        }
    }
}

/* Output:
TEN is on the following position in the enum: 0
TWENTY is on the following position in the enum: 1
FIFTY is on the following position in the enum: 2
ONE_HUNDRED is on the following position in the enum: 3
TWO_HUNDRED is on the following position in the enum: 4
FIVE_HUNDRED is on the following position in the enum: 5
*/