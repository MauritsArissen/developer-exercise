package assignment;

import assignment.components.BonusThievingComponent;
import assignment.components.MyInventoryComponent;
import assignment.components.MyMiningComponent;
import assignment.components.MyXPBoosterComponent;
import net.gameslabs.model.Assignment;

public class Main {

    public static void main(String[] args) {
        new Assignment(
            new MyXPBoosterComponent(),
            new MyInventoryComponent(),
            new MyMiningComponent(),
            new BonusThievingComponent()
        ).run();
    }
}
