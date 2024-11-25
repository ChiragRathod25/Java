class stack {
    int top = -1;
    int size;
    int arr[];

    stack() {
        this.size = -1;
    }

    stack(int s) {
        this.size = s;
        arr = new int[s];
    }

    void push(int val) throws Exception {
        if (top < size - 1) {
            top++;
            arr[top] = val;
            System.out.println("pushed");
        } else {
            throw new Exception("stack is full");
        }
    }

    void pop() throws Exception {
        if (top == -1)
            throw new Exception("stack is empty");
        top--;
    }

    int getTop() throws Exception {
        if (top == -1)
            throw new Exception("stack is empty");
        return arr[top];
    }

    void display() throws Exception {
        if (top == -1)
            throw new Exception("stack is empty");
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i] + " ");
        }

    }

}

class stack_main {
    public static void main(String[] args) {
        stack s = new stack(5);
        // s.display();
        // s.display();
        try {
            // s.pop();
            s.push(21);
            s.push(41);
            s.push(45);
            s.push(34);
            s.push(37);
            s.push(31);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);

            System.out.println(e.getMessage());
        }

        // s.display(); //=> we should must wrap up this in try catch blocks, because in class defination we mentioned that method "throws Exception"
        try {
            s.display();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}