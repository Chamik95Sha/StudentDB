void main() {
    int x = 60;
    int y = 0;
    while (--x > 6) {
        System.out.print((x) % (6) != 0 ? "*" : "\n");
        if (x % 6 == 0 && x > 30) x = x - ++y;
        if (x % 6 == 0 && x <= 30 ) x = x - --y;

    }

}