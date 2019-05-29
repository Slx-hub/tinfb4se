package de.codecrunch;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.utils.UBJsonReader;

public class Model3DFactory {
    public static Model empty,end,start,path_straight,path_corner,path_cross,path_split_right,path_split_left;
    private static G3dModelLoader modelLoader = new G3dModelLoader(new UBJsonReader());

    private Model3DFactory(){}

    public static void setup(){

        empty = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/empty.g3db", Files.FileType.Internal));
        end = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/end.g3db", Files.FileType.Internal));
        start = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/start.g3db", Files.FileType.Internal));
        path_straight = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/path_straight.g3db", Files.FileType.Internal));
        path_corner = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/path_corner.g3db", Files.FileType.Internal));
    }

    public static ModelInstance instantiate(Model model) {
        return new ModelInstance(model);
    }
    
    public static Model loadModel(String modelLoc){
    	return modelLoader.loadModel(Gdx.files.getFileHandle(modelLoc, Files.FileType.Internal));
    }
}
