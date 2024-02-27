package customer.project;

public class VIPCustomer extends Customer{
    private int agentID; // 상담원 ID

    double saleRatio; // 할인률

    public VIPCustomer(int customerID, String customerName, int agentID) {
        super(customerID, customerName);

        // super Grade fkd Ratio는 Customer 클래스에 있는 애들을 가져온당~

        super.customerGrade = "VIP";
        super.bonusRatio = 0.05;
        this.saleRatio = 0.1;
        this.agentID = agentID; // 상담원 ID~ VIP Customer를 만들때 int agentID를 만들어쥰당
    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio; // 보너스 적립
        return price - (int) (price * saleRatio); // 지불할 금액( 할인율 적용)
    }

    @Override
    public String showCustomerInfo() {
        return super.showCustomerInfo() + ", 담당 상담원 ID : " + agentID;
        // super로 부모클래스에 있는 얘를 출력해줘라앜 하는거
    }

    public int getAgentID() {
        return agentID;
    }
}
