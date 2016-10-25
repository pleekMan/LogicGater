package globals;

import java.util.ArrayList;

import operators.Operator;
import processing.core.PApplet;

public class Main extends PApplet {

	ArrayList<Operator> operators;
	int opIndex; 

	public void setup() {
		size(500, 500);
		setPAppletSingleton();

		operators = new ArrayList<Operator>();
		opIndex = 0;
		
		Operator init1 = new Operator();
		Operator init2 = new Operator();
		Operator orOp = new Operator();

		init1.forceOutput(Operator.HIGH);
		init2.forceOutput(Operator.HIGH);

		orOp.setGateType(Operator.AND);
		orOp.setInputOperators(init1, init2);
		
		operators.add(init1);
		operators.add(init2);
		operators.add(orOp);
	}

	public void draw() {

		/*
		 for (Operator op : operators) {
			
			op.operate();
		}
		*/
		Operator op = operators.get(opIndex); 
		op.operate();
		println(opIndex + " : " + op.name + " : " + op.getOutput() );
		
		noLoop();

	}

	public void mouseReleased() {

	}

	public void mousePressed() {

	}

	public void keyPressed() {
		opIndex = (opIndex + 1) % 3;
		redraw();
	}

	public static void main(String args[]) {
		/*
		 * if (args.length > 0) { String memorySize = args[0]; }
		 */

		PApplet.main(new String[] { Main.class.getName() });
		// PApplet.main(new String[] {
		// "--present","--hide-stop",Main.class.getName() }); //
		// PRESENT MODE
	}

	private void setPAppletSingleton() {
		PAppletSingleton.getInstance().setP5Applet(this);
	}

}
