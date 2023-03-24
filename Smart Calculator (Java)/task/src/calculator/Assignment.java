package calculator;

public class Assignment extends Expression {

    private String input;

    private String left;

    private String right;

    public Assignment withInput(String input) {
        this.input = input;
        return this;
    }

    @Override
    public void addVariable() {
        if(AssignmentValidator.getInstance().validate(this.input)) {
            this.left = this.input.split("=")[0].strip();
            var rhs = this.input.split("=")[1].strip();
            if(hasVariable(rhs)) {
                this.right = getVariableValue(rhs);
            } else {
                this.right = rhs;
            }
            getVariablesMap().put(this.left, this.right);
        }
    }


}
