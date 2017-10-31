import java.util.*;
import static net.mindview.util.Print.*;

enum Letters {
	VOWEL('a', 'e', 'i', 'o', 'u') {
		public String toString() {
			return "vowel";
		}
	},
	SOMETIMES_A_VOWEL('w', 'y') {
		public String toString() {
			return "sometimes a vowel";
		}
	},
	CONSONANT('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z') {
		public String toString() {
			return "consonant";
		}
	};
	Character[] letters;

	Letters(Character... letters) {
		this.letters = letters;
	}

	public static Letters typeOfLetter(Character c) {
		if ((Arrays.asList(CONSONANT.letters)).contains(c)) {
			return CONSONANT;
		} else if ((Arrays.asList(VOWEL.letters)).contains(c)) {
			return VOWEL;
		} else {
			return SOMETIMES_A_VOWEL;
		}
	}
}

public class VowelsAndConsonants {
	public static void main(String[] args) {
		Random rand = new Random(47);
		for (int i = 0; i < 100; i++) {
			int c = rand.nextInt(26) + 'a';
			print((char) c + ", " + c + ": " + Letters.typeOfLetter((char)c));
		}
	}
}

/* Output:
y, 121: sometimes a vowel
n, 110: consonant
z, 122: consonant
b, 98: consonant
r, 114: consonant
n, 110: consonant
y, 121: sometimes a vowel
g, 103: consonant
c, 99: consonant
f, 102: consonant
o, 111: vowel
w, 119: sometimes a vowel
z, 122: consonant
n, 110: consonant
t, 116: consonant
c, 99: consonant
q, 113: consonant
r, 114: consonant
g, 103: consonant
s, 115: consonant
e, 101: vowel
g, 103: consonant
z, 122: consonant
m, 109: consonant
m, 109: consonant
j, 106: consonant
m, 109: consonant
r, 114: consonant
o, 111: vowel
e, 101: vowel
s, 115: consonant
u, 117: vowel
e, 101: vowel
c, 99: consonant
u, 117: vowel
o, 111: vowel
n, 110: consonant
e, 101: vowel
o, 111: vowel
e, 101: vowel
d, 100: consonant
l, 108: consonant
s, 115: consonant
m, 109: consonant
w, 119: sometimes a vowel
h, 104: consonant
l, 108: consonant
g, 103: consonant
e, 101: vowel
a, 97: vowel
h, 104: consonant
k, 107: consonant
c, 99: consonant
x, 120: consonant
r, 114: consonant
e, 101: vowel
q, 113: consonant
u, 117: vowel
c, 99: consonant
b, 98: consonant
b, 98: consonant
k, 107: consonant
i, 105: vowel
n, 110: consonant
a, 97: vowel
m, 109: consonant
e, 101: vowel
s, 115: consonant
b, 98: consonant
t, 116: consonant
w, 119: sometimes a vowel
h, 104: consonant
k, 107: consonant
j, 106: consonant
u, 117: vowel
r, 114: consonant
u, 117: vowel
k, 107: consonant
z, 122: consonant
p, 112: consonant
g, 103: consonant
w, 119: sometimes a vowel
s, 115: consonant
q, 113: consonant
p, 112: consonant
z, 122: consonant
d, 100: consonant
y, 121: sometimes a vowel
c, 99: consonant
y, 121: sometimes a vowel
r, 114: consonant
f, 102: consonant
j, 106: consonant
q, 113: consonant
a, 97: vowel
h, 104: consonant
x, 120: consonant
x, 120: consonant
h, 104: consonant
v, 118: consonant
*/
