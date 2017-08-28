package ch16ex16;

public interface SkipGenerator<T> extends net.mindview.util.Generator<T> {
	T next();
	T next(int i);
}