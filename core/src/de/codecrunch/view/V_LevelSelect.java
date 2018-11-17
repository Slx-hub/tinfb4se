package de.codecrunch.view;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import java.util.List;
import de.codecrunch.TowerAttackGame;

public class V_LevelSelect extends VA_Screen {

    public V_LevelSelect(TowerAttackGame game) {
        super(game);
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);

        //selectController.load();

        TextButton newLevel = new TextButton("New Level", skin);
        TextButton up = new TextButton("^", skin);
       // List<TextButton> levels = selectController.getLevelButtons(skin);
        TextButton down = new TextButton("v", skin);

        TextButton back = new TextButton("Back", skin);

        table.add(newLevel).fillX().uniformX();
        table.add(up).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);

        table.add(back);
        table.add(down);

        //table.add(back).fillX().uniformX();
    }
}
