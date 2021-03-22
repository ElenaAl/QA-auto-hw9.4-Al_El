package tf.qa.automation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {

    private int size;

    private Object[] elementData = new Object[10];

    @Override
    public final boolean add(final E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
            // подаем туда массив, который хотим скопировать, а потом длину.
            // и самое выгодное решение- когда будем увеличивать в полтора
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public final int size() {
        return this.size;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public final boolean contains(final Object o) {

        try {
            if (o != null) {
                for (int i = 0; i < size; i++) {
                    if ((elementData[i]).equals(o)) {
                        return true;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (elementData[i] == null) {
                        return false;
                    }
                }
            }
            return false;
        } catch (NullPointerException nullPointerException) {
            throw new NullPointerException();
        }

    }

    @Override
    public final Object[] toArray() {
        return Arrays.copyOf(elementData, size);

    }

    @Override
    public final <T> T[] toArray(final T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        }
        if (a.length > size) {
            int count = 0;
            for (int i = 0; i < elementData.length; i++) {
                a[count] = (T) elementData[i];
                count++;
            }
        }

        return a;

    }

    @Override
    public final boolean remove(final Object o) {
        try {
            if (o != null) {
                for (int i = 0; i < size; i++) {
                    if (elementData[i].equals(o)) {
                        if (size - 1 > 0) {
                            System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                        }
                        size--;
                        return true;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (elementData[i] == null) {
                        if (size - 1 > 0) {
                            System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                        }
                        size--;
                        return true;
                    }
                }
            }
            return false;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }


    @Override
    public final boolean containsAll(final Collection<?> c) {
        MyCollection<Integer> collection = (MyCollection<Integer>) c;
        Iterator<Integer> it = collection.iterator();

        for (Object e : elementData) {
            for (Object d : collection) {
                if (e.equals(it.next())) {
                    return true;
                }
            }
        }

        return false;
    }


    @Override
    public final boolean addAll(final Collection<? extends E> c) {
        Object[] collection = c.toArray();

        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size + collection.length));
            // подаем туда массив, который хотим скопировать, а потом длину.
            // и самое выгодное решение- когда будем увеличивать в полтора
        }
        for (Object o : c) {
            elementData[size++] = o;
        }

        return true;
    }

    @Override
    public final boolean removeAll(final Collection<?> c) {
        try {
            boolean changes = false;
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (!c.contains(elementData[i])) {
                    elementData[count] = elementData[i];
                    count++;
                }
            }
            if (count != size) {
                for (int i = count; i < size; i++) {
                    elementData[i] = null;
                }
                size = count;
                changes = true;
            }
            return changes;
        } catch (NullPointerException npe) {
            throw new NullPointerException();
        }
    }

    @Override
    public final boolean retainAll(final Collection<?> c) {
        if (c != null) {
            final Object[] firstArr = c.toArray();
            int len = size;
            size = firstArr.length;
            int r;
            for (r = 0; r < size; r++) {
                if (r == size - 1) {
                    return true;
                }
                if (!contains(firstArr[r])) {
                    break;
                }
            }

            int w = r++;

            for (Object e; r < size; r++) {
                if (contains(e = firstArr[r])) {
                    firstArr[w] = e;
                    return true;
                }
            }
            System.arraycopy(firstArr, r, firstArr, w, size - r);

        }

        return false;
    }


    @Override
    public final void clear() {
        for (int i = 0; i < elementData.length - 1; i++) {
            if (elementData[i] != null) {
                elementData[i] = null;
                size--;
            }

        }
    }


    private class MyIterator<T> implements Iterator<T> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }

            return (T) elementData[cursor++];
            // так как массив объектов, то нужно использовать явное приведение
            //не страшно, так как мы используем только тип T
        }

        @Override
        public void remove() {

            if (cursor < 0) {
                throw new IllegalStateException("Метод next еще не был вызван");
            }

            if (cursor >= 0) {
                try {
                    int count = 0;
                    for (int i = 0; i < size; i++) {
                        if (i != cursor) {
                            elementData[count] = elementData[i];
                            count++;
                        }
                    }
                    if (count != size) {
                        for (int i = count; i < size; i++) {
                            elementData[i] = null;
                        }
                        size = count;
                    }

                } catch (NullPointerException e) {
                    throw new NullPointerException();
                }
            }
        }
    }
}