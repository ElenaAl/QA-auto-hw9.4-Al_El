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
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null && o == null) {
                        return true;
                    } else {
                        if ((elementData[i]).equals(o)) {
                            return true;
                        }
                    }
            }
        } catch (NullPointerException nullPointerException) {
        }
        return false;
    }

    @Override
    public final Object[] toArray() {
        return Arrays.copyOf(elementData, size);

    }

    @Override
    public final <T> T[] toArray(final T[] a) {
        if (a.length <= size) {
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        }
        if (a.length > size) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                a[count] = (T) elementData[i];
                count++;
            }
            return (T[]) Arrays.copyOf(a, a.length, a.getClass());
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
        }
        return false;
    }


    @Override
    public final boolean containsAll(final Collection<?> c) {
        try {
            for (Object e : c) {
                if (!contains(e)) {
                    return false;
                }
            }
            return true;
        } catch (NullPointerException npe) {

        }
        return true;
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
        try {
            boolean changes = false;
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (c.contains(elementData[i])) {
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
    public final void clear() {
        for (int i = 0; i < elementData.length - 1; i++) {
                elementData[i] = null;
                size--;
            }
    }


    private class MyIterator<T> implements Iterator<T> {

        private int cursor = 0;
        private boolean nextPass = false;


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

            nextPass = true;

            return (T) elementData[cursor++];
            // так как массив объектов, то нужно использовать явное приведение
            //не страшно, так как мы используем только тип T
        }

        @Override
        public void remove() {

            if (cursor == 0) {
                throw new IllegalStateException("Метод next еще не был вызван");
            }
            try {


                    for (int i = cursor; i < size; i++) {
                        elementData[i - 1] = elementData[i];
                    }
                    size--;
                    elementData = Arrays.copyOf(elementData, size);

                } catch (NullPointerException e) {

                }
            }
        }
    }
