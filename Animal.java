public class Animal {
    protected String animalName;

    public Animal() {

    }

    public void move(Animal[] river, int indexOfAnimal) {//add 1 to loop index if shifting right
        int randomInt = randomMoveInt();//random int 1-3

        //System.out.print(" ri :" + randomInt + " ");
        if (randomInt == 1 && checkIfOnEdgeGoingRight(river,indexOfAnimal)) { //swap to right
            moveAnimalRight(river,indexOfAnimal);

        }

        else if (randomInt == 2 && checkIfOnEdgeGoingLeft(river,indexOfAnimal)) {//swap to left
            moveAnimalLeft(river,indexOfAnimal);
        }

        //else if == 3 nothing happens and stays put
    }

    protected void moveAnimalRight(Animal[] river, int indexOfAnimal) {
        if ( checkIfOnEdgeGoingRight(river,indexOfAnimal)) {//if neighbor animal is null
            if (river[indexOfAnimal+1] == null) {

                Animal temp = river[indexOfAnimal];
                river[indexOfAnimal] = null;
                river[indexOfAnimal + 1] = temp;
                return;
            }
        }


        String currentAnimalName = river[indexOfAnimal].getAnimalName();
        String nextIndexAnimalName = river[indexOfAnimal + 1].getAnimalName();

        if (currentAnimalName.equals(nextIndexAnimalName)) {//if two same animal
            for (int i = 0; i < river.length; i++) {//loop add baby @ null loc;
                if (river[i] == null) {
                    addNewBaby(currentAnimalName,river,i);
                    break;
                }
            }
        }
        else if ((currentAnimalName.equals("BEAR") && nextIndexAnimalName.equals("FISH")) || currentAnimalName.equals("FISH") && nextIndexAnimalName.equals("BEAR")) {//different animals
            fishDies(river, indexOfAnimal);
        }

    }

    public void fishDies(Animal[] river, int indexOfAnimal) {
        String currentAnimalName = river[indexOfAnimal].getAnimalName();
        river[indexOfAnimal] = null;
    }


    public void addNewBaby(String currentAnimalName, Animal[] river,int i) {
        if (currentAnimalName.equals("BEAR")) {
            Bear b = new Bear();
            b.setAnimalName("BEAR");
            river[i] = b;
        }
        else if (currentAnimalName.equals("FISH")) {
            Fish f = new Fish();
            f.setAnimalName("FISH");
            river[i] = f;
        }
    }

    //change code top
    protected void moveAnimalLeft(Animal[] river, int indexOfAnimal) {
        //if neighbor exists
        if (checkIfOnEdgeGoingLeft(river,indexOfAnimal)) {
            Animal temp = river[indexOfAnimal - 1];
            river[indexOfAnimal - 1] = river[indexOfAnimal];
            river[indexOfAnimal] = temp;
            return;
        }

        String currentAnimalName = river[indexOfAnimal].getAnimalName();
        String nextIndexAnimalName = river[indexOfAnimal-1].getAnimalName();

        if (currentAnimalName.equals(nextIndexAnimalName)) {//if two same animal
            for (int i = 0; i < river.length; i++) {//loop add baby @ null loc;
                if (river[i] == null) {
                    addNewBaby(currentAnimalName,river,i);
                    break;
                }
            }
        }
    }

    public boolean checkIfOnEdgeGoingRight(Animal[] river, int indexOfAnimal) {
        if (indexOfAnimal+1 < river.length)
            return true;
        return false;
    }
    public boolean checkIfOnEdgeGoingLeft(Animal[] river, int indexOfAnimal) {
        if (indexOfAnimal-1 > 0)
            return true;
        return false;
    }

    protected int randomMoveInt() {
        return (int) (Math.random()*3) + 1;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
}
