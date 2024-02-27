package semi01.project;

public class TwinRoomReservation extends RoomReservation{
    public TwinRoomReservation(int customerID, String customerName, int night,int headcount, String customerGrade ){
        super(customerID, customerName, night, headcount,customerGrade);

        this.customerGrade = "Twin";
        this.saleRatio = 0.1;
        this.meal = "no";
        this.headcount = 3;
    }

    @Override
    public int calcPrice(int night) {
        int originalPrice = 250000; // 객실 원래 가격
        int totalPrice = originalPrice * night; // 숙박 일수에 따른 총 가격 계산

        if (night >= 3) { // 3일 이상 숙박 시 할인 적용
            totalPrice -= (int) (totalPrice * saleRatio); // 할인된 가격으로 변경
        }

        return totalPrice; // 총 가격 반환
    }

}
