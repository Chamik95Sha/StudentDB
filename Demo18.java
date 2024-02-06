void main() {
    int x = 30;
    int y =0;
    while (--x > 0) {
        System.out.print((x) % (6) != 0 ? "*" : "\n");
        if ( x % 6 == 0) x=x- ++y;

    }

}