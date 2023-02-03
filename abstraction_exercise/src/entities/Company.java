package entities;

public final class Company extends TaxPayer {

    private Integer numbersOfEmployees;

    public Company(){
        super();
    }

    public Company(String name, Double annualIncome, Integer numbersOfEmployees) {
        super(name, annualIncome);
        this.numbersOfEmployees = numbersOfEmployees;
    }

    public Integer getNumbersOfEmployees() {
        return numbersOfEmployees;
    }

    public void setNumbersOfEmployees(Integer numbersOfEmployees) {
        this.numbersOfEmployees = numbersOfEmployees;
    }

    @Override
    public double tax() {
        double taxPercentage;

        if(getNumbersOfEmployees() > 10){
            taxPercentage = 0.14;
        } else taxPercentage = 0.16;

        return getAnualIncome() * taxPercentage;
    }
}
