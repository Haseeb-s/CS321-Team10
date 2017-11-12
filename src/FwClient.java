import java.io.FileNotFoundException;

public class FwClient {
    public static void main(String [] args) {
        try {
            Framework.init(args[0]);
            while(Framework.hasNextInstruction()) {
                String [] instr = Framework.nextInstruction();
                executeInstruction(instr);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void executeInstruction(String [] ins) {
        int instrType = Integer.parseInt(ins[0]);
        System.out.println("Instruction type " + instrType);
        for (int i = 0; i < ins.length; i++) {
            System.out.println(ins[i]);
        }
    }
}