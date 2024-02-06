void main() {
    int x = 3;
    int y = 2;
    while (x++<40) {
        System.out.print((x) % (5) != 0 ? "*" : "\n");
        if (x % 5 == 0 && x < 20 ) x = x + y--;
        if (x % 5 == 0 && x >= 20 ) x = x + ++y;

    }

}