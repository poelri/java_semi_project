package semi01.project;

public class RoomReservation {

    //필드
    // protecte 선언 (다른 패키지 X)
    protected int customerID; //고객 ID
    protected String customerName; //고객 이름
    protected String customerGrade; //방 등급

    protected int headcount; // 인원수제한
    protected int night; // 예약 일수
    protected String meal = "no"; // 조식
    double saleRatio; // 3박 이상 할인율

    protected int price = 100000;

    // 생성자

    public RoomReservation(){
        initRoomReservation();
    }


    public RoomReservation( int customerID,String customerName, int night,int headcount, String customerGrade ){
        int cnt = 99999;
        switch (customerGrade){
            case "single" : cnt = 1;
                    break;
            case "double" : cnt = 2;
                break;
            case "twin" : cnt = 3;
                break;
        }

        if (headcount > cnt) {
            System.out.println(cnt+"인을 초과해서 숙박할 수 없습니다.");
            // 예외 처리 또는 예외 상황에 대한 처리 추가
            // 예를 들어 예외를 던지거나 예약을 취소하거나 다른 처리를 하도록 함
            // 여기서는 일단 return을 통해 메서드를 종료시켜 처리를 중단시킴
            return;
        }

        this.customerID = customerID;
        this.customerName = customerName;
        this.night = night;
        this.headcount = headcount;
        this.customerGrade = customerGrade;

        initRoomReservation();
    }

    private void initRoomReservation() {
        if (customerGrade == null) {
            customerGrade = "Single";
        }
    }

    // 3박 이상 할인률과 가격 리턴

    public int calcPrice(int night) {
        int originalPrice = 100000; // 객실 원래 가격
        int totalPrice = originalPrice * night; // 숙박 일수에 따른 총 가격 계산

        if (night >= 3) { // 3일 이상 숙박 시 할인 적용
            totalPrice -= (int) (totalPrice * saleRatio); // 할인된 가격으로 변경
        }

        return totalPrice; // 총 가격 반환
    }



    // 다른패키지에 있는 Application 클래스에서 사용하기 위해서


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }
    public String getMeal() {
        return meal;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHeadcount() {
        return headcount;
    }

    public void setHeadcount(int headcount) {
        this.headcount = headcount;
    }
}
