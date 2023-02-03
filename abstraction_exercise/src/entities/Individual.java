package entities;

public final class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual(){
        super();
    }

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        double totalTax = 0;
        double discountTax = 0;

        if(getAnualIncome() >= 20000.00){
            totalTax= getAnualIncome() * 0.25;
        } else {
            totalTax = getAnualIncome() * 0.15;
        }

        if(getHealthExpenditures() >= 0){
            discountTax = getHealthExpenditures() * 0.5;
        }

        return totalTax - discountTax;
    }

}
