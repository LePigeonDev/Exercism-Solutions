class SqueakyClean {
    static String clean(String identifier) {
        char[] charArray = identifier.toCharArray();
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < identifier.length(); i++) {

            if (Character.isWhitespace(charArray[i])) {
                builder.append('_');
                continue;
            }

            if (charArray[i] == '-') {
                builder.append(Character.toUpperCase(charArray[i+1]));
                i++;
                continue;
            }

            else if (!Character.isLetterOrDigit(charArray[i])) {
                continue;
            }

            switch (charArray[i]) {
                case '4':
                    builder.append('a');
                    continue;
                case '3':
                    builder.append('e');
                    continue;
                case '0':
                    builder.append('o');
                    continue;
                case '1':
                    builder.append('l');
                    continue;
                case '7':
                    builder.append('t');
                    continue;
            }


            builder.append(charArray[i]);
        }
        return builder.toString();
    }

}