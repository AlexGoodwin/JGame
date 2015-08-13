package engineTester;

import org.lwjgl.opengl.Display;

import renderEgnine.DisplayManager;
import renderEgnine.Loader;
import renderEgnine.RawModel;
import renderEgnine.Renderer;

public class MainGameLoop {

	public static void main(String[] args) {
		
		
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		// OpenGL expects vertices to be defined counter clockwise by default
		float[] vertices = { 
			-0.5f,0.5f,0,	// v0
			-0.5f,-0.5f,0,	// v1
			0.5f,-0.5f,0,	// v2
			0.5f,0.5f,0		// v3
		};
		
		int[] indices = {
				0,1,3, 	//Top left triangle (v0, v1, v3)
				3,1,2	//Bottom right triangle (v3, v1, v2)
		};
		
		RawModel model = loader.loadToVAO(vertices,indices);
		
		while(!Display.isCloseRequested()){
			renderer.prepare();
			//game logic
			renderer.render(model);
			DisplayManager.updateDisplay();
		}
		
		loader.cleanUp();
		DisplayManager.closeDisplay(); 

	}

}
