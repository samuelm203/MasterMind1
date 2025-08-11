private static void colorReader(String[] input, int currentColor){

boolean correctcolor = false;
while (!correctcolor) {
System.out.println("Type in " + (currentColor + 1) + ". color:");
String userInput = myObj.nextLine();
for (String s : color) {
if (s.equals(userInput.toLowerCase().replaceAll(" ", ""))){
correctcolor = true;
break;
}
}
if (!correctcolor) {
System.out.println("This color does not exist");
}

else {
input[currentColor] = userInput;
}
        }
