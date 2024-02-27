package customer.project;

public class VIPCustomerOther extends Customer{


    double saleRatio; // 할인률

    public VIPCustomerOther(int customerID, String customerName) {
        super(customerID, customerName);

        // super Grade fkd Ratio는 Customer 클래스에 있는 애들을 가져온당~

        super.customerGrade = "VIP";
        super.bonusRatio = 0.03;
        this.saleRatio = 0.2;

    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio; // 보너스 적립
        return price - (int) (price * saleRatio); // 지불할 금액( 할인율 적용)
    }

    @Override
    public String showCustomerInfo() {
        return super.showCustomerInfo() ;
        // super로 부모클래스에 있는 얘를 출력해줘라앜 하는거
    }


}

