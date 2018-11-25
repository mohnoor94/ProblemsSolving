import java.util.LinkedList;

/**
 * An animal shelter, which holds only dogs and cats, operats on a strictly "first in, first out" basis.
 * People must adopt either the oldest animal (based on arrival time) of all animals at the shelter, or they can
 * select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny,
 * dequeueDog, and dequeueCat.
 * You may use the built-in LinkedList data structure.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 3.6)
 */
public class AnimalShelter {

    public static void main(String[] args) {
        /*
         * Let n be the size of the animals queue;
         * Both solutions uses O(n) space
         * Both solutions takes O(1) to perform the enqueue operation
         *
         * > Solution1 takes O(n) time to perform all dequeue operations
         * > Thanks to the additional order field in Solution2; all dequeue operations will take O(1) time as well.
         *
         * Summary: Solution2 is better than Solution1.
         */

        testSolution1();
        System.out.println("======================");
        testSolution2();
    }

    private static void testSolution1() {
        Solution1.AnimalQueue animals = new Solution1.AnimalQueue();

        for (int i = 0; i < 5; i++) {
            animals.enqueue(new Solution1.Dog("d" + i));
            animals.enqueue(new Solution1.Cat("c" + i));
        }

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                System.out.println(animals.dequeueCat());
            } else {
                System.out.println(animals.dequeueDog());
            }
        }

        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.println(animals.dequeueAny());
        }
    }

    private static void testSolution2() {
        Solution2.AnimalQueue animals = new Solution2.AnimalQueue();

        for (int i = 0; i < 5; i++) {
            animals.enqueue(new Solution2.Dog("d" + i));
            animals.enqueue(new Solution2.Cat("c" + i));
        }

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                System.out.println(animals.dequeueCat());
            } else {
                System.out.println(animals.dequeueDog());
            }
        }

        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.println(animals.dequeueAny());
        }
    }
}

class Solution1 {
    static abstract class Animal {
        private String name;

        Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Cat extends Animal {
        Cat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Cat: " + super.toString();
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Dog: " + super.toString();
        }
    }

    static class AnimalQueue {
        private LinkedList<Animal> animals = new LinkedList<>();
        private LinkedList<Animal> helper = new LinkedList<>();

        void enqueue(Animal animal) {
            animals.add(animal);
        }

        Animal dequeueAny() {
            if (!helper.isEmpty()) return helper.remove();
            if (!animals.isEmpty()) return animals.remove();
            return null;
        }

        Cat dequeueCat() {
            if (!helper.isEmpty() && helper.peek() instanceof Cat) return (Cat) helper.remove();
            while (!animals.isEmpty() && !(animals.peek() instanceof Cat)) helper.add(animals.remove());
            if (!animals.isEmpty()) return (Cat) animals.remove();
            return null;
        }

        Dog dequeueDog() {
            if (!helper.isEmpty() && helper.peek() instanceof Dog) return (Dog) helper.remove();
            while (!animals.isEmpty() && !(animals.peek() instanceof Dog)) helper.add(animals.remove());
            if (!animals.isEmpty()) return (Dog) animals.remove();
            return null;
        }

        boolean isEmpty() {
            return animals.isEmpty() && helper.isEmpty();
        }
    }
}

class Solution2 {
    static abstract class Animal {
        private String name;
        private int order;

        Animal(String name) {
            this.name = name;
        }

        int getOrder() {
            return order;
        }

        void setOrder(int order) {
            this.order = order;
        }

        @Override
        public String toString() {
            return name;
        }

        boolean isOlderThan(Animal other) {
            return this.order < other.getOrder();
        }
    }

    static class Cat extends Animal {
        Cat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Cat: " + super.toString();
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Dog: " + super.toString();
        }
    }

    static class AnimalQueue {
        LinkedList<Dog> dogs = new LinkedList<>();
        LinkedList<Cat> cats = new LinkedList<>();
        int order = 0;

        void enqueue(Animal animal) {
            animal.setOrder(order++);

            if (animal instanceof Cat) cats.add((Cat) animal);
            else if (animal instanceof Dog) dogs.add((Dog) animal);
        }

        Animal dequeueAny() {
            if (isEmpty()) return null;
            if (dogs.isEmpty()) return dequeueCat();
            if (cats.isEmpty()) return dequeueDog();
            Dog dog = dogs.peek();
            Cat cat = cats.peek();
            if (cat.isOlderThan(dog)) return dequeueCat();
            return dequeueDog();
        }

        Animal dequeueDog() {
            if (dogs.isEmpty()) return null;
            return dogs.remove();
        }

        Animal dequeueCat() {
            if (cats.isEmpty()) return null;
            return cats.remove();
        }

        private boolean isEmpty() {
            return cats.isEmpty() && dogs.isEmpty();
        }
    }
}