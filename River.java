public class River {
    Animal[] river;

    public River() {
        river = new Animal[10];
    }

    public void riverSimulation() {
        initalizeRiver();
        printRiver();
    }

    public void initalizeRiver() {
        Animal a1 = new Bear();
        Animal a2 = new Bear();
        Animal a3 = new Bear();
        Animal f3 = new Fish();
        Animal f4 = new Fish();

        river[0] = a2;
        river[2] = a1;
        river[4] = f3;
        river[6] = a3;
        river[9] = f4;
    }

    public void printRiver() {
        boolean riverFilled = false;
        int i = 1;
        while(riverFilled == false) {
            System.out.print("River system #" + i + ": ");
            i++;

            for (int j = 0; j < river.length; j++) {
                Animal currentAnimal = river[j];
                if (currentAnimal != null)
                    currentAnimal.move(river,j);
            }

            for (Animal currentAnimal : river) {
                if (currentAnimal != null) {
                    System.out.print(currentAnimal.getAnimalName() + ", ");
                } else
                    System.out.print(currentAnimal + ", ");
            }

            System.out.println();

            int nullObjectCounter = 0;
            for (int j = 0; j < river.length; j++) {
                Animal currentAnimal = river[j];
                if (currentAnimal == null) {
                    nullObjectCounter++;
                }
            }

            if (nullObjectCounter == 0)
                riverFilled = true;
        }
    }//end print river method

}//end class
