package operators;

import processing.core.PVector;
import globals.Main;
import globals.PAppletSingleton;

public class Operator {

	Main p5;

	public final static int HIGH = 1;
	public final static int LOW = 0;

	//public final static int inputA = 0;
	//public final static int inputB = 1;

	int inputs[] = { 0, 0 };
	int output = 0;

	Operator inputOperators[] = { null, null };
	Operator outputOperator = null;

	public final static int AND = 0;
	public final static int OR = 1;
	public final static int INVERT = 2;
	public final static int NAND = 3;
	public final static int NOR = 4;
	public final static int XOR = 5;
	public final static int XNOR = 6;

	int gateType;

	//----------------

	PVector pos;
	public String name;

	public Operator() {
		p5 = getP5();

		pos = new PVector(0, 0);
		name = "";
	}

	public void render() {

		if (output == HIGH) {
			p5.fill(255, 255, 0);
		} else if (output == LOW) {
			p5.fill(0);
		} else {
			p5.noFill();
		}
		p5.stroke(127);
		p5.ellipse(pos.x - 5, pos.y + 5, 10, 10);

		p5.text(name, pos.x, pos.y);

	}

	//------------------------------------------------
	//------------------------------------------------
	//------------------------------------------------

	public void operate() {
		
		if (inputOperators[0] != null || inputOperators[0] != null) {
			inputs[0] = inputOperators[0].getOutput();
			inputs[1] = inputOperators[1].getOutput();
			
			switch (gateType) {
			case AND:
				output = inputs[0] * inputs[1];
				break;
			case OR:
				output = p5.constrain(inputs[0] + inputs[1], 0, 1);
				break;
			// TRY DOING THE OPERATION WITH BIT-SHIFTING
			default:
				break;
			}
			
					
		}

	}

	public void setGateType(int _gateType) {
		gateType = _gateType;
		switch (gateType) {

		case AND:
			name = "AND";
			break;
		case OR:
			name = "OR";
			break;

		default:
			break;
		}

	}

	public void setInputOperators(Operator opA, Operator opB) {
		inputOperators[0] = opA;
		inputOperators[1] = opB;
	}

	public void setOutputOperator(Operator outOperator) {
		outputOperator = outOperator;
	}

	public void setInputs(int A, int B) {
		inputs[0] = A;
		inputs[1] = B;
	}

	public void setInput(int value, int input) {
		inputs[input] = value;
	}

	public int getOutput() {
		return output;
	}

	public void forceOutput(int forceOutput) {
		output = forceOutput;
	}

	protected Main getP5() {
		return PAppletSingleton.getInstance().getP5Applet();
	}
}
