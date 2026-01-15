class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        String stringNumber = String.valueOf(numberToCheck);
        int result = 0;
        for(int i = 0; i < stringNumber.length(); i++) {
            String number = String.valueOf(stringNumber.charAt(i));
            result += Math.pow(Integer.parseInt(number), stringNumber.length());
        }

        return numberToCheck == result;
    }

}
