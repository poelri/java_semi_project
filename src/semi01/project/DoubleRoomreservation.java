package semi01.project;

public class DoubleRoomreservation extends RoomReservation{
    public DoubleRoomreservation(int customerID, String customerName, int night ,int headcount, String customerGrade ){
        super(customerID, customerName, night, headcount,customerGrade);


        this.customerGrade = "Double";
        this.saleRatio = 0.05;
        this.meal = "no";
        this.headcount = 2;

    }

    @Override
    public int calcPrice(int night) {
        int originalPrice = 200000; // 객실 원래 가격
        int totalPrice = originalPrice * night; // 숙박 일수에 따른 총 가격 계산

        if (night >= 3) { // 3일 이상 숙박 시 할인 적용
            totalPrice -= (int) (totalPrice * saleRatio); // 할인된 가격으로 변경
        }

        return totalPrice; // 총 가격 반환
    }
/*
    public String counts(int headcount) {
        if(headcount>2) {
            return ("2인 이상은 숙박 할 수 없습니다");
    } else {
        return ("숙박 가능한 인원 입니다.");
        }
    }

 */

}
