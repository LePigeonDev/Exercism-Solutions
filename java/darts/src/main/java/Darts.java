class Darts {
    int score(double xOfDart, double yOfDart) {
        double result = Math.sqrt((xOfDart * xOfDart) + (yOfDart * yOfDart));
        if (result <= 1) {
            return 10;
        } else if (result <= 5) {
            return 5;
        } else if (result <= 10) {
            return 1;
        }
        return 0;
    }
}
