package lesson03

    static void main(String[] args) {
        Student st = new Student();
        st.StudentID = 1;

        println(st.DisplayMarks());
        println(st.DisplayTotal());
    }

    interface Total {
        void DisplayTotal()
    }

    trait Marks implements Total {
        int Marks1;

        void DisplayMarks() {
            this.Marks1 = 10;
            println(this.Marks1);
        }

        void DisplayTotal() {
            println("Display Total");
        }
    }

    class Student implements Marks {
        int StudentID
    }
